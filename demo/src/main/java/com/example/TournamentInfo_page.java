package com.example;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TournamentInfo_page {
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

    public void createButton() throws IOException{
      FXMLLoader loader = new FXMLLoader(getClass().getResource("homePage.fxml"));
      AnchorPane root = loader.load();
      Home_page home_page = loader.getController();

      HBox vbox = (HBox) loader.getNamespace().get("Hbox"); // Get the VBox from the FXML file
      Button button = home_page.addToHbox("ebticar", "programming", false, 10); // Create a new button
      vbox.getChildren().add(button); // Add the button to the VBox

      Scene scene = new Scene(root);
      Stage stage = new Stage();
      stage.setScene(scene);
      stage.show();


    }
}
