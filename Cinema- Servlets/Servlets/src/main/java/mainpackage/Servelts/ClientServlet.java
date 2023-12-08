package mainpackage.Servelts;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Instant;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mainpackage.ExtraHelp.ExtraHelp;

@WebServlet("/ClientServlet")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ClientServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if(session!=null) {
			
			
			int IDpelath = (Integer) session.getAttribute("userID");
	
		
		String act = request.getParameter("dropdownlist");

		
		
		 if (act.equalsIgnoreCase("View all available Projections")) {	
							 PrintWriter po = response.getWriter();
								String url = "jdbc:mysql://localhost:3306/cinema_last";
								Connection con2;
								try {
								con2 = DriverManager.getConnection(url,"root","g1234567890");
								String sqldtbs ="select * from provoles"; 
								PreparedStatement ge = con2.prepareStatement(sqldtbs);
								ResultSet rs = ge.executeQuery();
								po.println("<head>\r\n"
										+ "<meta charset=\"UTF-8\">\r\n"
										+ "<title>Customer</title>\r\n"
										+"<link rel=\"stylesheet\" href=\"style3.css\"\r\n"
										+ "</head>\r\n"
										+ "<body>\r\n"
										+"<div class=\"filter\">\r\n"
										+ "</div>\r\n"
										+ "<table>\r\n"
										+ "<thead>\r\n"
										+ "<tr>\r\n"
										+ "	<th>MOVIE-ID</th>\r\n"
										+ "	<th>MOVIE-NAME</th>\r\n"
										+ "	<th>CINEMA-ID</th>\r\n"
										+ "	<th>PROJECTION-ID</th>\r\n"
										+ "	<th>PROJECTION-DATETIME</th>\r\n"
										+ "	<th>AVAILABLE-SEATS</th>\r\n"
										+ "</tr>\r\n"
										+ "</thead>\r\n"
										+ "<tbody>\r\n");
								
								while(rs.next()) {
									int movieid = rs.getInt("MOVIES_ID");
									String movieName = rs.getString("MOVIES_NAME");
									int cinemaid = rs.getInt("CINEMAS_ID");
									String projectionid = rs.getString("ID");
									String projectionDateTime = rs.getString("PROJECTION-DATETIME");
									int availableseats = rs.getInt("AVAILABLE-SEATS");
									po.println("<tr><td>"+ movieid+"</td><td>"+movieName+"</td><td>"+cinemaid+"</td><td>"+projectionid+"</td><td>"+projectionDateTime+"</td><td>"+availableseats+"</td></td>\r\n");
									}
								ge.close();
								
								
								}catch(Exception e){
									e.printStackTrace();
								}
	 
		} else if (act.equalsIgnoreCase("View my Reservations")) {
			
	
			 	PrintWriter po = response.getWriter();
				String url = "jdbc:mysql://localhost:3306/cinema_last";
				Connection con2;
				try {
				
				con2 = DriverManager.getConnection(url,"root","g1234567890");
				String sqldtbs ="select * from reservations where CUSTOMERS_ID=?"; 
				PreparedStatement ge = con2.prepareStatement(sqldtbs);
			//	ge.setInt(1,LoginServlet2.userID);
				ge.setInt(1,IDpelath);
				ResultSet rs = ge.executeQuery();
				po.println("<head>\r\n"
						+ "<meta charset=\"UTF-8\">\r\n"
						+ "<title>Customer</title>\r\n"
						+"<link rel=\"stylesheet\" href=\"style3.css\"\r\n"
						+ "</head>\r\n"
						+ "<body>\r\n"
						+"<div class=\"filter\">\r\n"
						+ "</div>\r\n"
						+ "<table>\r\n"
						+ "<thead>\r\n"
						+ "<tr>\r\n"
						+ "	<th>PROJECTION-ID</th>\r\n"
						+ "	<th>MOVIE-ID</th>\r\n"
						+ "	<th>MOVIE-NAME</th>\r\n"
						+ "	<th>CINEMA-ID</th>\r\n"
						+ "	<th>NUMBER OF SEATS</th>\r\n"
						+ "</tr>\r\n"
						+ "</thead>\r\n"
						+ "<tbody>\r\n");
				
				while(rs.next()) {
					String provoliID = rs.getString("PROVOLES_ID");
					int movieid = rs.getInt("PROVOLES_MOVIES_ID");
					String movieName = rs.getString("PROVOLES_MOVIES_NAME");
					int cinemaid = rs.getInt("PROVOLES_CINEMAS_ID");
					int seatsyoubooked = rs.getInt("NUMBER_OF_SEATS");
					po.println("<tr><td>"+ provoliID+"</td><td>"+movieid+"</td><td>"+movieName+"</td><td>"+cinemaid+"</td><td>"+seatsyoubooked+"</td>\r\n");
					}
				ge.close();
				
				}catch(Exception e) {e.printStackTrace();}
			
			
			
			
			
			
			
			
			
			
		} else if(act.equalsIgnoreCase("Make a Reservation")) {
			PrintWriter writer= response.getWriter();
			response.setContentType("text/html");
			writer.println("<head>\r\n"
					+ "<meta charset=\"UTF-8\">\r\n"
					+ "<title>Customer</title>\r\n"
					+ "<link rel=\"stylesheet\" href=\"style4.css\">\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "<h1 style=\"font-size:30px\">Make Reservation</h1>\r\n"
					+ "<form method=\"post\" action=ClientServletMakeReservation >\r\n"
					+ "<div class=\"input-container\">\r\n"
					+ "<label for=\"name\" class=\"input-label\" style=\"font-size:17px;\">Projection-ID</label>\r\n"
					+ "<input type=\"text\" id=\"PROJECTION-ID\" name=\"PROJECTION-ID\"  placeholder=\"Enter projection-ID\" required class=\"text-input\">\r\n"
					+ "\r\n"
					+ "<label for=\"name\" class=\"input-label\" style=\"font-size:17px;\">Number Of Seats</label>\r\n"
					+ "<input type=\"number\" id=\"NumberOfSeats\" name=\"NumberOfSeats\" placeholder=\"Enter Number Of Seats\" required class=\"text-input\">\r\n"
					+ "\r\n"
					+ "<input style=\"background-color:#333333;color:#F66A0E;border-radius:10px;position:fixed;left:46%;top:64%;font-size:1.4rem;\"  type=\"submit\" value=\"submit\" />\r\n"
					+ "</div>\r\n"
					+ "</form>\r\n"
					+ "</body>");
		}
		else if(act.equalsIgnoreCase("Logout")) {
			//PREPEI NA KATHARISW KAI THN CACHE APO TO SESSION MANAGEMENT
			session.removeAttribute("userID");
            session.invalidate();  
			
			response.setContentType("text/html");
			response.sendRedirect("index.html");
			
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


