import java.util.Date;
public class TicketData {
	
	String source,destination;
	int noOfTickets;
	Date date=new Date();
	
	public TicketData(String source,String destination,int noOfTickets, Date journeyDate){
		
		this.source=source;
		this.destination=destination;
		this.noOfTickets=noOfTickets;
		date=journeyDate;
	}
	private String getSource() {
		return source;
	}
	private void setSource(String source) {
		this.source = source;
	}
	private String getDestination() {
		return destination;
	}
	private void setDestination(String destination) {
		this.destination = destination;
	}
	private int getNoOfTickets() {
		return noOfTickets;
	}
	private void setNoOfTickets(int noOfTickets) {
		this.noOfTickets = noOfTickets;
	}
	private Date getDate() {
		return date;
	}
	private void setDate(Date date) {
		this.date = date;
	}
	
}
