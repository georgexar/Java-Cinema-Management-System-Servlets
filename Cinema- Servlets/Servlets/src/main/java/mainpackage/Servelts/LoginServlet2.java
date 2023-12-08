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

import mainpackage.ExtraHelp.ExtraHelp;
@WebServlet("/LoginServlet2")
public class LoginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginServlet2() {
        super();
      
    }
    
  
    
    public static int userID;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "jdbc:mysql://localhost:3306/cinema_last";
		try {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,"root","g1234567890");
		
		if(con == null) {
			out.println("<a>Connection failed!</a>");
			return;
		}
		String name = request.getParameter("txtName");
		String password = request.getParameter("txtPassword");
		PreparedStatement ps=con.prepareStatement("select * FROM user where username=? and password=?");
		ps.setString(1,name);
		ps.setString(2,password);
		ResultSet rs =ps.executeQuery();
		int id =0;
		if(rs.next()) 
		{
			
			
			
			String role= rs.getString("role");
			if(role.equalsIgnoreCase("ContentAdmin"))
			{	
				PreparedStatement ps2=con.prepareStatement("select * FROM content_admin where user_username=?");
				ps2.setString(1,name);
				ResultSet rs2 =ps2.executeQuery();
				if(rs2.next()) 
				{
					id = rs2.getInt("ID");
					//userID = id ;
				}
					HttpSession session=request.getSession();
			        session.setAttribute("userID",id);  
			        session.setMaxInactiveInterval(30*60);//30 LEPTA MPOREI NA EINAI ANENENERGOS MEXRI NA GINEI DISCONNECT
				
				
				
				
				PrintWriter po = response.getWriter();
				response.setContentType("text/html");
					po.println("<head>\r\n"
							+ "<meta charset=\"UTF-8\">\r\n"
							+ "<title>ContentAdmin</title>\r\n"
							+ "<link rel=\"stylesheet\" href=\"style2.css\">\r\n"
							+ "</head>\r\n"
							+ "<body style=\"overflow: hidden;color:#FFF8DC;\">\r\n"
							+ "<form method=\"post\" action=ContentAdminServlet>\r\n"
							+ "<h1>Welcome ContentAdmin With ID:"+id+"</h1>\r\n"
							+ "<h1>Choose an option</h1>\r\n"
							+ "<div class=\"select\">\r\n"
							+ "	<select name=\"dropdownlist\" id=\"dropdownlist\">\r\n"
							+ "	<option selected disabled>Options</option>\r\n"
							+ "	<option value=\"View all available movies\" selected>View all available movies</option>\r\n"
							+ "	<option value=\"Insert new movie\">Insert new movie</option>\r\n"
							+ "	<option value=\"View Available Projections\">View Available Projections</option>\r\n"
							+ "	<option value=\"Create Projection\">Create Projection</option>\r\n"
							+ "	<option value=\"Delete Projection\">Delete Projection</option>\r\n"
							+ "	<option value=\"Logout\">Logout</option>\r\n"
							+ "	</select> \r\n"
							+ "</div>\r\n"
							+ "<input style=\"background-color:#333333;color:#F66A0E;border-radius:10px;position:fixed;left:52%;top:56%;font-size:1.4rem;\"  type=\"submit\" value=\"submit\" />\r\n"
							+ "</form>\r\n"
							+ "</body>");
			}else if(role.equalsIgnoreCase("Admin")) 
			{	
				PreparedStatement ps3=con.prepareStatement("select * FROM admins where user_username=?");
				ps3.setString(1,name);
				ResultSet rs3 =ps3.executeQuery();
				if(rs3.next()) 
				{
					id = rs3.getInt("ID");
					//userID = id ;
				}
				
					HttpSession session=request.getSession();
			        session.setAttribute("userID",id);  
			        session.setMaxInactiveInterval(30*60);
				
				
				PrintWriter po=response.getWriter();
				response.setContentType("text/html");
				po.println("<head>\r\n"
						+ "<meta charset=\"UTF-8\">\r\n"
						+ "<title>Admin</title>\r\n"
						+ "<link rel=\"stylesheet\" href=\"style2.css\">\r\n"
						+ "</head>\r\n"
						+ "<body style=\"overflow: hidden;color:#FFF8DC;\">\r\n"
						+ "<form method=\"post\" action=AdminServlet>\r\n"
						+ "<h1>Welcome Admin With ID:"+id+"</h1>\r\n"
						+ "<h1>Choose an option</h1>\r\n"
						+ "<div class=\"select\">\r\n"
						+ "	<select name=\"dropdownlist\" id=\"dropdownlist\">\r\n"
						+ "	<option selected disabled>Options</option>\r\n"
						+ "	<option value=\"Create User\" selected>Create User</option>\r\n"
						+ "	<option value=\"Search User\">Search User</option>\r\n"
						+ "	<option value=\"View all Users\">View all Users</option>\r\n"
						+ "	<option value=\"Delete User\">Delete User</option>\r\n"
						+ "	<option value=\"Logout\">Logout</option>\r\n"
						+ "	</select> \r\n"
						+ "</div>\r\n"
						+ "<input style=\"background-color:#333333;color:#F66A0E;border-radius:10px;position:fixed;left:54%;top:56%;font-size:1.4rem;\"  type=\"submit\" value=\"submit\" />\r\n"
						+ "</form>\r\n"
						+ "</body>");
			}else if(role.equalsIgnoreCase("Customer")) 
			{   
				PreparedStatement ps4=con.prepareStatement("select * FROM customers where user_username=?");
				ps4.setString(1,name);
				ResultSet rs4 =ps4.executeQuery();
				if(rs4.next()) { 
				
					id = rs4.getInt("ID");
					//userID = id ;
				}
					HttpSession session=request.getSession();
			        session.setAttribute("userID",id);  
			        session.setMaxInactiveInterval(30*60);
			     //   int IDpelath = (Integer) session.getAttribute("userID"); //ETSI PAIRNW TIMH APO TO SESSION SWSTA
				
				
				PrintWriter po=response.getWriter();
				response.setContentType("text/html");
				po.println("<head>\r\n"
						+ "<meta charset=\"UTF-8\">\r\n"
						+ "<title>Customer</title>\r\n"
						+ "<link rel=\"stylesheet\" href=\"style2.css\">\r\n"
						+ "</head>\r\n"
						+ "<body style=\"overflow: hidden;color:#FFF8DC;\">\r\n"
						+ "<form method=\"post\" action=ClientServlet>\r\n"
						+ "<h1>Welcome Customer With ID:"+id+"</h1>\r\n"
						+ "<h1>Choose an option</h1>\r\n"
						+ "<div class=\"select\">\r\n"
						+ "	<select name=\"dropdownlist\" id=\"dropdownlist\">\r\n"
						+ "	<option selected disabled>Options</option>\r\n"
						+ "	<option value=\"View all available Projections\" selected>View available Projections</option>\r\n"
						+ "	<option value=\"View my Reservations\">View my Reservations</option>\r\n"
						+ "	<option value=\"Make a Reservation\">Make a Reservation</option>\r\n"
						+ "	<option value=\"Logout\">Logout</option>\r\n"
						+ "	</select> \r\n"
						+ "</div>\r\n"
						+ "<input style=\"background-color:#333333;color:#F66A0E;border-radius:10px;position:fixed;left:54%;top:56%;font-size:1.4rem;\"  type=\"submit\" value=\"submit\" />\r\n"
						+ "</form>\r\n"
						+ "</body>");
			}			
			
			
		}else 
		{
			PrintWriter po=response.getWriter();
			response.setContentType("text/html");
			po.println("<head>\r\n"
					+ "<meta charset=\"UTF-8\">\r\n"
					+ "<title>LoginForm</title>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "<h1 style=\"text-align:center;\">Unable to Login <a href=\"index.html\">Try again</a></h1>\r\n"
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
		
		
		
		}catch(Exception e){
			e.printStackTrace();
		
		}
		
	}

}

	


