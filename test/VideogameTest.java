import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

class VideogameTest {

    Videogame videogame;
    static final String gameName = "SampleGame";
    User user;

    @BeforeEach
    void setUp() {
        videogame = new Videogame(gameName);
        user = new User("testUser", "John", "Doe", "john.doe@example.com", LocalDate.of(1990, 1, 1), "password");
    }

    @Test
    void getName() {
        assertEquals(gameName, videogame.getName());
    }

    @Test
    void setName() {
        videogame.setName("NewGameName");
        assertEquals("NewGameName", videogame.getName());
    }

    @Test
    void getGenre() {
        videogame.setGenre("Action");
        assertEquals("Action", videogame.getGenre());
    }

    @Test
    void setGenre() {
        videogame.setGenre("RPG");
        assertEquals("RPG", videogame.getGenre());
    }

    @Test
    void getPlayersNumber() {
        videogame.setPlayersNumber(4);
        assertEquals(4, videogame.getPlayersNumber());
    }

    @Test
    void setPlayersNumber() {
        videogame.setPlayersNumber(8);
        assertEquals(8, videogame.getPlayersNumber());
    }

    @Test
    void getPrice() {
        videogame.setPrice(59.99f);
        assertEquals(59.99f, videogame.getPrice());
    }

    @Test
    void setPrice() {
        videogame.setPrice(49.99f);
        assertEquals(49.99f, videogame.getPrice());
    }

    @Test
    void getPlatforms() {
        videogame.setPlatforms("PC, PS5");
        assertEquals("PC, PS5", videogame.getPlatforms());
    }

    @Test
    void setPlatforms() {
        videogame.setPlatforms("Xbox, PC");
        assertEquals("Xbox, PC", videogame.getPlatforms());
    }

    @Test
    void getSetting() {
        videogame.setSetting("Futuristic");
        assertEquals("Futuristic", videogame.getSetting());
    }

    @Test
    void setSetting() {
        videogame.setSetting("Medieval");
        assertEquals("Medieval", videogame.getSetting());
    }

    @Test
    void getRecommendedAgePEGI() {
        videogame.setRecommendedAgePEGI("18");
        assertEquals("18", videogame.getRecommendedAgePEGI());
    }

    @Test
    void setRecommendedAgePEGI() {
        videogame.setRecommendedAgePEGI("16");
        assertEquals("16", videogame.getRecommendedAgePEGI());
    }

    @Test
    void getSpecificContentPEGI() {
        videogame.setSpecificContentPEGI("Violence");
        assertEquals("Violence", videogame.getSpecificContentPEGI());
    }

    @Test
    void setSpecificContentPEGI() {
        videogame.setSpecificContentPEGI("Sexual Content");
        assertEquals("Sexual Content", videogame.getSpecificContentPEGI());
    }

    @Test
    void getRequirements() {
        videogame.setRequirements("Windows 10, 16GB RAM, GTX 1060");
        assertEquals("Windows 10, 16GB RAM, GTX 1060", videogame.getRequirements());
    }

    @Test
    void setRequirements() {
        videogame.setRequirements("Windows 11, 32GB RAM, RTX 3080");
        assertEquals("Windows 11, 32GB RAM, RTX 3080", videogame.getRequirements());
    }

    @Test
    void addUsersWhoHaveConsulted() {
        videogame.addUsersWhoHaveConsulted(user);
        Set<User> consultedUsers = videogame.getUsersWhoHaveConsulted();
        assertTrue(consultedUsers.contains(user));
    }

    @Test
    void getUsersWhoHaveConsulted() {
        User user1 = new User("user1", "Alice", "Smith", "alice.smith@example.com", LocalDate.of(1995, 5, 10), "password");
        User user2 = new User("user2", "Bob", "Jones", "bob.jones@example.com", LocalDate.of(1988, 3, 20), "password");
        videogame.addUsersWhoHaveConsulted(user1);
        videogame.addUsersWhoHaveConsulted(user2);

        Set<User> consultedUsers = videogame.getUsersWhoHaveConsulted();
        assertEquals(2, consultedUsers.size());
        assertTrue(consultedUsers.contains(user1));
        assertTrue(consultedUsers.contains(user2));
    }

    @Test
    void showData() {
        videogame.setGenre("RPG");
        videogame.setPlayersNumber(4);
        videogame.setPrice(29.99f);
        videogame.setPlatforms("PC, PS4");
        videogame.setSetting("Fantasy");
        videogame.setRecommendedAgePEGI("16");
        videogame.setSpecificContentPEGI("Violence");
        videogame.setRequirements("Windows 10, 8GB RAM, GTX 970");

        videogame.showData(); 
    }
}
