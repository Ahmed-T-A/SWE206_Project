package com.example.pages;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class EliminationTournament_page
{
    @FXML
    public Stage stage;
    @FXML
    public Scene scene;
    @FXML
    public Parent root;

    String name;
    String ID;
    String username;
    String password;
    String email;

    @FXML
    public Button addParticipantButton;

    @FXML
    public TextField addParticipantFeild;

    @FXML
    public Button homeButton;

    @FXML
    public TextField participant1;

    @FXML
    public TextField participant2;

    @FXML
    public TextField participant3;

    @FXML
    public TextField participant4;

    @FXML
    public TextField participant5;

    @FXML
    public TextField participant6;

    @FXML
    public TextField participant7;

    @FXML
    public TextField participant8;

    public void setProb(String name, String ID, String username, String password, String email){
        participant1.setText(name);
        participant2.setText(ID);
        participant3.setText(username);
        participant4.setText(password);
        participant5.setText(email);
    }

    public void startTournamentButton(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/EliminationTournament.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void addParticipant(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/EliminationTournament.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
