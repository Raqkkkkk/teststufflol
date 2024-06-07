package view;

import entity.User;
import use_case.find_user.UserFindController;
import view_model.UserFindViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class UserFindView  extends JPanel implements ActionListener, PropertyChangeListener {
    public final String VIEW_NAME = "UserFindView";

    private final UserFindViewModel userFindViewModel;
    private final UserFindController userFindController;
    private final JTextField searchField = new JTextField(30);
    private final JButton searchButton = new JButton("Search");
    private final JPanel infoArea = new JPanel();
    private final JScrollPane infoPanel = new JScrollPane(infoArea);

    public UserFindView(UserFindViewModel userFindViewModel, UserFindController userFindController) {
        this.userFindController = userFindController;
        this.userFindViewModel = userFindViewModel;
        userFindViewModel.addPropertyChangeListener(this);

        LabelTextPanel searchInfo = new LabelTextPanel(
                new JLabel(userFindViewModel.FIND_USER_LABEL), searchField);

        searchButton.addActionListener(e -> userFindController.findUsers(searchField.getText()));

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(searchInfo);
        this.add(searchButton);
        this.add(infoPanel);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        if (evt.getPropertyName().equals("ranking")) {
            infoArea.removeAll();
            User[] userRankingList = (User[]) evt.getNewValue();
            infoArea.setLayout(new GridLayout(userRankingList.length, 2));
            for (User user : userRankingList) {
                infoArea.add(new JLabel(user.getUsername()));
                infoArea.add(new JLabel(user.getTag()));
            }
            infoArea.revalidate();
            infoArea.repaint();
        }
    }
}
