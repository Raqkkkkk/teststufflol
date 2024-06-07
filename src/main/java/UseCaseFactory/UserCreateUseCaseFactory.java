package UseCaseFactory;

import api.EmbedDataAPI;
import api.OpenAPIDataEmbed;
import use_case.create_user.*;
import view.UserCreationView;
import view_model.UserCreationResultViewModel;
import view_model.UserCreationViewModel;
import view_model.ViewManagerModel;

public class UserCreateUseCaseFactory {

    private UserCreateUseCaseFactory() {
    }

    public static UserCreationView create(UserCreationViewModel userCreationViewModel, ViewManagerModel viewManagerModel, UserCreationResultViewModel userCreationResultViewModel) {
        UserCreateController userCreateController = createController(viewManagerModel, userCreationResultViewModel, userCreationViewModel);
        return new UserCreationView(userCreationViewModel, userCreateController);
    }

    private static UserCreateController createController(ViewManagerModel viewManagerModel, UserCreationResultViewModel userCreationResultViewModel, UserCreationViewModel userCreationViewModel) {
        EmbedDataAPI embedDataAPI = new OpenAPIDataEmbed();
        UserCreateOutputBoundary presenter = new UserCreatePresenter(viewManagerModel, userCreationResultViewModel, userCreationViewModel);
        UserCreateInputBoundary interactor = new UserCreateInteractor(embedDataAPI, presenter);
        return new UserCreateController(interactor);
    }
}
