import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import java.util.Map;

import java.time.LocalDate;

public class SignUpLoginTest {

    private SignUpLogin signUpLogin;

    @BeforeEach
    public void setUp() {
        signUpLogin = new SignUpLogin();
        SignUpLogin.setRegisteredUsers(new HashMap<>());
    }

    @Test
    public void testSignUpAndGetRegisteredUsers() {
        signUpLogin.signUp("user1", "password1");
        signUpLogin.signUp("user2", "password2");

        Map<String, String> users = SignUpLogin.getRegisteredUsers();

        assertEquals(2, users.size());
        assertEquals("password1", users.get("user1"));
        assertEquals("password2", users.get("user2"));
    }

    @Test
    public void testSetRegisteredUsers() {
        Map<String, String> testUsers = new HashMap<>();
        testUsers.put("newUser", "newPassword");

        SignUpLogin.setRegisteredUsers(testUsers);

        assertEquals("newPassword", SignUpLogin.getRegisteredUsers().get("newUser"));
    }

    @Test
    public void testLoginSuccess() {
        signUpLogin.signUp("validUser", "password123");

        assertTrue(signUpLogin.login("validUser", "password123"));
    }

    @Test
    public void testLoginFailInvalidPassword() {
        signUpLogin.signUp("validUser", "password123");

        assertFalse(signUpLogin.login("validUser", "wrongPassword"));
    }

    @Test
    public void testLoginFailUserNotFound() {
        assertFalse(signUpLogin.login("nonExistentUser", "somePassword"));
    }
}
