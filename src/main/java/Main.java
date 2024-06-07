import UseCaseFactory.UserCreateUseCaseFactory;
import UseCaseFactory.UserFindUseCaseFactory;
import entity.UserList;
import view.*;
import view_model.UserCreationResultViewModel;
import view_model.UserCreationViewModel;
import view_model.UserFindViewModel;
import view_model.ViewManagerModel;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class Main {
    private final static boolean READ_SAVE_FILES = true;

    public static void main(String[] args) {
        JFrame application = new JFrame("Test app");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        ViewManager viewManager = new ViewManager(views, cardLayout, viewManagerModel);

        UserCreationResultViewModel userCreationResultViewModel = new UserCreationResultViewModel();
        UserCreationResult userCreationResult = new UserCreationResult(userCreationResultViewModel);

        UserCreationViewModel userCreationViewModel = new UserCreationViewModel();
        UserCreationView userCreationView = UserCreateUseCaseFactory.create(userCreationViewModel, viewManagerModel, userCreationResultViewModel);

        UserFindViewModel userFindViewModel = new UserFindViewModel();
        UserFindView userFindView = UserFindUseCaseFactory.create(userFindViewModel);

        views.add(userCreationView, "UserCreationView");
        views.add(userCreationResult, "UserCreationResult");
        views.add(userFindView, "UserFindView");

        viewManagerModel.setActiveView("UserCreationView");
        viewManagerModel.firePropertyChanged();

        JPanel buttons = new ButtonPanel(viewManagerModel);
        application.add(buttons);

        application.getContentPane().add(views, BorderLayout.CENTER);
        application.getContentPane().add(buttons, BorderLayout.SOUTH);
        application.pack();
        application.setVisible(true);

        if (READ_SAVE_FILES) {
            try {
                UserList.readFiles();
            }
            catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}