
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "showIndianFood", urlPatterns = { "/indian" })
public class IndianFood extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter write = response.getWriter();
		ServletContext context = getServletContext();
		ServletConfig config = getServletConfig();
		write.print("<html><body style=\" text-align : center\">");
		write.print("<h2>" + context.getInitParameter("CompanyName") + "</h2>");
		write.print("<h3>Menu Items</h3>");
		write.print("<table align=\"center\"><tr>");
		write.print("<th>Names</th><th>Code</th></tr>");
		write.print("<tr><td>1.Dosa</td><td>" + config.getInitParameter("Dosa") + "</td></tr>");
		write.print("<tr><td>2.Briyani</td><td>" + config.getInitParameter("Briyani") + "</td></tr>");
		write.print("<tr><td>3.Idly</td><td>" + config.getInitParameter("Idly") + "</td></tr>");
		write.print("<tr><td>4.Aapam</td><td>" + config.getInitParameter("Aapam") + "</td></tr>");
		write.print("</table></body></html>");
	}

}
