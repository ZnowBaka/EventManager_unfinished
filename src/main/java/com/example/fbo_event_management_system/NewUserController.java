package com.example.fbo_event_management_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;

/**
 * Controller for creating new user
 */
public class NewUserController {
    private static final String USER_FILE_PATH = "userNameFile";
    private static final String LOGIN_NAME_FILE_PATH = "loginName.txt";
    private static final String LOGIN_CODE_FILE_PATH = "loginCode.txt";

    private File userFile = new File(USER_FILE_PATH);
    private File loginNameFile = new File(LOGIN_NAME_FILE_PATH);
    private File loginCodeFile = new File(LOGIN_CODE_FILE_PATH);

    public static ArrayList<String> existingUsernames = new ArrayList<>();
    EventManagerController eventController = new EventManagerController();

    @FXML
    private TextField newUserNameField;
    @FXML
    private Label userTakenLabel;
    @FXML
    private TextField newLoginName;
    @FXML
    private TextField newLoginPass;

    @FXML
    protected void onNewUserScreenDoneButtonClick(ActionEvent event) {
        try {
            String newUserName = newUserNameField.getText();
            String newLoginNameStr = newLoginName.getText();
            String newLoginPassStr = newLoginPass.getText();

            // Check the readability of necessary files
            ensureFileExists(userFile);
            ensureFileExists(loginNameFile);
            ensureFileExists(loginCodeFile);

            if (isFileReadable(userFile) && isFileReadable(loginNameFile) && isFileReadable(loginCodeFile)) {
                // Write data to each file
                writeToFile(userFile, newUserName);
                writeToFile(loginNameFile, newLoginNameStr);
                writeToFile(loginCodeFile, newLoginPassStr);

                // Update existingUsernames list
                writeFromFileToArray(userFile);
                existingUsernames.forEach(System.out::println);  // log for debugging

                // Confirm user creation
                createUser(newLoginNameStr, newLoginPassStr, newUserName);
                userTakenLabel.setText("User created successfully");

                // Transition to the main screen
                new Main().changeScene("Main-Screen.fxml");
            } else {
                System.out.println("Error: Some files are not readable.");
                userTakenLabel.setText("Error: Some files are not readable.");
            }

        } catch (IOException e) {
            System.out.println("Exception during user creation: " + e.getMessage());
            userTakenLabel.setText("Exception during user creation: " + e.getMessage());
        }
    }

    /**
     * Ensures the file exists. If it doesn't, creates it.
     */
    private void ensureFileExists(File file) throws IOException {
        if (!file.exists()) {
            System.out.println(file.getName() + " does not exist. Creating it.");
            file.createNewFile();
            System.out.println(file.getName() + " created successfully.");
        }
    }

    /**
     * Writes the specified text to the given file
     */
    private void writeToFile(File file, String text) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(text);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to " + file.getName() + ": " + e.getMessage());
            userTakenLabel.setText("Error writing to " + file.getName());
        }
    }

    /**
     * Checks if the specified file is readable
     */
    private boolean isFileReadable(File file) {
        try {
            boolean isReadable = Files.isReadable(file.toPath());
            if (!isReadable) {
                System.out.println("Error: Cannot read " + file.getName());
                userTakenLabel.setText("Error: Cannot read " + file.getName());
            }
            return isReadable;
        } catch (Exception e) {
            System.out.println("Exception checking readability of " + file.getName() + ": " + e.getMessage());
            return false;
        }
    }

    /**
     * Reads all usernames from the specified file into the existing usernames list
     */
    private void writeFromFileToArray(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            existingUsernames.clear();
            while ((line = reader.readLine()) != null) {
                existingUsernames.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading " + file.getName() + ": " + e.getMessage());
            userTakenLabel.setText("Error reading " + file.getName());
        }
    }

    /**
     * Creates a new user and adds to the list
     */
    private void createUser(String loginName, String userPass, String userName) {
        User user = new User(userName, loginName, userPass);
        StartController.userArrayList.add(user);
        eventController.addUser(userName, userPass, false);


    }
}