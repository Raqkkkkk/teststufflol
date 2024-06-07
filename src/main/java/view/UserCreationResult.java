package view;

import view_model.UserCreationResultViewModel;
import view_model.UserCreationViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class UserCreationResult extends JPanel implements ActionListener, PropertyChangeListener {
    public final String VIEW_NAME = "UserCreationResult";

    private final UserCreationResultViewModel userCreationResultViewModel;
    private final JLabel infoLabel = new JLabel();

    public UserCreationResult(UserCreationResultViewModel userCreationResultViewModel) {
        this.userCreationResultViewModel = userCreationResultViewModel;
        userCreationResultViewModel.addPropertyChangeListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(infoLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("label")) {
            infoLabel.setText((String) evt.getNewValue());
        }
    }
}
