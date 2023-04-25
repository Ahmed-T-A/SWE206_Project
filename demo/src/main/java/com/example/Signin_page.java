package com.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Signin_page {

    @FXML
    private Label ID;

    @FXML
    private TextField IdField;

    @FXML
    private Label name;

    @FXML
    private TextField nameField;

    @FXML
    private Label password;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button registerButton;

    @FXML
    private Button signinButton;

    @FXML
    private Label username;

    @FXML
    private TextField usernameField;

    @FXML
    void register() {

    }

    @FXML
    private void switchToLogin() throws IOException {
        App.setRoot("login");
    }

    @FXML
    private void registerAndMoveToLoginPage() throws IOException {
        App.setRoot("login");
    }
}