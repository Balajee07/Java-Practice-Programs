
import java.io.*;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;

//@WebServlet(name = "Servlet2" , urlPatterns = { "/Page2" })
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter writer = response.getWriter();
		ServletContext context = getServletContext();
		writer.println(
				"username is : " + request.getParameter("userName") + "password : " + request.getParameter("Password"));
		context.setAttribute(request.getParameter("userName"), request.getParameter("Password"));
		writer.print("<html><body style=\"text-align: center;\">");
		writer.print("<h2>Sign up successful<h2><br>");
		writer.print("<h2> Please login to continue <h2>");
		writer.print("</body></html>");
		RequestDispatcher send = request.getRequestDispatcher("/login.html");
		send.forward(request, response);
	}

}
