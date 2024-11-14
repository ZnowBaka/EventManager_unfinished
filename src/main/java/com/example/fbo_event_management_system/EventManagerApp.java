package com.example.fbo_event_management_system;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

import static com.example.fbo_event_management_system.NewUserController.existingUsernames;
import static com.example.fbo_event_management_system.StartController.userArrayList;


public class EventManagerApp extends Application {

    private static Stage stage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        primaryStage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("Startup-Screen.fxml"));
        primaryStage.setTitle("Event Manager");
        primaryStage.setScene(new Scene(root,800,450));
        primaryStage.show();
    }// start End


    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stage.getScene().setRoot(pane);
    }


    public static void main(String[] args) {
        /*try {
            File file1 = new File("userNameFile.txt");
            File file2 = new File("loginName.txt");
            File file3 = new File("loginCode.txt");
            if(file1.createNewFile()&&file2.createNewFile()&&file3.createNewFile()){
                System.out.println("Files created");
            }else {
                System.out.println("Files not created");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/
        /*for (int i = 0; i < userArrayList.size(); i++) {
            userArrayList.remove(i);
        }
        for (int i = 0; i < existingUsernames.size(); i++) {
            existingUsernames.remove(i);
        }*/
        /*User adminUser1 = new AdminUser("admin1", "Admin","123", true, true);
        userArrayList.add(adminUser1);
        for (int i = 0; i < userArrayList.size(); i++) {
            System.out.println(userArrayList.get(i));
        }*/
        launch();
    }// main end
}// HelloApp End*/