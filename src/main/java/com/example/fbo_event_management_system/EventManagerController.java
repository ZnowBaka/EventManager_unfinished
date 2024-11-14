package com.example.fbo_event_management_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


public class EventManagerController {
    EventManagerApp appAction = new EventManagerApp();

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
        appAction.changeScene("Profile-Screen.fxml");
    }

    @FXML
    public void onShowEventsButtonClick(ActionEvent event) throws IOException {
        appAction.changeScene("Events-Screen.fxml");
    }

    @FXML
    public void onSelectEventButtonClick(){

    }

    //endregion


}// Controller End


