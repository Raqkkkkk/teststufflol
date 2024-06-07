package use_case.find_user;

import entity.User;
import view_model.UserFindViewModel;

public class UserFindPresenter implements UserFinderOutputBoundary {
    private final UserFindViewModel userFindViewModel;

    public UserFindPresenter(UserFindViewModel userFindViewModel) {
        this.userFindViewModel = userFindViewModel;
    }
    @Override
    public void displayRanking(User[] userRankingList) {
        userFindViewModel.setRankingList(userRankingList);
        userFindViewModel.firePropertyChanged();
    }
}
