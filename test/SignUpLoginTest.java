import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

public class SignUpLoginTest {

    User user;
    static final String userNickname = "nickname";
    static final String userPassword = "password";

    @BeforeEach
    void setUp() {
        user = new User(userNickname, "Username", "UserLastName", "user@email.com", LocalDate.of(1990, 1, 1), userPassword);
    }

    @Test
    void getSignUpUsernameTest() {
        SignUpLogin signUpLogin = new SignUpLogin(userNickname, userPassword);
        assertEquals(userNickname, signUpLogin.getSignUpUsername());
    }

    @Test
    void setSignUpUsernameTest() {
        SignUpLogin signUpLogin = new SignUpLogin(userNickname, userPassword);
        signUpLogin.setSignUpUsername("newNickname");
        assertEquals("newNickname", signUpLogin.getSignUpUsername());
    }

    @Test
    void getSignUpPassword() {
        SignUpLogin signUpLogin = new SignUpLogin(userNickname, userPassword);
        assertEquals(userPassword, signUpLogin.getSignUpPassword());
    }

    @Test
    void setSignUpPassword() {
        SignUpLogin signUpLogin = new SignUpLogin(userNickname, userPassword);
        signUpLogin.setSignUpPassword("newPassword");
        assertEquals("newPassword", signUpLogin.getSignUpPassword());
    }

    @Test
    void signUp() {
        SignUpLogin signUpLogin = new SignUpLogin(userNickname, userPassword);
        signUpLogin.signUp(user);
        assertEquals(user.getNickname(), signUpLogin.getSignUpUsername());
        assertEquals(user.getPassword(), signUpLogin.getSignUpPassword());
    }
}
