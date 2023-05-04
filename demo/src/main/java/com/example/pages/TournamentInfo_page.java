package com.example.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.example.Enrollment;
import com.example.Tournament;
import com.example.TournamentProgress;

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

  public static final long serialVersionUID = -3376593017416497415L;


  public Stage stage;
  public Scene scene;
  public Parent root; 
  String savedTournamentPath = "U:\\Term222\\SWE206\\SWE206_Project\\";

    @FXML
    public TextField availableSeatsField;

    @FXML
    public CheckBox archivedCheck;

    @FXML
    public CheckBox statusCheck;

    @FXML
    public Button backToHome;

    @FXML
    public ComboBox<String> comBox;

    public String tournamentType;
    
    @FXML
    public Button createButton;

    @FXML
    public TextField endDateField;

    @FXML
    public TextField startDateField;

    @FXML
    public CheckBox teamBasedButton;

    @FXML
    public TextField teamCapacityField;

    @FXML
    public TextField tournamentNameField;

    @FXML
    public TextField tournamentSportField;

    @FXML
    public AnchorPane welcomeScene;

    public void setData(String name, String sport, int availavleSeats,String startDate, String endDate,
     int teamCapacity,String tourType, boolean teamBased, boolean status, boolean isArchived)
     {
      tournamentNameField.setText(name);
      tournamentNameField.setEditable(false);
      tournamentSportField.setText(sport);
      startDateField.setText(startDate);
      endDateField.setText(endDate);
      availableSeatsField.setText(Integer.toString(availavleSeats));
      teamCapacityField.setText(Integer.toString(teamCapacity));
      comBox.setValue(tourType);
      if (teamBased == true )
        teamBasedButton.setSelected(true);
      if (status == true )
        statusCheck.setSelected(true);
      if (isArchived == true )
        archivedCheck.setSelected(true);
     }

    @FXML
    public void initialize() {
      comBox.getItems().removeAll(comBox.getItems());
      comBox.getItems().addAll("Elimination", "Round Robin");
      comBox.getSelectionModel().select("Select Tournament");
    }

    @FXML
    public void comboItems(ActionEvent event) throws IOException {
      tournamentType = comBox.getValue();
    }

    @FXML
    public void createButton(ActionEvent event) throws IOException{
      String name = tournamentNameField.getText();
      String sport = tournamentSportField.getText();
      String startDate = startDateField.getText();
      String endDate = endDateField.getText();
      String tourType = tournamentType;
      boolean teamBased = teamBasedButton.isSelected() ? true : false;
      boolean status = statusCheck.isSelected() ? true : false;
      boolean archived = archivedCheck.isSelected() ? true : false;
      String teamCapacity = teamCapacityField.getText();
      Enrollment enrollment = new Enrollment(Integer.parseInt(availableSeatsField.getText()), 0);
      TournamentProgress tournamentProgress = new TournamentProgress();
      Tournament tournament = new Tournament(name, sport, startDate, endDate, tourType, status, archived, teamBased, Integer.parseInt(teamCapacity), enrollment, tournamentProgress);
      File file = new File(savedTournamentPath + "tournaments.dat");
      tournament.saveTour(file);
    }

    @FXML
    public void backToHome(ActionEvent event) throws IOException{
      Parent root = FXMLLoader.load(getClass().getResource("/com/example/homePage.fxml"));
      stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      scene = new Scene(root);
      stage.setScene(scene);
      stage.show(); 
    }
}
