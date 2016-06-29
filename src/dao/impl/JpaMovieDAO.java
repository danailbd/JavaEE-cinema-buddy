package dao.impl;

import dao.MovieDAO;
import dao.models.Movie;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

public class JpaMovieDAO extends JpaDAO implements MovieDAO {
     
	@Override
    public void addMovie(Movie movie) {
	
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

	@Override
	public List<Movie> getMoviesByDirector(String director) {
			return getBy(director);
	    }
	
	@Override
	public List<Movie> getMoviesByGenre(String genre) {
			return getBy(genre);
	    }
	
	@Override
    public List<Movie> getMovieByRating(int rating) {
		return getBy(rating);
	}

	@Override
    public List<Movie> getMovieByTitle(String title) {
		return getBy(title);
	}

	@Override
	public List<Movie> getMoviesByYear(int year) {
		return getBy(year);
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
	@Override  
	public List<Movie> getBy(int attribute) {
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
