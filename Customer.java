package RentalCentral;

import java.util.Random;
import java.time.LocalDate;
import java.time.LocalTime;
import java.text.DecimalFormat;
import java.lang.*;

public class Customer {
    private String customerId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private double customerBalance;

    // default constructor with no parameters
    public Customer() {
        this.customerId = "";
	this.firstName = "";
	this.lastName = "";
        this.phoneNumber = "";
        this.email = "";
	this.address = "";
	this.city = "";
	this.state = "";
	this.zipCode = "";
	this.customerBalance = 0.0;
    }

    // constructor with parameters
    public Customer(String customerId, String firstName, String lastName, String phoneNumber,
            String email, String address, String city, String state, String zipCode, double customerBalance){
        this.customerId = customerId;
	this.firstName = firstName;
	this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
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
    
    public String getPhoneNumber(){
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
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
        
    // Customer ID Generator
    public String generateId(String lastName){
        String id;
        String number = String.valueOf(LocalTime.now());
        String ln = lastName.replaceAll(" ","");
        if(ln.isEmpty())
            ln = "cust";
        if(ln.length() == 1)
            ln = ln + ln + ln + ln;
        if(ln.length() == 2)
            ln = ln + ln;
        if(ln.length() == 3)
            ln = ln + ln.charAt(0);
        char n1, n2, n3, n4, n5, n6, n7, n8;
        n1 = ln.charAt(0);
        n2 = ln.charAt(1);
        n3 = ln.charAt(2);
        n4 = ln.charAt(3);
        n5 = number.charAt(0);
        n6 = number.charAt(1);
        n7 = number.charAt(3);
        n8 = number.charAt(4);        
        id = String.valueOf(n1) + String.valueOf(n2) + String.valueOf(n3)
                + String.valueOf(n4) + String.valueOf(n5) + String.valueOf(n6)
                + String.valueOf(n7) + String.valueOf(n8);
        return id;
    }
    
    // Every class needs a toString method
    @Override
    public String toString(){
        DecimalFormat df = new DecimalFormat("#.00");
        String output = "\nCustomer ID: " + this.customerId + "\nCustomer name: " + this.firstName + " "
                + this.lastName + "\nCustomer Phone: " + this.phoneNumber + "Customer Email: " + this.email
                + "\nCustomer Address: " + this.address + ", " + this.city + ", " + this.state
                + "  " + this.zipCode + "\nBalance: $" + df.format(this.customerBalance) + "\n";
        return output;
    }
}
