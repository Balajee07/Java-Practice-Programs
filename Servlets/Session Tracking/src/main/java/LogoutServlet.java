
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;

@WebServlet("/Logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter display = response.getWriter();
		HttpSession session = request.getSession(false);
		display.println("You are successfully Signed out");
		Cookie cookie = new Cookie((String) session.getAttribute("name"), "");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		session.invalidate();
	}

}
