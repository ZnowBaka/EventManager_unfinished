package com.example.fbo_event_management_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import static com.example.fbo_event_management_system.StartController.userArrayList;

public class NewUserController {

    @FXML
    private TextField newUserNameField;
    @FXML
    private Label userTakenLabel;

    public int newUserIndex = 0;
    private Stage stage;

    @FXML
    protected void onNewUserScreenDoneButtonClick(ActionEvent event) throws IOException {
        String newUserName = newUserNameField.getText().toString();
        // Check if the file exists
        // Ensure the file is readable
        if (isFileReadable(userFile)) {
            // Write data to file
                            writeToFile(userFile, newUserName);

        }else {
          System.out.println("Error writing to file ");
        }

        // Read from file and write to Array
        writeFromFileToArray(userFile);
        for (int i = 0; i < existingUsernames.size(); i++) {
            System.out.println(existingUsernames.get(i));
        }
        System.out.println(isFileReadable(userFile));

        // Transition to the main screen
        appAction.changeScene("Main-Screen.fxml");
    }
    public void writeToFile(File userFile, String newUserName) throws IOException {
        if (isFileReadable(userFile)){
            // If newUserIndex is valid, add the new user to the file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(userFile, true))) {
                writer.write(newUserName);
                writer.newLine();
            } catch (IOException e) {
                System.out.println("Error writing to userNameFile: " + e.getMessage());
                userTakenLabel.setText("Error writing to userNameFile.");
            }
        }
    }

    public boolean isFileReadable(File userFile) throws IOException{
        boolean readable = false;
        if (!Files.isReadable(Paths.get(userFile.toString()))) {
            System.out.println("Error: Cannot read userNameFile.");
            userTakenLabel.setText("Error: Cannot read userNameFile.");
        } else {
            readable = true;
        }
        return readable;

    }
  
    public void writeFromFileToArray(File userFile){
        // Read all existing usernames from the file into a list
        try (BufferedReader reader = new BufferedReader(new FileReader(userFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                existingUsernames.add(line);
            }
            System.out.println(existingUsernames);
        } catch (IOException e) {
            System.out.println("Error reading userNameFile: " + e.getMessage());
            userTakenLabel.setText("Error reading userNameFile.");
        }

    }

}// NewUsercontroller End

