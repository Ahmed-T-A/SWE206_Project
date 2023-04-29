package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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

public class Tournament_page {
  private Stage stage;
  private Scene scene;
  private Parent root; 
  Tournament tournament;

  @FXML
  private Label teamCapacity;

  @FXML
  private Button editButton;

  @FXML
  private Label header;

  @FXML
  private Button homeButton;

  @FXML
  private Label tournamentEndDate;

  @FXML
  private Label tournamentName;

  @FXML
  private Label tournamentSport;

  @FXML
  private Label tournamentStartDate;

  @FXML
  private Label tournamentStatus;

  @FXML
  private Label tournamentType;

  @FXML
  private TextField tournamentNameField;

  @FXML
  private Button tourProgressButton;


  public void getTournament1(ActionEvent event) throws IOException {
    File file = new File("U:\\Term222\\SWE206\\SWE206_Project\\tournaments.dat");
    readTourFile(file);
  }

  public void readTourFile(File file){
    try{
      FileInputStream fileInput = new FileInputStream(file);
      ObjectInputStream input = new ObjectInputStream(fileInput);
      tournament = (Tournament) input.readObject();
      while(tournament != null){
        if (tournament.getName().equals(tournamentNameField.getText())){
          header.setText(tournament.getName());
          tournamentSport.setText(tournament.getSport());
          tournamentStartDate.setText(tournament.getStartDate());
          tournamentEndDate.setText(tournament.getEndDate());
          tournamentType.setText(tournament.getType()); 
          teamCapacity.setText((Integer.toString(tournament.getTeamCapacity())));
          String status = tournament.getStatus() == true ? "Open" : "Close";
          tournamentStatus.setText(status);
          break;
        }
        ObjectInputStream input2 = new ObjectInputStream(fileInput);
        tournament = (Tournament) input2.readObject();
      }
      input.close();
    }
    catch(IOException em){
      System.out.println(em.getMessage());
    }
    catch (ClassNotFoundException es){
      System.out.println(es.getMessage());
    }
  }

  public void goToHome(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("homePage.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show(); 
  }

  public void showTournamentProgress(ActionEvent event) throws IOException {
    if (tournamentType.getText().equals("Elimination")){
      Parent root = FXMLLoader.load(getClass().getResource("EliminationTournamentPlayPage.fxml"));
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

    FXMLLoader loader = new FXMLLoader(getClass().getResource("tournamentInfoPage.fxml"));
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
