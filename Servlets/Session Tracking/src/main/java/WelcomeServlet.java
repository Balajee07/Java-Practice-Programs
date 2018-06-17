
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nameOfUser, password;
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		nameOfUser = (String) session.getAttribute("name");
		password = (String) session.getAttribute("password");
		Cookie cookies = new Cookie(nameOfUser, password);
		response.addCookie(cookies);
		
		out.print("<html><body>");
		out.print("<h3 style=\"text-align:center;\"> Hello " + nameOfUser + "</h3><br>");
		out.print("<h3 style=\"text-align:center;\"> This is the welcome page </h3>");
		out.print("<a href='/doLogout' style=\"float: right;\">Logout</a>");
		out.print(
				"<a href='openAbout?name=" + nameOfUser + "' style=\"float: right; margin-right:10px;\">About Us</a>");
		out.print("</body></html>");
	}
}