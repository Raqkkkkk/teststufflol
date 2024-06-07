package use_case.find_user;

import entity.User;

public interface UserFinderOutputBoundary {
    void displayRanking(User[] userRankingList);
}
