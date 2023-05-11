package com.example.pages;

import java.io.IOException;

import com.example.Tournament;
import com.example.pages.Tournament_page;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class EliminationTournament_match_page {

    int seats;
    int rounds;
    public Stage stage;
    public Scene scene;
    public Parent root; 
    Tournament tournament;

    @FXML
    public HBox fifthRound;

    @FXML
    public HBox firstRound;

    @FXML
    public HBox fourthRound;

    @FXML
    public HBox lastRound;

    @FXML
    public HBox secondRound;

    @FXML
    public HBox seventhRound;

    @FXML
    public HBox sixthRound;

    @FXML
    public HBox thirdRound;

    @FXML
    public Label tournamentNameLabel;

    @FXML
    public Button backToHome;

    @FXML
    public Button backTourInfo;

    
    public static void addMember(Object obj){
        
    }
    public void setData(Tournament tournament){
        this.tournament = tournament;
        tournamentNameLabel.setText(tournament.getName());
        this.seats = tournament.getEnrollment().getSeats();
        rounds = log2(seats);
        addMatches(rounds);
        firstRound.setAlignment(Pos.CENTER);  
        secondRound.setAlignment(Pos.CENTER); 
        thirdRound.setAlignment(Pos.CENTER); 
        fourthRound.setAlignment(Pos.CENTER);
        fifthRound.setAlignment(Pos.CENTER);
        sixthRound.setAlignment(Pos.CENTER);
        seventhRound.setAlignment(Pos.CENTER);
        lastRound.setAlignment(Pos.CENTER);

        if (seats == 8){
            firstRound.setSpacing(50);
            secondRound.setSpacing(200);
            thirdRound.setSpacing(500);
        }
        else if (seats == 16){
            secondRound.setSpacing(50);
            thirdRound.setSpacing(200);
            fourthRound.setSpacing(500);
        }
        else if (seats == 32){
            thirdRound.setSpacing(50);
            fourthRound.setSpacing(200);
            fifthRound.setSpacing(500);
        }
        else if (seats == 64){
            fourthRound.setSpacing(50);
            fifthRound.setSpacing(200);
            sixthRound.setSpacing(500);
        }

        Button match = new Button("Ahmed talalalla");
        Label winnerString = new Label("Winner") ;
        winnerString.setStyle("-fx-text-fill: #908700;  -fx-font: normal bold 20px 'AGA Arabesque';}");
        switch (rounds + 1) {
            case 1: firstRound.getChildren().add(match); secondRound.getChildren().add(winnerString); break;
            case 2: secondRound.getChildren().add(match); thirdRound.getChildren().add(winnerString); break;
            case 3: thirdRound.getChildren().add(match); fourthRound.getChildren().add(winnerString); break;
            case 4: fourthRound.getChildren().add(match); fifthRound.getChildren().add(winnerString); break;
            case 5: fifthRound.getChildren().add(match); sixthRound.getChildren().add(winnerString); break;
            case 6: sixthRound.getChildren().add(match); seventhRound.getChildren().add(winnerString); break;
            case 7: seventhRound.getChildren().add(match); lastRound.getChildren().add(winnerString); break;
            case 8: lastRound.getChildren().addAll(match, winnerString); break;
            default: break;
        }
        
    }

    public void addMatches(int rounds){
        int round = seats;
        for(int i = 1; i <= rounds; i++){
            for (int z = 0; z < round; z++){
                Button match = new Button("Ahmed talalalla");
                // match.setMaxWidth(Double.MAX_VALUE);
                match.setWrapText(true);
                switch (i) {
                    case 1:  this.firstRound.getChildren().add(match); break;
                    case 2:  this.secondRound.getChildren().add(match); break;
                    case 3:  this.thirdRound.getChildren().add(match); break;
                    case 4:  this.fourthRound.getChildren().add(match); break;
                    case 5:  this.fifthRound.getChildren().add(match); break;
                    case 6:  this.sixthRound.getChildren().add(match); break;
                    case 7:  this.seventhRound.getChildren().add(match); break;
                    case 8:  this.lastRound.getChildren().add(match); break;
                    default: break;
                }
            }
            round = round / 2;
        }
    }

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

    public static int log2(int N)
    {
        int result = (int)(Math.log(N) / Math.log(2));
        return result;
    }

    @FXML
    public void goToHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/homePage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void goToTourInfo (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/tournamentPage.fxml"));
        root = loader.load();
        Tournament_page controller = loader.getController();
        controller.setData(tournament);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
