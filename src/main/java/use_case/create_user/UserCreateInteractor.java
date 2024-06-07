package use_case.create_user;

import api.EmbedDataAPI;
import entity.CommonUser;
import entity.UserList;

public class UserCreateInteractor implements UserCreateInputBoundary {
    private final EmbedDataAPI embedDataAPI;
    private final UserCreateOutputBoundary outputBoundary;

    public UserCreateInteractor(EmbedDataAPI embedDataAPI, UserCreateOutputBoundary outputBoundary) {
        this.embedDataAPI = embedDataAPI;
        this.outputBoundary = outputBoundary;
    }
    @Override
    public void createUser(UserCreateInputData data) {
        try {
            double[] dataVector = embedDataAPI.getEmbedData(data.getTag());
            UserList.addUser(new CommonUser(data.getUsername(), data.getPassword(), data.getTag(), dataVector));
            UserCreateOutputData userCreateOutputData = new UserCreateOutputData(
                    data.getUsername(), data.getPassword(), data.getTag(), dataVector);
            outputBoundary.prepareSuccessView(userCreateOutputData);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            UserCreateOutputData userCreateOutputData = new UserCreateOutputData(
                    data.getUsername(), data.getPassword(), data.getTag(), null);
            outputBoundary.prepareFailView(userCreateOutputData);
        }
    }


}
