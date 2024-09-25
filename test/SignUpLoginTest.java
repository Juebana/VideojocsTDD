import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;

public class SignUpLoginTest {

    User user;
    static final String userNickname = "nickname";
    static final String userName = "Username";
    static final String userLastName = "UserLastName";
    static final String userEmail = "user@email.com";
    static final LocalDate userBirthDate = LocalDate.of(1990, 1, 1);
    static final String userPassword = "password";

    @BeforeEach
    void setUp() {
        user = new User(userNickname,userName, userLastName, userEmail, userBirthDate, userPassword);
    }

    @Test
    void signUp() {
        SignUpLogin signUpLogin = new SignUpLogin();
        signUpLogin.signUp(user);
    }
}
