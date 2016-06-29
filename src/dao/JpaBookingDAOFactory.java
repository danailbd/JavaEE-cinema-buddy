package dao;

import dao.impl.*;

public class JpaBookingDAOFactory {

    private final JpaUserDAO jpaUserDAO = new JpaUserDAO();
    private final JpaTheaterDAO jpaTheaterDAO = new JpaTheaterDAO();
    private final JpaProjectionDAO jpaProjectionDAO = new JpaProjectionDAO();
    private JpaMovieDAO jpaMovieDAO = new JpaMovieDAO();
    private JpaBookingDAO jpaBookingDAO = new JpaBookingDAO();

    public JpaBookingDAOFactory() {}

    public JpaMovieDAO getJpaMovieDAO () {
        return jpaMovieDAO;
    }

    public JpaBookingDAO getJpaBookingDAO () {
        return jpaBookingDAO;
    }

    public JpaUserDAO getJpaUserDAO () {
        return jpaUserDAO;
    }

    public JpaTheaterDAO getJpaTheaterDAO () {
        return jpaTheaterDAO;
    }

    public JpaProjectionDAO getJpaProjectionDAO () {
        return jpaProjectionDAO;
    }
}
