package mainpackage.Servelts;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mainpackage.ExtraHelp.ExtraHelp;

@WebServlet("/ClientServletMakeReservation")
public class ClientServletMakeReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ClientServletMakeReservation() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session!=null) {
			int IDpelath = (Integer) session.getAttribute("userID");
		Connection con=null;
		String url = "jdbc:mysql://localhost:3306/cinema_last";
		
		PrintWriter pw = response.getWriter();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,"root","g1234567890");
			
			String Projection_ID = request.getParameter("PROJECTION-ID");
			int Numofseats = Integer.parseInt(request.getParameter("NumberOfSeats"));
			int	Customer_ID=IDpelath;
			int movieID = 0;
			int CinemaID = 0;
			String movieName = "";
			int avSeats=0;
			String projectionDatetime = "";
			int ContentAdminID =0;
			
	
			
			
			PreparedStatement ps3=con.prepareStatement("select * FROM provoles where ID=?");
			ps3.setString(1,Projection_ID);
			ResultSet rs3 =ps3.executeQuery();
			if(rs3.next()) 
			{
				movieID=rs3.getInt("MOVIES_ID");
				CinemaID=rs3.getInt("CINEMAS_ID");
				movieName=rs3.getString("MOVIES_NAME");
				avSeats=rs3.getInt("AVAILABLE-SEATS");
				ContentAdminID=rs3.getInt("CONTENT_ADMIN_ID");
				projectionDatetime=rs3.getString("PROJECTION-DATETIME");
			}
			//ΕΔΩ ΠΑΙΡΝΕΙ ΕΝΤΑΞΕΙ ΤΙΣ ΜΕΤΑΒΛΗΤΕΣ
			int count = 0;
			int count2=0;
			if(avSeats - Numofseats >= 0) {
				
			String query = "insert into reservations values(?,?,?,?,?,?)"; 
			
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1,movieID);
			ps.setString(2,movieName);
			ps.setInt(3,CinemaID);
			ps.setInt(4,Customer_ID);
			ps.setInt(5,Numofseats);
			ps.setString(6,Projection_ID);
			count=ps.executeUpdate();
			
			PreparedStatement geo = con.prepareStatement("delete from provoles where ID = ?");
			geo.setString(1,Projection_ID );
			geo.executeUpdate();
	
		
			
			PreparedStatement damn2=con.prepareStatement("insert into provoles values(?,?,?,?,?,?,?)");
			damn2.setInt(1,movieID);
			damn2.setString(2,movieName);
			damn2.setInt(3,CinemaID);
			damn2.setString(4,Projection_ID);
			damn2.setInt(5,ContentAdminID);
			damn2.setString(6,projectionDatetime);
			damn2.setInt(7,avSeats-Numofseats);
			count2=damn2.executeUpdate();
			
					
			}
			
			
			
			
			if(count>0 && count2>0) 
			{
				pw.println("<head>\r\n"
						+ "<meta charset=\"UTF-8\">\r\n"
						+ "<title>LoginForm</title>\r\n"
						+ "<link rel=\"stylesheet\" href=\"style3.css\">\r\n"
						+ "</head>\r\n"
						+ "<body>\r\n"
						+ "<h1 style=\"text-align:center;\">Reservation has been made successfully!!!</h1>\r\n"
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
