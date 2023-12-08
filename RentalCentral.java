
package RentalCentral;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class RentalCentral extends Application {

    public static void main(String[] args){
        launch(args);
    }
    
    private double x = 0;
    private double y = 0;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Rental Central");
        primaryStage.setScene(new Scene(root, 600, 400));
        
        root.setOnMousePressed((MouseEvent event) ->{
            x = event.getSceneX();
            y = event.getSceneY();
        });
        
        root.setOnMouseDragged((MouseEvent event) ->{
            primaryStage.setX(event.getScreenX() - x);
            primaryStage.setY(event.getScreenY() - y);
            
            primaryStage.setOpacity(.8);
        });
        
        root.setOnMouseReleased((MouseEvent event) ->{
            primaryStage.setOpacity(1);
        });
        
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();
  
 
    }

    // Jiya's code from Discord
    public void addCustomer(Customer customer) {
    customers.add(customer);
}

public Customer searchCustomerByID(int id) {
    for (Customer customer : customers) {
        if (customer.getCustomerID() == id) {
            return customer;
        }
    }
    return null;
}
    
    
    
}
