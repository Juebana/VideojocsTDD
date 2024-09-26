import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

public class VideogamesLibrary {
    private Set<Videogame> videogames;

    public VideogamesLibrary() {
        videogames = new HashSet<>();
        createInitialVideogames();
    }

    public Videogame find(User user, String videogameName) {
        Videogame videogameFound = find(videogameName);
        if (videogameFound != null) {
            videogameFound.addUsersWhoHaveConsulted(user);
        }
        return videogameFound;
    }

    public Videogame find(String videogameName) {
        Videogame videogameFound = null;
        for (Videogame videogame : videogames) {
            if (videogame.getName().equals(videogameName)) {
                videogameFound = videogame;
            }
        }
        return videogameFound;
    }

    public List<Videogame> searchVideogames(String genre, String platform, float minPrice, float maxPrice) {
        List<Videogame> filteredVideogames = new ArrayList<>();

        for (Videogame videogame : videogames) {
            boolean matchesGenre = genre == null || videogame.getGenre().equalsIgnoreCase(genre);
            boolean matchesPlatform = platform == null || videogame.getPlatforms().contains(platform);
            boolean matchesPrice = videogame.getPrice() >= minPrice && videogame.getPrice() <= maxPrice;

            if (matchesGenre && matchesPlatform && matchesPrice) {
                filteredVideogames.add(videogame);
            }
        }

        return filteredVideogames;
    }

    private void createInitialVideogames() {
        Videogame returnToMonkeyIsland = new Videogame("Return to Monkey Island");
        returnToMonkeyIsland.setGenre("Point and click");
        returnToMonkeyIsland.setPlayersNumber(15539);
        returnToMonkeyIsland.setPrice(22.99f);
        returnToMonkeyIsland.setPlatforms("Windows, mac, Switch");
        returnToMonkeyIsland.setSetting("Pirates");
        returnToMonkeyIsland.setRecommendedAgePEGI("12");
        returnToMonkeyIsland.setSpecificContentPEGI("Moderate Violence");
        returnToMonkeyIsland.setRequirements("""
                Minimum requirements
                Memory: 8 GB
                Graphics Card: AMD Radeon HD 7750
                CPU: Intel Core i3-3240
                File Size: 4 GB
                OS: Windows 10
                
                Recommended specs
                Memory: 4 GB
                Graphics Card: NVIDIA GeForce 510
                CPU: Intel Core 2 Duo E8400
                File Size: Unknown
                OS: TBA""");
        videogames.add(returnToMonkeyIsland);

        Videogame dummyVideogame = new Videogame("Dummy name");
        dummyVideogame.setGenre("Dummy Genre");
        dummyVideogame.setPlayersNumber(99);
        dummyVideogame.setPrice(99f);
        dummyVideogame.setPlatforms("Dummy platform");
        dummyVideogame.setSetting("Dummy setting");
        dummyVideogame.setRecommendedAgePEGI("Dummy age");
        dummyVideogame.setSpecificContentPEGI("Dummy content");
        dummyVideogame.setRequirements("Dummy requirements");
        videogames.add(dummyVideogame);
    }
}
