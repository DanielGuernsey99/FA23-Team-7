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
import java.util.ArrayList;
import java.util.Date;

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
        
        ArrayList<Customer> customerAccountsArray = new ArrayList<>();
        ArrayList<Game> gameInventoryArray = new ArrayList<>();

        Customer cust1, cust2, cust3;
        cust1 = new Customer("Smil6575", "Samantha",
            "Smiley", "123 Four Place", "Hometown", "IN",
            "47409", 0.0);
        customerAccountsArray.add(cust1);
        cust2 = new Customer("Bail2345", "Trisha", "Bailey",
            "234 South St", "Titusville", "FL", "32780",
            0.0);
        customerAccountsArray.add(cust2);
        cust3 = new Customer("Prin6567", "Pebbles", "Prince",
            "1999 Nikki Way", "Warminster", "PA", "18974",
            0.0);
        customerAccountsArray.add(cust3); 
        
        customerAccountsArray.add(createCustomer());
        System.out.println(customerAccountsArray);
        
        gameInventoryArray.add(newGameToInventory());
        System.out.println(gameInventoryArray);
            
    }
    
    // Need to have ID, firstName, lastName, address, city, state, zip, & beginning balance
    public static Customer createCustomer(){
        
        Customer cust = new Customer();        
        Scanner scan = new Scanner(System.in);
        System.out.println("First Name: ");
        cust.setFirstName(scan.nextLine());
        System.out.println("Last Name: ");
        cust.setLastName(scan.nextLine());
        System.out.println("Street Address: ");
        cust.setAddress(scan.nextLine());
        System.out.println("City: ");
        cust.setCity(scan.nextLine());
        System.out.println("State: ");
        cust.setState(scan.nextLine());
        System.out.println("Zip Code: ");
        cust.setZipCode(scan.nextLine());
        cust.setCustomerId(cust.generateId(cust.getLastName()));
        cust.setCustomerBalance(0.0);
        return cust;       
    }
    
    // Need to have name, date received, gameid, genre, rating, platform,
    // status, current customer, due date
    public static Game newGameToInventory(){
        
        Game game = new Game();
        Scanner scan = new Scanner(System.in);
        System.out.println("Game Name: ");
        game.setName(scan.nextLine());
        System.out.println("Genre: ");
        game.setGenre(scan.nextLine());
        System.out.println("Rated: ");
        game.setRating(scan.nextLine());
        System.out.println("Platform: ");
        game.setPlatform(scan.nextLine());
        game.setGameId(game.generateGameId(game.getName(),game.getPlatform()));
        game.setStatus("available");
        game.setDateReceived(new java.util.Date());
        return game;
    }

    // Search Methods
    public void searchByGameId(){
    }
    
    public void searchByGameName(){        
    }
    
    public void searchByCustomerId(){        
    }
    
    public void searchByAvailableGames(){
    }
    
    public void searchAvailableByPlatform(){        
    }
    
    public void searchByRating(){        
    }
    
    public void searchByGenre(){        
    }
}
