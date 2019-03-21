/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccvis.project;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.Animation.Status;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.shape.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Immanuella Duke
 */
public class PReductionController implements Initializable {

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
    private AnchorPane apane;
    @FXML
    private Button stop_btn;
    @FXML
    private Button start_btn11;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
  
    private Circle makeCircle(Color c, double r, double x, double y){
     Circle c1 = new Circle(x, y, r, c);
            c1.setStrokeType(StrokeType.OUTSIDE);
            c1.setStroke(Color.BLACK);
            c1.setStrokeWidth(2);
            
        return c1;
    }
     public Label makeLabel(String c, double x, double y){
     Label t;
            t = new Label (c);
            t.setLayoutX(x);
            t.setLayoutY(y);
            t.setStyle("-fx-font: 24 Garamond; -fx-text-fill: #000000; ");
            return t;
     }
     
     private Line makeLine(double startx, double starty, double endx, double endy){
       
        Line l = new Line(startx,starty,endx,endy);               
        return l;
     }
     private CubicCurve makeArc(double startx, double starty,double conx1, 
             double cony1,double conx2 , double cony2,double endx, double endy){
        CubicCurve cubic = new CubicCurve();
        cubic.setStartX(startx);
        cubic.setStartY(starty);
        cubic.setControlX1(conx1);
        cubic.setControlY1(cony1);
        cubic.setControlX2(conx2);
        cubic.setControlY2(cony2);
        cubic.setEndX(endx);
        cubic.setEndY(endy);
        return cubic;
    }
     Timeline timeline = new Timeline();
    
    URL fileUrl = CCVISProject.class.getResource("other_useful_resources/sound.mp3");
     
     Media sound = new Media(fileUrl.toString());
     MediaPlayer mediaPlayer = new MediaPlayer(sound);
    Group root = new Group();
      
