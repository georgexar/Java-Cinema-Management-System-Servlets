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
import javax.servlet.http.HttpSession;

@WebServlet("/ContentAdminServletCreateProjection")
public class ContentAdminServletCreateProjection extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ContentAdminServletCreateProjection() 
    {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession(false);
		if(session!=null) {
		
		
		
		int movieid = Integer.parseInt(request.getParameter("MOVIE-ID"));
		String movieName = request.getParameter("MOVIE-NAME");
		int cinemaid=Integer.parseInt(request.getParameter("CINEMA-ID"));
		String projectionid = request.getParameter("PROJECTION-ID");
		int contentAdminId = Integer.parseInt(request.getParameter("CONTENTADMIN-ID"));
		String Datetimetostring = request.getParameter("PROJECTION-DATETIME");
		
		Connection con=null;
		String url = "jdbc:mysql://localhost:3306/cinema_last";
		
		PrintWriter pw = response.getWriter();
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,"root","g1234567890");
			
			int availableseats=0;
			PreparedStatement ps2=con.prepareStatement("select * FROM cinemas where ID=?");
			ps2.setInt(1,cinemaid);
			ResultSet rs2 =ps2.executeQuery();
			if(rs2.next()) 
			{
				availableseats = rs2.getInt("SEATS");
			}
			
			
			
			
			String query = "insert into provoles values(?,?,?,?,?,?,?)"; //EVALA KAI TO AVAILABLE SEATS
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1,movieid);
			ps.setString(2,movieName);
			ps.setInt(3,cinemaid);
			ps.setString(4,projectionid);
			ps.setInt(5,contentAdminId);
			ps.setString(6, Datetimetostring);
			ps.setInt(7, availableseats);
			int count=ps.executeUpdate();
			if(count>0) 
			{
				pw.println("<head>\r\n"
						+ "<meta charset=\"UTF-8\">\r\n"
						+ "<title>LoginForm</title>\r\n"
						+ "<link rel=\"stylesheet\" href=\"style3.css\">\r\n"
						+ "</head>\r\n"
						+ "<body>\r\n"
						+ "<h1 style=\"text-align:center;\">Insert was successful!!!</h1>\r\n"
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
			}else 
			{
				pw.println("<head>\r\n"
						+ "<meta charset=\"UTF-8\">\r\n"
						+ "<title>LoginForm</title>\r\n"
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
						+ "</style>");
			}
			
			
		}catch(Exception e)
		{
			pw.println("<head>\r\n"
					+ "<meta charset=\"UTF-8\">\r\n"
					+ "<title>LoginForm</title>\r\n"
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
					+ "</style> " );
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
