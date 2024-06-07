package view_model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class UserCreationViewModel extends ViewModel{

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private final boolean resetInput = true;

    public final String USERNAME_LABEL = "Enter username: ";
    public final String PASSWORD_LABEL = "Enter password: ";
    public final String TAG_LABEL = "Enter tag: ";

    public UserCreationViewModel() {
        super("UserCreationView");
    }
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("resetInput", null, resetInput);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
