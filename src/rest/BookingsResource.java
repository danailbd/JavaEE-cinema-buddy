package rest;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import dao.impl.JpaBookingDAO;
import dao.models.Booking;

@Path("/booking")
public class BookingsResource {
	private static final Response RESPONSE_OK = Response.ok().build();
	private static final Response RESPONSE_FAIL = Response.status(400).build();
	private static JpaBookingDAO dao = new JpaBookingDAO();

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
