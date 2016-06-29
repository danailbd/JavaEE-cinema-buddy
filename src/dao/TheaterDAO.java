package dao;

import java.util.List;

import dao.models.Theater;

public interface TheaterDAO {

    void addTheater(Theater theater);

    void removeTheater(int id);

    List<Theater> getAllTheaters();

    Theater getTheaterById(int id);
   
    
}
