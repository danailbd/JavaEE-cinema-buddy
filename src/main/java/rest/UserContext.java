package rest;
import dao.models.User;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;

/**
 * Created by ivann on 06/07/2016.
*/
@SessionScoped
public class UserContext implements Serializable {

    @Inject
    private User currentUser;
    private UserContext() {}

    public User getCurrentUser() {
         return currentUser;
     }

    public void setCurrentUser(User currentUser) {
         this.currentUser = currentUser;
        }
}
