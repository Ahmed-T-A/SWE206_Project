package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
import javafx.scene.layout.VBox;
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

  @FXML
  private VBox requestsVBox;

  @FXML
  private Label wrongMessage;

  @FXML
  private Label label;


  @FXML
  public void getTournament1(ActionEvent event) throws IOException {
    File file = new File("U:\\Term222\\SWE206\\SWE206_Project\\tournaments.dat");
    readTourFile(file);
    if (!label.getText().equals(" ")){
      wrongMessage.setText("There is no tournament with this name");
      label.setText(" ");
      header.setText("");
      tournamentSport.setText("");
      tournamentStartDate.setText("");
      tournamentEndDate.setText("");
      tournamentType.setText(""); 
      teamCapacity.setText("");
      tournamentStatus.setText("");
      requestsVBox.getChildren().removeAll();
    }
  }

  public void readTourFile(File file){
    try{
      FileInputStream fileInput = new FileInputStream(file);
      ObjectInputStream input = new ObjectInputStream(fileInput);
      tournament = (Tournament) input.readObject();
      label.setText("");
      requestsVBox.getChildren().removeAll();
      while(tournament != null){
        if (tournament.getName().equals(tournamentNameField.getText())){
          label.setText(" ");
          wrongMessage.setText("");
          header.setText(tournament.getName());
          tournamentSport.setText(tournament.getSport());
          tournamentStartDate.setText(tournament.getStartDate());
          tournamentEndDate.setText(tournament.getEndDate());
          tournamentType.setText(tournament.getType()); 
          teamCapacity.setText((Integer.toString(tournament.getTeamCapacity())));
          String status = tournament.getStatus() == true ? "Open" : "Close";
          tournamentStatus.setText(status);

          Label request = new Label();
          String n = tournament.getEnrollment().getRequests().get(0).toString();
          request.setText(n);
          request.setStyle("-fx-text-fill: #181818; -fx-font: normal bold 10px 'AGA Arabesque';");
          requestsVBox.setMargin(request, new Insets(10, 10, 10, 10));   
          requestsVBox.setAlignment(Pos.CENTER);
          requestsVBox.getChildren().add(request);

          // for (int i = 0; i < tournament.getEnrollment().getRequests().size(); i++){
          //   request.setText(tournament.getEnrollment().getRequests().get(i).toString());
          //   requestsVBox.getChildren().add(request);
          // }

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
