package rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.impl.JpaMovieDAO;
import dao.models.Movie;

@Path("/movie")
public class MovieResource {
	private static final Response RESPONSE_OK = Response.ok().build();
	private static final Response RESPONSE_FAIL = Response.status(400).build();
	private static JpaMovieDAO dao = new JpaMovieDAO();

	@PUT
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addMovie(Movie movie) {
		try {
			dao.addMovie(movie);
			return RESPONSE_OK;
		}catch(Exception e){
			return RESPONSE_FAIL;
		}

	};

	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateMovie(Movie movie) {
		try {
			dao.updateMovie(movie);
			return RESPONSE_OK;
		}catch(Exception e){
			return RESPONSE_FAIL;
		}
		
	};

	@POST
	@Path("/delete/{movieId}")
	public Response deleteMovie(@PathParam("movieId") Integer movieId) {
		try {
			dao.removeMovie(movieId);
			return RESPONSE_OK;
		} catch (Exception e) {
			return RESPONSE_FAIL;
		}
	};

}
