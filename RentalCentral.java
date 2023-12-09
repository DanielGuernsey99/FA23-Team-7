package RentalCentral;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import java.util.Scanner;

public class RentalCentral extends Application {

    private static Scene scene;
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
    
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        // comment out the launch function when testing without GUI
        //launch();
        
        // comment this out when using GUI        
        System.out.println("this is the main method.");
        Scanner scan = new Scanner(System.in);
        Customer cust1 = new Customer();
        System.out.println(cust1.generateId("R"));
        Game game1 = new Game();
        System.out.println(game1.generateGameId("MarioKart", "Switch"));
    }
}
