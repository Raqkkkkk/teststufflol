package use_case.create_user;

public class UserCreateController {

    private final UserCreateInputBoundary interactor;

    public UserCreateController(UserCreateInputBoundary interactor) {
        this.interactor = interactor;
    }
    public void createUser(String username, String password, String tag) {

        UserCreateInputData data = new UserCreateInputData(username, password, tag);

        interactor.createUser(data);
    }
}
