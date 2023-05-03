package com.example.pages;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class welcom_page {

  public Stage stage;
  public Scene scene;
  public Parent root; 

  @FXML
  public Button login;

  @FXML
  public Button signin;

  @FXML
  public void goToLogin(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/com/example/login.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show(); 
  }

  @FXML
  public void goToSignin(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/com/example/signin.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show(); 
  }
  
}
