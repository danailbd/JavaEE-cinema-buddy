package dao.impl;

import javax.ejb.Stateless;
import javax.management.InvalidAttributeValueException;
import javax.persistence.TypedQuery;

import dao.BookingDAO;
import java.util.List;
import dao.models.Booking;
import dao.models.Movie;
import dao.models.User;

@Stateless
public class JpaBookingDAO extends JpaDAO implements BookingDAO {

	public JpaBookingDAO() {
		super(Booking.class);
	}

	@Override
	public void addBooking(Booking booking) {

		long currentSeat = booking.getSeat();
		Long bitSeat = (1L << currentSeat);
		try {
			booking.setSeat(bitSeat);
		} catch (InvalidAttributeValueException e) {
			e.printStackTrace();
		}
		persist(booking);
	}

	@Override
	public void updateBooking(Booking booking) {
		Booking updatedBooking = getBookingById(booking.getId());
		updatedBooking.setProjection(booking.getProjection());
		try {
			updatedBooking.setSeat(booking.getSeat());
		} catch (InvalidAttributeValueException e) {
			e.printStackTrace();
		}
		updatedBooking.setUser(booking.getUser());
		merge(updatedBooking);
	}

	@Override
	public Booking getBookingById(int id) {

		return findById(id);
	}

	@Override
	public List<Booking> getBookingByProj(int projId) {
		String txtQuery = "SELECT u FROM Booking u WHERE u.projection.id=:PROJ_ID";
		TypedQuery<Booking> query = entityManager.createQuery(txtQuery, Booking.class);
		query.setParameter("PROJ_ID", projId);
		return query.getResultList();
	}

	@Override
	public void updateBookingStatus(int bookingId, String status) {
//		Booking bookingUpdatedStatus = getBookingById(bookingId);
//		bookingUpdatedStatus.setStatus(status);
	}

	@Override
	public List<Booking> getAllBookings() {
		return findAll();
	}

	@Override
	public void removeBooking(int id) {
		Booking booking = findById(id);
		this.remove(booking);
	}

	@Override
	public List<Booking> getBookingsPerUser(Integer userId) {
		String txtQuery = "SELECT u FROM Booking u WHERE u.user.id=:USER_ID";
		TypedQuery<Booking> query = entityManager.createQuery(txtQuery, Booking.class);
		query.setParameter("USER_ID", userId);
		return query.getResultList();
	}

	@Override
	public Long getFreeSeats(Integer projId){
		Long freeSeats = 0L;
		List<Booking> bookings = getBookingByProj(projId);
		for( Booking b : bookings){
			freeSeats |= b.getSeat();
		}
		return freeSeats;
	}

}
