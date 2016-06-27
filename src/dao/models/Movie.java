package dao.models;

import javax.persistence.*;

@Entity
public class Movie {
    @Id
    @GeneratedValue
    private int id;

    private int year;
    private int length;
    private String director;
    private String title;
    private String genre;
    private String description;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Enumerated(EnumType.STRING)
    private Rating rating;

    private double price;
}
