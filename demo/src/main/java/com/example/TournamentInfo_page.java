package com.example;

import java.io.IOException;

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

    @FXML
    private TextField availableSeatsField;

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

    public void createButton(ActionEvent event) throws IOException{

      String name = tournamentNameField.getText();
      String sport = tournamentSportField.getText();
      String availableSeats = availableSeatsField.getText();
      boolean teamBased = teamBasedButton.isSelected() ? true : false;
      
      FXMLLoader loader = new FXMLLoader(getClass().getResource("homePage.fxml"));
      AnchorPane root = loader.load();
      Home_page home_page = loader.getController();
      HBox hbox = (HBox) loader.getNamespace().get("Hbox"); // Get the HBox from the FXML file
      Button button = home_page.addToHbox(name, sport, teamBased, Integer.parseInt(availableSeats)); // Create a new button
      hbox.setMargin(button, new Insets(20, 10, 10, 10));
      hbox.getChildren().add(button); // Add the button to the HBox

      stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      scene = new Scene(root);
      stage.setScene(scene);
      stage.show();
    }
}
