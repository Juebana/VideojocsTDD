import java.time.LocalDate;

public class User {
    private final int id;
    private static int lastId = 0;

    private String nickname;
    private String name;
    private String lastName;
    private String email;
    private LocalDate birthDate;

    public User(String nickname, String name, String lastName, String email, LocalDate birthDate) {
        setNickname(nickname);
        lastId = 0;
        lastId++;
        this.id = lastId;
        setName(name);
        setLastName(lastName);
        setEmail(email);
        setBirthDate(birthDate);
    }

    public int getId() {
        return this.id;
    }

    public int getLastId() {
      return lastId;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }
    
}
