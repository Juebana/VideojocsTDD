import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class VideogamesLibraryTest {

    VideogamesLibrary videogamesLibrary;
    User user;

    @BeforeEach
    void setUp() {
        videogamesLibrary = new VideogamesLibrary();
        user = new User("testUser", "John", "Doe", "john.doe@example.com", LocalDate.of(1990, 1, 1), "password");
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

    @Test
    public void testSearchByGenre() {
        List<Videogame> results = videogamesLibrary.searchVideogames("Point and click", null, 0, Float.MAX_VALUE);
        assertEquals(1, results.size());
        assertEquals("Return to Monkey Island", results.get(0).getName());
    }

    @Test
    public void testSearchByPlatform() {
        List<Videogame> results = videogamesLibrary.searchVideogames(null, "Switch", 0, Float.MAX_VALUE);
        assertEquals(1, results.size());
        assertEquals("Return to Monkey Island", results.get(0).getName());
    }

    @Test
    public void testSearchByPriceRange() {
        List<Videogame> results = videogamesLibrary.searchVideogames(null, null, 20, 30);
        assertEquals(1, results.size());
        assertEquals("Return to Monkey Island", results.get(0).getName());
    }

    @Test
    public void testSearchByGenreAndPlatform() {
        List<Videogame> results = videogamesLibrary.searchVideogames("Point and click", "Switch", 0, Float.MAX_VALUE);
        assertEquals(1, results.size());
    }

    @Test
    public void testSearchNoMatches() {
        List<Videogame> results = videogamesLibrary.searchVideogames("RPG", "PlayStation", 0, Float.MAX_VALUE);
        assertTrue(results.isEmpty());
    }
}
