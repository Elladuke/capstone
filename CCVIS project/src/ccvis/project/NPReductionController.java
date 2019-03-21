/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccvis.project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Line;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Immanuella Duke
 */
public class NPReductionController implements Initializable {

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
    private Button intro_two_next_btn;
    @FXML
    private Button exit_btn;
    @FXML
    private Button intro_two_back_btn1;
    @FXML
    private Button intro_two_next_btn1;
    @FXML
    private Button play;
    @FXML
    private AnchorPane apane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void goto_welcome(ActionEvent event) throws IOException {
        timeline.stop();
        mediaPlayer.stop();
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
        timeline.stop();
        mediaPlayer.stop();
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
        timeline.stop();
        mediaPlayer.stop();
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
        timeline.stop();
        mediaPlayer.stop();
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
        timeline.stop();
        mediaPlayer.stop();
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
    private void goto_exercise(ActionEvent event) throws IOException {
        timeline.stop();
        mediaPlayer.stop();
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
     private Line makeLine(double startx, double starty, double endx, double endy){
       
        Line l = new Line(startx,starty,endx,endy);               
        return l;
     }

    @FXML
    private void exit(ActionEvent event) {
        timeline.stop();
        mediaPlayer.stop();
     Stage stagea = (Stage) exit_btn.getScene().getWindow();
       stagea.close();
    }

    
    Timeline timeline = new Timeline();
    
    URL fileUrl = CCVISProject.class.getResource("other_useful_resources/vertex_cover.mp3");
     
     Media sound = new Media(fileUrl.toString());
     MediaPlayer mediaPlayer = new MediaPlayer(sound);
    Group root = new Group();
    Group lines = new Group();
    
    private void start_anim(){
        if (root.getChildren().isEmpty() && lines.getChildren().isEmpty()){
            Stage primaryStage = (Stage) exit_btn.getScene().getWindow();
            Scene scene = (Scene) exit_btn.getScene();
            
           
            Line line1 = makeLine(100,580,420,580);
            Line line2 = makeLine(430,550,253,460);
            Line line3 = makeLine(100,568,245,460);
             Duration timepoint = Duration.ZERO ;
            Duration pause = Duration.seconds(3);
             Duration delay = Duration.seconds(25);
             
             timepoint = timepoint.add(delay);
            timepoint = timepoint.add(pause);
             KeyFrame lc1 = new KeyFrame(timepoint, e -> lines.getChildren().add(line1));
            timeline.getKeyFrames().add(lc1);
            timepoint = timepoint.add(pause);
            
            KeyFrame lc2 = new KeyFrame(timepoint, e -> lines.getChildren().add(line2));
            timeline.getKeyFrames().add(lc2);
            timepoint = timepoint.add(pause);
            
            KeyFrame lc3 = new KeyFrame(timepoint, e -> lines.getChildren().add(line3));
            timeline.getKeyFrames().add(lc3);
            timepoint = timepoint.add(pause);
            
            root.getChildren().add(lines);


            apane.getChildren().add(root);
        
        }
     
        else{
        //do nothing
        System.out.println("here runnss");
        }
   
    }
      
    @FXML
    private void pause_anim(ActionEvent event) {
        timeline.pause();
        mediaPlayer.pause();
    }

    int n = 1;
    @FXML
    private void play_anim(ActionEvent event) {
        if (n > 1 && mediaPlayer.getCurrentTime() == mediaPlayer.getTotalDuration()){
            
            System.out.println("n here:"+ n);
            timeline.stop();   
        }
        else{
            start_anim();
            timeline.play();
            mediaPlayer.play();
         
           n++;
        }   
    }

    
     @FXML
    private void goto_bigidea_pprob(ActionEvent event) throws IOException {
        timeline.stop();
        mediaPlayer.stop();
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
        timeline.stop();
        mediaPlayer.stop();
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
        timeline.stop();
        mediaPlayer.stop();
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
        timeline.stop();
        mediaPlayer.stop();
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
        timeline.stop();
        mediaPlayer.stop();
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
    
    @FXML
    private void goto_catcomp(ActionEvent event) throws IOException {
        
         timeline.stop();
        mediaPlayer.stop();
    Stage stagea = (Stage) exit_btn.getScene().getWindow();
       stagea.close();
     
    //open the next stage - introintrofxml
        FXMLLoader fxmlLoader = new 
        FXMLLoader(getClass().getResource("CategorizeCompFXML.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        //set what you want on your stage
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Categorize Complexity problem");
        stage.setScene(new Scene(root1));
        stage.setResizable(false);
        stage.show();
    }
@FXML
    private void goto_pproblemreduc(ActionEvent event) throws IOException {
        timeline.stop();
        mediaPlayer.stop();
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
    
}
