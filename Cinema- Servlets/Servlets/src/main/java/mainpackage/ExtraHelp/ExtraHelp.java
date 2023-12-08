package mainpackage.ExtraHelp;

public class ExtraHelp {

	
	
	public static String returnerContentAdmin() 
	{
		return "<head>\r\n"
				+ "<meta charset=\"UTF-8\">\r\n"
				+ "<title>ContentAdmin</title>\r\n"
				+ "<link rel=\"stylesheet\" href=\"style2.css\">\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "<form method=\"post\" action=ContentAdminServlet>\r\n"
				+ "<h1>Welcome ContentAdmin</h1>\r\n"
				+ "<h1>Choose an option</h1>\r\n"
				+ "<div class=\"select\">\r\n"
				+ "	<select name=\"dropdownlist\" id=\"dropdownlist\">\r\n"
				+ "	<option selected disabled>Options</option>\r\n"
				+ "	<option value=\"View all available movies\">View all available movies</option>\r\n"
				+ "	<option value=\"Insert new movie\">Insert new movie</option>\r\n"
				+ "	<option value=\"Create Projection\">Create Projection</option>\r\n"
				+ "	</select> \r\n"
				+ "</div>\r\n"
				+ "<input style=\"background-color:#333333;color:#F66A0E;border-radius:10px;position:fixed;left:58%;top:57%;font-size:1.4rem;\"  type=\"submit\" value=\"submit\" />\r\n"
				+ "</form>\r\n"
				+ "</body>";
	}
	public static String returnerAdmin() 
	{
		return "<head>\r\n"
				+ "<meta charset=\"UTF-8\">\r\n"
				+ "<title>Admin</title>\r\n"
				+ "<link rel=\"stylesheet\" href=\"style2.css\">\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "<form method=\"post\" action=AdminServlet>\r\n"
				+ "<h1>Welcome Admin</h1>\r\n"
				+ "<h1>Choose an option</h1>\r\n"
				+ "<div class=\"select\">\r\n"
				+ "	<select name=\"dropdownlist\" id=\"dropdownlist\">\r\n"
				+ "	<option selected disabled>Options</option>\r\n"
				+ "	<option value=\"Create User\">Create User</option>\r\n"
				+ "	<option value=\"Update User\">Update User</option>\r\n"
				+ "	<option value=\"Search User\">Search User</option>\r\n"
				+ "	<option value=\"View all Users\">View all Users</option>\r\n"
				+ "	<option value=\"Register Admin\">Register Admin</option>\r\n"
				+ "	</select> \r\n"
				+ "</div>\r\n"
				+ "<input style=\"background-color:#333333;color:#F66A0E;border-radius:10px;position:fixed;left:59%;top:57%;font-size:1.4rem;\"  type=\"submit\" value=\"submit\" />\r\n"
				+ "</form>\r\n"
				+ "</body>";
	}
	public static String returnerCustomer() 
	{
		return "<head>\r\n"
				+ "<meta charset=\"UTF-8\">\r\n"
				+ "<title>Customer</title>\r\n"
				+ "<link rel=\"stylesheet\" href=\"style2.css\">\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "<form method=\"post\" action=ClientServlet>\r\n"
				+ "<h1>Welcome Customer</h1>\r\n"
				+ "<h1>Choose an option</h1>\r\n"
				+ "<div class=\"select\">\r\n"
				+ "	<select name=\"dropdownlist\" id=\"dropdownlist\">\r\n"
				+ "	<option selected disabled>Options</option>\r\n"
				+ "	<option value=\"View all available Projections\">View all available Projections</option>\r\n"
				+ "	<option value=\"View my Reservations\">View my Reservations</option>\r\n"
				+ "	<option value=\"Make a Reservation\">Make a Reservation</option>\r\n"
				+ "	</select> \r\n"
				+ "</div>\r\n"
				+ "<input style=\"background-color:#333333;color:#F66A0E;border-radius:10px;position:fixed;left:59%;top:57%;font-size:1.4rem;\"  type=\"submit\" value=\"submit\" />\r\n"
				+ "</form>\r\n"
				+ "</body>";
	}
	 
}
