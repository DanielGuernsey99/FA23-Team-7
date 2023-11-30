package RentalCentral;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;


public class DashboardController {
    
    @FXML
    private Text HelloLabel;

    @FXML
    private Button close;
    
    
    public void close(){
        System.exit(0);
    }
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 

}
