package com.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TournamentInfo_page {

  private Stage stage;
  private Scene scene;
  private Parent root; 
  String savedTournamentPath = "U:\\Term222\\SWE206\\SWE206_Project\\";

    @FXML
    private TextField availableSeatsField;

    @FXML
    private CheckBox archivedCheck;

    @FXML
    private CheckBox statusCheck;

    @FXML
    private Button backToHome;

    @FXML
    private ComboBox<String> comBox;
    
    @FXML
    private Button createButton;

    @FXML
    private TextField endDateField;

    @FXML
    private TextField startDateField;

    @FXML
    private CheckBox teamBasedButton;

    @FXML
    private TextField teamCapacityField;

    @FXML
    private TextField tournamentNameField;

    @FXML
    private TextField tournamentSportField;

    @FXML
    private AnchorPane welcomeScene;

    @FXML
    void comboItems() {
      String[] tournamentsTypes = {"Elimination", "Round Robin"};
      comBox.getItems().addAll(tournamentsTypes);
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

    @FXML
    public void createButton(ActionEvent event) throws IOException{
      String name = tournamentNameField.getText();
      String sport = tournamentSportField.getText();
      String startDate = startDateField.getText();
      String endDate = endDateField.getText();
      boolean teamBased = teamBasedButton.isSelected() ? true : false;
      boolean status = statusCheck.isSelected() ? true : false;
      boolean archived = archivedCheck.isSelected() ? true : false;
      String teamCapacity = teamCapacityField.getText();
      Enrollment enrollment = new Enrollment(Integer.parseInt(availableSeatsField.getText()), 0);
      TournamentProgress tournamentProgress = new TournamentProgress();
      String availableSeats = availableSeatsField.getText();
      Tournament tournament = new Tournament(name, sport, startDate, endDate, "Elimination", status, archived, teamBased, Integer.parseInt(teamCapacity), enrollment, tournamentProgress);

      saveToutnament("tournaments", tournament);
    }

    @FXML
    public void backToHome(ActionEvent event) throws IOException{
      Parent root = FXMLLoader.load(getClass().getResource("homePage.fxml"));
      stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      scene = new Scene(root);
      stage.setScene(scene);
      stage.show(); 
    }
}
