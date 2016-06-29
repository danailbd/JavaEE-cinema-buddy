package dao;

import java.util.Date;
import java.util.List;

import dao.models.Projection;

public interface ProjectionDAO {

	void addProjection(Projection projection);

	void removeProjection(int id);

	List<Projection> getAllProjections();

	Projection getProjectionById(int id);

	//int getSeatsByProjection(Projection projection);

	void updateProjection(Projection projection);

	List<Projection> getProjectionsByDate(Date date);

}
