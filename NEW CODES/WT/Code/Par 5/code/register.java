import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/* * Servlet implementation class Register*/
@WebServlet("/register")
public class register extends HttpServlet {
    private static final long serialVersionUID = 1L;
    /* * @see HttpServlet#HttpServlet()*/
    public register() {
        super();
        // TODO Auto-generated constructor stub
    }
    /** @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)*/
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }
    /*** @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)*/
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String book_id = request.getParameter("book_id");
        String book_title = request.getParameter("book_title");
        String book_author = request.getParameter("book_author");
        String book_price = request.getParameter("book_price");
        String quantity = request.getParameter("quantity");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BookDB", "root", "root");
            PreparedStatement ps = con.prepareStatement("insert into ebookshop values(?,?,?,?,?)");
            ps.setString(1, book_id);
            ps.setString(2, book_title);
            ps.setString(3, book_author);
            ps.setString(4, book_price);
            ps.setString(5, quantity);
            int i = ps.executeUpdate();
            if (i > 0) {
                
                PreparedStatement ps1 = con.prepareStatement("SELECT * FROM ebookshop");
                ResultSet rs = ps1.executeQuery();


                out.println("<html><head><title>Book Inventory</title>");
                out.println("<style>");
                out.println("table {border-collapse: collapse; width: 100%;}");
                out.println("th, td {text-align: left; padding: 8px;}");
                out.println("th {background-color: #4CAF50; color: white;}");
                out.println("tr:nth-child(even) {background-color: #f2f2f2;}");
                out.println("</style>");
                out.println("</head><body>");
                out.println("<h2 style=\"text-align: center;\">Book Inventory</h2>");
                out.println("<table>");
                out.println("<tr><th>ID</th><th>Title</th><th>Author</th><th>Price</th><th>Quantity</th></tr>");
                while (rs.next()) {
                  book_id = rs.getString("book_id");
                  book_title = rs.getString("book_title");
                  book_author = rs.getString("book_author");
                  book_price = rs.getString("book_price");
                  quantity = rs.getString("quantity");
                  out.println("<tr><td>" + book_id + "</td><td>" + book_title + "</td><td>" + book_author + "</td><td>" + book_price + "</td><td>" + quantity + "</td></tr>");
                }
                out.println("</table>");
                out.print("<h3 style=\"text-align: center; color: red\">You're data has been stored successfully</h3>");

                out.println("</body></html>");



                rs.close();
                ps1.close();
                con.close();

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

