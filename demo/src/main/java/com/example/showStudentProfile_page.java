package com.example;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class showStudentProfile_page {
  private Stage stage;
  private Scene scene;
  private Parent root; 

  @FXML
  private Label StudentIDLable;

  @FXML
  private Button homeButton;

  @FXML
  private Button searchButton;

  @FXML
  private TextField studentNameField;

  @FXML
  private Label studentNameLabel;

  @FXML
  private VBox studentTournaments;

  public void goToHome(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("homePage.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show(); 
  }
}
