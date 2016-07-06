package dao.models;

import javax.management.InvalidAttributeValueException;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name = "booking")
public class Booking {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "projection_id")
    private Projection projection;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private Long seat;

    public int getId() {
        return id;
    }

    public Booking() { }

    public Booking(Projection projection, Long seat, User user) {
        this.projection = projection;
        this.seat = seat;
        this.user = user;
    }

    @XmlIDREF
    @XmlElement(name="projection_id")
    public Projection getProjection() {
        return projection;
    }

    public void setProjection(Projection projection) {
        this.projection = projection;
    }

    @XmlID
    @XmlElement(name="id")
    public String getStrId() {return String.valueOf(id);}

    @XmlIDREF
    @XmlElement(name="user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getSeat() {
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
            if (2 ==2){//booking.getSeat() == seat) {
                taken = true;
                break;
            }
        }
        return taken;
    }

    public void setSeat(Long seat) throws InvalidAttributeValueException {
 
        if (seat > 0L) {
            this.seat = seat;
        }
        throw new InvalidAttributeValueException();
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
        result = 31 * result + getSeat().intValue();
        return result;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", projection=" + projection +
                ", user=" + user +
                ", seat=" + seat +
                '}';
    }
}
