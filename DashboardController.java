package RentalCentral;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class DashboardController extends SampleController{
    

    @FXML
    private Button CustomerButton;

    @FXML
    private AnchorPane CustomerWindow;

    @FXML
    private Button GamesButton;

    @FXML
    private AnchorPane GamesWindow;

    @FXML
    private Label HelloLabel;

    @FXML
    private Button TransactionsButton;

    @FXML
    private AnchorPane TransactionsWindow;
    
    
    @FXML
    private ImageView LogoutButton;

    @FXML
    private Button close;

    @FXML
    private TableColumn<Customer, String> city;

    @FXML
    private Label currentDateLabel;

    @FXML
    private TableColumn<Customer, String> address;

    @FXML
    private TableColumn<Customer, Double> customerBalance;

    @FXML
    private TableColumn<Customer, String> firstName;

    @FXML
    private TableColumn<Customer, String> lastName;

    @FXML
    private TableColumn<Customer, String> state;

    @FXML
    private TableView<Customer> customerTable;

    @FXML
    private TableColumn<Customer, String> zipCode;
    
    @FXML
    private TableColumn<Customer, String> customerId;
    
    @FXML
    private TableColumn<Customer, String> phoneNumber;
    
    @FXML
    private TableColumn<Customer, String> email;
    
    @FXML
    private Button addCustomer;

    @FXML
    private AnchorPane addCustomerWindow;
    
    @FXML
    private TextField customerAddAddress;

    @FXML
    private TextField customerAddCity;

    @FXML
    private TextField customerAddEmail;

    @FXML
    private TextField customerAddFirstName;

    @FXML
    private TextField customerAddLastName;

    @FXML
    private TextField customerAddPhoneNumber;

    @FXML
    private TextField customerAddState;

    @FXML
    private TextField customerAddZipCode;
    
    @FXML
    private TableView<Game> gameTable;
    
    @FXML
    private MenuItem unavalilableMenuOptions;
    
    @FXML
    private MenuItem availableMenuOption;
    
    @FXML
    private TextField searchGame;
    
    @FXML
    private TableColumn<Game, String> genre;

    @FXML
    private TableColumn<Game, String> gameId;

    @FXML
    private TableColumn<Game, String> name;

    @FXML
    private TableColumn<Game, String> platform;

    @FXML
    private TableColumn<Game, String> rating;

    @FXML
    private TableColumn<Game, String> status;
    
    @FXML
    private TableColumn<Game, Customer> currentCustomer;
    
    @FXML
    private TableColumn<Game, Date> dateReceived;

    @FXML
    private TableColumn<Game, LocalDate> dueDate;
    
    @FXML
    private TextField addGameGenre;

    @FXML
    private TextField addGameName;

    @FXML
    private TextField addGamePlatform;

    @FXML
    private TextField addGameRating;
    
    @FXML
    private GridPane addGameGridPane;
    
    @FXML
    private GridPane gameSelect;
    
    @FXML
    private GridPane removeGameGridPane;
    
    @FXML
    private TextField removeGameID;

    
    private String generatedID;
    
    Customer customer = new Customer();
    Game game = new Game();
    private double x = 0;
    private double y = 0;
    
   //creates timestamp for time logged in
    String timeStamp = new SimpleDateFormat("MM/dd/yyyy - HH:mm a").format(Calendar.getInstance().getTime());
    
    ObservableList<Customer> customerList = FXCollections.observableArrayList();
    ObservableList<Game> gameList = FXCollections.observableArrayList();
    
    //closes the entire program
    @Override
    public void close(){
        System.exit(0);
    }
    
    //logs out of system back to login screen
    public void logout() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        
        LogoutButton.getScene().getWindow().hide();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }
    
    //displays the username in the hello label
    public void displayName(String username){
        HelloLabel.setText("Hello " + username + "!");
    }
    
    //when the Games button is clicked on the left hand side
    public void GamesWindow(){
        GamesWindow.setOpacity(1);
        GamesWindow.setDisable(false);
        CustomerWindow.setOpacity(0);
        CustomerWindow.setDisable(true);
        TransactionsWindow.setOpacity(0);
        TransactionsWindow.setDisable(true);
    }
    
    //when the Customer button is clicked on the left hand side
    public void CustomerWindow(){
        CustomerWindow.setOpacity(1);
        CustomerWindow.setDisable(false);
        GamesWindow.setOpacity(0);
        GamesWindow.setDisable(true);
        TransactionsWindow.setOpacity(0);
        TransactionsWindow.setDisable(true);
    }
    
    //when Inventory button is clicked on the left hand side
    public void TransactionsWindow(){
        TransactionsWindow.setOpacity(1);
        TransactionsWindow.setDisable(false);
        GamesWindow.setOpacity(0);
        GamesWindow.setDisable(true);
        CustomerWindow.setOpacity(0);
        CustomerWindow.setDisable(true);

    }
    
    //when the green plus sign button in the customer window is clicked
    public void addCustomer(){
        //action when button opens
        //bring open new stackpane window
        addCustomerWindow.setOpacity(1);
        addCustomerWindow.setDisable(false);
        addCustomer.setOpacity(0);
        addCustomer.setDisable(true); //MAKE SURE TO SET FALSE FOR COMPLETE CUSTOMER BUTTON
        customerTable.setOpacity(0);
        customerTable.setDisable(true); //MAKE SURE TO SET FALSE FOR COMPLETE CUSTOMER BUTTON
        //REMEMBER TO SET addCustomerWindow TO setDisable(true)!!!!
    }
    
    //when x is pressed in the add customer window this method activates
    public void closeCustomer(){
        addCustomerWindow.setOpacity(0);
        addCustomerWindow.setDisable(true);
        addCustomer.setOpacity(1);
        addCustomer.setDisable(false); 
        customerTable.setOpacity(1);
        customerTable.setDisable(false); 
    }
    
    //when green complete customer button pressed this method activates
    public void completeCustomer(){
        Alert alert;
        //if any fields during customer creation are empty
        if (customerAddFirstName.getText() == null || customerAddFirstName.getText().trim().isEmpty()
         || customerAddLastName.getText() == null || customerAddLastName.getText().trim().isEmpty()
         || customerAddAddress.getText() == null || customerAddAddress.getText().trim().isEmpty()
         || customerAddCity.getText() == null || customerAddCity.getText().trim().isEmpty()
         || customerAddState.getText() == null || customerAddState.getText().trim().isEmpty()
         || customerAddZipCode.getText() == null || customerAddZipCode.getText().trim().isEmpty()
         || customerAddPhoneNumber.getText() == null || customerAddPhoneNumber.getText().trim().isEmpty()
         || customerAddEmail.getText() == null || customerAddEmail.getText().trim().isEmpty())         
        {
            //presents alert
            Alert failedCustomerCreation = new Alert(AlertType.ERROR);
            failedCustomerCreation.setContentText("All fields must be complete for customer creation!");
            failedCustomerCreation.show();
        }
        else{
            //creates a new customer and adds it to the customer list
            generatedID = customer.generateId(customerAddLastName.getText());
            customerList.add(new Customer(generatedID,
            customerAddFirstName.getText(),
            customerAddLastName.getText(),
            customerAddPhoneNumber.getText(),
            customerAddEmail.getText(),
            customerAddAddress.getText(),
            customerAddCity.getText(),
            customerAddState.getText(),
            customerAddZipCode.getText(),
            0));
            
            Alert completedCustomerCreation = new Alert(AlertType.CONFIRMATION);
            completedCustomerCreation.setContentText(customerAddFirstName.getText() + " " + customerAddLastName.getText() + "was created successfuly!");
            completedCustomerCreation.show();
        
            customerAddFirstName.clear(); //clears textfields
            customerAddLastName.clear();
            customerAddAddress.clear();
            customerAddCity.clear();
            customerAddState.clear();
            customerAddZipCode.clear();
            customerAddPhoneNumber.clear();
            customerAddEmail.clear();

            //adds each individual field to the table
            customerId.setCellValueFactory(new PropertyValueFactory<Customer,String>("customerId"));
            firstName.setCellValueFactory(new PropertyValueFactory<Customer,String>("firstName"));
            lastName.setCellValueFactory(new PropertyValueFactory<Customer,String>("lastName"));
            phoneNumber.setCellValueFactory(new PropertyValueFactory<Customer,String>("phoneNumber"));
            email.setCellValueFactory(new PropertyValueFactory<Customer,String>("email"));
            address.setCellValueFactory(new PropertyValueFactory<Customer,String>("address"));
            state.setCellValueFactory(new PropertyValueFactory<Customer,String>("state"));
            city.setCellValueFactory(new PropertyValueFactory<Customer,String>("city"));
            zipCode.setCellValueFactory(new PropertyValueFactory<Customer,String>("zipCode"));
            customerBalance.setCellValueFactory(new PropertyValueFactory<Customer,Double>("customerBalance"));
        
            customerTable.setItems(customerList); //sets above fields' list to the customer table
        
            closeCustomer(); //closes customer creation window
        }
    }
    
    public void presetCustomers(){
        customerList.add(new Customer("1", "John", "Doe","3179894652" ,"doejohn@gmail.com","123 Main St", "Springfield", "IL", "62701", 20.00));
        customerList.add(new Customer("2", "Jane", "Smith","3176964611","smithjane@gmail.com", "456 Elm St", "Springfield", "IL", "62701", 30.00));
        customerList.add(new Customer("3", "Jordan", "Williams","3177982263","jordanwill@gmail.com","952 Bark Pl", "Desmoine", "IA", "25906", 40.00));
        
        customerTable.setItems(customerList);
        
            customerId.setCellValueFactory(new PropertyValueFactory<Customer,String>("customerId"));
            firstName.setCellValueFactory(new PropertyValueFactory<Customer,String>("firstName"));
            lastName.setCellValueFactory(new PropertyValueFactory<Customer,String>("lastName"));
            phoneNumber.setCellValueFactory(new PropertyValueFactory<Customer,String>("phoneNumber"));
            email.setCellValueFactory(new PropertyValueFactory<Customer,String>("email"));
            address.setCellValueFactory(new PropertyValueFactory<Customer,String>("address"));
            state.setCellValueFactory(new PropertyValueFactory<Customer,String>("state"));
            city.setCellValueFactory(new PropertyValueFactory<Customer,String>("city"));
            zipCode.setCellValueFactory(new PropertyValueFactory<Customer,String>("zipCode"));
            customerBalance.setCellValueFactory(new PropertyValueFactory<Customer,Double>("customerBalance"));
        

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

    // Customer Rents a game - If the game is available it will rent
    public static void rentGame(Customer customer, Game game) {
        if(!game.getStatus().equalsIgnoreCase("available"))
            System.out.println("This game is not available for rent.");
        else {
            game.setStatus("rented");
            game.setCurrentCustomer(customer);
            customer.setCustomerBalance(customer.getCustomerBalance() + 5.00);
            game.setDueDate(java.time.LocalDate.now().plusWeeks(1));
            System.out.println("Dear " + customer.getFirstName() + " " + customer.getLastName() +
                    ",\n    Thank you for choosing Rental Central.\nPlease return " + game.getName()
                    + " by " + game.getDueDate() + ". \nPlay on!");
        }
    }
    
    // Method to return a game
    public static void returnGame(Game game){
        game.setStatus("available");
        game.setCurrentCustomer(null);
        game.setDueDate(null);
        System.out.println("\nA copy of " + game.getName() + " for the " + game.getPlatform() +
                " is now available to rent.");
    }
    
    // Look for late games on a weekly basis and assess fees
    public static void assessLateFees(ArrayList<Game> gameList){        
        DecimalFormat df = new DecimalFormat("#.00");
        LocalDate today = java.time.LocalDate.now();
        System.out.println("Weekly Late Fee Assessment");
        for(Game games : gameList){
            if(games.getDueDate() != null){
                if(games.getDueDate().isBefore(today)){
                    games.getCurrentCustomer().setCustomerBalance(games.getCurrentCustomer().getCustomerBalance() + 20.0);
                    System.out.println("Customer account / " + games.getCurrentCustomer().getCustomerId() + " charged"                            
                            + " $20.00 / New balance $" + df.format(games.getCurrentCustomer().getCustomerBalance()));
                }
            }
        }
    }
    
    // Make a payment
    public static void makePayment(Customer customer){
        Scanner scan = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println("Your Balance is: $" + customer.getCustomerBalance() + 
                ". How much would you like to pay?\n");
        double payment = scan.nextDouble();
        String x = scan.nextLine();
        if(payment > customer.getCustomerBalance()){
            System.out.println("That amount will result in a credit on the "
                    + "account. Would you like to continue? Y or N\n");
            String answer = scan.nextLine();
            if(!answer.equalsIgnoreCase("y"))
                System.out.println("Payment Cancelled");
            else{
                customer.setCustomerBalance(customer.getCustomerBalance() -
                        payment);
                System.out.println("Payment Successful\nThe new account balance"
                        + " is: $" + df.format(customer.getCustomerBalance()));
            }
        }
        else{
            customer.setCustomerBalance(customer.getCustomerBalance() - payment);
            System.out.println("Payment Successful\nThe new account balance is: "
                    + "$" + df.format(customer.getCustomerBalance()));
        }
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
    
    // Platforms are: PC, Switch, Playstation, XBox, SNES, N64 
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
    
    public void presetGames(){
        
            Date date = new Date();
            System.out.println(date.toString());
            gameList.add(new Game("Smash Bros",
                                  date,
                                  game.generateGameId("Smash Bros", "Switch"),
                                   "Fighting" ,
                                    "E",
                                    "Switch",
                                    "Unavailable",
                                    customerList.get(0),
                                    LocalDate.now()));
                        gameList.add(new Game("Call of Duty",
                                  date,
                                  game.generateGameId("Call of Duty", "PS5"),
                                   "Shooter" ,
                                    "M",
                                    "PS5",
                                    "Unavailable",
                                    customerList.get(1),
                                    LocalDate.now()));
            
            //Game(String name, Date dateReceived, String gameId, String genre,
            //String rating, String platform, String status, Customer currentCustomer,
            //LocalDate dueDate)
        
            gameTable.setItems(gameList);
            
            gameId.setCellValueFactory(new PropertyValueFactory<Game,String>("gameId"));
            status.setCellValueFactory(new PropertyValueFactory<Game,String>("status"));
            name.setCellValueFactory(new PropertyValueFactory<Game,String>("name"));
            genre.setCellValueFactory(new PropertyValueFactory<Game,String>("genre"));
            platform.setCellValueFactory(new PropertyValueFactory<Game,String>("platform"));
            rating.setCellValueFactory(new PropertyValueFactory<Game,String>("rating"));
            dateReceived.setCellValueFactory(new PropertyValueFactory<Game,Date>("dateReceived"));
            dueDate.setCellValueFactory(new PropertyValueFactory<Game,LocalDate>("dueDate"));
            currentCustomer.setCellValueFactory(new PropertyValueFactory<Game,Customer>("currentCustomer"));
            
    }
    
    public void searchGames(){
            gameId.setCellValueFactory(new PropertyValueFactory<Game,String>("gameId"));
            status.setCellValueFactory(new PropertyValueFactory<Game,String>("status"));
            name.setCellValueFactory(new PropertyValueFactory<Game,String>("name"));
            genre.setCellValueFactory(new PropertyValueFactory<Game,String>("genre"));
            platform.setCellValueFactory(new PropertyValueFactory<Game,String>("platform"));
            rating.setCellValueFactory(new PropertyValueFactory<Game,String>("rating"));
            dateReceived.setCellValueFactory(new PropertyValueFactory<Game,Date>("dateReceived"));
            dueDate.setCellValueFactory(new PropertyValueFactory<Game,LocalDate>("dueDate"));
            currentCustomer.setCellValueFactory(new PropertyValueFactory<Game,Customer>("currentCustomer"));
            
            gameTable.setItems(gameList);
            
            FilteredList<Game> filteredGames = new FilteredList<>(gameList, b -> true);
            searchGame.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredGames.setPredicate(game -> {
                    if(newValue == null || newValue.isEmpty()){
                        return true;
                    }
                    String lowerCaseFilter = newValue.toLowerCase();
                    
                    if(game.getName().toLowerCase().indexOf(lowerCaseFilter) != -1){
                        return true;
                    }else if (game.getDateReceived().toString().toLowerCase().indexOf(lowerCaseFilter) != -1){
                        return true;
                    }else if (game.getGameId().toString().toLowerCase().indexOf(lowerCaseFilter) != -1){
                        return true;
                    }else if (game.getGenre().toLowerCase().indexOf(lowerCaseFilter) != -1){
                        return true;
                    }else if (game.getRating().toLowerCase().indexOf(lowerCaseFilter) != -1){
                        return true;
                    }else if (game.getPlatform().toLowerCase().indexOf(lowerCaseFilter) != -1){
                        return true;
                    }else if (game.getStatus().toLowerCase().indexOf(lowerCaseFilter) != -1){
                        return true;
                    }else if (game.getCurrentCustomer().toString().toLowerCase().indexOf(lowerCaseFilter) != -1){
                        return true;
                    }else if (game.getDueDate().toString().toLowerCase().indexOf(lowerCaseFilter) != -1){
                        return true;
                    }else{
                        return false;
                    }
                });
            });
            
            SortedList<Game> sortedGames = new SortedList<>(filteredGames);
            sortedGames.comparatorProperty().bind(gameTable.comparatorProperty());
            gameTable.setItems(sortedGames);
    }
    
    public void openAddGameGridPane(){
        addGameGridPane.setOpacity(1);
        addGameGridPane.setDisable(false);
        removeGameGridPane.setOpacity(0);
        removeGameGridPane.setDisable(true);
        gameSelect.setOpacity(0);
        gameSelect.setDisable(true);
    }
    
    public void addGame(){
        Date date = new Date();
        gameList.add(new Game(addGameName.getText(),
                              date,
                              game.generateGameId(addGameName.getText(),addGamePlatform.getText()),
                              addGameGenre.getText(),
                              addGameRating.getText(),
                              addGamePlatform.getText(),
                              "Available"));
        openSelector();
        
        Alert alert;
        
        Alert gameAddedAlert = new Alert(AlertType.INFORMATION);
        gameAddedAlert.setContentText(addGameName.getText() + " " + "successfully added!");
        gameAddedAlert.show();
    }
    
    public void openRemoveGameGridPane(){
        removeGameGridPane.setOpacity(1);
        removeGameGridPane.setDisable(false);
        addGameGridPane.setOpacity(0);
        addGameGridPane.setDisable(true);
        gameSelect.setOpacity(0);
        gameSelect.setDisable(true);
    }
    
    public void openSelector(){
        gameSelect.setOpacity(1);
        gameSelect.setDisable(false);
        addGameGridPane.setOpacity(0);
        addGameGridPane.setDisable(true);
        removeGameGridPane.setOpacity(0);
        removeGameGridPane.setDisable(true);
    }
    
    public void removeGame(){
        for(Game game : gameList){
            if(game.getGameId().equals(removeGameID.getText())){
                gameList.remove(game);
                    Alert gameRemovedAlert = new Alert(AlertType.INFORMATION);
                    gameRemovedAlert.setContentText(removeGameID.getText() + " " + "successfully removed!");
                    gameRemovedAlert.show();
                    openSelector();
            }
        }
        openSelector();

    }
    
    AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now){
                currentDateLabel.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM-dd-yyyy    HH:mm:ss a")));
            }
    };
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        currentDateLabel.setText(timeStamp); //sets text to date logged in
        presetCustomers();
        presetGames();
        searchGames();
        timer.start();

    } 

}
