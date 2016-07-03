package rest;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.BookingDAO;
import dao.models.Booking;

@Path("booking")
public class BookingsResource {
	@Context	 
	private static ServletContext context; 
	private static final Response RESPONSE_OK = Response.ok().build();
	private static final Response RESPONSE_FAIL = Response.status(400).build();

	@Inject
	private BookingDAO dao;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Booking> getAllBookings() {
		try {
			List<Booking> allBookings = dao.getAllBookings();
			return allBookings;
		} catch (Exception e) {
			return null;
		}
	}
	
	@GET
	@Path("/userId/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Booking> getBookingsPerUser(@PathParam("userId") Integer userId) {
		try {
			List<Booking> allBookings = dao.getBookingsPerUser(userId);
			return allBookings;
		} catch (Exception e) {
			return null;
		}
	}

	@GET
	@Path("/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Booking getById(@PathParam("bookingId") Integer bookingId) {
		try {
			Booking booking = dao.getBookingById(bookingId);
			return booking;
		} catch (Exception e) {
			return null;
		}
	}

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
	public Response updateBooking(Booking booking) {
		try {
			dao.updateBooking(booking);
			return RESPONSE_OK;
		} catch (Exception e) {
			return RESPONSE_FAIL;
		}

	};

	@POST
	@Path("/updateStatus/{bookingId}/{status}")
	public Response updateBooking(@PathParam("bookingId") Integer bookingId, @PathParam("status") String status) {
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
