import java.io.IOException;

//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import javax.servlet.*;

//@WebServlet(name = "HelloApp", urlPatterns = { "/hello" })
public class HelloApp extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		ServletContext context = getServletContext();
		context.setAttribute("Company", "FULL");
		context.setAttribute("Address", "Acendas");
		request.setAttribute("Hello", "madam");
		out.print("Company : " + context.getAttribute("Company"));
		out.print("Address : " + context.getAttribute("Address"));
		out.print("attribute from request object : " + request.getAttribute("Hello"));
		out.print("<html><head>");
		out.print("<title>Hello </title>");
		out.print("</head><body>");
		out.print("<a href='Page2'><h1>Goto page 2</h1></a>");
		out.print("</body></html>");
		out.print("Hello Google!\r\n");
		out.print("Username or Password invalid");
		// response.setCharacterEncoding("UTF-8");

	}
}