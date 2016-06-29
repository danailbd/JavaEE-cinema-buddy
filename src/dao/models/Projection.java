package dao.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Projection {

    @Id
    @GeneratedValue
    private int id;

    private Date startTime;
    private Date endTime;

    
    @ManyToOne
    @JoinColumn(name = "theater_id")
    private Theater theater;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Booking> bookings = new ArrayList();


    public Projection () {}

    public int getId() {
        return id;
    }
    
    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartDate(Date date) {
        this.startTime = date;
    }
    public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

    public List<Booking> getBookings() {
        return bookings;
    }

    @OneToMany
    @JoinColumn(name = "booking_id")
    private List<Booking> bookingsList = new ArrayList();

    public List<Booking> getBookingsList() {
        return bookings;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Projection that = (Projection) o;

        if (getId() != that.getId()) return false;
        if (!getStartTime().equals(that.getStartTime())) return false;
        if (!getEndTime().equals(that.getEndTime())) return false;
        if (!getTheater().equals(that.getTheater())) return false;
        if (!getMovie().equals(that.getMovie())) return false;
        return getBookings() != null ? getBookings().equals(that.getBookings()) : that.getBookings() == null;

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getStartTime().hashCode();
        result = 31 * result + getEndTime().hashCode();
        result = 31 * result + getTheater().hashCode();
        result = 31 * result + getMovie().hashCode();
        return result;
    }

	
