package view_model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class UserCreationResultViewModel extends ViewModel{
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private String label;

    public UserCreationResultViewModel() {
        super("UserCreationResult");
        this.label = "";
    }
    public void setLabel(String label) {
        this.label = label;
        firePropertyChanged();
    }
    public String getLabel() {
        return label;
    }
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("label", null, label);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
