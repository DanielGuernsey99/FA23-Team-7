# Rental Central

Brief description of the project:
    Rental Central provides a rental service for gamers to rent or buy games. A timeline for rent is provided upon rent. After a specific amount of time, the renter is charged an overdue fee. Collecting information
    about the user is essential to keep a renter accountable. 
    -Name of the Game
    -Name of the Renter
    -Address of the Renter
    -Age of the Renter
    -Quantity
    -Rating E,T,M,Ao,etc
    -Game Sharing
    -Game Exchange
    -Lending Time
    -Overdue Cost
    -General Cost
    -Merchant Service
        -Card information
    -Genre
    -Platform
    -Access Codes
    -Game inventory
    
Code Ideas:
    -Quick Test
    -Creating New Users
    -Hardcoded Users for testing purposes
    -Searching for Users
    -Refresh stock
    -Animations?
        -Text Art
        
List of contributors:
    Jennifer Rose:  Niffinator
    Daniel Guernsey: DanielGuernsey99
    Jiya Stroder: JStrod

Classes Created:
Customer Class: Jiya Stroder, JStrod
    
Submit the link to my gitAccount and the link to the project in the assignment link in Canvas.


To Run in NetBeans on Windows:
1. Download files from GitHub
2. Open File Explorer
3. Extract All from the zip file in Downloads
4. Open NetBeans
5. Create a new project:
   - Java with Maven --> FXML JavaFX Maven Archetype (Gluon)
   - Next
   - Project Name: RentalCentral
   - Package: RentalCentral
   - Finish
7. Expand the following folders in the new project:
   - RentalCentral Project
     - Source Packages Folder
       - RentalCentral Package
     - Other Sources Folder
       - src/main/resources/ Folder
         - RentalCentral Package
8. Move files from File Explorer into the project folders
   - files ending in  .java should be moved into the package under 'Source Packages'
       - Customer
       - DashboardController
       - Game
       - RentalCentral
       - SampleController     
   - files ending in  .fxml  .css  .gif  .png  should be moved into the package under 'Other Sources'
       - loginDesign
       - logo-game-controller-2
       - logout
       - RentalCentralDashboard
       - sample
   - files ending in  .txt  .md  can be moved into the package under 'Source Packages'
**An App file will have been created by the new project, it needs to be altered
1. In NetBeans open the two java files containing main methods
   - App.java       
   - RentalCentral.java
2. Highlight all of the content in App.java
   - Delete it
3. Highlight all of the content in RentalCentral.java
   - Copy it
   - Paste it into App.java
4. Go back to RentalCentral.java
   - Comment out the whole selection
   - Uncomment
       - End Curly brace
       - Class signature
       - Delete "extends Application" from Class signature
       - Package
5. Go back to App.java
   - Change name of Class from "RentalCentral" to "App"
      
      


EXTERNAL SOURCES:
1. For due date calculation | https://stackoverflow.com/questions/3300328/add-1-week-to-a-date-which-way-is-preferred
2. To find and ignore spaces in Strings | https://stackoverflow.com/questions/7815713/finding-spaces-newlines-and-tabs-with-charat
3. To replace all space in Strings | https://stackoverflow.com/questions/15633228/how-to-remove-all-white-spaces-in-java
4. To manually configure a LocalDate | https://www.baeldung.com/java-creating-localdate-with-values
5. To compare dates of different Date, LocalDate classes | https://stackoverflow.com/questions/56161066/comparing-two-dates-from-different-format
