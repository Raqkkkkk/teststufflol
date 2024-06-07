package use_case.create_user;

public class UserCreateInputData {
    private final String username;
    private final String password;
    private final String tag;

    public UserCreateInputData(String username, String password, String tag) {
        this.username = username;
        this.password = password;
        this.tag = tag;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getTag() {
        return tag;
    }
}
