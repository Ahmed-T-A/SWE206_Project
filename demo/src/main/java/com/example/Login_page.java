package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javafx.event.ActionEvent;
import javafx.event.Event;
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

public class Login_page {

    private Stage stage;
    private Scene scene;
    private Parent root; 
    private String studentPath = "U:\\Term222\\SWE206\\SWE206_Project\\";

    @FXML
    private Button loginButton;

    @FXML
    private Button bytoo;

    @FXML
    private Label password;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signinButton;

    @FXML
    private Label username;

    @FXML
    private TextField usernameField;
    
    @FXML
    void goToSignInPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("signin.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show(); 
    }

    @FXML
    void loginUser(ActionEvent event) throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();
        // if (matchUsernameAndPassword(username, password)){
            Parent root = FXMLLoader.load(getClass().getResource("homePage.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show(); 
        // }
    }

    public boolean matchUsernameAndPassword(String username, String password){
        try{
            File file = new File(studentPath + "students.dat");
            FileInputStream fileInput = new FileInputStream(file);
            ObjectInputStream input = new ObjectInputStream(fileInput);
            Student student = (Student) input.readObject();
            while (student != null)
            {
                if (student.getUsername().equals(username)){
                    if (student.getPassword().equals(password))
                        return true;
                }
                ObjectInputStream input2 = new ObjectInputStream(fileInput);
                student = (Student) input2.readObject();
            }
            input.close();
            return false;
        }
        catch(FileNotFoundException e){
            return false;
        }
        catch (IOException es){
            return false;
        }
        catch (ClassNotFoundException em){
            return false;
        }
    }
    public void bfdks(ActionEvent event) throws IOException{
        try{
            File file = new File(studentPath + "students.dat");
            FileInputStream fileInput = new FileInputStream(file);
            ObjectInputStream input = new ObjectInputStream(fileInput);
            Student student = (Student) input.readObject();
            while (student != null)
            {
                System.out.println(student.getUsername() + "\n" + student.getPassword());
                ObjectInputStream input2 = new ObjectInputStream(fileInput);
                student = (Student) input2.readObject();
            }
            input.close();
        }
        catch(FileNotFoundException e){
        }
        catch (IOException es){
        }
        catch (ClassNotFoundException em){
        }
    }
}
