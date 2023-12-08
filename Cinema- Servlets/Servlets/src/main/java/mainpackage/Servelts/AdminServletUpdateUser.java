package mainpackage.Servelts;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdminServletUpdateUser")
public class AdminServletUpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminServletUpdateUser() {
        super();
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String old_username = request.getParameter("txtCurrentUsername");
		String new_username = request.getParameter("txtNewUsername");
		String new_password = request.getParameter("txtNewPassword");
		String new_name = request.getParameter("txtNewName");
		String new_email = request.getParameter("txtNewEmail");
		Connection con=null;
		String url = "jdbc:mysql://localhost:3306/cinema_last";
		PrintWriter pw = response.getWriter();
		String role = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,"root","g1234567890");
			
			
			PreparedStatement ge = con.prepareStatement("select * from user where username=?");
			ge.setString(1, old_username);
			ResultSet rs = ge.executeQuery();
			if(rs.next()) {
			 role = rs.getString("role");
			}
			PreparedStatement ps = con.prepareStatement("REPLACE user(username,email,password) where username=? VALUES(?,?,?)");
			ps.setString(1, new_username);
			ps.setString(2, new_email);
			ps.setString(3, new_password);
			ps.setString(4, old_username);
			ps.executeUpdate();// EDW EXW PROBLHMA KAI TO STELNEI STO CATCH
			ps.close();
			
			
			
			if(role.equalsIgnoreCase("ContentAdmin")) {
			PreparedStatement geo = con.prepareStatement("update content_admin set NAME=? ,user_username=? where user_username=?");
			geo.setString(1, new_name);
			geo.setString(2, new_username);
			geo.setString(3, old_username);
			geo.executeUpdate();
			
			PrintWriter po=response.getWriter();
			response.setContentType("text/html");
			po.println("<head>\r\n"
					+ "<meta charset=\"UTF-8\">\r\n"
					+ "<title>Admin</title>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "<h1 style=\"text-align:center;\">User Updated Successfully!!!.</h1>\r\n"
					+ "</body>\r\n"
					+ "<style>\r\n"
					+ "body{\r\n"
					+ "	margin: 0;\r\n"
					+ "	padding:0;\r\n"
					+ "	font-family:montserrat;\r\n"
					+ "	background: linear-gradient(120deg,#F66A0E,#15C2DA);\r\n"
					+ "	height: 100vh;\r\n"
					+ "	overflow:hidden;\r\n"
					+ "}\r\n"
					+ "h1{\r\n"
					+ "	position:absolute;\r\n"
					+ "	top: 50%;\r\n"
					+ "    left: 50%;\r\n"
					+ "    transform: translate(-50%, -50%);\r\n"
					+ "	text-align: center;\r\n"
					+ "    margin: 0 auto;\r\n"
					+ "    float: center;\r\n"
					+ "    color: #fff;\r\n"
					+ "    font-size: 23px;\r\n"
					+ "    font-weight: bold;\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "</style>");
			
			
			
			}
			else if(role.equalsIgnoreCase("Admin")) {
				PreparedStatement geo2 = con.prepareStatement("update admins set NAME=? ,user_username=? where user_username=?");
				geo2.setString(1, new_name);
				geo2.setString(2, new_username);
				geo2.setString(3, old_username);
				geo2.executeUpdate();
				
				PrintWriter po2=response.getWriter();
				response.setContentType("text/html");
				po2.println("<head>\r\n"
						+ "<meta charset=\"UTF-8\">\r\n"
						+ "<title>Admin</title>\r\n"
						+ "</head>\r\n"
						+ "<body>\r\n"
						+ "<h1 style=\"text-align:center;\">User Updated Successfully!!!.</h1>\r\n"
						+ "</body>\r\n"
						+ "<style>\r\n"
						+ "body{\r\n"
						+ "	margin: 0;\r\n"
						+ "	padding:0;\r\n"
						+ "	font-family:montserrat;\r\n"
						+ "	background: linear-gradient(120deg,#F66A0E,#15C2DA);\r\n"
						+ "	height: 100vh;\r\n"
						+ "	overflow:hidden;\r\n"
						+ "}\r\n"
						+ "h1{\r\n"
						+ "	position:absolute;\r\n"
						+ "	top: 50%;\r\n"
						+ "    left: 50%;\r\n"
						+ "    transform: translate(-50%, -50%);\r\n"
						+ "	text-align: center;\r\n"
						+ "    margin: 0 auto;\r\n"
						+ "    float: center;\r\n"
						+ "    color: #fff;\r\n"
						+ "    font-size: 23px;\r\n"
						+ "    font-weight: bold;\r\n"
						+ "}\r\n"
						+ "\r\n"
						+ "\r\n"
						+ "</style>");
				
				
				
				}
			else if(role.equalsIgnoreCase("Customer")) {
				PreparedStatement geo3 = con.prepareStatement("update customers set NAME=? ,user_username=? where user_username=?");
				geo3.setString(1, new_name);
				geo3.setString(2, new_username);
				geo3.setString(3, old_username);
				geo3.executeUpdate();
				
				PrintWriter po3=response.getWriter();
				response.setContentType("text/html");
				po3.println("<head>\r\n"
						+ "<meta charset=\"UTF-8\">\r\n"
						+ "<title>Admin</title>\r\n"
						+ "</head>\r\n"
						+ "<body>\r\n"
						+ "<h1 style=\"text-align:center;\">User Updated Successfully!!!.</h1>\r\n"
						+ "</body>\r\n"
						+ "<style>\r\n"
						+ "body{\r\n"
						+ "	margin: 0;\r\n"
						+ "	padding:0;\r\n"
						+ "	font-family:montserrat;\r\n"
						+ "	background: linear-gradient(120deg,#F66A0E,#15C2DA);\r\n"
						+ "	height: 100vh;\r\n"
						+ "	overflow:hidden;\r\n"
						+ "}\r\n"
						+ "h1{\r\n"
						+ "	position:absolute;\r\n"
						+ "	top: 50%;\r\n"
						+ "    left: 50%;\r\n"
						+ "    transform: translate(-50%, -50%);\r\n"
						+ "	text-align: center;\r\n"
						+ "    margin: 0 auto;\r\n"
						+ "    float: center;\r\n"
						+ "    color: #fff;\r\n"
						+ "    font-size: 23px;\r\n"
						+ "    font-weight: bold;\r\n"
						+ "}\r\n"
						+ "\r\n"
						+ "\r\n"
						+ "</style>");
				
				
				}
			
			
		}catch(Exception e) 
		{
			pw.println("<head>\r\n"
					+ "<meta charset=\"UTF-8\">\r\n"
					+ "<title>Admin</title>\r\n"
					+ "<link rel=\"stylesheet\" href=\"style3.css\">\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "<h1 style=\"text-align:center;\">ERROR!!!Invalid information.</h1>\r\n"
					+ "</body>\r\n"
					+ "<style>\r\n"
					+ "body{\r\n"
					+ "margin: 0;\r\n"
					+ "padding:0;\r\n"
					+ "font-family:montserrat;\r\n"
					+ "	background: linear-gradient(120deg,#F66A0E,#15C2DA);\r\n"
					+ "	height: 100vh;\r\n"
					+ "	overflow:hidden;\r\n"
					+ "}\r\n"
					+ "h1{\r\n"
					+ "	position:absolute;\r\n"
					+ "	top: 50%;\r\n"
					+ "    left: 50%;\r\n"
					+ "    transform: translate(-50%, -50%);\r\n"
					+ "	text-align: center;\r\n"
					+ "    margin: 0 auto;\r\n"
					+ "    float: center;\r\n"
					+ "    color: #ff0000;\r\n"
					+ "    font-size: 60px;\r\n"
					+ "    font-weight: bold;\r\n"
					+ "}\r\n"
					+ "</style> ");
			
		}
		finally 
		{
			if(con!=null) 
			{
				try 
				{
					con.close();
				}catch(SQLException e) {e.printStackTrace();}
				
			}
		}
	}

}
