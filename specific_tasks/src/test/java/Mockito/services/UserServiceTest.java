package Mockito.services;

import Mockito.dao.UserDao;
import Mockito.model.User;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class UserServiceTest {
    @Mock
    private UserDao dao;

    private final UserService userService;

    public UserServiceTest() {
        MockitoAnnotations.openMocks(this);
        this.userService = new UserService(dao);
    }

    @Test
    void checkUserPresents_Should_Return_True() throws Exception {

        given(dao.getUserByUsername("peter@gmail.com")).willReturn(
                new User("peter@gmail.com"));
        boolean userExists = userService.checkUserPresents(
                new User("peter@gmail.com"));
        assertThat(userExists).isTrue();

        // verify
        verify(dao).getUserByUsername("peter@gmail.com");
    }


    @Test
    void checkUserPresents_Should_Return_False() throws Exception {

        given(dao.getUserByUsername("peter@gmail.com")).willReturn(
                null);
        boolean userExists = userService.checkUserPresents(
                new User("peter@gmail.com"));
        assertThat(userExists).isFalse();
    }

    @Test
    void checkUserPresents_Should_Return_Exception() throws Exception {

        given(dao.getUserByUsername(anyString())).willThrow(Exception.class);
        userService.checkUserPresents(new User("peter@gmail.com"));
    }

    @Test
    void testCaptor() throws Exception {
        given(dao.getUserByUsername(anyString())).willReturn(
                new User("peter@gmail.com"));

//        boolean b =  userService.checkUserPresents(new User("peter@gmail.com"));

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        verify(dao).getUserByUsername(captor.capture());
        String argument =  captor.getValue();
        assertThat(argument).isEqualTo("peter@gmail.com");
    }
}