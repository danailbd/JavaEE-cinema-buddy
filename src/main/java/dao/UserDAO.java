package dao;

import dao.models.User;
import dao.models.UserRole;

import java.util.List;

public interface UserDAO {
	
    User getUserById(int id);
    
    void addUser(User user);
    
    boolean validateUserCredentials(String email, String password);

    List<User> getAllUsers ();

    List<User> getAllUsersByRole(UserRole role);
}
