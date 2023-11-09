
package learn;

public class RentalCentral extends javax.swing.JFrame {


    public RentalCentral() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Celsius Converter");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Celsius");

        jButton1.setText("Convert");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Farenheit");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addContainerGap(615, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jTextField1});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel2))
                .addContainerGap(382, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            int tempFahr = (int)((Double.parseDouble(jTextField1.getText()))
            * 1.8 + 32);
            jLabel2.setText(tempFahr + " Fahrenheit");
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RentalCentral().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}

class Customer {
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

        public String toString() {
            String output = "Customer Name: " + this.firstName + " " + this.lastName + "\nAddress: " + this.streetAddress +
                    ", " + this.cityAddress + ", " + this.stateAddress + "\nCustomer ID: " + this.customerId + "\n";
            return output;
        }
    }


//====================================================

    class Account {

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

        public String toString() {
            DecimalFormat df = new DecimalFormat("#.00");
            String output = "\n" + this.customer + "\nAccount Number: " + this.accountNumber + "\nDate opened: " +
                    this.dateOpened + "\nCurrent balance: $" + df.format(this.balance) + "\n";
            return output;
        }
    }
