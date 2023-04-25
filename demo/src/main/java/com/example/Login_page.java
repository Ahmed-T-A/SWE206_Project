package com.example;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Login_page {
    @FXML
    private Button loginButton;

    @FXML
    private Label password;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signinButton;

    @FXML
    private Label username;

    @FXML
    private TextField usernameField;
    
    @FXML
    void goToSignInPage() throws IOException {
        App.setRoot("signin");
    }

    @FXML
    void loginUser() throws IOException {
        // if (usernameField.getText().equals("abdulmajed") && passwordField.getText().equals("12345"))
            App.setRoot("homePage");
    }
}
