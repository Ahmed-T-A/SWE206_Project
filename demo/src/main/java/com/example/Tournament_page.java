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
import javafx.stage.Stage;

public class Tournament_page {

  Tournament tournament = new Tournament("ah", "d", "g", "df", "g", true, true, false, 4, new Enrollment(0, 0), new TournamentProgress());

  // Home_page home_page = new Home_page();

  private Stage stage;
  private Scene scene;
  private Parent root; 

  @FXML
  private Label teamCapacity;

  @FXML
  private Button homeButton;

  @FXML
  private Label tournamentEndDate;

  @FXML
  private Label tournamentName;

  @FXML
  private Label tournamentProgress;

  @FXML
  private Label tournamentSport;

  @FXML
  private Label tournamentStartDate;

  @FXML
  private Label tournamentStatus;

  @FXML
  private Label tournamentType;

  public Tournament_page(){
    // tournament = home_page.getTournament();
    
  }

  public void setTournamen(Tournament a){
    tournament = a;
  }

  public void x (ActionEvent event) throws IOException {
    tournamentName.setText(tournament.getName());
    tournamentSport.setText(tournament.getSport());
    tournamentStartDate.setText(tournament.getStartDate());
    tournamentEndDate.setText(tournament.getEndDate());
    // tournamentType.setText(tournament.getType()); 
    tournamentType.setText("Elimination");
    teamCapacity.setText((Integer.toString(tournament.getTeamCapacity())));
    tournamentStatus.setText(Boolean.toString(tournament.getStatus()));
    tournamentProgress.setText("50%");
  }

  // public void getTournament1(ActionEvent event) throws IOException {
  //   File file = new File("U:\\Term222\\SWE206\\SWE206_Project\\tournaments.dat");
  //   readTourFile(file);
  // }
  // public void readTourFile(File file){
  //   try{
  //     FileInputStream fileInput = new FileInputStream(file);
  //     ObjectInputStream input = new ObjectInputStream(fileInput);
  //     Tournament tournament = (Tournament) input.readObject();
  //     tournamentName.setText(tournament.getName());
  //     tournamentSport.setText(tournament.getSport());
  //     tournamentStartDate.setText(tournament.getStartDate());
  //     tournamentEndDate.setText(tournament.getEndDate());
  //     // tournamentType.setText(tournament.getType()); 
  //     tournamentType.setText("Elimination");
  //     teamCapacity.setText((Integer.toString(tournament.getTeamCapacity())));
  //     tournamentStatus.setText(Boolean.toString(tournament.getStatus()));
  //     tournamentProgress.setText("50%");
  //     input.close();
  //   }
  //   catch(IOException em){
  //     System.out.println(em.getMessage());
  //   }
  //   catch (ClassNotFoundException es){
  //     System.out.println(es.getMessage());
  //   }
  // }

  public void goToHome(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("homePage.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show(); 
  }

}
