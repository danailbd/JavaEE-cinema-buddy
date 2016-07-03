package dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import dao.MovieDAO;
import dao.models.Movie;
import dao.models.User;


@Stateless
public class JpaMovieDAO extends JpaDAO implements MovieDAO {

    public JpaMovieDAO() {
        super(Movie.class);
    }

    @Override
    public void addMovie(Movie movie) {
		
        persist(movie);
    }

    @Override
    public void removeMovie(int id) {
    	Movie movie = findById(id);
        this.remove(movie);
    }

    @Override
    public List<Movie> getAllMovies() {
        return findAll();
    }

    @Override 
    public List<Movie> getLast3Movies(){
    	String txtQuery = "SELECT TOP 3 * FROM MOVIES ORDER BY Date desc  ";
        TypedQuery<Movie> query = entityManager.createQuery(txtQuery, Movie.class);
        return query.getResultList();
    }
    
    @Override
    public Movie getMovieById(int id) {
        return findById(id);
    }

	@Override
	public List<Movie> getMoviesByDirector(String director) {
			return getBy(director);
	    }
	
	@Override
	public List<Movie> getMoviesByGenre(String genre) {
			return getBy(genre);
	    }
	
	@Override
    public Movie getMovieByRating(int rating) {
		TypedQuery<Movie> query = entityManager
                .createNamedQuery("getMoviesByYear", Movie.class)
                .setParameter("rating", rating);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
	}

	@Override
    public List<Movie> getMovieByTitle(String title) {
		return getBy(title);
	}

	@Override
	public List<Movie> getMoviesByYear(int year) {
		TypedQuery<Movie> query = entityManager
                .createNamedQuery("getMoviesByYear", Movie.class)
                .setParameter("year", year);
        try {
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
	}
	public  void updateMovie(Movie movie) {
		Movie updatedMovie = getMovieById(movie.getId());
		updatedMovie.setDescription(movie.getDescription());
		updatedMovie.setDirector(movie.getDirector());
		updatedMovie.setGenre(movie.getGenre());
		updatedMovie.setLength(movie.getLength());
		updatedMovie.setPrice(movie.getPrice());
		updatedMovie.setRating(movie.getRating());
		updatedMovie.setTitle(movie.getTitle());
		updatedMovie.setTrailer(movie.getTrailer());
		updatedMovie.setType(movie.getType());
		updatedMovie.setYear(movie.getYear());
		merge(updatedMovie);
		
	}
	
	@Override  
    public List<Movie> getBy(String attribute) {
		TypedQuery<Movie> query = entityManager
                .createNamedQuery("getMoviesBy" + attribute, Movie.class)
                .setParameter(""+attribute, attribute);
        try {
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
	}
	   
    
    
}
