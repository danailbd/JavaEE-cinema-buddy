package dao;

import dao.models.Movie;

import java.util.List;

public interface MovieDAO {

    void addMovie(Movie movie);

    void removeMovie(Movie movie);


    List<Movie> getAllMovies();

    List<Movie> getMovieById(int id);
    /*
    List<Movie> getMoviesByDirector();
    List<Movie> getMovieByDirector();
    */
}
