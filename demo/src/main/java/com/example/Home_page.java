package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Home_page extends AnchorPane{

  private Stage stage;
  private Scene scene;
  private Parent root; 
  private Tournament tournament = new Tournament("ah", "d", "g", "df", "g", true, true, false, 4, new Enrollment(0, 0), new TournamentProgress());
  String savedTournamentPath = "U:\\Term222\\SWE206\\SWE206_Project\\";

  
  @FXML
  private VBox archevedTournaments;

  @FXML
  private VBox tournamentsInProgress;

  @FXML
  private VBox availableTournaments;

  @FXML
  private Button loadTournamentButton;

  @FXML
  private ScrollPane scrollPane;

  @FXML
  private Button addingTournamentButton;

  @FXML
  private MenuItem logoutButton;

  @FXML
  private Menu menu_logout;

  @FXML
  private Menu menu_profile;

  @FXML
  private Button tourButton;  

  @FXML
  private Button showStudentProfileButton;

  //------------------

  @FXML
  void goToProfile() {

  }

  @FXML
  private void logoutButton(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show(); 
  }

  public void readTourFile(File file){
    try{
      FileInputStream fileInput = new FileInputStream(file);
      ObjectInputStream input = new ObjectInputStream(fileInput);
      tournament = (Tournament) input.readObject();
      while(tournament != null){
        Button button = addToHbox(tournament.getName(), tournament.getSport(), tournament.isTeamBased(), tournament.getEnrollment().getAvailableSeats());
        button.setOnAction( e -> {
          try{
            Parent root = FXMLLoader.load(getClass().getResource("tournamentPage.fxml"));
            stage = (Stage)((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show(); 
          }
          catch(IOException em){
            System.out.println(em.getMessage());
          }
        });
        if (tournament.getStatus() == true){
          availableTournaments.setMargin(button, new Insets(20, 10, 10, 10));
          availableTournaments.getChildren().add(button);
        }
        else if (tournament.getStatus() == false && tournament.isArchived() == true){
          button.setStyle("-fx-text-fill: #181818;  -fx-font: normal bold 10px 'AGA Arabesque'; -fx-background-color:  #d0909c; -fx-text-alignment: center;}");  
          archevedTournaments.setMargin(button, new Insets(20, 10, 10, 10));
          archevedTournaments.getChildren().add(button);
        }
        else{
          button.setStyle("-fx-text-fill: #181818;  -fx-font: normal bold 10px 'AGA Arabesque'; -fx-background-color:  #99cf91; -fx-text-alignment: center;}");  
          tournamentsInProgress.setMargin(button, new Insets(20, 10, 10, 10));
          tournamentsInProgress.getChildren().add(button);
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

  @FXML
  public void readTournamentsFile(ActionEvent event) throws IOException{
    File file = new File("U:\\Term222\\SWE206\\SWE206_Project\\tournaments.dat");
    readTourFile(file);
  }

  public Button addToHbox(String name, String sport, boolean teamBased, int availableSeats){
    String teamBased2 = teamBased == true ? "team based" : "indevidual based"; 
    String title = name + "\n" + sport + "\n" + teamBased2 + "\n available seats: \n" + availableSeats;
    Button n = new Button(title);
    n.setStyle("-fx-text-fill: #181818;  -fx-font: normal bold 10px 'AGA Arabesque'; -fx-background-color:  #c1beff; -fx-text-alignment: center;}");  
    n.setPrefHeight(72); 
    n.setPrefWidth(110); 
    return n;
  }

  public void addToHBox(Button a, VBox b){
    b.setMargin(a, new Insets(10, 10, 10, 10));   
    b.setAlignment(Pos.CENTER); 
    b.getChildren().add(a);
  }

  public Tournament getTournament(){
    return tournament;
  }

  @FXML
  private void addingTournamentButton(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("tournamentInfoPage.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show(); 
  }

  @FXML
  private void showStudentProfileButton(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("showStudentProfilePage.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show(); 
  }

  public void saveToutnament(String fileName, Tournament tournament){
    try{
      FileOutputStream theBinaryFile = new FileOutputStream(savedTournamentPath + fileName + ".dat", true);
      ObjectOutputStream output = new ObjectOutputStream(theBinaryFile);
      output.writeObject(tournament);
      output.close();
    }
    catch(IOException e){
      System.out.println(e.getMessage());
    }
  }
}
