package com.example.fbo_event_management_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class StartController {
    Main appAction = new Main();

    public int newUserIndex = -1;
    public static ArrayList<User> userArrayList = new ArrayList<>();

    public void readUsersToSystem(ArrayList<User> userDB) {
        User user = null;
        for (User u : userDB) {
            user = u;
            EventManagerController.users.add(user);
        }
    }


    //region Labels and texts

    @FXML
    private Label loginLabel;

    @FXML
    private TextField userNameField;

    @FXML
    private TextField userPassField;


    //endregion

    /*@FXML
    private int findUserInDB(String userName) {
        for (int index = 0; index < userArrayList.size(); index++) {
            if (userArrayList.get(index).getNameOfUser().equals(userName)) {
                return index;
            }
        }
        return -1;
    }*/

    /*@FXML
    private boolean findUserPassInDB(int index, String userPass) {
        if (userArrayList.get(index).getUserLoginCode().equals(userPass)) {
            return true;
        }
        return false;
    }*/
    @FXML
    protected void onLoginButtonClick(ActionEvent event) throws IOException {
        String userName = userNameField.getCharacters().toString();
        String userPass = userPassField.getCharacters().toString();
        File userNameFile = new File("loginName.txt");
        File userPassFile = new File("loginCode.txt");


        if (isFileReadable(userNameFile) && isFileReadable(userPassFile)) {
            try (
                    BufferedReader nameReader = new BufferedReader(new FileReader(userNameFile));
                    BufferedReader passReader = new BufferedReader(new FileReader(userPassFile))
            ) {
                String userNameLine;
                String userPassLine;
                boolean isAuthenticated = false;
                while ((userNameLine = nameReader.readLine()) != null && (userPassLine = passReader.readLine()) != null) {
                    if (userNameLine.equals(userName) && userPassLine.equals(userPass)) {
                        isAuthenticated = true;
                        nameReader.close();
                        passReader.close();
                        break;
                    }
                }
                if (isAuthenticated) {
                    appAction.changeScene("Main-Screen.fxml");
                } else {
                    loginLabel.setText("Data mismatch: \nIncorrect username or password");
                }
            }
        }
        readUsersToSystem(userArrayList);
    }

    /*public void writeToFile(File loginFile, String userName, String userPass) throws IOException {
        if (isFileReadable(loginFile)){
            // If newUserIndex is valid, add the new user to the file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(loginFile, true))) {
                writer.write(userName + "    " + userPass);
                writer.newLine();
            } catch (IOException e) {
                System.out.println("Error writing to loginFile: " + e.getMessage());
                loginLabel.setText("Error writing to loginFile.");
            }
        }
    }*/

    public boolean isFileReadable(File loginFile) throws IOException {
        boolean readable = false;
        if (!Files.isReadable(Paths.get(loginFile.toString()))) {
            System.out.println("Error: Cannot read userNameFile.");
            loginLabel.setText("Error: Cannot read userNameFile.");
        } else {
            readable = true;
        }
        return readable;

    }

    /*public void writeFromFileToArray(File loginFile) {
        // Read all existing Usernames and passwords from the file into a list
        try (BufferedReader reader = new BufferedReader(new FileReader(loginFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                userArrayList.add(line.);
            }
            System.out.println(userArrayList);
        } catch (IOException e) {
            System.out.println("Error reading userNameFile: " + e.getMessage());
            loginLabel.setText("Error reading userNameFile.");
        }
    }*/

    @FXML
    public void onToMainScreenButtonClick(ActionEvent event) throws IOException {
        appAction.changeScene("Main-Screen.fxml");
    }

    @FXML
    protected void onNewUserButtonClick(ActionEvent e) throws IOException {
        appAction.changeScene("NewUser-Screen.fxml");

        /*int DBIndex = findUserInDB(userName);
        if (DBIndex == -1) {
            new StandardUser(userName, userPass);
            newUserIndex = findUserInDB(userName);
            // take newUserIndex along
            appAction.changeScene("NewUser-Screen.fxml");
        } else {
            loginLabel.setText("A user with that username already exists");
        }*/
    }
}


