import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class RegisterDao {
	private String dburl = "jdbc:mysql://localhost:3306/{database}";
	private String dbuname = "{username}";
	private String dbpassword = "{password}";
	private String dbdriver = "com.mysql.jdbc.Driver";

	public void loadDriver(String dbdriver)
	{
	try {
		Class.forName(dbdriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String insert(Member member) {
		loadDriver(dbdriver);
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection con;
		String result="Data Entered Successfully";
try {
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/{database}","{username}","{password}");
			
			PreparedStatement ps = con.prepareStatement("insert into member values(?,?,?,?);");
			ps.setString(1, member.getUname());
			ps.setString(2, member.getPassword());
			ps.setString(3, member.getEmail());
			ps.setNString(4, member.getPhone());
			ps.executeUpdate();
				
		}catch(SQLException e) {
			result="Data Not Entered Successfully";
			e.printStackTrace();
		}
	return result;

	}
}
