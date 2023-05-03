package com.example.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.example.Student;

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
  public void goToHome(final ActionEvent event) throws IOException {
    final Parent root = FXMLLoader.load(getClass().getResource("/com/example/homePage.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show(); 
  }

  @FXML
  public void searchButton(final ActionEvent event) throws IOException {
    final Student student = readStudentFile(studentNameField.getText());
    studentNameLabel.setText(student.getName());
    StudentIDLable.setText(student.getID());
  }

  public Student readStudentFile(final String name){
    try{
      final File file = new File(studentPath + "students.dat");
      final FileInputStream fileInput = new FileInputStream(file);
      final ObjectInputStream input = new ObjectInputStream(fileInput);
      Student student = (Student) input.readObject();
      while(student != null){
        if (student.getName().equals(name))
          return student;

        final ObjectInputStream input2 = new ObjectInputStream(fileInput);
        student = (Student) input2.readObject();
      }
      input.close();
      return new Student(name, name, name, name, name);
    }
    catch(final FileNotFoundException e){
      return new Student(name, name, name, name, name);
    }
    catch (final IOException es){
      return new Student(name, name, name, name, name);
    }
    catch (final ClassNotFoundException em){
      return new Student(name, name, name, name, name);
    }
  }
}
