import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;

@WebServlet(name = "showChineseFood", urlPatterns = { "/chinese" })
public class ChineseFood extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter write = response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		ServletContext context = getServletContext();
		ServletConfig config = getServletConfig();
		write.print("<html><body style=\" text-align : center\">");
		write.print("<h2>" + context.getInitParameter("CompanyName") + "</h2>");
		write.print("<h3>Menu Items</h3>");
		write.print("<table align=\"center\"><tr>");
		write.print("<th>Names</th><th>Code</th></tr>");
		write.print("<tr><td>1.Fried Rice</td><td>" + config.getInitParameter("Fried Rice") + "</td></tr>");
		write.print("<tr><td>2.Spring Roll</td><td>" + config.getInitParameter("Spring Roll") + "</td></tr>");
		write.print("<tr><td>3.Noodles</td><td>" + config.getInitParameter("Noodles") + "</td></tr>");
		write.print("<tr><td>4.Ma Po Tofu</td><td>" + config.getInitParameter("Ma Po Tofu") + "</td></tr>");
		write.print("</body></html>");

	}
}