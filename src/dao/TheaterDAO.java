package dao;

import java.util.List;

import dao.models.Theater;

import javax.enterprise.context.ApplicationScoped;


public interface TheaterDAO {

    void addTheater(Theater theater);

    void removeTheater(int id);

    List<Theater> getAllTheaters();

    Theater getTheaterById(int id);

    void updateTheater(Theater theater);
}
