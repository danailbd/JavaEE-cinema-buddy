package dao;
import java.util.List;
import dao.models.Booking;

public interface BookingDAO {
	
	void addBooking(Booking booking);
	
	void updateBooking(Booking booking);
	
	Booking getBookingById(int id);

	void updateBookingStatus(int bookingId, String status);
	
	List<Booking> getAllBookings();

	void removeBooking(int id);

	List<Booking> getBookingsPerUser(Integer userId);

	List<Booking> getBookingByProj(int projId);

	Long getFreeSeats(Integer projId);
}
