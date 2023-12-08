package mainpackage.Servelts;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AdminServletCreateUser")
public class AdminServletCreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminServletCreateUser() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session!=null) {
		
		String username = request.getParameter("txtUsername");
		String password = request.getParameter("txtPassword");
		String name = request.getParameter("txtName");
		String email = request.getParameter("txtEmail");
		String role = request.getParameter("dropdownlist");
		Connection con=null;
		String url = "jdbc:mysql://localhost:3306/cinema_last";
		PrintWriter pw = response.getWriter();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,"root","g1234567890");
			PreparedStatement ps = con.prepareStatement("insert into user values (?,?,?,?,?,?)");
			ps.setString(1, username);
			ps.setString(2, email);
			ps.setString(3, password);
			ps.setString(4,LocalDateTime.now().toString());
			ps.setString(5, "");
			ps.setString(6, role);
			ps.executeUpdate();
			
			
			if(role.equalsIgnoreCase("ContentAdmin")) {
				Random rand = new Random();
			PreparedStatement geo = con.prepareStatement("insert into content_admin values (?,?,?)");
			geo.setInt(1, rand.nextInt(1000000,9548294));
			geo.setString(2, name);
			geo.setString(3, username);
			geo.executeUpdate();
			
			PrintWriter po=response.getWriter();
			response.setContentType("text/html");
			po.println("<head>\r\n"
					+ "<meta charset=\"UTF-8\">\r\n"
					+ "<title>Admin</title>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "<h1 style=\"text-align:center;\">User Created Successfully!!!.</h1>\r\n"
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
				Random rand2 = new Random();
				PreparedStatement geo2 = con.prepareStatement("insert into admins values (?,?,?)");
				geo2.setInt(1, rand2.nextInt(1000000,9548294));
				geo2.setString(2, name);
				geo2.setString(3, username);
				geo2.executeUpdate();
				
				PrintWriter po2=response.getWriter();
				response.setContentType("text/html");
				po2.println("<head>\r\n"
						+ "<meta charset=\"UTF-8\">\r\n"
						+ "<title>Admin</title>\r\n"
						+ "</head>\r\n"
						+ "<body>\r\n"
						+ "<h1 style=\"text-align:center;\">User Created Successfully!!!.</h1>\r\n"
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
				Random rand3 = new Random();
				PreparedStatement geo3 = con.prepareStatement("insert into customers values (?,?,?)");
				geo3.setInt(1, rand3.nextInt(1000000,9548294));
				geo3.setString(2, name);
				geo3.setString(3, username);
				geo3.executeUpdate();
				
				PrintWriter po3=response.getWriter();
				response.setContentType("text/html");
				po3.println("<head>\r\n"
						+ "<meta charset=\"UTF-8\">\r\n"
						+ "<title>Admin</title>\r\n"
						+ "</head>\r\n"
						+ "<body>\r\n"
						+ "<h1 style=\"text-align:center;\">User Created Successfully!!!.</h1>\r\n"
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
					+ "<h1 style=\"text-align:center;\">ERROR!!!Invalid informations.</h1>\r\n"
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
		}else {PrintWriter po=response.getWriter();
		response.setContentType("text/html");
		po.println("<head>\r\n"
				+ "<meta charset=\"UTF-8\">\r\n"
				+ "<title>LoginForm</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "<h1 style=\"text-align:center;\">Login Again. Session expired <a href=\"index.html\">Try again</a></h1>\r\n"
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
				+ "</style>");}
		
	}

}
