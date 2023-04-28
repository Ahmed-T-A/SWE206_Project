package com.example;

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
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    private Button startTournament;
    @FXML
    private Button addParticipant;
    @FXML

    private TextField participant1;
    @FXML
    private TextField participant2;
    @FXML
    private TextField participant3;
    @FXML
    private TextField participant4;
    @FXML
    private TextField participant5;
    @FXML
    private TextField participant6;
    @FXML
    private TextField participant7;
    @FXML
    private TextField participant8;

    public void startTournamentButton(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EliminationTournament.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void addParticipant(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EliminationTournament.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
