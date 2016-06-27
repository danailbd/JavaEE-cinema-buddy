package user;

import javax.enterprise.context.SessionScoped;

@SessionScoped
public class UserContext {

	private User currentUser;
	
	public User getCurrentUser() {
		return currentUser;
	}
	
	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
	
}
