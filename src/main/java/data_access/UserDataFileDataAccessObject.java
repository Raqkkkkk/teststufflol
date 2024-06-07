package data_access;

import entity.CommonUser;
import entity.User;
import entity.UserList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class UserDataFileDataAccessObject implements UserDataInterface {

    private static final String FILE_PATH = "random_files/users/";

    @Override
    public void loadUsers() throws FileNotFoundException {
        for (File saveFile : Objects.requireNonNull(new File(FILE_PATH).listFiles())) {
            if (saveFile.getName().endsWith(".txt")) {
                Scanner scanner = new Scanner(saveFile);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] args = line.split("/");
                    args[3] =args[3].replace("[", "").replace("]", "");
                    User newUser = new CommonUser(args[0], args[1], args[2], Arrays.stream(args[3].split(",")).mapToDouble(Double::parseDouble).toArray());
                    UserList.addUser(newUser);
                }
                scanner.close();
            }
        }
    }

    @Override
    public void saveUser(User user) {
        write(FILE_PATH + user.getUsername() + ".txt", user.toString());
    }

    private void write(String filename, String content) {
        try {
            java.io.FileWriter file = new java.io.FileWriter(filename);
            file.write(content);
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
