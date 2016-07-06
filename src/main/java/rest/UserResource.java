package rest;

import dao.UserDAO;
import dao.models.User;
import dao.models.UserRole;

import java.net.HttpURLConnection;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.Column;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by danailbd on 7/3/16.
 */
@Stateless
@Path("users")
public class UserResource {

    private static final Response RESPONSE_OK = Response.ok().build();

    @Inject
    private UserDAO dao;
    @Inject
    private UserContext context;

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public List<User> getUsers(UserRole role) {
        if (role != null)
            return dao.getAllUsersByRole(role);
        else
            return dao.getAllUsers();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void registerUser(User newUser) {
        dao.addUser(newUser);
        context.setCurrentUser(newUser);
    }

    @Path("login")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response loginUser(User user) {
        boolean isUserValid = dao.validateUserCredentials(user.getEmail(),
                user.getPassword());
        if (!isUserValid) {
            return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).build();
        }
        context.setCurrentUser(user);
        return RESPONSE_OK;
    }

    @Path("authenticated")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public Response isAuthenticated() {
        if (context.getCurrentUser() == null) {
            return Response.status(HttpURLConnection.HTTP_NOT_FOUND).build();
        }
        return RESPONSE_OK;
    }

    @Path("current")
    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    public String getUser() {
        if (context.getCurrentUser() == null) {
            return null;
        }
        String userNames = context.getCurrentUser().getFirstName()
                + context.getCurrentUser().getLastName();
        return userNames;
    }

    @Path("logout")
    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    public void logoutUser() {
        context.setCurrentUser(null);
    }
}
