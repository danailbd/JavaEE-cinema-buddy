package dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
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

    @Override
    public List<Integer> getSeatsByProjection(Projection projection) {
        // Dummy impl
        Integer[] x = {1,2,3};
        return new ArrayList<>(Arrays.asList(x));
    }

    /*
    @Override
    public int getSeatsByProjection(int id) {
        Projection projection = getProjectionById(id);
        return projection.getBooking().getSeats();
    }

*/
    @Override
    public void updateProjection(Projection projection) {

    }

    public List<Projection> getAllProjections() {
        return null;
    }

    public List<Integer> getProjectionSeatsById(Integer projectionId) {
        Projection projection = getProjectionById(projectionId);
        return getSeatsByProjection(projection);
    }
}
