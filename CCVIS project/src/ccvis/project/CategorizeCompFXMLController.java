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
import javafx.event.EventHandler;
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
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Immanuella Duke
 */
public class CategorizeCompFXMLController implements Initializable {

    @FXML
    private MenuBar menu_bar;
    @FXML
    private MenuItem welcome_id;
    @FXML
    private Menu menu_animation;
    @FXML
    private Menu menu_reduction;
    @FXML
    private Menu menu_exercise;
    @FXML
    private Button exit_btn;
    @FXML
    private Ellipse pprob_id;
   // @FXML
   // private Ellipse npprob_id;
    @FXML
    private Label np_Prob;
    @FXML
    private Label ham_lab;
    @FXML
    private Label cnf3;
    @FXML
    private Label bin_lab2;
    @FXML
    private Label knap_lab3;
    @FXML
    private Label np_Prob1;
    @FXML
    private Label np_Prob2;
    @FXML
    private Label np_Prob3;
    @FXML
    private Ellipse ham_ellip;
    @FXML
    private Ellipse cnf_eliip;
    @FXML
    private Ellipse bin_ellip;
    @FXML
    private Ellipse knap_ellip;
    @FXML
    private Ellipse npprob_id;
    @FXML
    private Label p_Prob1;
    @FXML
    private Label p_Prob3;
    @FXML
    private Label p_Prob2;
    @FXML
    private Ellipse mcol_ellip;
    @FXML
    private Ellipse linprog_ellip;
    @FXML
    private Ellipse gcd_ellip;
    @FXML
    private Label mcol_lab;
    @FXML
    private Label gcd_lab;
    @FXML
    private Label linprog_lab;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void goto_welcome(ActionEvent event) throws IOException {
    Stage stagea = (Stage) exit_btn.getScene().getWindow();
       stagea.close();
     
    //open the next stage - introintrofxml
        FXMLLoader fxmlLoader = new 
        FXMLLoader(getClass().getResource("IntroPageFXML.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        //set what you want on your stage
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("CCVisu Visualization system");
        stage.setScene(new Scene(root1));
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void goto_introintro(ActionEvent event) throws IOException {
    //close current stage
       Stage stagea = (Stage) exit_btn.getScene().getWindow();
       stagea.close();
     
    //open the next stage - introintrofxml
        FXMLLoader fxmlLoader = new 
        FXMLLoader(getClass().getResource("IntrointroFXML.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        //set what you want on your stage
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Computational Complexity");
        stage.setScene(new Scene(root1));
        stage.setResizable(false);
        stage.show();
    }

    private void goto_intro_types(ActionEvent event) throws IOException {
    Stage stagea = (Stage) exit_btn.getScene().getWindow();
       stagea.close();
     
    //open the next stage - introintrofxml
        FXMLLoader fxmlLoader = new 
        FXMLLoader(getClass().getResource("introtypesFXML.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        //set what you want on your stage
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Types of Complexity");
        stage.setScene(new Scene(root1));
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void goto_pproblem(ActionEvent event) throws IOException {
    //close current stage
       Stage stagea = (Stage) exit_btn.getScene().getWindow();
       stagea.close();
     
    //open the next stage - introintrofxml
        FXMLLoader fxmlLoader = new 
        FXMLLoader(getClass().getResource("Animationone.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        //set what you want on your stage
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("P-problem animation");
        stage.setScene(new Scene(root1));
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void goto_npproblem(ActionEvent event) throws IOException {
    Stage stagea = (Stage) exit_btn.getScene().getWindow();
       stagea.close();
     
    //open the next stage - introintrofxml
        FXMLLoader fxmlLoader = new 
        FXMLLoader(getClass().getResource("Animationtwo.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        //set what you want on your stage
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("NP-problem animation");
        stage.setScene(new Scene(root1));
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void goto_pproblemreduc(ActionEvent event) throws IOException {
    Stage stagea = (Stage) exit_btn.getScene().getWindow();
       stagea.close();
     
    //open the next stage - introintrofxml
        FXMLLoader fxmlLoader = new 
        FXMLLoader(getClass().getResource("PReduction.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        //set what you want on your stage
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("P-problem Reduction");
        stage.setScene(new Scene(root1));
        stage.setResizable(false);
        stage.show();
    }


    @FXML
    private void goto_exercise(ActionEvent event) throws IOException {
    Stage stagea = (Stage) exit_btn.getScene().getWindow();
       stagea.close();
     
    //open the next stage - introintrofxml
        FXMLLoader fxmlLoader = new 
        FXMLLoader(getClass().getResource("ExerciseOneFXML.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        
        Stage stage = new Stage();
        //set what you want on your stage
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Computational complexity exercises");
        stage.setScene(new Scene(root1));
        stage.setResizable(false);
        stage.show();
    }


    @FXML
    private void exit(ActionEvent event) {
        Stage stagea = (Stage) exit_btn.getScene().getWindow();
       stagea.close();
    }

    @FXML
    private void goto_npproblemreduc(ActionEvent event) throws IOException {
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

    @FXML
    private void setOnMouseDragged_np(DragEvent eventa1) {

        ham_ellip.setOnDragEntered(new EventHandler<DragEvent>() {
        public void handle(DragEvent eventa) {
        /* the drag-and-drop gesture entered the target */
        /* show to the user that it is an actual gesture target */
             if (eventa.getGestureSource() != ham_ellip &&
                     eventa.getDragboard().hasString() && "ham_ellip".equals(ham_ellip.getId())) {
                 np_Prob.setTextFill(Color.BLACK);
             }

             eventa.consume();
        }
});
        
    }


    @FXML
    private void setOnDragDetected_np(MouseEvent eventa2) {
        np_Prob.setOnDragDetected(new EventHandler<MouseEvent>() {
    public void handle(MouseEvent eventb) {
        /* drag was detected, start a drag-and-drop gesture*/
        /* allow any transfer mode */
        Dragboard db = np_Prob.startDragAndDrop(TransferMode.MOVE);
        
        /* Put a string on a dragboard */
        ClipboardContent content1 = new ClipboardContent();
        content1.putString(np_Prob.getText());
        //System.out.println(np_Prob.getText());
        db.setContent(content1);
        
        eventb.consume();
    }
});
    }

    @FXML
    private void setOnDragDone_np(DragEvent eventa3) {
        np_Prob.setOnDragDone(new EventHandler<DragEvent>() {
    public void handle(DragEvent eventc) {
        /* the drag and drop gesture ended */
        /* if the data was successfully moved, clear it */
        System.out.println("geyt transfer "+eventc.getTransferMode());
        if (eventc.getTransferMode() == TransferMode.MOVE) {
            np_Prob.setText("");
        }
        eventc.consume();
    }
});
    }

   

    @FXML
    private void setOnDragOver_np(DragEvent eventa4) {
        ham_ellip.setOnDragOver(new EventHandler<DragEvent>() {
    public void handle(DragEvent eventd) {
        /* data is dragged over the target */
        /* accept it only if it is not dragged from the same node 
         * and if it has a string data */
        
        if (eventd.getGestureSource() != ham_ellip &&
                eventd.getDragboard().hasString() ) {
           // ham_lab.setText(eventd.getDragboard().getString());
           // ham_lab.setStyle("-fx-background-color: yellow; ");
            eventd.acceptTransferModes(TransferMode.COPY_OR_MOVE);
            //np_Prob.setText("");
        } 
        
        eventd.consume();
    }
});
        
    }
  

    @FXML
    private void setOnDragDropped_np(DragEvent eventa5) {
        ham_ellip.setOnDragDropped(new EventHandler<DragEvent>() {
    public void handle(DragEvent evente) {
        Dragboard db = evente.getDragboard();
        boolean success = false;
        //System.out.println("db val" +db.getString());
        if(db.hasString()){   
           ham_lab.setText(db.getString());
           ham_lab.setStyle("-fx-background-color: yellow; ");
           //System.out.println("yes");
           success = true;
        }
        evente.setDropCompleted(success);  
        evente.consume();
    }
});
        
    }

    @FXML
    private void setOnDragEntered_np(DragEvent eventa6) {
        ham_ellip.setOnDragEntered(new EventHandler<DragEvent>() {
    public void handle(DragEvent eventf) {
    /* the drag-and-drop gesture entered the target */
    /* show to the user that it is an actual gesture target */
         if (eventf.getGestureSource() != ham_ellip &&
                 eventf.getDragboard().hasString()) {
           // ham_ellip.setFill(Color.YELLOW);
         }       
         eventf.consume();
    }
});
    }

    @FXML
    private void setOnDragOver1_np(DragEvent event1) {
        bin_ellip.setOnDragOver(new EventHandler<DragEvent>() {
    public void handle(DragEvent event1) {
        /* data is dragged over the target */
        /* accept it only if it is not dragged from the same node 
         * and if it has a string data */
        if (event1.getGestureSource() != bin_ellip &&
                event1.getDragboard().hasString() ) {
            //bin_lab2.setText(event1.getDragboard().getString());
            //bin_lab2.setStyle("-fx-background-color: yellow; ");
            event1.acceptTransferModes(TransferMode.COPY_OR_MOVE);
            //np_Prob1.setText("");
        }
        
        event1.consume();
    }
});
    }



    @FXML
    private void setOnDragDropped1_np(DragEvent event) {
        
        bin_ellip.setOnDragDropped(new EventHandler<DragEvent>() {
    public void handle(DragEvent event) {
        
        Dragboard db1 = event.getDragboard();
        boolean success = false;
        
        if(db1.hasString()){
           
           bin_lab2.setText(db1.getString());
            bin_lab2.setStyle("-fx-background-color: yellow; ");
           success = true;
        }
        
        event.setDropCompleted(success);
        
        event.consume();
    }
});
    }

    @FXML
    private void setOnMouseDragged1_np(DragEvent event) {
        bin_ellip.setOnDragEntered(new EventHandler<DragEvent>() {
        public void handle(DragEvent event1) {
        /* the drag-and-drop gesture entered the target */
        /* show to the user that it is an actual gesture target */
             if (event1.getGestureSource() != bin_ellip &&
                     event1.getDragboard().hasString() && "bin_ellip".equals(bin_ellip.getId())) {
                 np_Prob1.setTextFill(Color.BLACK);
             }

             event.consume();
        }
});
        
    }

    @FXML
    private void setOnDragDetected1_np(MouseEvent event) {
         np_Prob1.setOnDragDetected(new EventHandler<MouseEvent>() {
    public void handle(MouseEvent event) {
        /* drag was detected, start a drag-and-drop gesture*/
        /* allow any transfer mode */
        Dragboard db2 = np_Prob1.startDragAndDrop(TransferMode.ANY);
        
        /* Put a string on a dragboard */
        ClipboardContent content = new ClipboardContent();
        content.putString(np_Prob1.getText());
        db2.setContent(content);
        
        event.consume();
    }
});
    }

    @FXML
    private void setOnDragDone1_np(DragEvent event) {
         np_Prob1.setOnDragDone(new EventHandler<DragEvent>() {
    public void handle(DragEvent event3) {
        /* the drag and drop gesture ended */
        /* if the data was successfully moved, clear it */
        if (event3.getTransferMode() == TransferMode.MOVE) {
            np_Prob1.setText("");
        }
        event.consume();
    }
});
    }

    @FXML
    private void setOnMouseDragged2_np(DragEvent event) {
        knap_ellip.setOnDragEntered(new EventHandler<DragEvent>() {
        public void handle(DragEvent event) {
        /* the drag-and-drop gesture entered the target */
        /* show to the user that it is an actual gesture target */
             if (event.getGestureSource() != knap_ellip &&
                     event.getDragboard().hasString() && "knap_ellip".equals(knap_ellip.getId())) {
                 np_Prob2.setTextFill(Color.BLACK);
             }

             event.consume();
        }
});
        
    }

    @FXML
    private void setOnDragDetected2_np(MouseEvent event) {
        np_Prob2.setOnDragDetected(new EventHandler<MouseEvent>() {
    public void handle(MouseEvent event) {
        /* drag was detected, start a drag-and-drop gesture*/
        /* allow any transfer mode */
        Dragboard db = np_Prob2.startDragAndDrop(TransferMode.ANY);
        
        /* Put a string on a dragboard */
        ClipboardContent content = new ClipboardContent();
        content.putString(np_Prob2.getText());
        db.setContent(content);
        
        event.consume();
    }
});
    }

    @FXML
    private void setOnDragDone2_np(DragEvent event) {
        np_Prob2.setOnDragDone(new EventHandler<DragEvent>() {
    public void handle(DragEvent event) {
        /* the drag and drop gesture ended */
        /* if the data was successfully moved, clear it */
        if (event.getTransferMode() == TransferMode.MOVE) {
            np_Prob2.setText("");
        }
        event.consume();
    }
});
    }

    @FXML
    private void setOnDragOver2_np(DragEvent event) {
        knap_ellip.setOnDragOver(new EventHandler<DragEvent>() {
    public void handle(DragEvent event4) {
        /* data is dragged over the target */
        /* accept it only if it is not dragged from the same node 
         * and if it has a string data */
        if (event4.getGestureSource() != knap_ellip &&
                event4.getDragboard().hasString() ) {
            //knap_lab3.setText(event.getDragboard().getString());
            ///knap_lab3.setStyle("-fx-background-color: yellow; ");
            event4.acceptTransferModes(TransferMode.COPY_OR_MOVE);
            //np_Prob2.setText("");
        }
        
        event4.consume();
    }
});
    }

    @FXML
    private void setOnDragDropped2_np(DragEvent event) {
        knap_ellip.setOnDragDropped(new EventHandler<DragEvent>() {
    public void handle(DragEvent event3) {
        
        Dragboard db3 = event3.getDragboard();
        boolean success = false;
        
        if(db3.hasString()){
           
           knap_lab3.setText(db3.getString());
           knap_lab3.setStyle("-fx-background-color: yellow; ");
           success = true;
        }
        
        event3.setDropCompleted(success);
        
        event3.consume();
    }
});
    }

    @FXML
    private void setOnMouseDragged3_np(DragEvent event) {
        cnf_eliip.setOnDragEntered(new EventHandler<DragEvent>() {
        public void handle(DragEvent event9) {
        /* the drag-and-drop gesture entered the target */
        /* show to the user that it is an actual gesture target */
             if (event9.getGestureSource() != cnf_eliip &&
                     event9.getDragboard().hasString() && "cnf_eliip".equals(cnf_eliip.getId())) {
                 np_Prob3.setTextFill(Color.BLACK);
             }

             event9.consume();
        }
});
        
    }

    @FXML
    private void setOnDragDetected3_np(MouseEvent event) {
        np_Prob3.setOnDragDetected(new EventHandler<MouseEvent>() {
    public void handle(MouseEvent event7) {
        /* drag was detected, start a drag-and-drop gesture*/
        /* allow any transfer mode */
        Dragboard db5 = np_Prob3.startDragAndDrop(TransferMode.MOVE);
        
        /* Put a string on a dragboard */
        ClipboardContent content7 = new ClipboardContent();
        content7.putString(np_Prob3.getText());
        db5.setContent(content7);
        
        event7.consume();
    }
});
    }

    @FXML
    private void setOnDragDone3_np(DragEvent event) {
         np_Prob3.setOnDragDone(new EventHandler<DragEvent>() {
    public void handle(DragEvent event8) {
        /* the drag and drop gesture ended */
        /* if the data was successfully moved, clear it */
        if (event8.getTransferMode() == TransferMode.MOVE) {
            np_Prob3.setText("");
        }
        event8.consume();
    }
});
    }

    @FXML
    private void setOnDragOver3_np(DragEvent event) {
        cnf_eliip.setOnDragOver(new EventHandler<DragEvent>() {
    public void handle(DragEvent event0) {
        /* data is dragged over the target */
        /* accept it only if it is not dragged from the same node 
         * and if it has a string data */
        if (event0.getGestureSource() != cnf_eliip &&
                event0.getDragboard().hasString() ) {
            //cnf3.setText(event.getDragboard().getString());
            //cnf3.setStyle("-fx-background-color: pink; ");
            event0.acceptTransferModes(TransferMode.COPY_OR_MOVE);
            //np_Prob3.setText("");
        }
        
        event0.consume();
    }
});
    }

    @FXML
    private void setOnDragDropped3_np(DragEvent event) {
        cnf_eliip.setOnDragDropped(new EventHandler<DragEvent>() {
    public void handle(DragEvent event4) {
        
        Dragboard db6 = event4.getDragboard();
        boolean success = false;
        if(db6.hasString()){
           cnf3.setText(db6.getString());
           cnf3.setStyle("-fx-background-color: yellow; ");
           //System.out.println("yes");
           success = true;
        }
        event4.setDropCompleted(success);
        
        event4.consume();
    }
});
    }

    @FXML
    private void setOnMouseDragged1_p(DragEvent event) {
        mcol_ellip.setOnDragEntered(new EventHandler<DragEvent>() {
        public void handle(DragEvent event9) {
        /* the drag-and-drop gesture entered the target */
        /* show to the user that it is an actual gesture target */
             if (event9.getGestureSource() != mcol_ellip &&
                     event9.getDragboard().hasString() && "mcol_ellip".equals(mcol_ellip.getId())) {
                 p_Prob1.setTextFill(Color.BLACK);
             }

             event9.consume();
        }
});
    }

    @FXML
    private void setOnDragDetected1_p(MouseEvent event) {
         p_Prob1.setOnDragDetected(new EventHandler<MouseEvent>() {
    public void handle(MouseEvent event7) {
        /* drag was detected, start a drag-and-drop gesture*/
        /* allow any transfer mode */
        Dragboard db5 = p_Prob1.startDragAndDrop(TransferMode.MOVE);
        
        /* Put a string on a dragboard */
        ClipboardContent content7 = new ClipboardContent();
        content7.putString(p_Prob1.getText());
        db5.setContent(content7);
        
        event7.consume();
    }
});
    }

    @FXML
    private void setOnDragDone1_p(DragEvent event) {
        p_Prob1.setOnDragDone(new EventHandler<DragEvent>() {
    public void handle(DragEvent event8) {
        /* the drag and drop gesture ended */
        /* if the data was successfully moved, clear it */
        if (event8.getTransferMode() == TransferMode.MOVE) {
            p_Prob1.setText("");
        }
        event8.consume();
    }
});
    }

    @FXML
    private void setOnDragOver1_p(DragEvent event) {
        mcol_ellip.setOnDragOver(new EventHandler<DragEvent>() {
    public void handle(DragEvent event0) {
        /* data is dragged over the target */
        /* accept it only if it is not dragged from the same node 
         * and if it has a string data */
        if (event0.getGestureSource() != mcol_ellip &&
                event0.getDragboard().hasString() ) {
           
            event0.acceptTransferModes(TransferMode.COPY_OR_MOVE);

        }
        
        event0.consume();
    }
});
    }
    
    @FXML
    private void setOnDragDropped1_p(DragEvent event) {
        mcol_ellip.setOnDragDropped(new EventHandler<DragEvent>() {
    public void handle(DragEvent event4) {
        
        Dragboard db6 = event4.getDragboard();
        boolean success = false;
        if(db6.hasString()){
           mcol_lab.setText(db6.getString());
           mcol_lab.setStyle("-fx-background-color: yellow; ");
           //System.out.println("yes");
           success = true;
        }
        event4.setDropCompleted(success);
        
        event4.consume();
    }
});
    }
    
     @FXML
    private void setOnMouseDragged2_p(DragEvent event) {
        gcd_ellip.setOnDragEntered(new EventHandler<DragEvent>() {
        public void handle(DragEvent event9) {
        /* the drag-and-drop gesture entered the target */
        /* show to the user that it is an actual gesture target */
             if (event9.getGestureSource() != gcd_ellip &&
                     event9.getDragboard().hasString() && "gcd_ellip".equals(gcd_ellip.getId())) {
                 p_Prob2.setTextFill(Color.BLACK);
             }

             event9.consume();
        }
});
    
    }

    @FXML
    private void setOnDragDetected2_p(MouseEvent event) {
         p_Prob2.setOnDragDetected(new EventHandler<MouseEvent>() {
    public void handle(MouseEvent event7) {
        /* drag was detected, start a drag-and-drop gesture*/
        /* allow any transfer mode */
        Dragboard db5 = p_Prob2.startDragAndDrop(TransferMode.MOVE);
        
        /* Put a string on a dragboard */
        ClipboardContent content7 = new ClipboardContent();
        content7.putString(p_Prob2.getText());
        db5.setContent(content7);
        
        event7.consume();
    }
});
    }

    @FXML
    private void setOnDragDone2_p(DragEvent event) {
          p_Prob2.setOnDragDone(new EventHandler<DragEvent>() {
    public void handle(DragEvent event8) {
        /* the drag and drop gesture ended */
        /* if the data was successfully moved, clear it */
        if (event8.getTransferMode() == TransferMode.MOVE) {
            p_Prob2.setText("");
        }
        event8.consume();
    }
});
    }

    @FXML
    private void setOnDragOver2_p(DragEvent event) {
         gcd_ellip.setOnDragOver(new EventHandler<DragEvent>() {
    public void handle(DragEvent event0) {
        /* data is dragged over the target */
        /* accept it only if it is not dragged from the same node 
         * and if it has a string data */
        if (event0.getGestureSource() != gcd_ellip &&
                event0.getDragboard().hasString() ) {
           
            event0.acceptTransferModes(TransferMode.COPY_OR_MOVE);

        }
        
        event0.consume();
    }
});
    }
    @FXML
    private void setOnDragDropped2_p(DragEvent event) {
         gcd_ellip.setOnDragDropped(new EventHandler<DragEvent>() {
    public void handle(DragEvent event4) {
        
        Dragboard db6 = event4.getDragboard();
        boolean success = false;
        if(db6.hasString()){
           gcd_lab.setText(db6.getString());
           gcd_lab.setStyle("-fx-background-color: yellow; ");
           //System.out.println("yes");
           success = true;
        }
        event4.setDropCompleted(success);
        
        event4.consume();
    }
});
    }
    
    @FXML
    private void setOnMouseDragged3_p(DragEvent event) {
        linprog_ellip.setOnDragEntered(new EventHandler<DragEvent>() {
        public void handle(DragEvent event9) {
        /* the drag-and-drop gesture entered the target */
        /* show to the user that it is an actual gesture target */
             if (event9.getGestureSource() != linprog_ellip &&
                     event9.getDragboard().hasString() && "linprog_ellip".equals(linprog_ellip.getId())) {
                 p_Prob3.setTextFill(Color.BLACK);
             }

             event9.consume();
        }
});
    }

    @FXML
    private void setOnDragDetected3_p(MouseEvent event) {
        p_Prob3.setOnDragDetected(new EventHandler<MouseEvent>() {
    public void handle(MouseEvent event7) {
        /* drag was detected, start a drag-and-drop gesture*/
        /* allow any transfer mode */
        Dragboard db5 = p_Prob3.startDragAndDrop(TransferMode.MOVE);
        
        /* Put a string on a dragboard */
        ClipboardContent content7 = new ClipboardContent();
        content7.putString(p_Prob3.getText());
        db5.setContent(content7);
        
        event7.consume();
    }
});
    }

    @FXML
    private void setOnDragDone3_p(DragEvent event) {
        p_Prob3.setOnDragDone(new EventHandler<DragEvent>() {
    public void handle(DragEvent event8) {
        /* the drag and drop gesture ended */
        /* if the data was successfully moved, clear it */
        if (event8.getTransferMode() == TransferMode.MOVE) {
            p_Prob3.setText("");
        }
        event8.consume();
    }
});
    }

    @FXML
    private void setOnDragOver3_p(DragEvent event) {
        linprog_ellip.setOnDragOver(new EventHandler<DragEvent>() {
    public void handle(DragEvent event0) {
        /* data is dragged over the target */
        /* accept it only if it is not dragged from the same node 
         * and if it has a string data */
        if (event0.getGestureSource() != linprog_ellip &&
                event0.getDragboard().hasString() ) {
           
            event0.acceptTransferModes(TransferMode.COPY_OR_MOVE);

        }
        
        event0.consume();
    }
});
    }

   

    @FXML
    private void setOnDragDropped3_p(DragEvent event) {
        linprog_ellip.setOnDragDropped(new EventHandler<DragEvent>() {
    public void handle(DragEvent event4) {
        
        Dragboard db6 = event4.getDragboard();
        boolean success = false;
        if(db6.hasString()){
           linprog_lab.setText(db6.getString());
           linprog_lab.setStyle("-fx-background-color: yellow; ");
           //System.out.println("yes");
           success = true;
        }
        event4.setDropCompleted(success);
        
        event4.consume();
    }
});
    }

    @FXML
    private void goto_bigidea_pprob(ActionEvent event) throws IOException {
         Stage stagea = (Stage) exit_btn.getScene().getWindow();
       stagea.close();
     
    //open the next stage - introintrofxml
        FXMLLoader fxmlLoader = new 
        FXMLLoader(getClass().getResource("BigIdea_pproblemFXML.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        
        Stage stage = new Stage();
        //set what you want on your stage
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Understanding P complexity");
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
    private void goto_bigidea_npcomp(ActionEvent event) throws IOException {
          Stage stagea = (Stage) exit_btn.getScene().getWindow();
       stagea.close();
     
    //open the next stage - introintrofxml
        FXMLLoader fxmlLoader = new 
        FXMLLoader(getClass().getResource("BigIdea_npcompleteFXML.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        
        Stage stage = new Stage();
        //set what you want on your stage
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Understanding NP-complete complexity");
        stage.setScene(new Scene(root1));
        stage.setResizable(false);
        stage.show();
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
    private void goto_bigidea_euler(ActionEvent event) throws IOException {
        Stage stagea = (Stage) exit_btn.getScene().getWindow();
       stagea.close();
     
    //open the next stage - introintrofxml
        FXMLLoader fxmlLoader = new 
        FXMLLoader(getClass().getResource("BigIdea_illustrationsFXML.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        
        Stage stage = new Stage();
        //set what you want on your stage
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Euler's Diagram");
        stage.setScene(new Scene(root1));
        stage.setResizable(false);
        stage.show();
    }

    

    
    
}
