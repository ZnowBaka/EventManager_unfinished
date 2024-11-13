package com.example.fbo_event_management_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.*;
import java.io.IOException;

import static com.example.fbo_event_management_system.StartController.userArrayList;

public class NewUserController {

    @FXML
    private TextField newUserNameField;
    @FXML
    private Label userTakenLabel;

    public int newUserIndex = -1;
    private Stage stage;

    @FXML
    protected void onNewUserScreenDoneButtonClick(ActionEvent event) throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader("userNameFile"))){
            String line;
            while((line = reader.readLine()) != null){
                if (line != newUserNameField.getText()){
                    BufferedWriter writer = new BufferedWriter(new FileWriter("userNameFile"));
                    writer.write(newUserNameField.getText());
                    writer.newLine();
                    userArrayList.get(newUserIndex).setNameOfUser(newUserNameField.getText());
                    // Go to Main Screen
                    FXMLLoader fxmlLoader = new FXMLLoader(EventManagerApp.class.getResource("Main-Screen.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(fxmlLoader.load(), 800, 450);
                    stage.setScene(scene);
                    stage.show();

                } else {
                    userTakenLabel.setText("Username Already taken...");
                    break;
                }
            }
        } catch (IOException ie){
            System.out.println("error in file");
        }
    }
}
