package Mockito.services;

import Mockito.dao.UserDao;
import Mockito.model.User;

import java.util.Objects;

public class UserService {
    private final UserDao dao;

    public UserService(UserDao dao) {
        this.dao = dao;
    }

    public boolean checkUserPresents(User user) throws Exception {
        User u = dao.getUserByUsername(user.getUsername());
        return Objects.nonNull(u);
    }
}
