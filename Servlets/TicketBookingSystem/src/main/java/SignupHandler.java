
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Signup servlet", urlPatterns = { "/startSignup" })
public class SignupHandler extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private String userName, email, password;
	private long phoneNumber;
	private boolean flag;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		userName = request.getParameter("userName");
		email = request.getParameter("email");
		phoneNumber = Long.parseLong(request.getParameter("phoneNumber"));
		password = request.getParameter("password");
		UserDetailController handler = new UserDetailController();
		flag = handler.addUser(userName, email, password, phoneNumber);
		if(!flag) {
			response.getWriter().println("User is already registered");
		}
		else {
			response.getWriter().println("Successfully signed up");
			response.getWriter().println("Please login to continue");
			RequestDispatcher dispatch=request.getRequestDispatcher("/login.html");
			dispatch.forward(request, response);
		
		}
	}

}
