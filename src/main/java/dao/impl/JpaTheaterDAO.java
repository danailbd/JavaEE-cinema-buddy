package dao.impl;

import java.util.List;

import dao.TheaterDAO;
import dao.models.Theater;

import javax.ejb.Stateless;

@Stateless
public class JpaTheaterDAO extends JpaDAO implements TheaterDAO {

	public JpaTheaterDAO() {
		super(Theater.class);
	}

	@Override
	public void addTheater(Theater theater) {
		persist(theater);
	}

	@Override
	public void removeTheater(int id) {
		Theater theater = findById(id);
        this.remove(theater);
	}

	@Override
	public List<Theater> getAllTheaters() {
        return findAll();
	}

	@Override
	public Theater getTheaterById(int id) {
		return findById(id);
	}


	public void updateTheater(Theater theater) { }
}
