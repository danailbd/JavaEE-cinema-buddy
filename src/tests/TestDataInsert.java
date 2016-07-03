/*package tests;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.servlet.ServletException;

@Singleton
@Startup
public class TestDataInsert {
	
	    
	    @EJB
	    private DatabaseUtils utils;
	    
	    public TestDataInsert() {}
	    
	    @PostConstruct
	    public void init() throws ServletException {
	        utils.addTestDataToDB();
	    }
	    
}
*/