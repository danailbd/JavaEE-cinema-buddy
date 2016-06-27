package dao;

import dao.impl.*;

public class JpaBookingDAOFactory {

    JpaMovieDAO getJpaMovieDAO () {
        return new JpaMovieDAO();
    }

    JpaBookingDAO getJpaBookingDAO () {
        return new JpaBookingDAO();
    }

    JpaUserDAO getJpaUserDAO () {
        return new JpaUserDAO();
    }

    JpaTheaterDAO getJpaTheaterDAO () {
        return new JpaTheaterDAO();
    }

    JpaProjectionDAO getJpaProjectionDAO () {
        return new JpaProjectionDAO();
    }
}
