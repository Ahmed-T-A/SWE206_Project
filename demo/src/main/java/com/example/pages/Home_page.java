package com.example.pages;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import com.example.Tournament;
import com.example.Tournaments;

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

  public Stage stage;
  public Scene scene;
  public Parent root; 
  String savedTournamentPath = "U:\\Term222\\SWE206\\SWE206_Project\\";

  
  @FXML
  public VBox archevedTournaments;

  @FXML
  public VBox tournamentsInProgress;

  @FXML
  public VBox availableTournaments;

  @FXML
  public Button loadTournamentButton;

  @FXML
  public ScrollPane scrollPane;

  @FXML
  public Button addingTournamentButton;

  @FXML
  public Button logoutButton;

  @FXML
  public Button tourButton;  

  @FXML
  public Button showStudentProfileButton;

  //------------------
  @FXML
  public void logoutButton(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/com/example/login.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show(); 
  }
  @FXML
  public void initialize(){
    File file = new File(savedTournamentPath + "tournaments.dat");
    readTourFile(file);
  }

  public void readTourFile(File file) {
    try (FileInputStream fileInput = new FileInputStream(file);
      ObjectInputStream input = new ObjectInputStream(fileInput)) {
      Tournaments tournaments = (Tournaments) input.readObject();
      if (tournaments == null) {
        return;
      }
      ArrayList<Tournament> available = tournaments.getAvailableTournaments();
      ArrayList<Tournament> inProgress = tournaments.getInProgressTournaments();
      ArrayList<Tournament> previous = tournaments.getPreviousTournaments();
      for(int i = 0; i < inProgress.size(); i++){
        Button button = addToHbox(inProgress.get(i).getName(), inProgress.get(i).getSport(), 
        inProgress.get(i).isTeamBased(), inProgress.get(i).getEnrollment().getAvailableSeats());
        Tournament tournament = inProgress.get(i);
        button.setOnAction(e -> {
          try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/tournamentPage.fxml"));
            root = loader.load();
            Tournament_page controller = loader.getController();
            controller.setData(tournament);

            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
          } catch (IOException em) {
            System.out.println(em.getMessage());
          }
        });
        button.setStyle("-fx-text-fill: #181818; -fx-font: normal bold 10px 'AGA Arabesque'; -fx-background-color: #99cf91; -fx-text-alignment: center;}");
        tournamentsInProgress.setMargin(button, new Insets(20, 10, 10, 10));
        tournamentsInProgress.getChildren().add(button);
      }
      for(int i = 0; i < available.size(); i++){
        Button button = addToHbox(available.get(i).getName(), available.get(i).getSport(), 
        available.get(i).isTeamBased(), available.get(i).getEnrollment().getAvailableSeats());
        Tournament tournament = available.get(i);
        button.setOnAction(e -> {
          try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/tournamentPage.fxml"));
            root = loader.load();
            Tournament_page controller = loader.getController();
            controller.setData(tournament);

            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
          } 
          catch (IOException em) {
            System.out.println(em.getMessage());
          }
        });
        availableTournaments.setMargin(button, new Insets(20, 10, 10, 10));
        availableTournaments.getChildren().add(button);
      }
      for(int i = 0; i < previous.size(); i++){
        Button button = addToHbox(previous.get(i).getName(), previous.get(i).getSport(), 
        previous.get(i).isTeamBased(), previous.get(i).getEnrollment().getAvailableSeats());
        Tournament tournament = previous.get(i);
        button.setOnAction(e -> {
          try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/tournamentPage.fxml"));
            root = loader.load();
            Tournament_page controller = loader.getController();
            controller.setData(tournament);

            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
          } 
          catch (IOException em) {
            System.out.println(em.getMessage());
          }
        });
        button.setStyle("-fx-text-fill: #181818; -fx-font: normal bold 10px 'AGA Arabesque'; -fx-background-color: #d0909c; -fx-text-alignment: center;}");
        archevedTournaments.setMargin(button, new Insets(20, 10, 10, 10));
        archevedTournaments.getChildren().add(button);
      }
    }
    catch (IOException em) {
        System.out.println(em);
    }
    catch (ClassNotFoundException ex) {
      System.out.println(ex);
  }
}


  @FXML
  public void readTournamentsFile(ActionEvent event) throws IOException{
    File file = new File(savedTournamentPath + "tournaments.dat");
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

  @FXML
  public void addingTournamentButton(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/com/example/tournamentInfoPage.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show(); 
  }

  @FXML
  public void showStudentProfileButton(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/com/example/showStudentProfilePage.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show(); 
  }
}
