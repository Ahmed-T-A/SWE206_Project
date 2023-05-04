package com.example.pages;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import com.example.Student;
import com.example.Tournament;
import com.example.Tournaments;

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

  public Stage stage;
  public Scene scene;
  public Parent root;
  public Student student;
  // public Tournament tournament;

  @FXML
  public HBox availableTour; 

  @FXML
  public VBox inProgressTour;

  @FXML
  public Button logoutButton;

  @FXML
  public Button profileButton;

  @FXML
  public Button makeRequestButton;

  @FXML
  public TextField nameOfTournamentField;

  @FXML
  public Label studentNameLabel;

  public void setData2(String name){
    studentNameLabel.setText(name);
  }

  public void setData(Student student, String name)
  {
    studentNameLabel.setText(name);
    this.student = student;
  }

  @FXML
  public void logout(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/com/example/login.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show(); 
  }

  @FXML
  public void initialize(){
    File file = new File("U:\\Term222\\SWE206\\SWE206_Project\\tournaments.dat");
    readTourFile(file);
  }

  public void readTourFile(File file) {
    try (FileInputStream fileInput = new FileInputStream(file);
         ObjectInputStream input = new ObjectInputStream(fileInput)) {

        while (true) {
            try {
                Tournaments tournaments = (Tournaments) input.readObject();
                if (tournaments == null) {
                    break; // exit the loop if end of file is reached
                }
                ArrayList<Tournament> available = tournaments.getAvailableTournaments();
                ArrayList<Tournament> inProgress = tournaments.getInProgressTournaments();
                ArrayList<Tournament> previous = tournaments.getPreviousTournaments();
                for(int i = 0; i < inProgress.size(); i++){
                  Button button = addToHbox(inProgress.get(i).getName(), inProgress.get(i).getSport(), 
                  inProgress.get(i).isTeamBased(), inProgress.get(i).getEnrollment().getAvailableSeats());
                  // Tournament tournament = inProgress.get(i);
                  // button.setOnAction(e -> {
                  //       try {
                  //           FXMLLoader loader = new FXMLLoader(getClass().getResource("tournamentPage.fxml"));
                  //           root = loader.load();
                  //           Tournament_page controller = loader.getController();
                  //           controller.setData(tournament);

                  //           // Parent root = FXMLLoader.load(getClass().getResource("tournamentPage.fxml"));
                  //           stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                  //           scene = new Scene(root);
                  //           stage.setScene(scene);
                  //           stage.show();
                  //       } catch (IOException em) {
                  //           System.out.println(em.getMessage());
                  //       }
                  // });
                  button.setStyle("-fx-text-fill: #181818; -fx-font: normal bold 10px 'AGA Arabesque'; -fx-background-color: #99cf91; -fx-text-alignment: center;}");
                  button.setMinWidth(240);
                  inProgressTour.setMargin(button, new Insets(20, 10, 10, 10));
                  inProgressTour.getChildren().add(button);
                }
                for(int i = 0; i < available.size(); i++){
                  Button button = addToHbox(available.get(i).getName(), available.get(i).getSport(), 
                  available.get(i).isTeamBased(), available.get(i).getEnrollment().getAvailableSeats());
                  Tournament tournament = available.get(i);
                  button.setOnAction(e -> {
                    nameOfTournamentField.setText(tournament.getName());
                  });
                  availableTour.setMargin(button, new Insets(20, 10, 10, 10));
                  availableTour.getChildren().add(button);
                }
            } catch (EOFException eof) {
                break; // exit the loop if end of file is reached
            } catch (ClassNotFoundException ex) {
                System.out.println(ex);
            }
        }
    } catch (IOException em) {
        System.out.println(em);
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
    Tournament tournament = readSpecificTournament(file, nameOfTournamentField.getText());
    tournament.makeRequest(student);
    tournament.saveTour(file);
  }

  public Tournament readSpecificTournament(File file, String tournamentName){
    Tournament tournament = null;
    try{
      FileInputStream fileInput = new FileInputStream(file);
      ObjectInputStream input = new ObjectInputStream(fileInput);
      Tournaments tournaments = (Tournaments) input.readObject();
      ArrayList<Tournament> available = tournaments.getAvailableTournaments();

      for (int i = 0; i < available.size(); i++){
        if (tournamentName.equals(available.get(i).getName())){
          return tournament = available.get(i);
        }
      }

      input.close();
    }
    catch(IOException em){
      System.out.println(em.getMessage());
    }
    catch (ClassNotFoundException es){
      System.out.println(es.getMessage());
    }
    return tournament;
  }
}
