package data_access;

import entity.User;

import java.io.FileNotFoundException;

public interface UserDataInterface {

    void loadUsers() throws FileNotFoundException;
    void saveUser(User user);
}
