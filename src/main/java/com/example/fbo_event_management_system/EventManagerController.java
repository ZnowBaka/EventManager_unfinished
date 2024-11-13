package com.example.fbo_event_management_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import static com.example.fbo_event_management_system.StartController.userArrayList;


public class EventManagerController {

    public ArrayList<Event> eventArrayList = new ArrayList<>();
    private Stage stage;
    private Scene scene;


    //region TextFields and Labels
    @FXML
    private Label userProfileName;

    @FXML
    private Label userProfileAdminStatus;

    @FXML
    private Label userProfileManagerStatus;


    //endregion

    //region Methods that are called via other Methods

    @FXML
    public void onToProfileScreenButtonClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(EventManagerApp.class.getResource("File.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 800, 450);
        stage.setTitle("Profile Screen");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onShowEventsButtonClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(EventManagerApp.class.getResource("File.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 800, 450);
        stage.setTitle("Events Screen");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onSelectEventButtonClick(){

    }


    //endregion


}// Controller End


