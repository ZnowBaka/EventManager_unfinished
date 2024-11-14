package com.example.fbo_event_management_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class StartController {
    EventManagerApp appAction = new EventManagerApp();

    public int newUserIndex = -1;
    public static ArrayList<User> userArrayList = new ArrayList<>();





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

        //int DBIndex = findUserInDB(userName);
        /*if (DBIndex != -1) {
            boolean loginStatus = findUserPassInDB(DBIndex, userPass);
            if (loginStatus) {
                if (userArrayList.get(DBIndex).getAdminPrivilege()) {
                    appAction.changeScene("MainAdmin.fxml");
                }
            }else {
                appAction.changeScene("Main-Screen.fxml");
            }
            // Go to Main Screen
        } else {
            loginLabel.setText("Data mismatch: \nIncorrect username or password");
        }*/
        if (isFileReadable(new File("loginName.txt")) && isFileReadable(new File("loginCode.txt"))) {
            try (BufferedReader reader = new BufferedReader(new FileReader("loginName.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.equals(userName)) {
                        try (BufferedReader reader2 = new BufferedReader(new FileReader("loginCode.txt"))) {
                            String line2;
                            while ((line2 = reader2.readLine()) != null) {
                                if (line2.equals(userPass)) {
                                    appAction.changeScene("Main-Screen.fxml");
                                    //if (userArrayList.get(newUserIndex).getAdminPrivilege()) {}
                                }
                            }
                        }
                    }
                }
            }

        }

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

    public boolean isFileReadable(File loginFile) throws IOException{
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
        String userName = userNameField.getCharacters().toString();
        String userPass = userPassField.getCharacters().toString();

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


