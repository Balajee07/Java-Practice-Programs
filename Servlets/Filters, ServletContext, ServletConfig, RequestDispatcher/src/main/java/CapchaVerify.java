

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;


//@WebFilter("/CapchaVerify")
public class CapchaVerify implements Filter {

	FilterConfig config = null;
	public void init(FilterConfig fConfig) throws ServletException {
		config=fConfig;
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		if(request.getParameter("capchaValue").equals(config.getInitParameter("capchaValue"))) {
			
			RequestDispatcher dispatch=request.getRequestDispatcher("/welcome.html");
			dispatch.forward(request, response);	
		}
		else {
			RequestDispatcher dispatch=request.getRequestDispatcher("/index.html");
			dispatch.forward(request, response);
		}
		
	}
	
	public void destroy() {}
}
