package dao.impl;

import dao.models.User;
import dao.UserDAO;

public class JpaUserDAO extends JpaDAO implements UserDAO{
    @Override
    public User getUserById(int id) {
        return null;
    }
}
