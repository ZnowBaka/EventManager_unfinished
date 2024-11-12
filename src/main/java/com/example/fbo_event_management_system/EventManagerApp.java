package com.example.fbo_event_management_system;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class EventManagerApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(EventManagerApp.class.getResource("Startup-Screen.fxml"));
        Scene startupScene = new Scene(fxmlLoader.load(), 800, 450);
        stage.setTitle("Event Manager");
        stage.setScene(startupScene);
        stage.show();
    }// start End




    public static void main(String[] args) {
        launch();
    }// main end



}// HelloApp End