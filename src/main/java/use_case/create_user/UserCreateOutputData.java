package use_case.create_user;

public class UserCreateOutputData {
    private final String username;
    private final String password;
    private final String tag;
    private final double[] dataVector;

    public UserCreateOutputData(String username, String password, String tag, double[] dataVector) {
        this.username = username;
        this.password = password;
        this.tag = tag;
        this.dataVector = dataVector;
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

    public double[] getDataVector() {
        return dataVector;
    }
}
