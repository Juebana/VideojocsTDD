import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User user;
    static final String userNickname = "nickname";
    static final String userName = "Username";
    static final String userLastName = "UserLastName";
    static final String userEmail = "user@email.com";
    static final LocalDate userBirthDate = LocalDate.of(1990, 1, 1);

    @BeforeEach
    void setUp() {
        user = new User(userNickname,userName, userLastName, userEmail, userBirthDate);
    }

    @Test
    void getId() {
        assertEquals(user.getId(), user.getLastId());
    }

    @Test
    void getLastId() {
        assertEquals(user.getId(), user.getLastId());
    }

    @Test
    void getNickname() {
        assertEquals(user.getNickname(), userNickname);
    }

    @Test
    void getName() {
        assertEquals(user.getName(), userName);
    }

    @Test
    void setName() {
        user.setName("newName");
        assertEquals(user.getName(), "newName");
    }

    @Test
    void getLastName() {
        assertEquals(user.getLastName(), userLastName);
    }

    @Test
    void setLastName() {
        user.setLastName("newLastName");
        assertEquals(user.getLastName(), "newLastName");
    }

    @Test
    void getEmail() {
        assertEquals(user.getEmail(), userEmail);
    }

    @Test
    void setEmail() {
        user.setEmail("newEmail@example.com");
        assertEquals(user.getEmail(), "newEmail@example.com");
    }

    @Test
    void getBirthDate() {
        user.setBirthDate(userBirthDate);
        assertEquals(user.getBirthDate(), userBirthDate);
    }

    @Test
    void setBirthDate() {
        user.setBirthDate(userBirthDate);
        assertEquals(user.getBirthDate(), userBirthDate);
    }

}