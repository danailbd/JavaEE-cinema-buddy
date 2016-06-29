package rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.impl.JpaBookingDAO;
import dao.models.Booking;
import dao.models.Booking;

@Path("/booking")
public class BookingsResource {
	private static final Response RESPONSE_OK = Response.ok().build();
	private static final Response RESPONSE_FAIL = Response.status(400).build();
	private static JpaBookingDAO dao = new JpaBookingDAO();

/*	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public void getAllBookings(){
		try {
			List<Booking> allBookings = dao.getAllBookings;
			allBookings.
			
		} catch (Exception e) {
			return RESPONSE_FAIL;
		}
	}*/
/*	
	@GET
	@Path("/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void getById(@PathParam("bookingId") Integer bookingId){
		try {
			Booking booking = dao.findById(bookingId);
			Booking booking =re
			
		} catch (Exception e) {
			return "";
		}
	}*/
	
	@PUT
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addBooking(Booking booking) {
		try {
			dao.addBooking(booking);
			return RESPONSE_OK;
		} catch (Exception e) {
			return RESPONSE_FAIL;
		}

	};

	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateBooking(Booking booking) {
		Integer bookingId = booking.getId();
		try {
			dao.updateBooking(booking);
			return RESPONSE_OK;
		} catch (Exception e) {
			return RESPONSE_FAIL;
		}

	};

	@POST
	@Path("/updateStatus/{bookingId}/{status}")
	public void updateBooking(@PathParam("bookingId") Integer bookingId, @PathParam("status") Integer status) {
		try {
			dao.updateBookingStatus(bookingId, status);
			return RESPONSE_OK;
		} catch (Exception e) {
			return RESPONSE_FAIL;
		}

	};

	@POST
	@Path("/delete/{bookingId}")
	public Response deleteBooking(@PathParam("bookingId") Integer bookingId) {
		try {
			dao.removeBooking(bookingId);
			return RESPONSE_OK;
		} catch (Exception e) {
			return RESPONSE_FAIL;
		}
	};

}
