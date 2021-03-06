package dao.models;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@XmlRootElement(name = "movie")
public class Movie implements Serializable {
    @Id
    @GeneratedValue
//    @XmlJavaTypeAdapter(type=long.class, value=WSLongAdapter.class)
    private int id;

    private int year;
    private int length;
    private String director;
    private String title;
    private String genre;
    private String description;
    private Date date;

    private String trailer;

    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
    private Type type;

    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
    private Rating rating;

    private double price;


    public Movie() {
    }

    public Movie(String title, double price) {
        this.title = title;
        this.price = price;
    }

    @XmlID
    @XmlElement(name="id")
    public String getStrId() {return String.valueOf(id);}

    public int getId() {
        return id;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYear() {

        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // We want to access all projections for movie
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE})
    @XmlTransient
    private List<Projection> projections = new ArrayList();

    public List<Projection> getProjections () {
        return projections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (getId() != movie.getId()) return false;
        if (getYear() != movie.getYear()) return false;
        if (getLength() != movie.getLength()) return false;
        if (Double.compare(movie.getPrice(), getPrice()) != 0) return false;
        if (!getDirector().equals(movie.getDirector())) return false;
        if (!getTitle().equals(movie.getTitle())) return false;
        if (!getGenre().equals(movie.getGenre())) return false;
        if (getDescription() != null ? !getDescription().equals(movie.getDescription()) : movie.getDescription() != null)
            return false;
        if (getType() != movie.getType()) return false;
        return getRating() == movie.getRating();

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getId();
        result = 31 * result + getYear();
        result = 31 * result + getLength();
        result = 31 * result + getDirector().hashCode();
        result = 31 * result + getTitle().hashCode();
        result = 31 * result + getGenre().hashCode();
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        result = 31 * result + getRating().hashCode();
        temp = Double.doubleToLongBits(getPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", year=" + year +
                ", length=" + length +
                ", director='" + director + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", trailer='" + trailer + '\'' +
                ", type=" + type +
                ", rating=" + rating +
                ", price=" + price +
                ", projections=" + projections +
                '}';
    }
}
