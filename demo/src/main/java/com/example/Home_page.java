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
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Home_page extends AnchorPane{

  private Stage stage;
  private Scene scene;
  private Parent root; 

  @FXML
  public HBox Hbox;

  @FXML
  private ScrollPane scrollPane;

  @FXML
  private Button addingTournamentButton;

  @FXML
  private MenuItem logoutButton;

  @FXML
  private Menu menu_logout;

  @FXML
  private Menu menu_profile;

  @FXML
  private Button tourButton;  

  boolean isLeft = true;
  //------------------

  @FXML
  void goToProfile() {

  }

  @FXML
  private void logoutButton() throws IOException {
    App.setRoot("login");
  }

  @FXML
  public void tourButton() throws IOException {
   
  }

  public Button addToHbox(String name, String sport, boolean teamBased, int availableSeats){
    Hbox = new HBox();
    String teamBased2 = teamBased == true ? "team based" : "indevidual based"; 
    String title = name + "\n" + sport + "\n" + teamBased2 + "\n available seats: \n" + availableSeats;
    Button n = new Button(title);
    n.setStyle("-fx-text-fill: #181818;  -fx-font: normal bold 10px 'AGA Arabesque'; -fx-background-color:  #c1beff; -fx-text-alignment: center; -fx-effect: innershadow(gaussian, #666666, 10, 0.5, 0, 0);}");  
    n.setPrefHeight(72); 
    n.setPrefWidth(110); 
    return n;
    // Hbox.setMargin(n, new Insets(20, 10, 10, 10));
    // Hbox.getChildren().add(n);
  }

  @FXML
  private void addingTournamentButton(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("tournamentInfoPage.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show(); 
  }
}
