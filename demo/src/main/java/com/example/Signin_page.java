package com.example;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Signin_page {

    private Stage stage;
    private Scene scene;
    private Parent root; 
    private String studentPath = "U:\\Term222\\SWE206\\SWE206_Project\\";

    @FXML
    private Label ID;

    @FXML
    private TextField emailField;

    @FXML
    private TextField IdField;

    @FXML
    private Label name;

    @FXML
    private TextField nameField;

    @FXML
    private Label password;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button registerButton;

    @FXML
    private Button signinButton;

    @FXML
    private Label username;

    @FXML
    private TextField usernameField;

    @FXML
    void register() {

    }

    @FXML
    private void switchToLogin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show(); 
    }

    @FXML
    private void registerAndMoveToLoginPage(ActionEvent event) throws IOException {
        String name = nameField.getText();
        String ID = IdField.getText();
        String username = usernameField.getText();
        String password = passwordField.getText();
        String email = emailField.getText();
        Student student = new Student(name, ID, username, password,email);
        if (studentAlreadyRegistered(student) == false){
            saveToStudentFile("students", student);
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } 
    }

    public boolean studentAlreadyRegistered(Student student) {
        try {
            File file = new File(studentPath + "students.dat");
            FileInputStream fileInput = new FileInputStream(file);
            ObjectInputStream input = new ObjectInputStream(fileInput);
            Object object = input.readObject();
            while (object != null) {
                if (student.equals((Student) object)) {
                    System.out.println("found");
                    input.close();
                    return true;
                } else {
                    object = input.readObject();
                }
            }
            input.close();
            return false;
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return false;
        } catch (EOFException e) {
            System.out.println("End of file reached");
            return false;
        } catch (IOException e) {
            System.out.println("IOException occurred");
            return false;
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
            return false;
        }
    }
    

    public void saveToStudentFile(String fileName, Student student){

        try{
            FileOutputStream theBinaryFile = new FileOutputStream(studentPath + fileName + ".dat", true);
            ObjectOutputStream output = new ObjectOutputStream(theBinaryFile);
            output.writeObject(student);
            output.close();
            }
            catch(IOException e){
              System.out.println(e.getMessage());
            }
    }
}
