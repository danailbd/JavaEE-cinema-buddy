package user;

import java.security.MessageDigest;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Singleton
public class UserDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void addUser(User user) {
		user.setPassword(getHashedPassword(user.getPassword()));
		em.persist(user);
	}
	
	public boolean validateUserCredentials(String firstName, String secondName, String password) {
        String txtQuery = "SELECT u FROM User u WHERE u.firstName=:firstName AND "
        		+ "u.secondName=:secondName AND u.password=:password";
        TypedQuery<User> query = em.createQuery(txtQuery, User.class);
        query.setParameter("firstName", firstName);
        query.setParameter("firstName", firstName);
        query.setParameter("password", getHashedPassword(password));
        return queryUser(query) != null;
    }
	
	public User findUserByName(String firstName, String secondName) {
        String txtQuery = "SELECT u FROM User u WHERE u.firstName = :firstName";
        TypedQuery<User> query = em.createQuery(txtQuery, User.class);
        query.setParameter("firstName", firstName);
        query.setParameter("secondName", secondName);
        return queryUser(query);
    }

	 private User queryUser(TypedQuery<User> query) {
	        try {
	            return query.getSingleResult();
	        } catch (Exception e) {
	            return null;
	        }
	    }

	    private String getHashedPassword(String password) {
	        try {
	            MessageDigest mda = MessageDigest.getInstance("SHA-512");
	            password = new String(mda.digest(password.getBytes()));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return password;
	    }

}
