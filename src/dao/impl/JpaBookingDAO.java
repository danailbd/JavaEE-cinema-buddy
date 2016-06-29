package dao.impl;

import javax.management.InvalidAttributeValueException;

import dao.BookingDAO;
import java.util.List;
import dao.models.Booking;
import dao.models.Movie;

public class JpaBookingDAO extends JpaDAO implements BookingDAO{
	
	@Override
	public void addBooking(Booking booking) {
		persist(booking);
	}
	
	@Override
	public void updateBooking(Booking booking){
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
	public void updateBookingStatus(int bookingId, String status){
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

}

