package dao;

import dao.impl.JpaMovieDAO;

public class JpaBookingDAOFactory {

    JpaMovieDAO getJpaMovieDAO () {
        return new JpaMovieDAO();
    }

    // Add other daos
}
