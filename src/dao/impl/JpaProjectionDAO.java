package dao.impl;

import java.util.List;

import dao.ProjectionDAO;
import dao.models.Projection;

public class JpaProjectionDAO extends JpaDAO implements ProjectionDAO {

	@Override
	public void addProjection(Projection projection) {
		persist(projection);
		
	}

	@Override
	public void removeProjection(int id) {
		Projection projection = findById(id);
        this.remove(projection);
		
	}

	@Override
	public List<Projection> getAllProjection() {
		return findAll();
	}

	@Override
	public Projection getProjectionById(int id) {
		return findById(id);
		
	}
	/*
	@Override
	public int getSeatsByProjection(int id) {
		Projection projection = getProjectionById(id);
		return projection.getBooking().getSeats();
	}

*/	@Override
	public void updateProjection(Projection projection) {
		
		
	}
}