    private void start_helper(){
        //System.out.println("music file "+System.getProperty("user.dir")+"other_useful_resources/sound.mp3" );
        //first set of circles
        
        if (root.getChildren().isEmpty()){
        
            Stage primaryStage = (Stage) exit_btn.getScene().getWindow();
            Scene scene = (Scene) exit_btn.getScene();

            Group circles = new Group();
            Group labels = new Group();
            Group lines = new Group();


            Color co [] = {Color.MAGENTA, Color.DODGERBLUE, Color.YELLOW, Color.DARKVIOLET,Color.LIMEGREEN, Color.LEMONCHIFFON};
            //create c1

                Circle c1 = makeCircle(co[0], 20, 200, 200);
                Label l1 = makeLabel("N", 190, 190);
                Line line = makeLine(200,200,150,250);
                //create c2
                 Circle c2 = makeCircle(co[1], 20, 150, 250);
                 Label l2 = makeLabel("F", 140, 240);
                 Line line1 = makeLine(150,250,250,250);
          
                //create c3
                 Circle c3 = makeCircle(co[2], 20, 250, 250);
                 Label l3 = makeLabel("T", 240, 240);
                 Line line2 = makeLine(200,200,250,250);
      

              Label lc = makeLabel("Color the three vertices differently", 240, 190);
   

            Duration timepoint = Duration.ZERO ;
            Duration pause = Duration.seconds(3);


            //add first circle
            KeyFrame initial = new KeyFrame(timepoint, e -> circles.getChildren().add(c1));
            KeyFrame initial1 = new KeyFrame(timepoint, e -> labels.getChildren().add(l1));
             KeyFrame line_initial1 = new KeyFrame(timepoint, e -> lines.getChildren().add(line));
             KeyFrame lc1 = new KeyFrame(timepoint, e -> lines.getChildren().add(lc));
            timeline.getKeyFrames().add(line_initial1);
             timeline.getKeyFrames().add(initial);
            timeline.getKeyFrames().add(initial1);
            timeline.getKeyFrames().add(lc1);

            timepoint = timepoint.add(pause);
            KeyFrame keyFrame = new KeyFrame(timepoint, e -> circles.getChildren().add(c2));
            KeyFrame initial3 = new KeyFrame(timepoint, e -> labels.getChildren().add(l2));
            KeyFrame line_initial2 = new KeyFrame(timepoint, e -> lines.getChildren().add(line1));
            timeline.getKeyFrames().add(keyFrame);
            timeline.getKeyFrames().add(initial3);
            timeline.getKeyFrames().add(line_initial2);

            timepoint = timepoint.add(pause);
            KeyFrame keyFrame2 = new KeyFrame(timepoint, e -> circles.getChildren().add(c3));
            KeyFrame initial4 = new KeyFrame(timepoint, e -> labels.getChildren().add(l3));
            KeyFrame line_initial3 = new KeyFrame(timepoint, e -> lines.getChildren().add(line2));
            timeline.getKeyFrames().add(keyFrame2);
            timeline.getKeyFrames().add(initial4);
            timeline.getKeyFrames().add(line_initial3);

            timepoint = timepoint.add(pause);
            timepoint = timepoint.add(pause);
            //draw p
             Circle c4 = makeCircle(co[2], 20, 350, 250);
             Label l4 = makeLabel("P", 340, 240);
             Label l5 = makeLabel("Force P to be truth colored", 380, 240);
             timepoint = timepoint.add(pause);
            KeyFrame p = new KeyFrame(timepoint, e -> circles.getChildren().add(c4));
            KeyFrame p1 = new KeyFrame(timepoint, e -> labels.getChildren().add(l4));
            KeyFrame l5f = new KeyFrame(timepoint, e -> labels.getChildren().add(l5));
            timeline.getKeyFrames().add(p);
             timeline.getKeyFrames().add(p1);
            timeline.getKeyFrames().add(l5f);

            //draw line from n to p
            Line np = makeLine(200,200,350,250);
            np.getStrokeDashArray().addAll(2d);
            np.setStroke(co[2]);
            timepoint = timepoint.add(pause);
            KeyFrame k_np = new KeyFrame(timepoint, e -> lines.getChildren().add(np));
            timeline.getKeyFrames().add(k_np);

            //draw not p
             Circle p4 = makeCircle(co[1], 40, 350, 350);
             Label pl4 = makeLabel("NOT(P)", 315, 340);
             Label pl5 = makeLabel("simulate NOT", 410, 340);
             timepoint = timepoint.add(pause);
            KeyFrame notp = new KeyFrame(timepoint, e -> circles.getChildren().add(p4));
            KeyFrame notp1 = new KeyFrame(timepoint, e -> labels.getChildren().add(pl4));
            KeyFrame notl5f = new KeyFrame(timepoint, e -> labels.getChildren().add(pl5));
            timeline.getKeyFrames().add(notp);
             timeline.getKeyFrames().add(notp1);
            timeline.getKeyFrames().add(notl5f);

            //n to not p
            CubicCurve cubic = makeArc(200, 200,20,250, 20,250, 350, 350);
           // Line nnotp = makeLine(200,200,350,350);
            cubic.getStrokeDashArray().addAll(2d);
            cubic.setStroke(co[2]);
            cubic.setFill(null);
            timepoint = timepoint.add(pause);
            KeyFrame k_notnp = new KeyFrame(timepoint, e -> lines.getChildren().add(cubic));
            timeline.getKeyFrames().add(k_notnp);

            //p to not p
             Line pnp = makeLine(350,250,350,350);
            pnp.getStrokeDashArray().addAll(2d);
            pnp.setStroke(Color.BLACK);
            timepoint = timepoint.add(pause);
            KeyFrame k_pnp = new KeyFrame(timepoint, e -> lines.getChildren().add(pnp));
            timeline.getKeyFrames().add(k_pnp);

            //code for simulate OR
            
                 Circle orc1 = makeCircle(co[5], 35, 190, 490);
                Label orl1 = makeLabel("P or Q", 190, 490);
                Line orline = makeLine(200,500,150,550);
                //create c2
                 Circle orc2 = makeCircle(co[5], 20, 150, 550);
                 Label orl2 = makeLabel("Q", 140, 540);
                 Line orline1 = makeLine(150,550,250,550);
          
                //create c3
                 Circle orc3 = makeCircle(co[5], 20, 250, 550);
                 Label orl3 = makeLabel("P", 230, 540);
                 Line orline2 = makeLine(200,500,250,550);
            
            timepoint = timepoint.add(pause);
            timepoint = timepoint.add(pause);
            timepoint = timepoint.add(pause);
            timepoint = timepoint.add(pause);
            timepoint = timepoint.add(pause);

            root.getChildren().add(lines);

            root.getChildren().add(circles);

            root.getChildren().add(labels);


            apane.getChildren().add(root);
    }//end of if
        
  
        else{//do nothing}
                }                
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
        stage.setTitle("Travelling Salesman problem");
        stage.setScene(new Scene(root1));
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void goto_npreduc(ActionEvent event) throws IOException {
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
    private void goto_catcomp(ActionEvent event) throws IOException {
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
    private void pause_anim(ActionEvent event) { 
        timeline.pause();
        mediaPlayer.pause();
    }
    int n = 1;
    @FXML
    private void play_anim(ActionEvent event) {
        if (n > 1 && timeline.getStatus() == Status.STOPPED){
            System.out.println("n here:"+ n);
            timeline.stop();   
        }
        else{
            start_helper();
            timeline.play();
            mediaPlayer.play();
         
           n++;
        }   
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
