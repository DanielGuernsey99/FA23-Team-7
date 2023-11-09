/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package learn;

/**
 *
 * @author jackg
 */
public class Customer {
    protected String firstName;
        protected String lastName;
        protected String streetAddress;
        protected String cityAddress;
        protected String stateAddress;
        protected String customerId;

        public Customer() {
            this.firstName = "";
            this.lastName = "";
            this.streetAddress = "";
            this.cityAddress = "";
            this.stateAddress = "";
            this.customerId = "";
        }

        public Customer(String firstName, String lastName, String streetAddress, String cityAddress, String stateAddress, String customerId) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.streetAddress = streetAddress;
            this.cityAddress = cityAddress;
            this.stateAddress = stateAddress;
            this.customerId = customerId;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getStreetAddress() {
            return streetAddress;
        }

        public void setStreetAddress(String streetAddress) {
            this.streetAddress = streetAddress;
        }

        public String getCityAddress() {
            return cityAddress;
        }

        public void setCityAddress(String cityAddress) {
            this.cityAddress = cityAddress;
        }

        public String getStateAddress() {
            return stateAddress;
        }

        public void setStateAddress(String stateAddress) {
            this.stateAddress = stateAddress;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

    @Override
        public String toString() {
            String output = "Customer Name: " + this.firstName + " " + this.lastName + "\nAddress: " + this.streetAddress +
                    ", " + this.cityAddress + ", " + this.stateAddress + "\nCustomer ID: " + this.customerId + "\n";
            return output;
        }
}
