import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class VideogamesLibraryTest {

    VideogamesLibrary videogamesLibrary;
    User user;

    @BeforeEach
    void setUp() {
        videogamesLibrary = new VideogamesLibrary();
        user = new User("testUser", "John", "Doe", "john.doe@example.com", LocalDate.of(1990, 1, 1));
    }

    @Test
    void findExistingVideogame() {
        Videogame foundVideogame = videogamesLibrary.find(user, "Return to Monkey Island");
        assertNotNull(foundVideogame);
    }

    @Test
    void findNonExistingVideogame() {
        Videogame foundVideogame = videogamesLibrary.find(user, "Non Existent Game");
        assertNull(foundVideogame);
    }

    @Test
    void addUserToConsultedList() {
        Videogame foundVideogame = videogamesLibrary.find(user, "Dummy name");
        assertNotNull(foundVideogame);
        assertTrue(foundVideogame.getUsersWhoHaveConsulted().contains(user));
    }

    @Test
    void consultedUsersInitiallyEmpty() {
        Videogame foundVideogame = videogamesLibrary.find("Return to Monkey Island");
        assertTrue(foundVideogame.getUsersWhoHaveConsulted().isEmpty());
    }

    @Test
    void videogamesLibraryInitialVideogames() {
        assertNotNull(videogamesLibrary.find(user, "Return to Monkey Island"));
        assertNotNull(videogamesLibrary.find(user, "Dummy name"));
    }
}
