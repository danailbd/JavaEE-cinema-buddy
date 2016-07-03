package rest;

import dao.UserDAO;
import dao.models.User;
import dao.models.UserRole;

import javax.inject.Inject;
import javax.persistence.Column;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by danailbd on 7/3/16.
 */
@Path("users")
public class UserResource {

    @Inject
    private UserDAO dao;

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public List<User> getUsers(UserRole role) {
        if (role != null)
            return dao.getAllUsersByRole(role);
        else
            return dao.getAllUsers();
    }
}
