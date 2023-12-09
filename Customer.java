package RentalCentral;

import java.time.LocalDate;
import java.time.LocalTime;

public class Customer {
    private String customerId;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private double customerBalance;

    // need an id generator first 4 letters of last name + counter of numbers

    // default constructor with no parameters
    public Customer() {
        this.customerId = "";
	this.firstName = "";
	this.lastName = "";
	this.address = "";
	this.city = "";
	this.state = "";
	this.zipCode = "";
	this.customerBalance = 0.0;
    }

    // constructor with parameters
    public Customer(String customerId, String firstName, String lastName, String address,
            String city, String state, String zipCode, double customerBalance) {
        this.customerId = customerId;
	this.firstName = firstName;
	this.lastName = lastName;
        this.address = address;
	this.city = city;
	this.state = state;
	this.zipCode = zipCode;
	this.customerBalance = customerBalance;
    }

    //**************Below are the getters and setters***************
    public String getCustomerId(){
        return customerId;
    }
    
    public void setCustomerId(String customerId){
        this.customerId = customerId;
    }    
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName){
	this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getState(){
        return state;
    }

    public void setState(String state){
        this.state = state;
    }

    public String getZipCode(){
        return zipCode;
    }

    public void setZipCode(String zipCode){
        this.zipCode = zipCode;
    }

    public double getCustomerBalance() {
        return customerBalance;
    }

    public void setCustomerBalance(double customerBalance){
        this.customerBalance = customerBalance;
    }
    //**************END OF THE getters and setters***************
    
    
    // ID Generator
    public String generateId(String lastName){
        String id;
        String alt = "rent";
        String number = String.valueOf(LocalTime.now());
        char n1, n2, n3, n4, n5, n6, n7, n8;
        n1 = alt.charAt(0);
        n2 = alt.charAt(1);
        n3 = alt.charAt(2);
        n4 = alt.charAt(3);
        n5 = number.charAt(0);
        n6 = number.charAt(1);
        n7 = number.charAt(3);
        n8 = number.charAt(4);
        
        if(lastName.isEmpty()){
            n1 = alt.charAt(0);
            n2 = alt.charAt(1);
            n3 = alt.charAt(2);
            n4 = alt.charAt(3);
        }
        if(lastName.length() == 1){
            n1 = lastName.charAt(0);
            n2 = lastName.charAt(0);
            n3 = lastName.charAt(0);
            n4 = lastName.charAt(0);
        }
        if(lastName.length() == 2){
            n1 = lastName.charAt(0);
            n2 = lastName.charAt(1);
            n3 = lastName.charAt(0);
            n4 = lastName.charAt(1);
        }
        if(lastName.length() == 3){
            n1 = lastName.charAt(0);
            n2 = lastName.charAt(1);
            n3 = lastName.charAt(2);
            n4 = lastName.charAt(0);
        }
        if(lastName.length() >= 4){            
            n1 = lastName.charAt(0);
            n2 = lastName.charAt(1);
            n3 = lastName.charAt(2);
            n4 = lastName.charAt(3);
        }
        id = String.valueOf(n1) + String.valueOf(n2) + String.valueOf(n3)
                + String.valueOf(n4) + String.valueOf(n5) + String.valueOf(n6)
                + String.valueOf(n7) + String.valueOf(n8);
        return id;
    }
    
    // this method will notify the customer of an item that is due by a certain date
    public void notifyReturnDate() {
        System.out.println("Dear " + this.firstName + " " + this.lastName +
                ",\n Please return by. Thank you.");
    }

    // Every class needs a toString method
    @Override
    public String toString(){
        String output = "\nCustomer ID: " + this.customerId + "\nCustomer name: " + this.firstName + " "
            + this.lastName + "\nCustomer Address: " + this.address + ", " + this.city + ", " + this.state
            + "  " + this.zipCode + "\nBalance: $" + this.getCustomerBalance() + "\n";
        return output;
    }
}
