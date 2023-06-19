package Mockito.dao;

import Mockito.model.User;

import java.util.List;

public interface UserDao {
    User getUserByUsername(String username) throws Exception;

    List<User> findAllUsers();
}
