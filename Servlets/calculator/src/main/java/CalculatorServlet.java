import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HelloAppEngine", urlPatterns = { "/doCalculation" })
public class CalculatorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException , ServletException{
		
		int value1,value2;
		String operator,answer="";
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		value1=Integer.parseInt(request.getParameter("firstNumber"));
		value2=Integer.parseInt(request.getParameter("secondNumber"));
		operator=request.getParameter("operatorType");
		switch(operator) {
		case "+":
			answer=Integer.toString(value1+value2);
			break;
		case "-":
			answer=Integer.toString(value1-value2);
			break;
		case "*":
			answer=Integer.toString(value1*value2);
			break;
		case "/":
			try {
				
			answer=Integer.toString(value1/value2);
			}
			catch(ArithmeticException e) {
				out.println("can't be divide by 0!!");
				out.println("Enter some other value");
				RequestDispatcher dispatch=request.getRequestDispatcher("/index.html");
				dispatch.forward(request, response);
			break;
		}
		}
		out.println("<html><body><b>Output :" + answer+ "<b></body></html>");
		

	}
}