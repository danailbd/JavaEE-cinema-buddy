package dao;

import dao.models.Movie;

import java.util.List;

public interface MovieDAO {

    void addMovie(Movie movie);

    void removeMovie(Movie movie);


    List<Movie> getAllMovies();

    List<Movie> getMovieById(int id);
    
    List<Movie> getMoviesByDirector(String director);
    
    List<Movie> getMoviesByGenre(String genre);
    
    List<Movie> getMovieByTitle(String title);
    
    List<Movie> getMovieByRating(int rating);
  
    List<Movie> getMoviesByYear(int year);
    
    List<Movie> getBy(String attribute);
    
    List<Movie> getBy(int attribute);
    
    
}
