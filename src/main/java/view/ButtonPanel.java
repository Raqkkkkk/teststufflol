package view;

import view_model.ViewManagerModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel {

    private JButton createUserButton = new JButton("Create User");
    private JButton findUserButton = new JButton("Find User");

    public ButtonPanel(ViewManagerModel viewManagerModel) {
        createUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewManagerModel.setActiveView("UserCreationView");
                viewManagerModel.firePropertyChanged();
            }
        });

        findUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewManagerModel.setActiveView("UserFindView");
                viewManagerModel.firePropertyChanged();
            }
        });

        this.add(createUserButton);
        this.add(findUserButton);
    }
}
