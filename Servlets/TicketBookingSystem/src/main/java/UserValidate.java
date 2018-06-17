
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class UserValidate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String emailId, password;
	UserDetailController handler = new UserDetailController();
	RequestDispatcher dispatch;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession userSession = request.getSession();
		response.getWriter().println("Filer processing");
		if (userSession.isNew()) {
			
			dispatch = request.getRequestDispatcher("/index.html");
			dispatch.forward(request, response);
//			emailId = (String) userSession.getAttribute("emailId");
//			password = (String) userSession.getAttribute("password");
//			if (password.equals("12345")) {
//				dispatch = request.getRequestDispatcher("/WelcomeLoader");
//				dispatch.forward(request, response);
//			}
//
//			else {
//				dispatch = request.getRequestDispatcher("/index.html");
//				dispatch.forward(request, response);
//			}
		} 
		else {
			
			dispatch = request.getRequestDispatcher("/login.html");
			dispatch.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
