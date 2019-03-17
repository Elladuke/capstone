/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccvis.project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Immanuella Duke
 */
public class ExerciseFiveFXMLController implements Initializable {

    @FXML
    private Button exit_btn;
    @FXML
    private Button next_btn1;
    @FXML
    private RadioButton ck1;
    @FXML
    private RadioButton ck2;
    @FXML
    private RadioButton ck3;
    @FXML
    private Label ans;
    @FXML
    private ToggleGroup blue;
    @FXML
    private Button next_btn11;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void exit(ActionEvent event) {
        Stage stagea = (Stage) exit_btn.getScene().getWindow();
       stagea.close();
    }

    @FXML
    private void clicked_1(ActionEvent event) {
        if(ck1.isSelected() ){
            ans.setText("This is impossible! Try again" );
        }
    }

    @FXML
    private void clicked_2(ActionEvent event) {
        if(ck2.isSelected() ){
            ans.setText("Correct!" );
        }
    }

    @FXML
    private void clicked_3(ActionEvent event) {
        if(ck3.isSelected() ){
            ans.setText("You should try solving it!" );
        }
    }

    @FXML
    private void goto_exercise_four(ActionEvent event) throws IOException {
        Stage stagea = (Stage) exit_btn.getScene().getWindow();
       stagea.close();
     
    //open the next stage - introintrofxml
        FXMLLoader fxmlLoader = new 
        FXMLLoader(getClass().getResource("ExerciseFourFXML.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        //set what you want on your stage
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Exercise Four");
        stage.setScene(new Scene(root1));
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void finish(ActionEvent event) {
        
        Stage stagea = (Stage) exit_btn.getScene().getWindow();
       stagea.close();
    }
    
}
