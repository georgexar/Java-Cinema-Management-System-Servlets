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

@WebServlet("/ContentAdminServletDeleteProjection")
public class ContentAdminServletDeleteProjection extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ContentAdminServletDeleteProjection() {
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
		
		String provoliID = request.getParameter("PROJECTION-ID");
		PreparedStatement ps=con.prepareStatement("select * FROM provoles where ID=?");
		ps.setString(1,provoliID);
		ResultSet rs =ps.executeQuery();

		if(rs.next()) 
		{
			
			PreparedStatement geo3 = con.prepareStatement("delete from provoles where ID = ?");
			geo3.setString(1,provoliID );
			geo3.executeUpdate();
			
			
			PreparedStatement geo4 = con.prepareStatement("delete from reservations where PROVOLES_ID = ?");
			geo4.setString(1,provoliID );
			geo4.executeUpdate();
			
			po.println("<head>\r\n"
					+ "<meta charset=\"UTF-8\">\r\n"
					+ "<title>LoginForm</title>\r\n"
					+ "<link rel=\"stylesheet\" href=\"style3.css\">\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "<h1 style=\"text-align:center;\">Projection deleted successfully!!!</h1>\r\n"
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
					+ "    color: #FFE4C4;\r\n"
					+ "    font-size: 60px;\r\n"
					+ "    font-weight: bold;\r\n"
					+ "}\r\n"
					+ "</style>");
			
			
			
			
			
			
		}
		else 
		{
			po.println("<head>\r\n"
					+ "<meta charset=\"UTF-8\">\r\n"
					+ "<title>LoginForm</title>\r\n"
					+ "<link rel=\"stylesheet\" href=\"style3.css\">\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "<h1 style=\"text-align:center;\">ERROR!!!Projection couldnt be found.</h1>\r\n"
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
					+ "</style>");
			
			
			
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
