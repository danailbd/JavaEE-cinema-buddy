package dao.impl;

import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import dao.ProjectionDAO;
import dao.models.Movie;
import dao.models.Projection;

@Stateless
public class JpaProjectionDAO extends JpaDAO implements ProjectionDAO {

	@Override
	public void addProjection(Projection projection) {
		//checkTime(projection.getStartTime(), projection.getEndTime());
		persist(projection);

	}
/*
	private void checkTime(Date d, Date es) {
		//List<Projection> projs = getAllProjections()
		
	}*/

	@Override
	public void removeProjection(int id) {
		Projection projection = findById(id);
		this.remove(projection);

	}

	@Override
	public List<Projection> getAllProjections() {
		return findAll();
	}

	@Override
	public Projection getProjectionById(int id) {
		return findById(id);
	}

	@Override
	public List<Integer> getSeatsByProjection(Projection projection) {
		return null;
	}

	/*
	 * @Override public int getSeatsByProjection(int id) { Projection projection
	 * = getProjectionById(id); return projection.getBooking().getSeats(); }
	 */
	@Override
	public List<Projection> getProjectionsByDate(Date date) {
		TypedQuery<Projection> query = entityManager.createNamedQuery("getProjectionByDate", Projection.class)
				.setParameter("DATE", date);
		try {
			return query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	};

	@Override
	public void updateProjection(Projection projection) {

	}
}
