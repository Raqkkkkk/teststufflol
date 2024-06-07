package use_case.find_user;

public class UserFindController {
    private final UserFindInputBoundary userFindInputBoundary;

    public UserFindController(UserFindInputBoundary userFindInputBoundary) {
        this.userFindInputBoundary = userFindInputBoundary;
    }

    public void findUsers(String search) {
        userFindInputBoundary.rankUsers(search);
    }
}
