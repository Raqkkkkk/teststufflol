package use_case.create_user;

import view_model.UserCreationResultViewModel;
import view_model.UserCreationViewModel;
import view_model.ViewManagerModel;

public class UserCreatePresenter implements UserCreateOutputBoundary {

    private final ViewManagerModel viewManagerModel;
    private final UserCreationResultViewModel userCreationResultViewModel;
    private final UserCreationViewModel userCreationViewModel;

    public UserCreatePresenter(ViewManagerModel viewManagerModel, UserCreationResultViewModel userCreationResultViewModel, UserCreationViewModel userCreationViewModel) {
        this.userCreationViewModel = userCreationViewModel;
        this.userCreationResultViewModel = userCreationResultViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(UserCreateOutputData userCreateOutputData) {
        userCreationResultViewModel.setLabel(String.format("User %s created", userCreateOutputData.getUsername()));
        userCreationResultViewModel.firePropertyChanged();
        userCreationViewModel.firePropertyChanged();
        viewManagerModel.setActiveView("UserCreationResult");
        viewManagerModel.firePropertyChanged();
    }
    @Override
    public void prepareFailView(UserCreateOutputData userCreateOutputData) {
        userCreationResultViewModel.setLabel("Fail bruh");
        userCreationResultViewModel.firePropertyChanged();
        viewManagerModel.setActiveView("UserCreationResult");
        viewManagerModel.firePropertyChanged();
    }


}
