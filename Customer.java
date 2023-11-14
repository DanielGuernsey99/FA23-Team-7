import java.time.LocalDate;

public class Customer {
    private String name;
    private String address;
    private int gameId;
    private String rentalStatus;
    private LocalDate returnDate;

    public Customer(String name, String address, int gameId, String rentalStatus, LocalDate returnDate) {
        this.name = name;
        this.address = address;
        this.gameId = gameId;
        this.rentalStatus = rentalStatus;
        this.returnDate = returnDate;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getGameId() {
        return gameId;
    }

    public String getRentalStatus() {
        return rentalStatus;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public void setAddress(String address) {
    	this.address = address;
    }
    
    public void setGameId(int gameId) {
    	this.gameId = gameId;
    }

    public void setRentalStatus(String rentalStatus) {
        this.rentalStatus = rentalStatus;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public void notifyReturnDate() {
        System.out.println("Dear " + name + ", please return game ID: " + gameId + " by " + returnDate);
    }
}
