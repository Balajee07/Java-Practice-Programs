

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.CompositeFilter;
import com.google.appengine.api.datastore.Query.CompositeFilterOperator;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.appengine.api.datastore.Query.SortDirection;

/**
 * Servlet implementation class QueriesDatastore
 */
@WebServlet(name = "Queries Servlet", urlPatterns = {"/showQueryOperations"})
public class QueriesDatastore extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Servlet 2 running");
		
		//Datastore Instantiation
		
			DatastoreService dsService = DatastoreServiceFactory.getDatastoreService();
			PreparedQuery pQuery;
		
		//Retrieving all the entities from the datastore from all kinds
			
			System.out.println("Retrieving all the entities from the datastore from all kinds\n");
			Query getAllEntities = new Query();
			pQuery = dsService.prepare(getAllEntities);
			for ( Entity itr : pQuery.asIterable()) {
				System.out.println(itr);
			}
		
		//Retrieving all the entities of a Specific kind from datastore
			
			System.out.println("Retrieving all the entities of a Specific kind from datastore\n");
			Query getEntities = new Query("Teacher");
			pQuery = dsService.prepare(getEntities);
			for ( Entity itr : pQuery.asIterable()) {
				System.out.println(itr);
			}
			
		//Applying Sorting in Queries
			
			System.out.println("\nAge Sorted by ascending order using Queries\n");
			
			Query sortQuery1 = new Query("Student").addSort("age", SortDirection.ASCENDING);
			pQuery = dsService.prepare(sortQuery1);
			Iterator<Entity> itr1 =pQuery.asIterator();
			while(itr1.hasNext()) {
				System.out.println(itr1.next());
			}
		
			System.out.println("\nName Sorted by descending order using Queries\n");
			Query sortQuery2 = new Query("Student").addSort("name", SortDirection.DESCENDING);
			pQuery = dsService.prepare(sortQuery2);
			Iterator<Entity> itr2 =pQuery.asIterator();
			while(itr2.hasNext()) {
				System.out.println(itr2.next());
			}
		//Applying Filters in queries
			
			System.out.println("\nApplying filters in Queries\n");
			System.out.println("\nFilter: Age must be greater than 10\n");
			//int minAge = 10;
			Query filterQuery1 = new Query("Student").setFilter(new FilterPredicate("age", FilterOperator.GREATER_THAN_OR_EQUAL, 13));
			pQuery = dsService.prepare(filterQuery1);
			for(Entity itr : pQuery.asIterable() ) {
				System.out.println(itr);
			}
			
			//int maxAge = 17;
			System.out.println("\nFilter: Age must be lesser than 17 \n");
			Query filterQuery2 = new Query("Student").setFilter(new FilterPredicate("age", FilterOperator.LESS_THAN_OR_EQUAL, 15));
			pQuery = dsService.prepare(filterQuery2);
			for (Entity itr : pQuery.asIterable()) {
				System.out.println(itr);
			}
		//composite filter on class
			
			System.out.println("Applying compostite filter on student class property\n");
			Query filterQuery4 = new Query("Student").setFilter(CompositeFilterOperator.and(new FilterPredicate("class", FilterOperator.GREATER_THAN, 6), new FilterPredicate("class", FilterOperator.LESS_THAN, 12)));
			pQuery = dsService.prepare(filterQuery4);
			System.out.println("Printing entities based on composite filter");
			for(Entity studentEntities : pQuery.asIterable()) {
				System.out.println(studentEntities);
			}
			
			
			System.out.println("\nShowing the entity of Michel Raj using equality filter\n");
			Query filterQuery3 = new Query("Student").setFilter(new FilterPredicate("name", FilterOperator.EQUAL, "Michel Raj"));
			pQuery = dsService.prepare(filterQuery3);
			System.out.println(pQuery.asSingleEntity());
			
		
	}

}
