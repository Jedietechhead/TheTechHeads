package services;


import daos.UserDAO;

import java.util.List;

public class UserService {
    private UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAO();
    }

    public List<String> getAllUsers() {
        return userDAO.getAllUsers();
    }
}
