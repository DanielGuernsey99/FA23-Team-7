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
import java.lang.*;

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
        
        // When using GUI - comment out the code that prints to the console        
        
        // Create the customer and game lists associated with the rentals
        ArrayList<Customer> customerList = new ArrayList<>();
        ArrayList<Game> gameList = new ArrayList<>();
                
        // Create baseline 'beginning' Customer objects
        Customer c1, c2, c3, c4, c5, c6;
        c1 = new Customer("1", "John", "Doe", "123 Main St", "Springfield", "IL", "62701", 20.00);
        c2 = new Customer("2", "Jane", "Smith", "456 Elm St", "Springfield", "IL", "62701", 30.00);
        c3 = new Customer("3", "Jordan", "Williams", "952 Bark Pl", "Desmoine", "IA", "25906", 40.00);
        c4 = new Customer("4", "Jayden", "Mendoza", "835 Rocket RD", "Seattle", "WA", "95708", 50.00);
        c5 = new Customer("5", "Norwin", "Bermudez", "734 Angler CT", "Carmel", "IN", "46032", 60.00);
        c6 = new Customer("6", "Angelita", "De La Cruz", "156 Whitestown Pkwy", "Zionsville", "IN", "46077", 70.00);
        
        // Set unique customer Ids
        c1.setCustomerId(c1.generateId(c1.getLastName()));
        c2.setCustomerId(c2.generateId(c2.getLastName()));
        c3.setCustomerId(c3.generateId(c3.getLastName()));
        c4.setCustomerId(c4.generateId(c4.getLastName()));
        c5.setCustomerId(c5.generateId(c5.getLastName()));
        c6.setCustomerId(c6.generateId(c6.getLastName()));
        
        // Add baseline Customer objects to the Customer ArrayList
        customerList.add(c1);
        customerList.add(c2);
        customerList.add(c3);
        customerList.add(c4);
        customerList.add(c5);
        customerList.add(c6);
        
        // Add a customer using the createCustomer method
        //customerList.add(createCustomer());
                
        // Create New Game Objects
        Game g1, g2, g3, g4, g5, g6;
        g1 = new Game("Rag n Bone", new Date(), "1", "Action", "E", "PC", "Available");
        g2 = new Game("Link: WildBreath", new Date(), "2", "Adventure", "E", "Switch", "Available");
        g3 = new Game("Call of Duty Warzone Warfare", new Date(), "3", "FPS", "M", "PlayStation", "Available");
        g4 = new Game("Spongebob Bubble Brawl", new Date(), "4", "Action", "E", "PC", "Available");
        g5 = new Game("Grilling Daddy", new Date(), "5", "Cooking Simulator", "E", "Xbox", "Available");
        g6 = new Game("Zelda Tears of the Kingdom", new Date(), "6", "Adventure", "E", "Switch", "Available");
        
        // Set unique game Ids
        g1.setGameId(g1.generateGameId(g1.getName(), g1.getPlatform()));
        g2.setGameId(g2.generateGameId(g2.getName(), g2.getPlatform()));
        g3.setGameId(g3.generateGameId(g3.getName(), g3.getPlatform()));
        g4.setGameId(g4.generateGameId(g4.getName(), g4.getPlatform()));
        g5.setGameId(g5.generateGameId(g5.getName(), g5.getPlatform()));
        g6.setGameId(g6.generateGameId(g6.getName(), g6.getPlatform()));
        
        // Add the Game objects to the Game inventory
        gameList.add(g1);
        gameList.add(g2);
        gameList.add(g3);
        gameList.add(g4);
        gameList.add(g5);
        gameList.add(g6);
        
        // Add a game using the createGame method
        //gameList.add(newGameToInventory());
        
        // Print the lists
        printCustomerList(customerList);
        //printGameList(gameList);
        //searchByGameId(gameList);
        //searchByGameName(gameList);
        //searchGameByCustomerId(gameList);
        //searchGamesByStatus(gameList);
        //searchAvailableByPlatform(gameList);
        //searchAllByRating(gameList);
        //searchAllByGenre(gameList);
        searchCustomerListByName(customerList);
        searchCustomerListByCustomerId(customerList);
        
        //Search for a game and then rent it
    }
    
    // Call this method to print the customer list at any time
    public static void printCustomerList(ArrayList<Customer> customers){
        System.out.println("\nLIST OF CURRENT CUSTOMERS:");
        for (Customer customer : customers) {
            System.out.print("---------------");
            System.out.print(customer.toString());
        }
    }
        
    // Call this method to print the game list at any time
    public static void printGameList(ArrayList<Game> games){
        System.out.println("\nLIST OF GAME INVENTORY:");
        for (Game game : games) {
            System.out.print("---------------");
            System.out.print(game.toString());            
        }
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
    public static void searchCustomerListByName(ArrayList<Customer> customerList){
        Scanner input = new Scanner(System.in);
        System.out.println("\nSearch for Customer by Last Name: ");
        String lastName = input.nextLine();
        for(Customer customers : customerList){
            if(customers.getLastName().equalsIgnoreCase(lastName))
                System.out.println(customers);
        }
    }
    
    public static void searchCustomerListByCustomerId(ArrayList<Customer> customerList){
        Scanner input = new Scanner(System.in);
        System.out.println("\nSearch for Customer by Customer Id: ");
        String custId = input.nextLine();
        for(Customer customers : customerList){
            if(customers.getCustomerId().equalsIgnoreCase(custId))
                System.out.println(customers);
        }
    }
    
    public static void searchByGameId(ArrayList<Game> gamesList){
        Scanner input = new Scanner(System.in);
        System.out.println("\nSearch for game by game ID: ");
        String gameId = input.nextLine();
        for(Game games : gamesList){
            if(games.getGameId().equalsIgnoreCase(gameId))
                System.out.println(games);
        }
    }
    
    public static void searchByGameName(ArrayList<Game> gamesList){
        Scanner input = new Scanner(System.in);
        System.out.println("\nSearch for game by name: ");
        String gameName = input.nextLine();
        for(Game games : gamesList){
            if(games.getName().equalsIgnoreCase(gameName))
                System.out.println(games);
        }
    }
    
    public static void searchGameByCustomerId(ArrayList<Game> gamesList){
        Scanner input = new Scanner(System.in);
        System.out.println("\nSearch for game by Customer Id: ");
        String custId = input.nextLine();
        for(Game games : gamesList){
            if(games.getCurrentCustomer()!= null){
                if(games.getCurrentCustomer().getCustomerId().equalsIgnoreCase(custId))
                System.out.println(games);
            }
        }
    }
    
    public static void searchGamesByStatus(ArrayList<Game> gamesList){
        Scanner input = new Scanner(System.in);
        System.out.println("\nSearch by rental status: \n1. AVAILABLE\n" +
                "2. RENTED");
        int answer = input.nextInt();
        String x = input.nextLine(); // fixes a nextInt error
        while ((answer != 1) && (answer != 2)){
            System.out.println("Entry not recognized.");
            System.out.println("\nSearch by rental status: \n1. AVAILABLE\n" +
                "2. RENTED");
            answer = input.nextInt();
            x = input.nextLine();  // fixes a nextInt error 
        }
        if(answer == 1){
            for(Game games : gamesList){
                if(games.getStatus().equalsIgnoreCase("available"))
                System.out.println(games);
            }
        }
        if(answer == 2){
            for(Game games : gamesList){
                if(games.getStatus().equalsIgnoreCase("rented"))
                System.out.println(games);
            }
        }
    }
    
    // Platforms are: PC, Switch, Playstation, XBox, SNES, Genesis 
    public static void searchAvailableByPlatform(ArrayList<Game> gamesList){
        Scanner input = new Scanner(System.in);
        System.out.println("\nSearch Available Games by Platform:\n1. PC\n2. Switch\n3."
                + " Playstation\n4. XBox\n5. SNES\n6. N64\n");
        int answer = input.nextInt();
        String x = input.nextLine();  // fixes a nextInt error
        while((answer != 1) && (answer != 2) && (answer != 3) && (answer != 4)
                && (answer != 5) && (answer != 6)){
            System.out.println("Entry not recognized.");
            System.out.println("\nSearch Available Games by Platform:\n1. PC\n2. Switch\n3."
                + " Playstation\n4. XBox\n5. SNES\n6. N64\n");
            answer = input.nextInt();
            x = input.nextLine();  // fixes a nextInt error
        }
        if(answer == 1){
            System.out.println("PC");
            for(Game games : gamesList){
                if((games.getStatus().equalsIgnoreCase("Available"))
                        && (games.getPlatform().equalsIgnoreCase("PC"))){
                    System.out.println(games);
                }
            }
        }
        if(answer == 2){
            System.out.println("Switch");
            for(Game games : gamesList){
                if((games.getStatus().equalsIgnoreCase("Available"))
                        && (games.getPlatform().equalsIgnoreCase("Switch"))){
                    System.out.println(games);
                }
            }            
        }
        if(answer == 3){
            System.out.println("PlayStation");
            for(Game games : gamesList){
                if((games.getStatus().equalsIgnoreCase("Available"))
                        && (games.getPlatform().equalsIgnoreCase("Playstation"))){
                    System.out.println(games);
                }
            }
        }
        if(answer == 4){
            System.out.println("XBox");
            for(Game games : gamesList){
                if((games.getStatus().equalsIgnoreCase("Available"))
                        && (games.getPlatform().equalsIgnoreCase("XBox"))){
                    System.out.println(games);
                }
            }
        }
        if(answer == 5){
            System.out.println("SNES-Super Nintendo");
            for(Game games : gamesList){
                if((games.getStatus().equalsIgnoreCase("Available"))
                        && (games.getPlatform().equalsIgnoreCase("SNES"))){
                    System.out.println(games);
                }
            }
        }
        if(answer == 6){
            System.out.println("N64-Nintendo 64");
            for(Game games : gamesList){
                if((games.getStatus().equalsIgnoreCase("Available"))
                        && (games.getPlatform().equalsIgnoreCase("N64"))){
                    System.out.println(games);
                }
            }
        }
    }
    
    // Ratings are: EC , E , E10+ , T , M , A
    public static void searchAllByRating(ArrayList<Game> gamesList){
        Scanner input = new Scanner(System.in);
        System.out.println("\nSearch Available Games by Rating:\n1. EC   -Early Childhood\n2. "
                + "E    -Everyone\n3. E10+ -Everyone 10 and up\n4. T    -Teen\n5. M    -Mature 17+\n6. "
                + "A    -Adults Only 18+\n");
        int answer = input.nextInt();
        String x = input.nextLine();  // fixes a nextInt error
        while((answer != 1) && (answer != 2) && (answer != 3) && (answer != 4)
                && (answer != 5) && (answer != 6)){
            System.out.println("Entry not recognized.");
            System.out.println("\nSearch Available Games by Rating:\n1. EC   -Early Childhood\n2. "
                + "E     -Everyone\n3. E10+  -Everyone 10 and up\n4. T     Teen\n5. M     Mature 17+\n6. "
                + "A    -Adults Only 18+\n");
            answer = input.nextInt();
            x = input.nextLine();  // fixes a nextInt error
        }
        if(answer == 1){
            System.out.println("EC");
            for(Game games : gamesList)
                if(games.getRating().equalsIgnoreCase("EC"))
                    System.out.println(games);
        }
        if(answer == 2){
            System.out.println("E");
            for(Game games : gamesList)
                if(games.getRating().equalsIgnoreCase("E"))
                    System.out.println(games);
        }
        if(answer == 3){
            System.out.println("E10+");
            for(Game games : gamesList)
                if(games.getRating().equalsIgnoreCase("E10+"))
                    System.out.println(games);
        }
        if(answer == 4){
            System.out.println("T");
            for(Game games : gamesList)
                if(games.getRating().equalsIgnoreCase("T"))
                    System.out.println(games);
        }
        if(answer == 5){
            System.out.println("M");
            for(Game games : gamesList)
                if(games.getRating().equalsIgnoreCase("M"))
                    System.out.println(games);
        }
        if(answer == 6){
            System.out.println("A");
            for(Game games : gamesList)
                if(games.getRating().equalsIgnoreCase("A"))
                    System.out.println(games);
        }        
    }
    
    public static void searchAllByGenre(ArrayList<Game> gamesList){
        Scanner input = new Scanner(System.in);
        System.out.println("\nSearch Games by Genre:\n1. Action\n2. Action-Adventure\n3. Adventure\n4. "
                + "Cooking Simulator\n5. Fighting\n6. FPS\n7. Horror\n8. Racing\n9. Shooters\n10. Sports"
                + "\n11. Strategy\n12. Casual");
        int answer = input.nextInt();
        String x = input.nextLine();  // fixes a nextInt error
        while((answer <= 0) || (answer >= 13)){
            System.out.println("Entry not recognized.");
            System.out.println("\nSearch Games by Genre:\n1. Action\n2. Action-Adventure\n3. Adventure\n4. "
                + "Cooking Simulator\n5. Fighting\n6. FPS\n7. Horror\n8. Racing\n9. Shooters\n10. Sports"
                + "\n11. Strategy\n12. Casual");
            answer = input.nextInt();
            x = input.nextLine();  // fixes a nextInt error
        }
        if(answer == 1){
            System.out.println("Action");
            for(Game games : gamesList)
                if(games.getGenre().equalsIgnoreCase("Action"))
                    System.out.println(games);
        }
        if(answer == 2){
            System.out.println("Action-Adventure");
            for(Game games : gamesList)
                if(games.getGenre().equalsIgnoreCase("Action-Adventure"))
                    System.out.println(games);
        }
        if(answer == 3){
            System.out.println("Adventure");
            for(Game games : gamesList)
                if(games.getGenre().equalsIgnoreCase("Adventure"))
                    System.out.println(games);
        }
        if(answer == 4){
            System.out.println("Cooking Simulator");
            for(Game games : gamesList)
                if(games.getGenre().equalsIgnoreCase("Cooking Simulator"))
                    System.out.println(games);
        }
        if(answer == 5){
            System.out.println("Fighting");
            for(Game games : gamesList)
                if(games.getGenre().equalsIgnoreCase("Fighting"))
                    System.out.println(games);
        }
        if(answer == 6){
            System.out.println("FPS");
            for(Game games : gamesList)
                if(games.getGenre().equalsIgnoreCase("FPS"))
                    System.out.println(games);
        }
        if(answer == 7){
            System.out.println("Horror");
            for(Game games : gamesList)
                if(games.getGenre().equalsIgnoreCase("Horror"))
                    System.out.println(games);
        }
        if(answer == 8){
            System.out.println("Racing");
            for(Game games : gamesList)
                if(games.getGenre().equalsIgnoreCase("Racing"))
                    System.out.println(games);
        }
        if(answer == 9){
            System.out.println("Shooters");
            for(Game games : gamesList)
                if(games.getGenre().equalsIgnoreCase("Shooters"))
                    System.out.println(games);
        }
        if(answer == 10){
            System.out.println("Sports");
            for(Game games : gamesList)
                if(games.getGenre().equalsIgnoreCase("Sports"))
                    System.out.println(games);
        }
        if(answer == 11){
            System.out.println("Strategy");
            for(Game games : gamesList)
                if(games.getGenre().equalsIgnoreCase("Strategy"))
                    System.out.println(games);
        }
        if(answer == 12){
            System.out.println("Casual/Indie");
            for(Game games : gamesList)
                if(games.getGenre().equalsIgnoreCase("Casual/Indie"))
                    System.out.println(games);
        }
    }
}
