package entity;

import data_access.UserDataFileDataAccessObject;
import data_access.UserDataInterface;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Map.Entry;

public class UserList {

    private static User[] users = new User[0];
    private static final boolean SAVE_TO_FILE = true;
    private static final String FILE_PATH = "random_files/users/";
    private static final UserDataInterface userDataInterface = new UserDataFileDataAccessObject();

    public static User[] getUsers() {
        return users;
    }

    public static void addUser(User user) {
        User[] newUsers = new User[users.length + 1];
        System.arraycopy(users, 0, newUsers, 0, users.length);
        newUsers[users.length] = user;
        users = newUsers;

        if (SAVE_TO_FILE) {
            userDataInterface.saveUser(user);
        }
    }

    public static void removeUser(User user) {
        User[] newUsers = new User[users.length - 1];
        int j = 0;
        for (int i = 0; i < users.length; i++) {
            if (users[i] != user) {
                newUsers[j] = users[i];
                j++;
            }
        }
        users = newUsers;
    }

    public static User getUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public static User[] sortByCosineSimilarity(double[] dataVector) {

        Map<User, Double> cosineSimilarityMap = new LinkedHashMap<>();
        for (User user : users) {
            cosineSimilarityMap.put(user, user.cosineSimilarity(dataVector));
        }
        return sortByValue(cosineSimilarityMap).keySet().toArray(new User[0]);
    }

    private static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Entry.comparingByValue());
        Collections.reverse(list);

        Map<K, V> result = new LinkedHashMap<>();
        for (Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

    public static void readFiles() throws FileNotFoundException {
        userDataInterface.loadUsers();
    }
}
