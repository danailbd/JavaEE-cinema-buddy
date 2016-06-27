package dao.models;

import com.oracle.jrockit.jfr.InvalidValueException;

import javax.persistence.*;

@Entity
public class Booking {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "projection_id")
    private Projection projection;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    private int seat;

    public int getId() {
        return id;
    }

    public Projection getProjection() {
        return projection;
    }

    public void setProjection(Projection projection) {
        this.projection = projection;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getSeat() {
        return seat;
    }

    /**
     * Checks whether a seat is already taken.
     * @param seat
     * @return
     */
    private Boolean isSeatTaken(int seat) {
        boolean taken = false;

        for (Booking booking : projection.getBookings()) {
            if (booking.getSeat() == seat) {
                taken = true;
                break;
            }
        }
        return taken;
    }

    public void setSeat(int seat) throws InvalidValueException {
        // TODO business logic here ??
        if (seat > 0 && seat < projection.getTheater().getCapacity() &&
                !isSeatTaken(seat)) {
            this.seat = seat;
        }
        throw new InvalidValueException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Booking booking = (Booking) o;

        if (getId() != booking.getId()) return false;
        if (getSeat() != booking.getSeat()) return false;
        if (!getProjection().equals(booking.getProjection())) return false;
        return getUser().equals(booking.getUser());

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getProjection().hashCode();
        result = 31 * result + getUser().hashCode();
        result = 31 * result + getSeat();
        return result;
    }
}
