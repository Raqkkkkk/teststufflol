package view_model;

import entity.User;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class UserFindViewModel extends ViewModel{

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private User[] userRankingList;

    public final String FIND_USER_LABEL = "Enter tag to search: ";

    public UserFindViewModel() {
        super("UserFindView");
    }

    public void setRankingList(User[] userRankingList) {
        this.userRankingList = userRankingList;
    }
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("ranking", null, userRankingList);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
