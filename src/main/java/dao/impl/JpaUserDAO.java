package dao.impl;

import java.security.MessageDigest;
import java.util.List;
import java.util.Queue;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import dao.UserDAO;
import dao.models.User;
import dao.models.UserRole;

@Stateless
public class JpaUserDAO extends JpaDAO implements UserDAO {

    public JpaUserDAO() {
        super(User.class);
    }

    @Override
	public User getUserById(int id) {
        return findById(id);
    }
    
   @Override
	public void addUser(User user) {
		user.setPassword(getHashedPassword(user.getPassword()));
		persist(user);
	}
	
   @Override
	public boolean validateUserCredentials(String email, String password) {
        String txtQuery = "SELECT * FROM Users u WHERE u.email=:email AND u.password=:password";
        TypedQuery<User> query = entityManager.createQuery(txtQuery, User.class);
        query.setParameter("email", email);
        query.setParameter("password", getHashedPassword(password));
        return queryUser(query) != null;
    }

    @Override
    public List<User> getAllUsers() {
        return findAll();
    }

    @Override
    public List<User> getAllUsersByRole(UserRole role) {
        Query q = entityManager.createQuery(
                "SELECT e FROM " + entityClass.getName() + " e WHERE e.role=:role");
        q.setParameter("role", role);
        return q.getResultList();
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
