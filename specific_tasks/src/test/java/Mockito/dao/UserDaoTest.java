package Mockito.dao;

import Mockito.model.User;
import org.junit.jupiter.api.BeforeEach;
import  org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class UserDaoTest {

    private UserDao dao;

    @BeforeEach
    public void setUp() {
        this.dao = new UserDaoImp();
    }


    @Test
    void getUserByUsername_Should_Return_True() throws Exception {
        User alex = dao.getUserByUsername("alex@gmail.com");
        assertThat(alex).isNotNull();
        assertThat(alex.getUsername()).isEqualTo("alex@gmail.com");
    }

    @Test
    void getUserByUsername_Null_User() throws Exception {
        User peter = dao.getUserByUsername("peter@gmail.com");
        assertThat(peter).isNull();
    }

    @Test
    void findAllUsers_Contain() {
        List<User> allUsers = dao.findAllUsers();
        assertThat(allUsers).contains(new User("robert@gmail.com", "admin"));}
}