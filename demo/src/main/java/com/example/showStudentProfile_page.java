package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

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
  private String studentPath = "U:\\Term222\\SWE206\\SWE206_Project\\";


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

  @FXML
  public void goToHome(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("homePage.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show(); 
  }

  @FXML
  public void searchButton(ActionEvent event) throws IOException {
    Student student = readStudentFile(studentNameField.getText());
    studentNameLabel.setText(student.getName());
    StudentIDLable.setText(student.getID());
  }

  public Student readStudentFile(String name){
    try{
      File file = new File(studentPath + "students.dat");
      FileInputStream fileInput = new FileInputStream(file);
      ObjectInputStream input = new ObjectInputStream(fileInput);
      Student student = (Student) input.readObject();
      while(student != null){
        if (student.getName().equals(name))
          return student;

        ObjectInputStream input2 = new ObjectInputStream(fileInput);
        student = (Student) input2.readObject();
      }
      input.close();
      return new Student(name, name, name, name, name);
    }
    catch(FileNotFoundException e){
      return new Student(name, name, name, name, name);
    }
    catch (IOException es){
      return new Student(name, name, name, name, name);
    }
    catch (ClassNotFoundException em){
      return new Student(name, name, name, name, name);
    }
  }
}
