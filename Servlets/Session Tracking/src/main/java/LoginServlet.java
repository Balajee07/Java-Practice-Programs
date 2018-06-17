
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletTwo")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String userName, userPassword;
		userName = request.getParameter("userName");
		userPassword = request.getParameter("Password");
		ServletContext context = getServletContext();
		if (userPassword.equals(context.getAttribute(userName)) && request.getParameter("loginKey").equals("34de5")) {

			HttpSession session = request.getSession();
			session.setAttribute("name", userName);
			session.setAttribute("password", userPassword);
			request.getRequestDispatcher("/welcome").forward(request, response);

		} else {

			out.println("Username or Password is wrong");
			request.getRequestDispatcher("/login.html").forward(request, response);
		}

	}

}
