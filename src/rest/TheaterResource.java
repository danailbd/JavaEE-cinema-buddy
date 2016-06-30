package rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.JpaBookingDAOFactory;
import dao.impl.JpaTheaterDAO;
import dao.models.Theater;

@Path("/theater")
public class TheaterResource {
    private static final Response RESPONSE_OK = Response.ok().build();
    private static final Response RESPONSE_FAIL = Response.status(400).build();
    private static final JpaBookingDAOFactory jpaTheaterDAOFactory = new JpaBookingDAOFactory();
    private static JpaTheaterDAO dao = jpaTheaterDAOFactory.getJpaTheaterDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Theater> getAllTheaters() {
        try {
            List<Theater> allTheaters = dao.getAllTheaters();
            return allTheaters;
        } catch (Exception e) {
            return null;
        }
    }

<<<<<<< HEAD
	@GET
	@Path("/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Theater getById(@PathParam("theaterId") Integer theaterId) {
		try {
			Theater theater = dao.getTheaterById(theaterId);
			return theater;
		} catch (Exception e) {
			return null;
		}
	}
	
	@PUT
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addNewTheater(Theater theater) {
		try {
			dao.addTheater(theater);
			return RESPONSE_OK;
		}catch(Exception e){
			return RESPONSE_FAIL;
		}
	};
	//TODO:
	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateTheater(Theater theater) {
		try {
			//dao.updateTheater(theater);
			return RESPONSE_OK;
		}catch(Exception e){
			return RESPONSE_FAIL;
		}
	}
=======
    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Theater getById(@PathParam("theaterId") Integer theaterId) {
        try {
            Theater theater = dao.getTheaterById(theaterId);
            return theater;
        } catch (Exception e) {
            return null;
        }
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewTheater(Theater theater) {
        try {
            dao.addTheater(theater);
            return RESPONSE_OK;
        } catch (Exception e) {
            return RESPONSE_FAIL;
        }
    }
>>>>>>> refs/remotes/origin/master

    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateTheater(Theater theater) {
        try {
            dao.updateTheater(theater);
            return RESPONSE_OK;
        } catch (Exception e) {
            return RESPONSE_FAIL;
        }
    }

    @POST
    @Path("/delete/{theaterId}")
    public Response deleteTheater(@PathParam("theaterId") Integer theaterId) {
        try {
            dao.removeTheater(theaterId);
            return RESPONSE_OK;
        } catch (Exception e) {
            return RESPONSE_FAIL;
        }
    }
}
