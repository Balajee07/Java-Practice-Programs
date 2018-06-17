
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Welcome page", urlPatterns = { "/WelcomeLoader" })
public class WelcomeLoader extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String emailId;
		UserDetailController handler=new UserDetailController();
		response.setContentType("text/html");
		HttpSession userSession = request.getSession(false);
		PrintWriter out = response.getWriter();
		emailId = (String) userSession.getAttribute("emailId");
		out.print("<html><body style=\"text-align:center; margin-top:10px;\">");
		out.print("<h3>Hello " + handler.getUserName(emailId) + "</h3>");
		out.print("<p align=\"right\"><a href=\"/LogoutHandler\" > Logout</a></p>");
		out.print("<br><hr><br>");
		out.print("Enter details here<br>");
		out.print("<fieldset><legend>Enter Tickets Details</legend>");
		out.print("<form action=\"/TicketBook\" method=\"post\">");
		out.print("<label style=\"display:inline-block; width:100px;\">From : </label><select name=\"sourcePlace\" style=\" width: 150px; margin-top:10px;\">");
		out.print("<option value=\"chennai\">Chennai</option>");
		out.print("<option value=\"mumbai\">Mumbai</option>");
		out.print("<option value=\"delhi\">Delhi</option>");
		out.print("</select></br>");
		out.print("<label style=\"display:inline-block; width:100px;\">To : </label><select name=\"destinationPlace\" style=\" width: 150px; margin-top:10px;\">");
		out.print("<option value=\"bangalore\">Bangalore</option>");
		out.print("<option value=\"hydrabad\">Hydrabad</option>");
		out.print("<option value=\"kerala\">Kerala</option>");
		out.print("</select></br>");
		out.print("<label style=\"display:inline-block; width:100px;\">No of Tickets : </label><select name=\"ticketCount\" style=\" width: 150px; margin-top:10px;\">");
		out.print("<option value=\"1\">1</option>");
		out.print("<option value=\"2\">2</option>");
		out.print("<option value=\"3\">3</option>");
		out.print("<option value=\"4\">4</option>");
		out.print("<option value=\"5\">5</option>");
		out.print("</select></br>");
		out.print(
				"<label style=\"display:inline-block; width:100px;\">Journey date : </label><input type=\"date\" name=\"date\" placeholder=\"Select Date\" style=\" width: 150px; margin-top:10px;\"><br>");
		out.print("<input type=\"submit\" value=\"Book\" style=\"margin-top:10px;\"><br>");
		out.print("</form></fieldset>");
		out.print("</body></html>");
	}

}
