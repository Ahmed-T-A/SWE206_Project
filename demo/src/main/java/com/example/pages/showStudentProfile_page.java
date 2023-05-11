package com.example.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.example.Student;
import com.example.Url;

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
  public Stage stage;
  public Scene scene;
  public Parent root; 
  public final String studentPath = "U:\\Term222\\SWE206\\SWE206_Project\\";


  @FXML
  public Label StudentIDLable;

  @FXML
  public Button homeButton;

  @FXML
  public Button searchButton;

  @FXML
  public TextField studentNameField;

  @FXML
  public Label studentNameLabel;

  @FXML
  public VBox studentTournaments;

  @FXML
  public void goToHome(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/com/example/homePage.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show(); 
  }

  @FXML
  public void searchButton(ActionEvent event) throws IOException {
    Student student = readStudentFile(studentNameField.getText());

    if (student != null){
      StudentIDLable.setText(student.getID());
      studentNameLabel.setText(student.getName());
    }

  }

  public Student readStudentFile(String name){
    Student student = null;
        try (FileInputStream fileInputStream = new FileInputStream(new File(studentPath + "students.dat"));
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            while (fileInputStream.available() > 0) {
                Student obj = (Student) objectInputStream.readObject();
                if (obj.getName().equals(name)) {
                    student = obj;
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return student;
  }
}
