package dao.models;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@XmlRootElement(name = "projection")
public class Projection implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private Timestamp startTime;
    @Column(nullable = false)
    private Timestamp endTime;


    @ManyToOne
    @JoinColumn(name = "theater_id")
    private Theater theater;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;


    @OneToMany(cascade = CascadeType.ALL)
    @XmlTransient
    private List<Booking> bookings = new ArrayList();


    public Projection() {
    }

    public Projection(Timestamp startTime, Timestamp endTime, Theater theater, Movie movie) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.theater = theater;
        this.movie = movie;
    }

    @XmlID
    public String getStrId() {return String.valueOf(id);}

    public int getId() {
        return id;
    }

    @XmlIDREF
    @XmlElement(name="theater_id")
    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    @XmlIDREF
    @XmlElement(name="movie_id")
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartDate(Timestamp date) {
        this.startTime = date;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
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

    @Override
    public String toString() {
        return "Projection{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", theater=" + theater +
                ", movie=" + movie +
                ", bookings=" + bookings +
                ", bookingsList=" + bookingsList +
                '}';
    }
}
