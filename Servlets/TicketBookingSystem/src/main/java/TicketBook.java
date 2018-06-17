
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TicketBook
 */
@WebServlet(name="Book Ticket", urlPatterns= {"/TicketBook"})
public class TicketBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		Date journeyDate = new Date();
		int noOfTickets;
		UserDetailController handler = new UserDetailController();
		String sourcePlace, destinationPlace, emailId;
		HttpSession userSession = request.getSession(false);
		emailId = (String) userSession.getAttribute("emailId");		
		sourcePlace = request.getParameter("sourcePlace");
		destinationPlace = request.getParameter("destinationPlace");
		noOfTickets = Integer.parseInt(request.getParameter("ticketCount"));
		try {
			journeyDate = dateFormat.parse((request.getParameter("date")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print("<h3 style=\"text-align:center; margin-top:10px;\">Hello " + handler.getUserName(emailId) + "</h3>");
		
		if (handler.addTicket(emailId, sourcePlace, destinationPlace, noOfTickets, journeyDate)) {

			out.print("<html><body style=\"text-align:center; margin-top:10px;\">");
			out.print("<p align=\"right\"><a href=\"/LogoutHandler\"> Logout</a></p>");
			out.print("<br><hr><br>");
			out.print("<h3>Ticket Booking confirmed</h3>");
			out.print("<p><b>From : <b>" + sourcePlace + "<br>");
			out.print("<b>To : <b>" + destinationPlace + "<br>");
			out.print("<b>No of Tickets : <b>" + noOfTickets + "<br><p>");
			out.print("</body></html>");
	}
		else {
			out.println("Something went wrong");
		}

}
}
