package view;

import view_model.ViewManagerModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel {

    private final JButton createUserButton = new JButton("Create User");
    private final JButton findUserButton = new JButton("Find User");

    public ButtonPanel(ViewManagerModel viewManagerModel) {
        createUserButton.addActionListener(e -> {
            viewManagerModel.setActiveView("UserCreationView");
            viewManagerModel.firePropertyChanged();
        });

        findUserButton.addActionListener(e -> {
            viewManagerModel.setActiveView("UserFindView");
            viewManagerModel.firePropertyChanged();
        });

        this.add(createUserButton);
        this.add(findUserButton);
    }
}
