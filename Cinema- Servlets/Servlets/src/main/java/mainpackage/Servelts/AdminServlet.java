package mainpackage.Servelts;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminServlet() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if(session!=null) {
		
		
		
		String act = request.getParameter("dropdownlist");
		 if (act.equalsIgnoreCase("Create User")) {
			 
				PrintWriter writer= response.getWriter();
				response.setContentType("text/html");
				writer.println("<head>\r\n"
						+ "<meta charset=\"UTF-8\">\r\n"
						+ "<title>CreateUser</title>\r\n"
						+ "<link rel=\"stylesheet\" href=\"SignupStyle.css\">\r\n"
						+ "</head>\r\n"
						+ "<body>\r\n"
						+ "	<div class=\"center\">\r\n"
						+ "	<h1>Create-User</h1>\r\n"
						+ "	<form method=\"post\" action=AdminServletCreateUser>\r\n"
						+ "	<div class=\"txt_field\">\r\n"
						+ "	<input type=\"text\" required name=\"txtUsername\" id=\"txtUsername\">\r\n"
						+ "	<span></span>\r\n"
						+ "	<label>Username</label>\r\n"
						+ "	</div>\r\n"
						+ "	\r\n"
						+ "	<div class=\"txt_field\">\r\n"
						+ "	<input type=\"password\" required name=\"txtPassword\" id=\"txtPassword\">\r\n"
						+ "	<span></span>\r\n"
						+ "	<label>Password</label>\r\n"
						+ "	</div>\r\n"
						+ "	\r\n"
						+ "	<div class=\"txt_field\">\r\n"
						+ "	<input type=\"text\" required name=\"txtName\" id=\"txtName\">\r\n"
						+ "	<span></span>\r\n"
						+ "	<label>Name</label>\r\n"
						+ "	</div>\r\n"
						+ "	\r\n"
						+ "	<div class=\"txt_field\">\r\n"
						+ "	<input type=\"email\" required name=\"txtEmail\" id=\"txtEmail\">\r\n"
						+ "	<span></span>\r\n"
						+ "	<label>Email</label>\r\n"
						+ "	</div>\r\n"
						+ "	\r\n"
						+ "	\r\n"
						+ "	<div class=\"select\">\r\n"
						+ "	<label style=\"font-family:montserrat;\">Role: </label><select name=\"dropdownlist\" id=\"dropdownlist\" required>\r\n"
						+ "	<option selected disabled>Role</option>\r\n"
						+ "	<option value=\"Customer\" selected>Customer</option>\r\n"
						+ "	<option value=\"Admin\">Admin</option>\r\n"
						+ "	<option value=\"ContentAdmin\">ContentAdmin</option>\r\n"
						+ "	</select>\r\n"
						+ "	</div>\r\n"
						+ "	\r\n"
						+ "	\r\n"
						+ "	<input type=\"submit\" value=\"Submit\">\r\n"
						+ "	</form>\r\n"
						+ "	</div>\r\n"
						+ "</body>");
		
			 
			 
			 
			 
			 
		} else if (act.equalsIgnoreCase("Delete User")) {
			
			PrintWriter writer= response.getWriter();
			response.setContentType("text/html");
			writer.println("<head>\r\n"
					+ "<meta charset=\"UTF-8\">\r\n"
					+ "<title>DeleteUser</title>\r\n"
					+ "<link rel=\"stylesheet\" href=\"style4.css\">\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "<h1 style=\"font-size:30px\">Delete User by Username</h1>\r\n"
					+ "<form method=\"post\" action=AdminServletDeleteUser >\r\n"
					+ "<label for=\"name\" class=\"input-label\" style=\"font-size:17px;\">User-username</label>\r\n"
					+ "<input type=\"text\" id=\"USER-USERNAME\" name=\"USER-USERNAME\"  placeholder=\"Enter username \" required class=\"text-input\">\r\n"
					+ "\r\n"
					+ "<input style=\"background-color:#333333;color:#F66A0E;border-radius:10px;position:fixed;left:45%;top:60%;font-size:1.4rem;\"  type=\"submit\" value=\"submit\" />\r\n"
					+ "</form>\r\n"
					+ "</body>");
			
			
			
			
			
			
		} else if(act.equalsIgnoreCase("Search User")) {
			
			
			
			PrintWriter writer= response.getWriter();
			response.setContentType("text/html");
			writer.println("<head>\r\n"
					+ "<meta charset=\"UTF-8\">\r\n"
					+ "<title>SearchUser</title>\r\n"
					+ "<link rel=\"stylesheet\" href=\"style4.css\">\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "<h1 style=\"font-size:30px\">Search User by Username</h1>\r\n"
					+ "<form method=\"post\" action=AdminServletSearchUser >\r\n"
					+ "<label for=\"name\" class=\"input-label\" style=\"font-size:17px;\">Search-Username</label>\r\n"
					+ "<input type=\"text\" id=\"USER-USERNAME\" name=\"USER-USERNAME\"  placeholder=\"Enter username \" required class=\"text-input\">\r\n"
					+ "\r\n"
					+ "<input style=\"background-color:#333333;color:#F66A0E;border-radius:10px;position:fixed;left:45%;top:60%;font-size:1.4rem;\"  type=\"submit\" value=\"submit\" />\r\n"
					+ "</form>\r\n"
					+ "</body>");
			
			
		}
		 else if(act.equalsIgnoreCase("View all Users")) {
			 
			 PrintWriter po = response.getWriter();
				String url = "jdbc:mysql://localhost:3306/cinema_last";
				Connection con2;
				try {
				con2 = DriverManager.getConnection(url,"root","g1234567890");
				String sqldtbs ="select * from user"; 
				PreparedStatement ge = con2.prepareStatement(sqldtbs);
				ResultSet rs = ge.executeQuery();
				po.println("<head>\r\n"
						+ "<meta charset=\"UTF-8\">\r\n"
						+ "<title>Admin</title>\r\n"
						+"<link rel=\"stylesheet\" href=\"style3.css\"\r\n"
						+ "</head>\r\n"
						+ "<body>\r\n"
						+"<div class=\"filter\">\r\n"
						+ "</div>\r\n"
						+ "<table>\r\n"
						+ "<thead>\r\n"
						+ "<tr>\r\n"
						+ "	<th>USERNAME</th>\r\n"
						+ "	<th>EMAIL</th>\r\n"
						+ "	<th>PASSWORD</th>\r\n"
						+ "	<th>ROLE</th>\r\n"
						+ "</tr>\r\n"
						+ "</thead>\r\n"
						+ "<tbody>\r\n");
				
				while(rs.next()) {

					String username = rs.getString("username");
					String email = rs.getString("email");
					String password = rs.getString("password");
					String role = rs.getString("role");
					po.println("<tr><td>"+ username+"</td><td>"+email+"</td><td>"+password+"</td><td>"+role+"\r\n");
					
				}
				ge.close();
				
				
				}catch(Exception e){
					e.printStackTrace();
				}
			 
			}
		 else if(act.equalsIgnoreCase("Logout")) {
			//PREPEI NA KATHARISW KAI THN CACHE APO TO SESSION MANAGEMENT
			 	session.removeAttribute("userID");
	            session.invalidate();  
			 
			 
			 	response.setContentType("text/html");
				response.sendRedirect("index.html");
				
			}
		}else 
		{PrintWriter po=response.getWriter();
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
				+ "</style>");
			
		}
	}
}


