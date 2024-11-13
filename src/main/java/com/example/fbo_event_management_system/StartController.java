package com.example.fbo_event_management_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class StartController {
    public int newUserIndex = -1;
    public static ArrayList<User> userArrayList = new ArrayList<>();
    private Stage stage;
    private Scene scene;
    User user1 = new User("Snorre", "123");

    //region Labels and texts

    @FXML
    private Label loginLabel;

    @FXML
    private TextField userNameField;

    @FXML
    private TextField userPassField;


    //endregion

    @FXML
    private int findUserInDB(String userName) {
        for (int index = 0; index < userArrayList.size(); index++) {
            if (userArrayList.get(index).getNameOfUser().equals(userName)) {
                return index;
            }
        }
        return -1;
    }

    @FXML
    private boolean findUserPassInDB(int index, String userPass) {
        if (userArrayList.get(index).getUserLoginCode().equals(userPass)) {
            return true;
        }
        return false;
    }

    @FXML
    protected void onLoginButtonClick(ActionEvent event) throws IOException {
        String userName = userNameField.getCharacters().toString();
        String userPass = userPassField.getCharacters().toString();

        int DBIndex = findUserInDB(userName);
        if (DBIndex != -1) {
            boolean loginStatus = findUserPassInDB(DBIndex, userPass);
            if (loginStatus) {
                FXMLLoader fxmlLoader = new FXMLLoader(EventManagerApp.class.getResource("Main-Screen.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(fxmlLoader.load(), 800, 450);
                stage.setTitle("Main Screen");
                stage.setScene(scene);
                stage.show();
            }
            // Go to Main Screen
        } else {
            loginLabel.setText("Data mismatch: \nIncorrect username or password");
        }
    }

    @FXML
    public void onToMainScreenButtonClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(EventManagerApp.class.getResource("Main-Screen.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 800, 450);
        stage.setTitle("Main Screen");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onNewUserButtonClick(ActionEvent e) throws IOException {
        String userName = userNameField.getCharacters().toString();
        String userPass = userPassField.getCharacters().toString();

        int DBIndex = findUserInDB(userName);
        if (DBIndex == -1) {
            new StandardUser(userName, userPass);
            newUserIndex = findUserInDB(userName);
            // take newUserIndex along
            // Go to Create new user screen
            FXMLLoader fxmlLoader = new FXMLLoader(EventManagerApp.class.getResource("NewUser-Screen.fxml"));
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            Scene scene = new Scene(fxmlLoader.load(), 800, 450);
            stage.setScene(scene);
            stage.show();
        } else {
            loginLabel.setText("A user with that username already exists");
        }
    }
}


