package mainpackage.Servelts;

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
import javax.servlet.http.HttpSession;


@WebServlet("/AdminServletSearchUser")
public class AdminServletSearchUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AdminServletSearchUser() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session!=null) {
	
		String url = "jdbc:mysql://localhost:3306/cinema_last";
		try {
		PrintWriter po=response.getWriter();
		response.setContentType("text/html");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,"root","g1234567890");
		
		String username = request.getParameter("USER-USERNAME");
		PreparedStatement ps=con.prepareStatement("select * FROM user where username=?");
		ps.setString(1,username);
		ResultSet rs =ps.executeQuery();
		
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
			String user_username = rs.getString("username");
			String user_email = rs.getString("email");
			String user_password = rs.getString("password");
			String user_role = rs.getString("role");
			po.println("<tr><td>"+user_username +"</td><td>"+user_email+"</td><td>"+ user_password+"</td><td>"+user_role+"</td></td>\r\n");
			
		}
		ps.close();
		

		}catch(Exception e) {e.printStackTrace();}
		
		
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
