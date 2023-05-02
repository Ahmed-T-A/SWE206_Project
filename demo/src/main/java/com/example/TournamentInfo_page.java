package com.example;

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

  private static final long serialVersionUID = -3376593017416497415L;


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

    String tournamentType;
    
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
    void comboItems(ActionEvent event) throws IOException {
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
      // enrollment.request(new Student("Ahmed", "200000", "kfv", "tourType", "teamCapacity"));
      TournamentProgress tournamentProgress = new TournamentProgress();
      Tournament tournament = new Tournament(name, sport, startDate, endDate, tourType, status, archived, teamBased, Integer.parseInt(teamCapacity), enrollment, tournamentProgress);
      File file = new File(savedTournamentPath + "tournaments.dat");
      tournament.saveTour(file);
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
