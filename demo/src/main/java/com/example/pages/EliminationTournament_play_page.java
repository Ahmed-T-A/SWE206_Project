package com.example.pages;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class EliminationTournament_play_page extends EliminationTournament_match_page{
    @FXML
    public TextField quarterFinal1;
    @FXML
    public TextField quarterFinal2;
    @FXML
    public TextField quarterFinal3;
    @FXML
    public TextField quarterFinal4;
    @FXML
    public TextField quarterFinal5;
    @FXML
    public TextField quarterFinal6;
    @FXML
    public TextField quarterFinal7;
    @FXML
    public TextField quarterFinal8;
    @FXML
    public TextField SemiFinal1;
    @FXML
    public TextField SemiFinal2;
    @FXML
    public TextField SemiFinal3;
    @FXML
    public TextField SemiFinal4;
    @FXML
    public TextField Final1;
    @FXML
    public TextField Final2;
    @FXML
    public TextField Champion;
    @FXML
    public Button match1;
    @FXML
    public Button match2;
    @FXML
    public Button match3;
    @FXML
    public Button match4;
    @FXML
    public Button match5;
    @FXML
    public Button match6;
    @FXML
    public Button match7;


    public boolean checkIfNameIsWritten(TextField txt) {
        if (txt.getText().isEmpty()) {
            return false;
        } else
            return true;
    }
    public void setMatch1(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/EliminationTournamentMatch_page.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Score Game Betwwen   "+quarterFinal1+"and   "+quarterFinal2);
        primaryStage.initModality(Modality.WINDOW_MODAL);
        primaryStage.show();
    }
    public void setMatch2(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/EliminationTournamentMatch_page.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Score Game Betwwen   "+quarterFinal3+"and   "+quarterFinal4);
        primaryStage.initModality(Modality.WINDOW_MODAL);
        primaryStage.show();
    }
    public void setMatch3(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/EliminationTournamentMatch_page.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Score Game Betwwen   "+quarterFinal5+"and   "+quarterFinal6);
        primaryStage.initModality(Modality.WINDOW_MODAL);
        primaryStage.show();
    }
    public void setMatch4(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/EliminationTournamentMatch_page.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Score Game Betwwen   "+quarterFinal7+"and   "+quarterFinal8);
        primaryStage.initModality(Modality.WINDOW_MODAL);
        primaryStage.show();
    }
    public void setSemiFinal1 (TextField quarterFinal1 , TextField quarterFinal2){
        if(super.CheckTheWinner(quarterFinal1,quarterFinal2).equals("First Participant Win "))
            SemiFinal1 = quarterFinal1;
        else if(super.CheckTheWinner(quarterFinal1,quarterFinal2).equals("Second Participant Win "))
            SemiFinal1 = quarterFinal2;
    }
    public void setSemiFinal2 (TextField quarterFinal3 , TextField quarterFinal4){
        if(super.CheckTheWinner(quarterFinal3,quarterFinal4).equals("First Participant Win "))
            SemiFinal2 = quarterFinal3;
        else if(super.CheckTheWinner(quarterFinal3,quarterFinal4).equals("Second Participant Win "))
            SemiFinal2 = quarterFinal4;
    }
    public void setSemiFinal3 (TextField quarterFinal5 , TextField quarterFinal6){
        if(super.CheckTheWinner(quarterFinal5,quarterFinal6).equals("First Participant Win "))
            SemiFinal3 = quarterFinal5;
        else if(super.CheckTheWinner(quarterFinal5,quarterFinal6).equals("Second Participant Win "))
            SemiFinal3 = quarterFinal6;
    }
    public void setSemiFinal4 (TextField quarterFinal7 , TextField quarterFinal8){
        if(super.CheckTheWinner(quarterFinal7,quarterFinal8).equals("First Participant Win "))
            SemiFinal4 = quarterFinal7;
        else if(super.CheckTheWinner(quarterFinal7,quarterFinal8).equals("Second Participant Win "))
            SemiFinal4 = quarterFinal7;
    }
    public void setMatch5(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EliminationTournamentMatch_page.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Score Game Betwwen   "+SemiFinal1+"and   "+SemiFinal2);
        primaryStage.initModality(Modality.WINDOW_MODAL);
        primaryStage.show();
    }
    public void setMatch6(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EliminationTournamentMatch_page.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Score Game Betwwen   "+SemiFinal3+"and   "+SemiFinal4);
        primaryStage.initModality(Modality.WINDOW_MODAL);
        primaryStage.show();
    }
    public void setFinal1 (TextField semiFinal1 , TextField semiFinal2){
        if(super.CheckTheWinner(semiFinal1,semiFinal2).equals("First Participant Win "))
            Final1 = semiFinal1;
        else if(super.CheckTheWinner(semiFinal1,semiFinal2).equals("Second Participant Win "))
            Final1 = semiFinal2;
    }
    public void setFinal2 (TextField semiFinal3 , TextField semiFinal4){
        if(super.CheckTheWinner(semiFinal3,semiFinal4).equals("First Participant Win "))
            Final2 = semiFinal3;
        else if(super.CheckTheWinner(semiFinal3,semiFinal4).equals("Second Participant Win "))
            Final2 = semiFinal4;
    }
    public void setMatch7(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EliminationTournamentMatch_page.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Score Game Betwwen   " + Final1 + "and   " + Final2);
        primaryStage.initModality(Modality.WINDOW_MODAL);
        primaryStage.show();
    }

    public void setChampion (TextField final1 , TextField final2){
        if(super.CheckTheWinner(final1,final2).equals("First Participant Win "))
            Champion=final1;
        else if(super.CheckTheWinner(final1,final2).equals("Second Participant Win "))
            Champion=final2;
    }

}
