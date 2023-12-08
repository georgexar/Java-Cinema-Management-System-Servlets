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




@WebServlet("/ContentAdminServlet")
public class ContentAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ContentAdminServlet() {
        super(); 
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession(false);
		if(session!=null) {
		
		
		String act = request.getParameter("dropdownlist");
		if (act.equalsIgnoreCase("View all available movies")) {
	
			PrintWriter po = response.getWriter();
			String url = "jdbc:mysql://localhost:3306/cinema_last";
			Connection con2;
			try {
			con2 = DriverManager.getConnection(url,"root","g1234567890");
			String sqldtbs ="select * from movies"; 
			PreparedStatement ge = con2.prepareStatement(sqldtbs);
			ResultSet rs = ge.executeQuery();
			po.println("<head>\r\n"
					+ "<meta charset=\"UTF-8\">\r\n"
					+ "<title>ContentAdmin</title>\r\n"
					+"<link rel=\"stylesheet\" href=\"style3.css\"\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+"<div class=\"filter\">\r\n"
					+ "</div>\r\n"
					+ "<table>\r\n"
					+ "<thead>\r\n"
					+ "<tr>\r\n"
					+ "	<th>ID</th>\r\n"
					+ "	<th>NAME</th>\r\n"
					+ "	<th>TYPE</th>\r\n"
					+ "	<th>DIRECTOR</th>\r\n"
					+ "	<th>SUMMARY</th>\r\n"
					+ "</tr>\r\n"
					+ "</thead>\r\n"
					+ "<tbody>\r\n");
			
			while(rs.next()) {
				int ID = rs.getInt("ID");
				String Name = rs.getString("NAME");
				String Type = rs.getString("TYPE");
				String Summary = rs.getString("SUMMARY");
				String Director = rs.getString("DIRECTOR");
				po.println("<tr><td>"+ ID+"</td><td>"+Name+"</td><td>"+Type+"</td><td>"+Director+"</td><td>"+Summary+"</td></td>\r\n");
				
			}
			ge.close();
			
			
			}catch(Exception e){
				e.printStackTrace();
			}
			
		} else if (act.equalsIgnoreCase("Insert new movie")) {
			//ΠΡΕΠΕΙ ΝΑ ΤΗΝ ΦΤΙΑΞΩ ΔΥΝΑΜΙΚΑ ΑΛΛΑ ΔΕΝ ΔΗΜΙΟΥΡΓΕΙΤΑΙ ΣΩΣΤΑ Η ΣΕΛΙΔΑ
			PrintWriter writer= response.getWriter();
			response.setContentType("text/html");
			writer.println("<head>\r\n"
					+ "<meta charset=\"UTF-8\">\r\n"
					+ "<title>ContentAdmin</title>\r\n"
					+ "<link rel=\"stylesheet\" href=\"style4.css\">\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "<h1 style=\"font-size:30px\">Fill The Movie Attributes</h1>\r\n"
					+ "<form method=\"post\" action=ContentAdminServletInsertMovie >\r\n"
					+ "<div class=\"input-container\">\r\n"
					+ "<label for=\"name\" class=\"input-label\" style=\"font-size:17px;\" >Movie-ID</label>\r\n"
					+ "<input type=\"number\" id=\"MOVIE-ID\" name=\"MOVIE-ID\"  placeholder=\"Enter movie-ID\" required class=\"text-input\">\r\n"
					+ "\r\n"
					+ "<label for=\"name\" class=\"input-label\" style=\"font-size:17px;\">Movie-Name</label>\r\n"
					+ "<input type=\"text\" id=\"MOVIE-NAME\" name=\"MOVIE-NAME\"  placeholder=\"Enter movie name\" required class=\"text-input\">\r\n"
					+ "\r\n"
					+ "<label for=\"name\" class=\"input-label\" style=\"font-size:17px;\">Movie-Content</label>\r\n"
					+ "<input type=\"text\" id=\"MOVIE-CONTENT\" name=\"MOVIE-CONTENT\"  placeholder=\"Enter movie content\" required class=\"text-input\">\r\n"
					+ "\r\n"
					+ "<label for=\"name\" class=\"input-label\" style=\"font-size:17px;\">Movie-Length</label>\r\n"
					+ "<input type=\"number\" id=\"MOVIE-LENGTH\" name=\"MOVIE-LENGTH\" placeholder=\"Enter movie length\" required class=\"text-input\">\r\n"
					+ "\r\n"
					+ "<label for=\"name\" class=\"input-label\" style=\"font-size:17px;\">Movie-Type</label>\r\n"
					+ "<input type='text' id=\"MOVIE-TYPE\" name=\"MOVIE-TYPE\" placeholder=\"Enter movie type\" required class=\"text-input\">\r\n"
					+ "\r\n"
					+ "<label for=\"name\" class=\"input-label\" style=\"font-size:17px;\">Movie-Summary</label>\r\n"
					+ "<input type=\"text\"id=\"MOVIE-SUMMARY\" name=\"MOVIE-SUMMARY\"  placeholder=\"Enter movie summary\" required class=\"text-input\">\r\n"
					+ "\r\n"
					+ "<label for=\"name\" class=\"input-label\" style=\"font-size:17px;\">Movie-Director</label>\r\n"
					+ "<input type='text' id=\"MOVIE-DIRECTOR\" name=\"MOVIE-DIRECTOR\" placeholder=\"Enter movie director\"required class=\"text-input\">\r\n"
					+ "\r\n"
					+ "<label for=\"name\" class=\"input-label\" style=\"font-size:17px;\">ContentAdmin-ID</label>\r\n"
					+ "<input type=\"number\" id=\"CONTENTADMIN-ID\" name=\"CONTENTADMIN-ID\"  placeholder=\"Enter CAdminID\" required class=\"text-input\"><br>\r\n"
					+ "<input style=\"background-color:#333333;color:#F66A0E;border-radius:10px;position:fixed;left:42%;top:83%;font-size:1.4rem;\"  type=\"submit\" value=\"submit\" />\r\n"
					+ "</div>\r\n"
					+ "</form>\r\n"
					+ "</body>");
			
			
			
		} else if(act.equalsIgnoreCase("Create Projection")) {
			
			PrintWriter writer= response.getWriter();
			response.setContentType("text/html");
			writer.println("<head>\r\n"
					+ "<meta charset=\"UTF-8\">\r\n"
					+ "<title>ContentAdmin</title>\r\n"
					+ "<link rel=\"stylesheet\" href=\"style4.css\">\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "<h1 style=\"font-size:30px\">Fill The Projection Attributes</h1>\r\n"
					+ "<form method=\"post\" action=ContentAdminServletCreateProjection >\r\n"
					+ "<div class=\"input-container\">\r\n"
					+ "<label for=\"name\" class=\"input-label\" style=\"font-size:17px;\" >Movie-ID</label>\r\n"
					+ "<input type=\"number\" id=\"MOVIE-ID\" name=\"MOVIE-ID\"  placeholder=\"Enter movie-ID\" required class=\"text-input\">\r\n"
					+ "\r\n"
					+ "<label for=\"name\" class=\"input-label\" style=\"font-size:17px;\">Movie-Name</label>\r\n"
					+ "<input type=\"text\" id=\"MOVIE-NAME\" name=\"MOVIE-NAME\"  placeholder=\"Enter movie name\" required class=\"text-input\">\r\n"
					+ "\r\n"
					+ "<label for=\"name\" class=\"input-label\" style=\"font-size:17px;\">Cinema-ID</label>\r\n"
					+ "<input type=\"number\" id=\"CINEMA-ID\" name=\"CINEMA-ID\"  placeholder=\"Enter cinema-ID\" required class=\"text-input\">\r\n"
					+ "\r\n"
					+ "<label for=\"name\" class=\"input-label\" style=\"font-size:17px;\">Projection-ID</label>\r\n"
					+ "<input type=\"text\" id=\"PROJECTION-ID\" name=\"PROJECTION-ID\" placeholder=\"Enter projection-ID\" required class=\"text-input\">\r\n"
					+ "\r\n"
					+ "<label for=\"name\" class=\"input-label\" style=\"font-size:17px;\">ContentAdmin-ID</label>\r\n"
					+ "<input type='number' id=\"CONTENTADMIN-ID\" name=\"CONTENTADMIN-ID\" placeholder=\"Enter CAdmin-ID\" required class=\"text-input\">\r\n"
					+ "\r\n"
					+ "<label for=\"name\" class=\"input-label\" style=\"font-size:17px; display=grid;\">Date and Time:</label>\r\n"
					+ "<input type='datetime-local' id=\"PROJECTION-DATETIME\" name=\"PROJECTION-DATETIME\" required class=\"text-input\">\r\n"
					+ "<input style=\"background-color:#333333;color:#F66A0E;border-radius:10px;position:fixed;left:40%;top:77%;font-size:1.4rem;\"  type=\"submit\" value=\"submit\" />\r\n"
					+ "</div>\r\n"
					+ "</form>\r\n"
					+ "</body>");
			
		} else if(act.equalsIgnoreCase("Delete Projection")) {
			
			PrintWriter writer= response.getWriter();
			response.setContentType("text/html");
			writer.println("<head>\r\n"
					+ "<meta charset=\"UTF-8\">\r\n"
					+ "<title>DeleteUser</title>\r\n"
					+ "<link rel=\"stylesheet\" href=\"style4.css\">\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "<h1 style=\"font-size:30px\">Delete Projection by ID</h1>\r\n"
					+ "<form method=\"post\" action=ContentAdminServletDeleteProjection >\r\n"
					+ "<label for=\"name\" class=\"input-label\" style=\"font-size:17px;\">Projection-ID</label>\r\n"
					+ "<input type=\"text\" id=\"PROJECTION-ID\" name=\"PROJECTION-ID\"  placeholder=\"Enter projection-ID \" required class=\"text-input\">\r\n"
					+ "\r\n"
					+ "<input style=\"background-color:#333333;color:#F66A0E;border-radius:10px;position:fixed;left:45%;top:60%;font-size:1.4rem;\"  type=\"submit\" value=\"submit\" />\r\n"
					+ "</form>\r\n"
					+ "</body>");
			
			
		}
else if(act.equalsIgnoreCase("View Available Projections")) {
			
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
			
			
		}else if(act.equalsIgnoreCase("Logout")) {
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
