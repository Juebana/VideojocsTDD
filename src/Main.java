import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SignUpLogin signUpLogin = new SignUpLogin();
        VideogamesLibrary library = new VideogamesLibrary();

        while (true) {
            System.out.println("1. Sign Up");
            System.out.println("2. Login");
            System.out.println("3. Add Review");
            System.out.println("4. Search Videogames");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter username: ");
                    String signUpUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String signUpPassword = scanner.nextLine();
                    signUpLogin.signUp(signUpUsername, signUpPassword);
                    System.out.println("User registered successfully!");
                    break;

                case 2:
                    System.out.print("Enter username: ");
                    String loginUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String loginPassword = scanner.nextLine();
                    if (signUpLogin.login(loginUsername, loginPassword)) {
                        System.out.println("Login successful!");

                        // Inside the logged-in context
                        while (true) {
                            System.out.println("1. Add Review");
                            System.out.println("2. Search Videogames");
                            System.out.println("3. Logout");
                            System.out.print("Select an option: ");
                            int loggedInOption = scanner.nextInt();
                            scanner.nextLine();  // Consume newline

                            if (loggedInOption == 1) {
                                System.out.print("Enter videogame name: ");
                                String videogameName = scanner.nextLine();
                                Videogame videogame = library.find(videogameName);

                                if (videogame != null) {
                                    System.out.print("Enter review comment: ");
                                    String comment = scanner.nextLine();
                                    System.out.print("Enter rating (1-5): ");
                                    int rating = scanner.nextInt();
                                    videogame.addReview(new User(loginUsername, loginUsername, "", "", LocalDate.now(), loginPassword), comment, rating);
                                    System.out.println("Review added!");
                                } else {
                                    System.out.println("Videogame not found.");
                                }
                            } else if (loggedInOption == 2) {
                                System.out.print("Enter genre (or leave empty): ");
                                String genre = scanner.nextLine();
                                System.out.print("Enter platform (or leave empty): ");
                                String platform = scanner.nextLine();
                                System.out.print("Enter minimum price: ");
                                float minPrice = scanner.nextFloat();
                                System.out.print("Enter maximum price: ");
                                float maxPrice = scanner.nextFloat();

                                List<Videogame> results = library.searchVideogames(genre, platform, minPrice, maxPrice);
                                System.out.println("Search results:");
                                for (Videogame v : results) {
                                    System.out.println("- " + v.getName());
                                }
                            } else if (loggedInOption == 3) {
                                break; // Logout
                            }
                        }
                    } else {
                        System.out.println("Login failed. Please check your credentials.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting the application.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
