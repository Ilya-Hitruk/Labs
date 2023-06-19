package Mockito.dao;

import Mockito.model.User;

import java.util.Arrays;
import java.util.List;

public class UserDaoImp implements UserDao {
    private final List<User> users;

    public UserDaoImp() {
        this.users = Arrays.asList(
                new User("samantha@gmail.com", "guest"),
                new User("robert@gmail.com", "admin"),
                new User("alex@gmail.com", "guest"));
    }
    @Override
    public User getUserByUsername(String username) {
        return users.stream().filter(user -> user.getUsername().equals(username))
                .findAny().orElse(null);
    }

    @Override
    public List<User> findAllUsers() {
        return users;
    }
}
