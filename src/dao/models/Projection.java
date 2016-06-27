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

    private Date date;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Projection that = (Projection) o;

        if (getId() != that.getId()) return false;
        if (!getDate().equals(that.getDate())) return false;
        if (!getTheater().equals(that.getTheater())) return false;
        if (!getMovie().equals(that.getMovie())) return false;
        return getBookings() != null ? getBookings().equals(that.getBookings()) : that.getBookings() == null;

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getDate().hashCode();
        result = 31 * result + getTheater().hashCode();
        result = 31 * result + getMovie().hashCode();
        return result;
    }
}
