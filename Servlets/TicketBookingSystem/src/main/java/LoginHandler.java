
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Login Servlet", urlPatterns = { "/loginHandler" })
public class LoginHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		RequestDispatcher dispatch;
		String loginEmailId, loginPassword, userPassword;
		loginEmailId = request.getParameter("email");
		loginPassword = request.getParameter("password");
		UserDetailController handler = new UserDetailController();
		userPassword = handler.isUserDataPresent(loginEmailId);
		if (userPassword == null) {

			out.println("<html><body style=\"text-align:center;\">");
			out.println("<h3><b>You are not signed up<br></h3>");
			out.println("please sign up to continue");
			out.println("</body></html>");
			dispatch = request.getRequestDispatcher("/signup.html");
			dispatch.forward(request, response);

		} else if (userPassword.equals(loginPassword)) {

			HttpSession userSession = request.getSession();
			userSession.setAttribute("emailId", loginEmailId);
			userSession.setAttribute("password", loginPassword);
			dispatch = request.getRequestDispatcher("/WelcomeLoader");
			dispatch.forward(request, response);

		} else {
			out.print("Password incorrect");
			dispatch = request.getRequestDispatcher("/login.html");
			dispatch.forward(request, response);
		}
	}

}
