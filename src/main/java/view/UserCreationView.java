package view;

import use_case.create_user.UserCreateController;
import use_case.create_user.UserCreateInputBoundary;
import view_model.UserCreationViewModel;
import view_model.ViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class UserCreationView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String VIEW_NAME = "UserCreationView";

    private final UserCreationViewModel userCreationViewModel;
    private final UserCreateController userCreateController;
    private final JTextField usernameField = new JTextField(15);
    private final JPasswordField passwordField = new JPasswordField(15);
    private final JTextField tagField = new JTextField(30);
    private final JButton submitButton = new JButton("Submit");

    public UserCreationView(UserCreationViewModel userCreationViewModel, UserCreateController userCreateController) {
        this.userCreationViewModel = userCreationViewModel;
        userCreationViewModel.addPropertyChangeListener(this);
        this.userCreateController = userCreateController;

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel(userCreationViewModel.USERNAME_LABEL), usernameField);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel(userCreationViewModel.PASSWORD_LABEL), passwordField);
        LabelTextPanel tagInfo = new LabelTextPanel(
                new JLabel(userCreationViewModel.TAG_LABEL), tagField);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userCreateController.createUser(usernameField.getText(), passwordField.getText(), tagField.getText());
            }
        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(usernameInfo);
        this.add(passwordInfo);
        this.add(tagInfo);
        this.add(submitButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("resetInput")) {
            usernameField.setText("");
            passwordField.setText("");
            tagField.setText("");
        }
    }
}
