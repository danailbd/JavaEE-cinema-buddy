package dao.impl;

import dao.MovieDAO;
import dao.models.Movie;

import java.util.List;

public class JpaMovieDAO extends JpaDAO implements MovieDAO {
    @Override
    public void addMovie(Movie movie) {
        // Save the entry
        persist(movie);
    }

    @Override
    public void removeMovie(Movie movie) {
        this.remove(movie);
    }

    @Override
    public List<Movie> getAllMovies() {
        return findAll();
    }

    @Override
    public List<Movie> getMovieById(int id) {
        return findById(id);
    }
}
