<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Students Information</title>
	<style>
		table {border-collapse: collapse; width: 100%;}
		th, td {text-align: left; padding: 8px;}
		th {background-color: #4CAF50; color: white;}
		tr:nth-child(even) {background-color: #f2f2f2;}
	</style>
</head>
<body>
	<%
		String student_id = request.getParameter("student_id");
		String student_name = request.getParameter("student_name");
		String class_Name = request.getParameter("class_Name");
		String division = request.getParameter("division");
		String city = request.getParameter("city");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/
     student", "root", "root");
			PreparedStatement ps = con.prepareStatement("insert into student_info 
     values(?,?,?,?,?)");
			ps.setString(1, student_id);
			ps.setString(2, student_name);
			ps.setString(3, class_Name);
			ps.setString(4, division);
			ps.setString(5, city);
			int i = ps.executeUpdate();
			if (i > 0) {
				PreparedStatement ps1 = con.prepareStatement("SELECT * FROM 
       student_info");
				ResultSet rs = ps1.executeQuery();
				out.println("<h2 style=\"text-align: center;\">STUDENTS 
                                                                            INFORMATION</h2>");
				out.println("<table>");
				out.println("<tr><th>ID</th><th>NAME</th><th>CLASS</th><th>DIVISION</th><th>CITY</th></tr
          >");
				while (rs.next()) {
					student_id = rs.getString("student_id");
					student_name = rs.getString("student_name");
					class_Name = rs.getString("class_Name");
					division = rs.getString("division");
					city = rs.getString("city");
					out.println("<tr><td>" + student_id + "</td><td>" + student_name + 
"</td><td>" + class_Name + "</td><td>" + division + "</td><td>" + 
city + "</td></tr>");
				}
				out.println("</table>");
				out.print("<h3 style=\"text-align: center; color: red\">Your data has been 
     stored successfully</h3>");
				rs.close();
				ps1.close();
				con.close();
			}
		} catch (Exception e) {
			out.println(e);
		}
	%>
</body>
</html>
