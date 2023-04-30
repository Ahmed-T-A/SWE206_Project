package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StudentHome_page {

  private Stage stage;
  private Scene scene;
  private Parent root;
  private Student student;
  private Tournament tournament;

  @FXML
  private HBox availableTour; 

  @FXML
  private VBox inProgressTour;

  @FXML
  private Button logoutButton;

  @FXML
  private Button profileButton;

  @FXML
    private Button makeRequestButton;

  @FXML
  private TextField nameOfTournamentField;

  @FXML
  private Label studentNameLabel;

  public void setData(Student student, String name)
  {
    studentNameLabel.setText(name);
    this.student = student;
  }

  @FXML
  void logout(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show(); 
  }

  @FXML
  public void initialize(){
    File file = new File("U:\\Term222\\SWE206\\SWE206_Project\\tournaments.dat");
    readFile(file);
  }

  public void readFile(File file){
    try{
      FileInputStream fileInput = new FileInputStream(file);
      ObjectInputStream input = new ObjectInputStream(fileInput);
      Tournament tournament = (Tournament) input.readObject();
      while(tournament != null){
        Button button = addToHbox(tournament.getName(), tournament.getSport(), tournament.isTeamBased(), tournament.getEnrollment().getAvailableSeats());
        Button button2 = addToHbox(tournament.getName(), tournament.getSport(), tournament.isTeamBased(), tournament.getEnrollment().getAvailableSeats());
        button2.setMinWidth(223);
        button2.setStyle("-fx-text-fill: #181818;  -fx-font: normal bold 12px 'AGA Arabesque'; -fx-background-color:  #7de2f6; -fx-text-alignment: center;}");  
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
          availableTour.setMargin(button, new Insets(10, 10, 10, 10));
          availableTour.getChildren().add(button);
          inProgressTour.setMargin(button2, new Insets(10, 10, 10, 10));
          inProgressTour.getChildren().add(button2);
        }
        ObjectInputStream input2 = new ObjectInputStream(fileInput);
        tournament = (Tournament) input2.readObject();
      }
    }
    catch(IOException em){
      System.out.println(em.getMessage());
    }
    catch (ClassNotFoundException es){
      System.out.println(es.getMessage());
    }
  }

  public Button addToHbox(String name, String sport, boolean teamBased, int availableSeats){
    String teamBased2 = teamBased == true ? "team based" : "indevidual based"; 
    String title = name + "\n" + sport + "\n" + teamBased2 + "\n available seats: " + availableSeats;
    Button n = new Button(title);
    n.setStyle("-fx-text-fill: #181818;  -fx-font: normal bold 10px 'AGA Arabesque'; -fx-background-color:  #c1beff; -fx-text-alignment: center;}");  
    n.setPrefHeight(72); 
    n.setPrefWidth(110); 
    return n;
  }

  @FXML
  public void showStudentProfile(ActionEvent event) throws IOException {
    
  }

  @FXML
  public void makeRequest(ActionEvent event) throws IOException {
    File file = new File("U:\\Term222\\SWE206\\SWE206_Project\\tournaments.dat");
    readSpecificTournament(file, nameOfTournamentField.getText());
    tournament.makeRequest(student);
    tournament.saveToFile("tournaments");
  }

  public void readSpecificTournament(File file, String tournamentName){
    try{
      FileInputStream fileInput = new FileInputStream(file);
      ObjectInputStream input = new ObjectInputStream(fileInput);
      Tournament tournament = (Tournament) input.readObject();
      while(tournament != null){
        if (tournament.getName().equals(tournamentName)){
          this.tournament = tournament;
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
}
