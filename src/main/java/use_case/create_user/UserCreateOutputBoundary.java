package use_case.create_user;

public interface UserCreateOutputBoundary {
    void prepareSuccessView(UserCreateOutputData userCreateOutputData);
    void prepareFailView(UserCreateOutputData userCreateOutputData);
}
