import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class UserDetailController {

	private static HashMap<String,UserDetail> signupDb = new HashMap<>();
	private static HashMap<String,TicketData> ticketDb = new HashMap<>();
	
public boolean addUser(String userName, String email, String password, long phoneNumber) {
		if(signupDb.containsKey(email)) {
			return false;
		}
		signupDb.put(email, new UserDetail(userName, email, password, phoneNumber));
		return true;
	}
public void printUser(HttpServletResponse response) throws IOException {
	
	for(Map.Entry<String, UserDetail> entry : signupDb.entrySet()) {
		response.getWriter().println(entry.getKey() + " -> " + entry.getValue());
	}
}

public String isUserDataPresent(String email) {
	
	if(signupDb.containsKey(email)) {
		return signupDb.get(email).getPassword(); 
	}
	return null;
}

public String getUserName(String email) {
	
	return  signupDb.get(email).getName();
}

public boolean addTicket(String email,String source,String destination,int noOfTickets,Date journeyDate) {
	
	ticketDb.put(email,new TicketData(source,destination,noOfTickets,journeyDate));
	return true;
}

}
