package RentalCentral;

import java.util.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.lang.*;

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
        String number = String.valueOf(LocalTime.now());
        String nm = name.replaceAll(" ", "");
        String plat = platform.replaceAll(" ","");
        if(nm.isEmpty())
            nm = "game";
        if(nm.length() == 1)
            nm = nm + nm + nm + nm;
        if(nm.length() == 2)
            nm = nm + nm;
        if(nm.length() == 3)
            nm = nm + nm.charAt(0);        
        if(plat.isEmpty())
            plat = "plt";
        if(plat.length() == 1)
            plat = plat + "xx";
        if(plat.length() == 2)
            plat = plat + "x";        
        char n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11;
        n1 = nm.charAt(0);
        n2 = nm.charAt(1);
        n3 = nm.charAt(2);
        n4 = nm.charAt(3);
        n5 = number.charAt(0);
        n6 = number.charAt(1);
        n7 = number.charAt(3);
        n8 = number.charAt(4);
        n9 = plat.charAt(0);
        n10 = plat.charAt(1);
        n11 = plat.charAt(2);        
        id = String.valueOf(n1) + String.valueOf(n2) + String.valueOf(n3)
                + String.valueOf(n4) + String.valueOf(n5) + String.valueOf(n6)
                + String.valueOf(n7) + String.valueOf(n8) + String.valueOf(n9)
                + String.valueOf(n10) + String.valueOf(n11);
        return id;
    }
}
