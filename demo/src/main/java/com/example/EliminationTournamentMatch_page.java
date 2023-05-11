package com.example;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class EliminationTournamentMatch_page  extends EliminationTournament_play_page{
    @FXML
    Button Return;
    @FXML
    Label matchResult ;
    @FXML

    Label Participant1;
    @FXML

    Label Participant2;
    @FXML
    Label Score;
    @FXML
    Button DoneButton;
    @FXML
    TextField Participant1Result;
    @FXML
    TextField Participant2Result;

    Stage stage;
    Scene scene;

    public void setReturn(ActionEvent actionEvent)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EliminationTournamentPlayPage.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("EliminationTournamentPlayPage");
        stage.setScene(scene);
        stage.show();
    }
    public  void Done(ActionEvent actionEvent){
        int Participant1Goals=Integer.parseInt(Participant1Result.getText());
        int Participant2Goals=Integer.parseInt(Participant2Result.getText());

        if(Participant1Goals>Participant2Goals)
            this.SemiFinal1.setText(QuarterFinal1.getText());
    }

}
