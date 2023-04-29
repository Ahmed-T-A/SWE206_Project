package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EliminationTournament_match_page {
    @FXML
    Label matchResult;
    @FXML
    Label Participant1= new Label("Participant1");
    @FXML
    Label Participant2=new Label("Participant2");
    @FXML
    Label Score;
    @FXML
    TextField Participant1Result;
    @FXML
    TextField Participant2Result;
    @FXML
    Button DoneButton;

    public String checkIfNumbers(TextField txt) {
        try {
            Integer.parseInt(txt.getText());
        } catch (NumberFormatException ex) {
            return "All results must be numbers";
        }
        if (Integer.parseInt(txt.getText()) < 0) {
            return "Score must not be negative";
        }
        return "";
    }

    public String CheckTheWinner(TextField participant1Result , TextField participant2Result){
        int firstParticipantResult = Integer.parseInt(participant1Result.getText());
        int secondParticipantResult = Integer.parseInt(participant2Result.getText());
        if(firstParticipantResult>secondParticipantResult)
            return "First Participant Win ";
        else if (firstParticipantResult<secondParticipantResult)
            return "Second Participant Win ";
        else
            return "There is No Winner";
    }

    public String DoneButton(ActionEvent actionEvent){
        return "Match result saved";
    }

}
