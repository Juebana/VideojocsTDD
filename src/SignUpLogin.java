public class SignUpLogin {
    private String signUpUsername;
    private String signUpPassword;

    public SignUpLogin(String username, String password) {
        this.signUpUsername = username;
        this.signUpPassword = password;
    }

    public String getSignUpUsername() {
        return signUpUsername;
    }

    public void setSignUpUsername(String username) {
        this.signUpUsername = username;
    }

    public String getSignUpPassword() {
        return signUpPassword;
    }

    public void setSignUpPassword(String password) {
        this.signUpPassword = password;
    }

    public void signUp(User user) {
        setSignUpUsername(user.getNickname());
        setSignUpPassword(user.getPassword());
    }
}