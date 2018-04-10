/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package birds;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Christine Kim
 */
public class AlertController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
     
    @FXML public Label error;
   
    public void setAlertText(String text) {
        // set text from another class
        error.setText(text);
    } 
private void displayAlert(String msg) {
       /* try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Alert.fxml"));
            Parent ERROR = loader.load();
            AlertController controller = (AlertController) loader.getController();

            Scene scene = new Scene(ERROR);
            Stage stage = new Stage();
            stage.setScene(scene);

            stage.getIcons().add(new Image("file:src/iPAYROLL/WesternLogo.png"));
            controller.setAlertText(msg);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();

        } catch (IOException ex1) {

        }*/
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      
    }    
    //have a textbox that displays the error when needed
    
    
}
