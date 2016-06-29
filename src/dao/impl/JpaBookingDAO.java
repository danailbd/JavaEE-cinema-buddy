package dao.impl;

import javax.management.InvalidAttributeValueException;
import javax.persistence.TypedQuery;

import dao.BookingDAO;
import java.util.List;
import dao.models.Booking;
import dao.models.Movie;
import dao.models.User;

public class JpaBookingDAO extends JpaDAO implements BookingDAO {

	@Override
	public void addBooking(Booking booking) {
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
	public void updateBookingStatus(int bookingId, String status) {
		Booking bookingUpdatedStatus = getBookingById(bookingId);
		bookingUpdatedStatus.setStatus(status);
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
		String txtQuery = "SELECT * FROM BOOKINGS WHERE u.USER_ID=:USER_ID";
		TypedQuery<Booking> query = entityManager.createQuery(txtQuery, Booking.class);
		query.setParameter("USER_ID", userId);
		return query.getResultList();
	}

}
