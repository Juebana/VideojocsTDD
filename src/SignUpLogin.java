public class SignUpLogin {
    private String signUpUsername;
    private String signUpPassword;

    public void signUp(User user) {
        signUpUsername = (String) user.getNickname();
        signUpPassword = (String) user.getPassword();
    }
    
}
