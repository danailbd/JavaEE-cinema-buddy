package dao;

import dao.models.User;

public interface UserDAO {
	
    User getUserById(int id);
    
    void addUser(User user);
    
    boolean validateUserCredentials(String email, String password);
    
}
