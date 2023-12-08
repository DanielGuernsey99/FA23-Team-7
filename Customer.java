//testing a new branch - this is customer in jennifer branch
package GroupProject;

import java.time.LocalDate;

public class Customer {
    private int customerId;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private double customerBalance;

    // need an id generator

    // default constructor with no parameters
    public Customer() {
        this.customerId = 0;
	this.firstName = "";
	this.lastName = "";
	this.address = "";
	this.city = "";
	this.state = "";
	this.zipCode = "";
	this.customerBalance = 0.0;
    }

    // constructor with parameters
    public Customer(int customerId, String firstName, String lastName, String address,
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
            + "  this.zipCode\n";
        return output;
    }
}
