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
import java.util.HashMap;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class SampleController implements Initializable{
//    String[] usernames = {"admin"};
//    String[] passwords = {"1234"};
    
    
    @FXML
    private Button close;

    @FXML
    private Button loginButton;

    @FXML
    private AnchorPane main_form;

    @FXML
    public TextField password;
    
    @FXML
    public TextField username;
    
    private Parent root;
   
    private double x = 0;
    private double y = 0;
    
    public void loginAdmin() throws IOException{
            Logins login = new Logins();
        
            String dashboardUsername = username.getText();
            String dashboardPassword = password.getText();
            
            if(login.logininfo.containsKey(dashboardUsername)){
                
                if(login.logininfo.get(dashboardUsername).equals(dashboardPassword)){
                    
            
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("RentalCentralDashboard.fxml"));
                    root = loader.load();
            
                    DashboardController dashboardcontroller = loader.getController();
                    dashboardcontroller.displayName(dashboardUsername);
            
                    System.out.println("Login Successful");
            
                    loginButton.getScene().getWindow().hide();
                    
//                  Parent root = FXMLLoader.load(getClass().getResource("RentalCentralDashboard.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.initStyle(StageStyle.TRANSPARENT);
                    
                    root.setOnMousePressed((MouseEvent event) ->{
                        x = event.getSceneX();
                        y = event.getSceneY();
                    });
        
                    root.setOnMouseDragged((MouseEvent event) ->{
                        stage.setX(event.getScreenX() - x);
                        stage.setY(event.getScreenY() - y);
                        stage.setOpacity(.8);
                    });
        
                    root.setOnMouseReleased((MouseEvent event) ->{
                            stage.setOpacity(1);
                    });
        
                    stage.initStyle(StageStyle.TRANSPARENT);

                    stage.show();
                    
                }
                   
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
