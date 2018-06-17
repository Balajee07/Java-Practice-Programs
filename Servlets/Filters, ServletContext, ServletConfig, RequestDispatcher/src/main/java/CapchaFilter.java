
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class CapchaFilter
 */
@WebFilter("/CapchaFilter")
public class CapchaFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.print("<html><body style=\"text-align:center;\">");
		out.print("<h3>Enter Capcha to verify</h3>");
		out.print("<img src=\"https://cdn.instructables.com/FWA/J4NG/HPQO9GSK/FWAJ4NGHPQO9GSK.LARGE.jpg?auto=webp\">");
		out.print("<form action='/CapchaVerify' method=\"get\">");
		out.print("<input type=\"text\" name=\"capchaValue\">");	
		out.print("<input type=\"submit\" value=\"Okay\">");
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
