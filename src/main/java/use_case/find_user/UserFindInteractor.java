package use_case.find_user;

import api.EmbedDataAPI;
import entity.User;
import entity.UserList;

public class UserFindInteractor implements UserFindInputBoundary {
    private final EmbedDataAPI embedDataAPI;
    private final UserFinderOutputBoundary userFinderOutputBoundary;

    public UserFindInteractor(EmbedDataAPI embedDataAPI, UserFinderOutputBoundary userFinderOutputBoundary) {
        this.userFinderOutputBoundary = userFinderOutputBoundary;
        this.embedDataAPI = embedDataAPI;
    }
    @Override
    public void rankUsers(String search) {
        double[] searchVector = embedDataAPI.getEmbedData(search);
        User[] rankedUsers = UserList.sortByCosineSimilarity(searchVector);
        userFinderOutputBoundary.displayRanking(rankedUsers);
    }
}
