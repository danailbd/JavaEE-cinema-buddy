package rest;

import java.util.Date;
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
import dao.impl.JpaProjectionDAO;
import dao.models.Projection;

@Path("/projection")
public class ProjectionResource {
	private static final Response RESPONSE_OK = Response.ok().build();
	private static final Response RESPONSE_FAIL = Response.status(400).build();
	private static final JpaBookingDAOFactory jpaProjectionDAOFactory = new JpaBookingDAOFactory();
	private static JpaProjectionDAO dao = jpaProjectionDAOFactory.getJpaProjectionDAO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Projection> getAllProjections() {
		try {
			List<Projection> allProjections = dao.getAllProjections();
			return allProjections;
		} catch (Exception e) {
			return null;
		}
	}
	
	@GET
	@Path("date/{date}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Projection> getProjectionsByDate(@PathParam("date") Date date) {
		try {
			List<Projection> allProjections = dao.getProjectionsByDate(date);
			return allProjections;
		} catch (Exception e) {
			return null;
		}
	}

	@GET
	@Path("/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Projection getById(@PathParam("projectionId") Integer projectionId) {
		try {
			Projection projection = dao.getProjectionById(projectionId);
			return projection;
		} catch (Exception e) {
			return null;
		}
	}
	//TODO: 
	@GET
	@Path("/freeSeats/{projectionId}")
	@Produces(MediaType.TEXT_PLAIN)
	public List<Integer> getSeatsById(@PathParam("projectionId") Integer projectionId) {
		try {
//			String seats= dao.getProjectionSeats(projectionId);
			return null;//seats;
		} catch (Exception e) {
			return null;
		}
	}
	
	@PUT
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addNewProjection(Projection projection) {
		try {
			dao.addProjection(projection);
			return RESPONSE_OK;
		}catch(Exception e){
			return RESPONSE_FAIL;
		}

	};

	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateProjection(Projection projection) {
		try {
			dao.updateProjection(projection);
			return RESPONSE_OK;
		}catch(Exception e){
			return RESPONSE_FAIL;
		}
	}

	@POST
	@Path("/delete/{projectionId}")
	public Response deleteProjection(@PathParam("projectionId") Integer projectionId) {
		try {
			dao.removeProjection(projectionId);
			return RESPONSE_OK;
		} catch (Exception e) {
			return RESPONSE_FAIL;
		}
	}
}
