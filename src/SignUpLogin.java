import java.util.HashMap;
import java.util.Map;

public class SignUpLogin {

    private static Map<String, String> registeredUsers = new HashMap<>();

    public void signUp(String username, String password) {
        registeredUsers.put(username, password);
    }

    public boolean login(String username, String password) {
        return registeredUsers.containsKey(username) && registeredUsers.get(username).equals(password);
    }

    public static Map<String, String> getRegisteredUsers() {
        return registeredUsers;
    }

    public static void setRegisteredUsers(Map<String, String> users) {
        registeredUsers = users;
    }
}
