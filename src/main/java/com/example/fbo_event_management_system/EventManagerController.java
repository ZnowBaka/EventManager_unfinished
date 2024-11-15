package com.example.fbo_event_management_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public  class EventManagerController {
    Main appAction = new Main();
    public static List<User> users = new ArrayList<>();
    public static List<Event> events = new ArrayList<>();

    //region EventManager controls to manipulate Users
    public void addUser(String username, String loginName, boolean isAdmin) {
        users.add(new User(username, loginName, isAdmin));
        System.out.println("User registered: " + username);
    }

    public void listUsers() {
        System.out.println("Users:");
        for (User user : users) {
            System.out.println(user);
        }
    }

    public void removeUser(String username) {
        users.removeIf(user -> {
            String nameOfUser = user.getNameOfUser().toString();
            return (nameOfUser != null && nameOfUser.equals(username));
        });
        System.out.println("User removed: " + username);
    }
    //endregion

    //region EventManager controls to manipulate Events
    public void createEvent(Event event) {
        events.add(event);
        System.out.println("Event created: " + event.getTitle());
    }

    public void removeEvent(String title) {
        events.removeIf(event -> event.getTitle().equals(title));
        System.out.println("Event removed: " + title);
    }

    public void listEvents() {
        System.out.println("Events:");
        for (Event event : events) {
            System.out.println(event.getDetails());
        }
    }
    //endregion



    // EventManager action that is only available to admins.
    public void generateReports(String username) {
        User user = null;
        for (User u : users) {
            if (username.equals(u.getNameOfUser().toString())) {
                user = u;
                break;
            }
        }

        if (user != null && user.getAdminPrivilege()) {
            System.out.println("AdminReport:");
            System.out.println("Total users: " + users.size());
            System.out.println("Total events: " + events.size());
        } else {
            System.out.println("Access denied. Only admin users can generate reports.");
        }
    }


    //region TextFields and Labels
    @FXML
    private Label userProfileName;

    @FXML
    private Label userProfileAdminStatus;

    @FXML
    private Label userProfileManagerStatus;


    //endregion

    @FXML
    public void onToProfileScreenButtonClick(ActionEvent event) throws IOException {
        appAction.changeScene("Profile-Screen.fxml");
    }

    @FXML
    public void onShowEventsButtonClick(ActionEvent event) throws IOException {
        appAction.changeScene("Events-Screen.fxml");
    }

    @FXML
    public void onSelectEventButtonClick() {

    }

    //test area
}