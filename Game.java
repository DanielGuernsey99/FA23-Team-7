// Team 7: Daniel Guernsey, Jennifer Rose, Jiya Stroder
// INFO-C211 Group Project
// November 2023
// Rental Central is a game rental company that acquires games for different
// gaming platforms and rents them out to customers. An object in the Game class
// will be created and tracked throughout its lifetime. When a customer is renting it
// the status will be 'rented', when it is returned the status will change to 'available'
// Game class by Jennifer Rose
// Appends by Jiya

package RentalCentral;

import java.util.Date;
import java.time.LocalDate;
import java.time.LocalTime;

public class Game {
    
    private String name;
    private Date dateReceived;
    private String gameId;
    private String genre;
    private String rating;
    private String platform;
    private String status;
    private Customer currentCustomer;
    private LocalDate dueDate;
    
    // Default constructor with no args
    public Game(){
        this.name = "";
        this.dateReceived = new java.util.Date();
        this.gameId = "";
        this.genre = "";
        this.rating = "";
        this.platform = "";
        this.status = "";
        this.currentCustomer = null;
        this.dueDate = null;
    }
    
    // Constructor with all arguments
    public Game(String name, Date dateReceived, String gameId, String genre,
            String rating, String platform, String status, Customer currentCustomer,
            LocalDate dueDate){
        this.name = name;
        this.dateReceived = dateReceived;
        this.gameId = gameId;
        this.genre = genre;
        this.rating = rating;
        this.platform = platform;
        this.status = status;
        this.currentCustomer = currentCustomer;
        this.dueDate = dueDate;
    }
    
    // Constructor for game with no current renter
        public Game(String name, Date dateReceived, String gameId, String genre,
            String rating, String platform, String status){
        this.name = name;
        this.dateReceived = dateReceived;
        this.gameId = gameId;
        this.genre = genre;
        this.rating = rating;
        this.platform = platform;
        this.status = status;
        this.currentCustomer = null;
        this.dueDate = null;
    }
        
    // The next methods are the getters and setters ----------
    // ----------------------------------------------------------
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public Date getDateReceived(){
        return dateReceived;
    }
    
    public void setDateReceived(Date dateReceived){
        this.dateReceived = dateReceived;
    }
    
    public String getGameId(){
        return gameId;
    }
    
    public void setGameId(String gameId){
        this.gameId = gameId;
    }
    
    public String getGenre(){
        return genre;
    }
    
    public void setGenre(String genre){
        this.genre = genre;
    }
    
    public String getRating(){
        return rating;
    }
    
    public void setRating(String rating){
        this.rating = rating;
    }
    
    public String getPlatform(){
        return platform;
    }
    
    public void setPlatform(String platform){
        this.platform = platform;
    }
    
    public String getStatus(){
        return status;
    }
    
    public void setStatus(String status){
        this.status = status;      
    }
    
    public Customer getCurrentCustomer(){
        return currentCustomer;
    }
    
    public void setCurrentCustomer(Customer currentCustomer){
        this.currentCustomer = currentCustomer;
    }
    
    public LocalDate getDueDate(){
        return dueDate;
    }
    
    public void setDueDate(LocalDate dueDate){
        this.dueDate = dueDate;
    }    
    // This is the end of getters and setters -------------------
    // ----------------------------------------------------------


    // Every class should have a toString method
    @Override
    public String toString(){
        String output;
        
        if (this.status.equalsIgnoreCase("rented")){
            output = "\nGame: " + this.name + "\nID: " + this.gameId
                + "\nDate acquired: " + this.dateReceived + "\nGenre: "
                + this.genre + "\nRating: " + this.rating + "\nPlatform: "
                + this.platform + "\nStatus: " + this.status + "\nCurrently held by customer: "
                + this.currentCustomer.getLastName() + "\nExpected Return Date: "
                + this.dueDate + "\n";
        }else{
            output = "\nGame: " + this.name + "\nID: " + this.gameId
                + "\nDate acquired: " + this.dateReceived + "\nGenre: "
                + this.genre + "\nRating: " + this.rating + "\nPlatform: "
                + this.platform + "\nStatus: " + this.status + "\n";
        }        
        return output;
    }
    
    // Game ID Generator
    public String generateGameId(String name, String platform){
        String id;
        String alt = "game";
        String number = String.valueOf(LocalTime.now());
        char n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11;
        n1 = alt.charAt(0);
        n2 = alt.charAt(1);
        n3 = alt.charAt(2);
        n4 = alt.charAt(3);
        n5 = number.charAt(0);
        n6 = number.charAt(1);
        n7 = number.charAt(3);
        n8 = number.charAt(4);
        n9 = platform.charAt(0);
        n10 = platform.charAt(1);
        n11 = platform.charAt(2);
               
        if(name.isEmpty()){
            n1 = alt.charAt(0);
            n2 = alt.charAt(1);
            n3 = alt.charAt(2);
            n4 = alt.charAt(3);
        }
        if(name.length() == 1){
            n1 = name.charAt(0);
            n2 = name.charAt(0);
            n3 = name.charAt(0);
            n4 = name.charAt(0);
        }
        if(name.length() == 2){
            n1 = name.charAt(0);
            n2 = name.charAt(1);
            n3 = name.charAt(0);
            n4 = name.charAt(1);
        }
        if(name.length() == 3){
            n1 = name.charAt(0);
            n2 = name.charAt(1);
            n3 = name.charAt(2);
            n4 = name.charAt(0);
        }
        if(name.length() >= 4){            
            n1 = name.charAt(0);
            n2 = name.charAt(1);
            n3 = name.charAt(2);
            n4 = name.charAt(3);
        }
        if(platform.isEmpty()){
            n9 = alt.charAt(0);
            n10 = alt.charAt(1);
            n11 = alt.charAt(2);
        }
        if(platform.length() == 1){
            n9 = platform.charAt(0);
            n10 = platform.charAt(0);
            n11 = platform.charAt(0);
        }
        if(platform.length() == 2){
            n9 = platform.charAt(0);
            n10 = platform.charAt(1);
            n11 = platform.charAt(0);
        }
        if(platform.length() >= 3){
            n9 = platform.charAt(0);
            n10 = platform.charAt(1);
            n11 = platform.charAt(2);
        }
        
        id = String.valueOf(n1) + String.valueOf(n2) + String.valueOf(n3)
                + String.valueOf(n4) + String.valueOf(n5) + String.valueOf(n6)
                + String.valueOf(n7) + String.valueOf(n8) + String.valueOf(n9)
                + String.valueOf(n10) + String.valueOf(n11);
        return id;
    }

    // New method to rent a game
    // If the game is available it will rent, if it is not
    // available then it is either rented or late
    public void rentGame(Customer customer) {
        if (this.status.equals("available")) {
            setStatus("rented");
            setCurrentCustomer(customer);
            customer.setCustomerBalance(customer.getCustomerBalance() + 4.99 );
            setDueDate(java.time.LocalDate.now().plusWeeks(1));            
        } else {
            System.out.println("This game is not available for rent.");
        }
    }
    
    // Method to return a game
    public void returnGame(){
        setStatus("available");
        setCurrentCustomer(null);
        setDueDate(null);
    }
}
