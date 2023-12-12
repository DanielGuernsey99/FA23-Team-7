# Rental Central
Team 7: Daniel Guernsey, Jennifer Rose, Jiya Stroder

Rental Central is a software tool used by employees of the rental company. It will house information on customers and an inventory of games. The system will track rentals with opperations to rent and return games. It will calculate return dates and notify customers of those dates. It will assess late fees if games are not returned before they are due. It will accept payments on customer accounts. There are search functions for various attributes by customer and by game, such as game rating, genre, rental status, and console compatibility. Searches can be performed on customers as well. Full lists of customers and games may be printed.

OBJECTS IN THE SYSTEM:
Customer Class by Jiya Stroder & Jennifer Rose
  Attributes
  - Customer Id
  - First Name
  - Last Name
  - Phone Number
  - Email Address
  - Street Address
  - City
  - State
  - Zip code
  Functions
  - Customer ID generator

Game Class by Jennifer Rose
  Attributes
  - Name
  - Date acquired by the store
  - Game Id
  - Genre
  - Rating
  - Platform
  - Status
  - Current Customer
  - Due Date
  Functions
  - Game ID generator

Graphic User Interface by Daniel Guernsey
  - Dashboard Controller
  - Sample Controller
  - Logins Hashmap
      - admin     1234
      - dguernsey Daniel2023
      - Jrose     Jennifer2023
      - Jstroder  Jiya2023
  - Cascading Style Sheets
  - Images
  - Gifs
  - FXML Code

Rental Central Functions
  - printCustomerList
  - printGameList
  - createCustomer
  - newGameToInventory
  - rentGame
  - returnGame
  - assessLateFees
  - makePayment
  - searchCustomerListByName
  - searchCustomerListByCustomerId
  - searchByGameId
  - searchByGameName
  - searchGameByCustomerId
  - searchGamesByStatus
  - searchAvailableByPlatform
  - searchAllByRating
  - searchAllByGenre

CODE LOCATION:
GitHub
https://github.com/DanielGuernsey99/Rental-Central
        
List of contributors in GitHub:
    Jennifer Rose:  Niffinator
    Daniel Guernsey: DanielGuernsey99
    Jiya Stroder: JStrod

TO RUN IN NETBEANS ON WINDOWS:
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
8. Delete some of the files the project created:
   - Primary.fxml
   - Secondary.fxml
   - PrimaryController.java / safely delete & refactor
   - SecondaryController.java / safely delete & refactor
10. Move files from File Explorer into the project folders
   - files ending in  .java should be moved into the package under 'Source Packages'
       - Customer
       - DashboardController
       - Game
       - Logins
       - RentalCentral
       - SampleController     
   - files ending in  .fxml  .css  .gif  .png  should be moved into the package under 'Other Sources'
       - loginDesign
       - logo-game-controller-2
       - logout
       - RentalCentralDashboard
       - sample
   - files ending in  .txt  .md  can be moved into the package under 'Source Packages' or 'Other Sources'

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
5. Go back to App.java
   - Change name of Class from "RentalCentral" to "App"


**TO RUN WITH GUI (this will be the default when the files are downloaded)
![image](https://github.com/DanielGuernsey99/Rental-Central/assets/146021903/2c6dcb0b-9b14-45db-aa64-8165147a9c81)


**TO RUN WITHOUT GUI (comment out the launch function and un comment the others)
![image](https://github.com/DanielGuernsey99/Rental-Central/assets/146021903/383f764a-1fd2-4779-ab33-4b6f6c62e3bb)
![image](https://github.com/DanielGuernsey99/Rental-Central/assets/146021903/3fdd80f1-c8e4-4977-9fcb-cf1b232c1969)


JAR BUILT
![image](https://github.com/DanielGuernsey99/Rental-Central/assets/146021903/07e5649c-baa4-473b-a775-1870fa80a972)



EXTERNAL SOURCES:
1. For due date calculation | https://stackoverflow.com/questions/3300328/add-1-week-to-a-date-which-way-is-preferred
2. To find and ignore spaces in Strings | https://stackoverflow.com/questions/7815713/finding-spaces-newlines-and-tabs-with-charat
3. To replace all space in Strings | https://stackoverflow.com/questions/15633228/how-to-remove-all-white-spaces-in-java
4. To manually configure a LocalDate | https://www.baeldung.com/java-creating-localdate-with-values
5. To compare dates of different Date, LocalDate classes | https://stackoverflow.com/questions/56161066/comparing-two-dates-from-different-format
