/*package tests;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import user.User2;
import user.UserDAO;

@Stateless
public class DatabaseUtils {
	
	  
    private static User2[] USERS = {};
	
	@PersistenceContext
    private EntityManager em;
	
	 @EJB
	 private UserDAO userDAO;
	 
	 public void addTestDataToDB() {
	        deleteData();
	        addTestUsers();
	    }

	    private void deleteData() {
	       em.createQuery("DELETE FROM User").executeUpdate();
	   }

	    private void addTestUsers() {
	        for (User2 user : USERS) {
	            userDAO.addUser(user);
	        }
	    }

}
*/