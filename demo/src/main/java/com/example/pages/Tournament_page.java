package com.example.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import com.example.Student;
import com.example.Tournament;

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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Tournament_page {
  public Stage stage;
  public Scene scene;
  public Parent root; 
  Tournament tournament;

  @FXML
  public Label teamCapacity;

  @FXML
  public Button editButton;

  @FXML
  public Label header;

  @FXML
  public Button homeButton;

  @FXML
  public Label tournamentEndDate;

  @FXML
  public Label tournamentName;

  @FXML
  public Label tournamentSport;

  @FXML
  public Label tournamentStartDate;

  @FXML
  public Label tournamentStatus;

  @FXML
  public Label tournamentType;

  @FXML
  public Button tourProgressButton;

  @FXML
  public VBox requestsVBox;


  public void setData(Tournament tournament){
    this.tournament = tournament;
    header.setText(tournament.getName());
    tournamentSport.setText(tournament.getSport());
    tournamentStartDate.setText(tournament.getStartDate());
    tournamentEndDate.setText(tournament.getEndDate());
    tournamentType.setText(tournament.getType()); 
    teamCapacity.setText((Integer.toString(tournament.getTeamCapacity())));
    String status = tournament.getStatus() == true ? "Open" : "Close";
    tournamentStatus.setText(status);

    Label request = new Label();
    ArrayList<Object> n = tournament.getEnrollment().getRequests();
    requestsVBox.setAlignment(Pos.CENTER_LEFT);
    for (int i = 0; i < n.size(); i++){
      HBox labelAndButton = new HBox();
      labelAndButton.setAlignment(Pos.CENTER_RIGHT);
      Button accept = new Button("Accept");
      accept.setStyle("-fx-text-fill: #ffffff; -fx-font: normal bold 11px 'AGA Arabesque'; -fx-background-color: #106b5c; -fx-text-alignment: center;}");
      Student student = (Student) n.get(i);
      Label requestLabel = new Label(student.getName());
      labelAndButton.getChildren().addAll(requestLabel, accept);
      labelAndButton.setMargin(requestLabel, new Insets(5, 5, 5, 10));
      requestsVBox.getChildren().add(labelAndButton);
      requestLabel.setStyle("-fx-text-fill:  #2f5b2a; -fx-font: normal bold 17px 'Franklin Gothic Heavy';");
      requestsVBox.setMargin(requestLabel, new Insets(0, 10, 0, 10));   
      accept.setOnAction(e ->{
        tournament.acceptRequest(student);
        requestsVBox.getChildren().remove(labelAndButton);
      });
    }
  }


  public void goToHome(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/com/example/homePage.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show(); 
  }

  public void showTournamentProgress(ActionEvent event) throws IOException {
    if (tournamentType.getText().equals("Elimination")){
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/EliminationTournamentPlayPage.fxml"));
      root = loader.load();
      EliminationTournament_match_page controller = loader.getController();
      controller.setData(tournament);

      stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      scene = new Scene(root);
      stage.setScene(scene);
      stage.show(); 
    }
    else{
      // Parent root = FXMLLoader.load(getClass().getResource("RoundRobinTournamentPlayPage.fxml"));
      // stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      // scene = new Scene(root);
      // stage.setScene(scene);
      // stage.show(); 
    }
  }

  public void edit(ActionEvent event) throws IOException {

    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/tournamentInfoPage.fxml"));
    root = loader.load();
    TournamentInfo_page controller = loader.getController();
    controller.setData(tournament.getName(), tournament.getSport(), tournament.getEnrollment().getAvailableSeats(), tournament.getStartDate(),
    tournament.getEndDate(),tournament.getTeamCapacity(), tournament.getType(), tournament.isTeamBased(), tournament.getStatus(), tournament.isArchived());

    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show(); 
  }
}
