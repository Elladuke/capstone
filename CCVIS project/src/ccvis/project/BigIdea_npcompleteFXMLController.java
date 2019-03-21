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
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Immanuella Duke
 */
public class BigIdea_npcompleteFXMLController implements Initializable {

    @FXML
    private Button types_next_btn;
    @FXML
    private Button exit_btn;
    @FXML
    private Button types_back_btn1;

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
    private void goto_bigidea_nphard(ActionEvent event) throws IOException {
         Stage stagea = (Stage) exit_btn.getScene().getWindow();
       stagea.close();
     
    //open the next stage - introintrofxml
        FXMLLoader fxmlLoader = new 
        FXMLLoader(getClass().getResource("BigIdea_nphardFXML.fxml"));
        Parent root1 = (Parent) fxmlLoader.load( );
        
        Stage stage = new Stage();
        //set what you want on your stage
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Understanding NP-hard complexity");
        stage.setScene(new Scene(root1));
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void goto_bigidea_npprob(ActionEvent event) throws IOException {
         Stage stagea = (Stage) exit_btn.getScene().getWindow();
       stagea.close();
     
    //open the next stage - introintrofxml
        FXMLLoader fxmlLoader = new 
        FXMLLoader(getClass().getResource("BIgIdea_npproblemFXML.fxml"));
        Parent root1 = (Parent) fxmlLoader.load( );
        
        Stage stage = new Stage();
        //set what you want on your stage
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Understanding NP complexity");
        stage.setScene(new Scene(root1));
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void goto_npreduc(MouseEvent event) throws IOException {
         Stage stagea = (Stage) exit_btn.getScene().getWindow();
       stagea.close();
     
    //open the next stage - introintrofxml
        FXMLLoader fxmlLoader = new 
        FXMLLoader(getClass().getResource("NPReduction.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        //set what you want on your stage
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("NP-problem Reduction");
        stage.setScene(new Scene(root1));
        stage.setResizable(false);
        stage.show();
    }
    
}
