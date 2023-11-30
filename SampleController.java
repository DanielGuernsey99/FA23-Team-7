/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package RentalCentral;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.util.Arrays;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;


public class SampleController implements Initializable {
    String[] usernames = {"admin"};
    String[] passwords = {"1234"};
    
    @FXML
    private Button close;

    @FXML
    private Button loginButton;

    @FXML
    private AnchorPane main_form;

    @FXML
    private TextField password;
    
    @FXML
    private TextField username;
    
    public void loginAdmin() throws IOException{
        Alert alert;
        
        if(Arrays.asList(usernames).contains(username.getText()) && Arrays.asList(passwords).contains(password.getText())){
            
            System.out.println("Login Successful");
            alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Login Successful!");
            
            loginButton.getScene().getWindow().hide();
            
            Parent root = FXMLLoader.load(getClass().getResource("RentalCentralDashboard.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        }
        else{
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please enter in a correct login!");
        }
    }
    
    public void close(){
        System.exit(0);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
