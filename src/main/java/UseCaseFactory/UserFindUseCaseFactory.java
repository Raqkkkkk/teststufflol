package UseCaseFactory;

import api.EmbedDataAPI;
import api.OpenAPIDataEmbed;
import use_case.find_user.*;
import view.UserFindView;
import view_model.UserFindViewModel;

public class UserFindUseCaseFactory {

    private UserFindUseCaseFactory() {
    }

    public static UserFindView create(UserFindViewModel userFindViewModel) {
        UserFindController userFindController = createController(userFindViewModel);
        return new UserFindView(userFindViewModel, userFindController);
    }

    private static UserFindController createController(UserFindViewModel userFindViewModel) {
        EmbedDataAPI embedDataAPI = new OpenAPIDataEmbed();
        UserFinderOutputBoundary userFinderOutputBoundary = new UserFindPresenter(userFindViewModel);
        UserFindInputBoundary userFindInputBoundary = new UserFindInteractor(embedDataAPI, userFinderOutputBoundary);
        return new UserFindController(userFindInputBoundary);
    }
}
