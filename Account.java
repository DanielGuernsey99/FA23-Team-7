/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package learn;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author jackg
 */
public class Account {
        protected Customer customer;
        protected String accountNumber;
        protected Date dateOpened;
        protected double balance;

        public Account() {
            this.customer = null;
            this.accountNumber = "";
            this.dateOpened = new java.util.Date();
            this.balance = 0.0;
        }

        public Account(Customer customer, String accountNumber, Date dateOpened, double balance) {
            this.customer = customer;
            this.accountNumber = accountNumber;
            this.dateOpened = new java.util.Date();
            this.balance = balance;
        }

        public Customer getCustomer() {
            return customer;
        }

        public void setCustomer(Customer customer) {
            this.customer = customer;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public void setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
        }

        public Date getDateOpened() {
            return dateOpened;
        }

        public void setDateOpened(Date dateOpened) {
            this.dateOpened = dateOpened;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        @Override
        public String toString() {
            DecimalFormat df = new DecimalFormat("#.00");
            String output = "\n" + this.customer + "\nAccount Number: " + this.accountNumber + "\nDate opened: " +
                    this.dateOpened + "\nCurrent balance: $" + df.format(this.balance) + "\n";
            return output;
        }
}
