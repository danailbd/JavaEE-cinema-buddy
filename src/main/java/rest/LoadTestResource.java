package rest;

import dao.*;
import dao.models.*;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by danailbd on 7/3/16.
 */
@Path("load")
@Produces(MediaType.APPLICATION_JSON)
public class LoadTestResource {

    @Inject
    private TheaterDAO tDao;
    @Inject
    private MovieDAO mDao;
    @Inject
    private UserDAO uDao;
    @Inject
    private BookingDAO bDao;
    @Inject
    private ProjectionDAO pDao;

    List res;

    private void loadTheaters() {
        Theater tmp = new Theater(10, Type.D2);
        res.add(tmp);
        tDao.addTheater(tmp);

        tmp = new Theater(60, Type.D2);
        res.add(tmp);
        tDao.addTheater(tmp);

        tmp = new Theater(50, Type.D2);
        res.add(tmp);
        tDao.addTheater(tmp);
    }

    private void loadMovies() {
        Movie tmp = new Movie("ab", 10);
        res.add(tmp);
        mDao.addMovie(tmp);

        tmp = new Movie("cbd", 20);
        res.add(tmp);
        mDao.addMovie(tmp);

        tmp = new Movie("AG", 20);
        res.add(tmp);
        mDao.addMovie(tmp);
    }

    private void loadUsers () {
        User tmp = new User("ga1@mail.bg", "124", UserRole.admin);
        res.add(tmp);
        uDao.addUser(tmp);

        tmp = new User("ga@mail.bg", "124", UserRole.simple);
        res.add(tmp);
        uDao.addUser(tmp);
    }

    private void loadProjections () {
        List<Movie> movies = mDao.getAllMovies();
        List<Theater> theaters = tDao.getAllTheaters();

        Timestamp t1 = new Timestamp(Calendar.getInstance().getTime().getTime());
        Timestamp t2 = new Timestamp(Calendar.getInstance().getTime().getTime());
        Projection tmp = new Projection(t1, t2, theaters.get(0), movies.get(0));
        res.add(tmp);
        pDao.addProjection(tmp);
    }

    private void loadBookings () {
        List<Projection> projections = pDao.getAllProjections();
        List<User> users = uDao.getAllUsersByRole(UserRole.simple);

        Booking tmp = new Booking(projections.get(0), 1L,  users.get(0));
        res.add(tmp);
        bDao.addBooking(tmp);
    }

    @POST
    public List loadAll() {
        res = new ArrayList();

        loadUsers();
        loadTheaters();
        loadMovies();
        loadProjections();
        loadBookings();

        return res;
    }

}
