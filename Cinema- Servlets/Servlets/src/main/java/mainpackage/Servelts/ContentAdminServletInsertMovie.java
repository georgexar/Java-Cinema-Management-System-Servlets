package mainpackage.Servelts;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/ContentAdminServletInsertMovie")
public class ContentAdminServletInsertMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ContentAdminServletInsertMovie() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession(false);
		if(session!=null) {
		
		
		
		int movieid = Integer.parseInt(request.getParameter("MOVIE-ID"));
		String movieName = request.getParameter("MOVIE-NAME");
		String movieContent= request.getParameter("MOVIE-CONTENT");
		int movieLength=Integer.parseInt(request.getParameter("MOVIE-LENGTH"));
		String movieType= request.getParameter("MOVIE-TYPE");
		String movieSummary= request.getParameter("MOVIE-SUMMARY");
		String movieDirector= request.getParameter("MOVIE-DIRECTOR");
		int contentAdminId = Integer.parseInt(request.getParameter("CONTENTADMIN-ID"));
		Connection con=null;
		String url = "jdbc:mysql://localhost:3306/cinema_last";
		
		PrintWriter pw = response.getWriter();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,"root","g1234567890");
			String query = "insert into movies values(?,?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1,movieid);
			ps.setString(2,movieName);
			ps.setString(3,movieContent);
			ps.setInt(4,movieLength);
			ps.setString(5,movieType);
			ps.setString(6,movieSummary);
			ps.setString(7,movieDirector);
			ps.setInt(8,contentAdminId);
		
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
