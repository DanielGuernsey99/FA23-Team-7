// Team 7: Daniel Guernsey, Jennifer Rose, Jiya Stroder
// INFO-C211 Group Project
// November 2023
// Rental Central is a game rental company that acquires games for different
// gaming platforms and rents them out to customers. An object in the Game class
// will be created and tracked throughout its lifetime. When a customer is renting it
// the status will be 'rented', when it is returned the status will change to 'available'
// Game class by Jennifer Rose
// Appends by Jiya

package GroupProject;

import java.util.Date;

public class Game {
    
    private String name;
    private Date dateReceived;
    private String gameId;
    private String genre;
    private String rating;
    private String platform;
    private String status;
    
    // Default constructor with no args
    public Game(){
        this.name = "";
        this.dateReceived = new java.util.Date();
        this.gameId = "";
        this.genre = "";
        this.rating = "";
        this.platform = "";
        this.status = "";
    }
    
    // Constructor with all arguments
    public Game(String name, Date dateReceived, String gameId, String genre,
            String rating, String platform, String status){
        this.name = name;
        this.dateReceived = dateReceived;
        this.gameId = gameId;
        this.genre = genre;
        this.rating = rating;
        this.platform = platform;
        this.status = status;
    }
    
    // The next 14 methods are the getters and setters ----------
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
    // This is the end of getters and setters -------------------
    // ----------------------------------------------------------

    // This will be a method that is called to check and then change the rental status of a game
    public void updateStatus(){

    }

    // Every class should have a toString method
    @Override
    public String toString(){
        String output = "\nGame: " + this.name + "\nID: " + this.gameId
                + "\nDate acquired: " + this.dateReceived + "\nGenre: "
                + this.genre + "\nRating: " + this.rating + "\nPlatform: "
                + this.platform + "\nStatus: " + this.status + "\n";
        return output;
    }

    //Jiya's code from Discord
        // Existing fields...
    private String customerId; // New field

    // Existing constructors...

    // New constructor with customerId
    public Game(String name, Date dateReceived, String gameId, String genre, String rating, String platform, String status, String customerId){
        this.name = name;
        this.dateReceived = dateReceived;
        this.gameId = gameId;
        this.genre = genre;
        this.rating = rating;
        this.platform = platform;
        this.status = status;
        this.customerId = customerId; // Initialize new field
    }

    // Existing getters and setters...

    // New getter and setter for customerId
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    // Existing methods...

    // New method to rent a game
    public void rentGame(String customerId) {
        if (this.status.equals("available")) {
            this.status = "rented";
            this.customerId = customerId;
        } else {
            System.out.println("This game is not available for rent.");
        }
    }

    // Existing toString method...
}
}
