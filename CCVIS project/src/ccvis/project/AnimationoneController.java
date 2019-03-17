/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccvis.project;

import java.io.IOException;
import static java.lang.Math.random;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Immanuella Duke
 */
public class AnimationoneController implements Initializable {

    @FXML
    private MenuBar menu_bar;
    @FXML
    private Menu menu_animation;
    @FXML
    private Menu menu_reduction;
    @FXML
    private Menu menu_exercise;
    @FXML
    private Button anim1_next_btn;
    @FXML
    private Button exit_btn;
    @FXML
    private Button animation_back_btn1;
    @FXML
    private Button anim1_next_btn1;

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
    private void goto_pproblem_anim(ActionEvent event) throws IOException {
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

   
    //.........................m-coloring problem code. the play animation
    //method up, will run the m-coloring method
    //generate problem
    @FXML
    private void play_vert_and_m(ActionEvent event){
        
       // ArrayList<Integer> vertandm = new ArrayList<Integer>();
        //generate random number in range one to three
        int randomNum = ThreadLocalRandom.current().nextInt(1, 4);
        
        if (randomNum == 1) {
 
                //10 vertices, 3 colors
                int V = 10;
                int m = 3;
                int [] colored_v = new int [V];
                int [][] graph = generate_graph(V);
              
                boolean result = graph_colouring(graph, m, V, colored_v);
               // System.out.println("For vertex "+ V + " and m of "+ m + "\n");
                System.out.println(result);
                //return vertandm
        }
        else if (randomNum == 2){
                //3 vertices, 2 colors ...//impossible to color the graph
                int V2 = 7;
                int m2 = 3;
                int [] colored_v_two = new int [V2];
                int [][] graph_two = generate_graph(V2);
                
                
                boolean result2 = graph_colouring(graph_two, m2, V2, colored_v_two);
                //System.out.println("For vertex "+ V2 + " and m of "+ m2 + "\n");
                System.out.println(result2);
                //return vertandm;
                
        }
        else if (randomNum == 3){
                //4 vertices, 3 colors ...
                int V3 = 4;
                int m3 = 3;
                int [] colored_v_three = new int [V3];
                int [][] graph_three  = generate_graph(V3);
               
               
                boolean result3 = graph_colouring(graph_three, m3, V3, colored_v_three);
                //System.out.println("For vertex "+ V3 + " and m of "+ m3 + "\n");
                System.out.println(result3);
        }
                //return vertandm;      
    }
   
    //generates a graph which is an adjacency matrix of v vertices.
    private static int [][] generate_graph(int V){
        int [][] graph = new int [V][V];
        for (int i = 0; i < V; i++){
            int [] sublist = new int [V];
            for (int j = 0; j < V; j++){
                //randomize whether two vertices are connected or not, using 0 or 1
                //this randomization also helps to ensure we have a lot of new examples
                int randomNum = ThreadLocalRandom.current().nextInt(0, 2);
                sublist[j] = randomNum;
                
            }
            graph[i] = sublist;//add the sublist to the adjacency matrix
        }
        
        //to make sure the graph is properly arranged
        for (int k = V-1; k >= 0; k--){
            int n = V - 2;
            while (n != 0){
                //do it n times
                for (int l = 0; l <= n; l++){
                    graph[k][l] = graph[l][k];
                }
                n = n - 1;
            }
        }  
        int sub_val = 0; 
        for (int []sub: graph){
            for (int i = 0; i < V; i++){
                //set for e.g graph [0][0] = 0
                if (sub_val == i){
                    graph[sub_val][i] = 0;
                }
            }
            sub_val += 1;
        }
        return graph;//return graph that has been generated   
    }
   
    //check if it is ok to colour this vertex with the colour c.
    private boolean is_poss(int v , int c, int g [][], int V, int []colored_v){
        //for the total number of vertices
        for (int i = 0; i < V; i++)
            if (g[v][i] == 1 && c == colored_v[i])
                return false;
        return true;      
    }
    public Label makeLabel(String c, double x, double y){
     Label t;
            t = new Label (c);
            t.setLayoutX(x);
            t.setLayoutY(y);
            t.setStyle("-fx-font: 24 Garamond; -fx-text-fill: #000000; ");
            return t;
     }
    
    //helper function to correctly colour the vertices connected to vertex v
    //returns the colour array of the vertices. set each vertex connected with
    //v with the right colour.
    private boolean graph_colouring_helper(int v, int V, int g[][], 
            int colored_v [], int m){
       
        //base case, if all vertices now have a color.
        if (v == V)
            return true;
        
        //keeping trying different colors.
        for (int c = 1; c <= m; c++){
            //check if the assignment to this color is acceptable
            if (is_poss(v, c, g, V, colored_v)){
                //assign color to this vertex v
                colored_v[v] = c;
                //recursion to other vertices.
                if (graph_colouring_helper(v+1, V, g, colored_v, m))
                    return true;
                //if this assignment doesn't lead to an answer set the color
                //of the v back to 0
                colored_v[v] = 0;
      
            }
         
        }
        return false;
    }
   //makes use of the graph colouring helper function
    private boolean graph_colouring(int [][]g, int m, int V, int []colored_v){
        
        //set all color values to 0
        for (int k = 0; k < colored_v.length ; k++){
            colored_v[k] = 0;
        }
       
        if (!graph_colouring_helper(0,V, g, colored_v, m)){
            System.out.println("no solution for v of " + V + "and m of " + m);
            //Label l = new Label ("no solution for v of " + V + "and m of " + m);
            
            return false;
        }
        //print out colors used to color graph.
        for (int i = 0; i < colored_v.length; i++){
            System.out.println("colour of vertex " + i + " is " + colored_v[i]);
        }
        
        //color the graph here
       Color c1 = Color.ALICEBLUE;
       Color c2 = Color.LIMEGREEN;
       Color c3 = Color.BLUE;
       Color c4 = Color.YELLOW;
       Color c5 = Color.BLACK;
       Color bgc = Color.valueOf("#f71735");
       //put colors in array
       Color color_arr [] = {c1,c2,c3,c4,c5};
       
        //draw the vertices..stopped here
        int width= 700;
        int height = 500;
        
        //aaray to keep cordinates of vertices.    
        double [][] coord_array = new double[V][2];
        //array to keep verts of other group
        double [][] coord_uncol_array = new double[V][2];
        Group vert_layer = new Group();
        Group uncol_vert_layer = new Group();
        int start_w = (width/2)+ 160;
        int start_h = height/2 + 20;
        int start_uncol_w = (width/2)- 160;
        int start_uncol_h = height/2 + 20;
        double angle = (360/ V) * Math.PI/180;
        int n = 1;
        for (int i = 0; i < V; i++){
            //for colored circle
            Circle circle = new Circle(); 
         
        
            double pos_x = start_w + 120*Math.sin(n *angle);
            double pos_y = start_h + 120*Math.cos(n *angle);
            //Setting the position of the circle 
            circle.setCenterX(pos_x); 
            circle.setCenterY(pos_y); 
            
            //populate coord_array with vertex coordinates..this will help with 
            //creating edges between vertices 
            coord_array[i][0] = pos_x;
            coord_array[i][1] = pos_y;
            //Setting the radius of the circle 
            circle.setRadius(30.0f); 

            //Set fill to color of the actual vertex
            circle.setFill(color_arr[colored_v[i]]); 
  
            //Setting the stroke width of the circle 
            circle.setStrokeWidth(5);
            vert_layer.getChildren().add(circle);
            //for uncolored circle
            Circle uncol_circle = new Circle();
            
            double pos_uncol_x = start_uncol_w + 120*Math.sin(n *angle);
            double pos_uncol_y = start_uncol_h + 120*Math.cos(n *angle);
            
            uncol_circle.setCenterX(pos_uncol_x); 
            uncol_circle.setCenterY(pos_uncol_y); 
            uncol_circle.setFill(Color.web("#f71735"));
            coord_uncol_array[i][0] = pos_uncol_x;
            coord_uncol_array[i][1] = pos_uncol_y;
            uncol_circle.setRadius(30.0f); 
            uncol_circle.setStrokeWidth(2);
            uncol_circle.setStroke(Color.BLACK);
            uncol_vert_layer.getChildren().add(uncol_circle);
            
            n++;
            
        }     
        Group line_layer = new Group();
        Group line_uncol_layer = new Group();
        //place edges between connected vertices
        int sub_val = 0;
        for (int[] sublist : g) {
            for(int i = 0; i < sublist.length; i++){
                
                if (sublist[i] == 1){
                    Line l = new Line(coord_array[sub_val][0], coord_array[sub_val][1], 
                    coord_array[i][0], coord_array[i][1]);
                    line_layer.getChildren().add(l);
                    
                    Line u = new Line(coord_uncol_array[sub_val][0], coord_uncol_array[sub_val][1], 
                    coord_uncol_array[i][0], coord_uncol_array[i][1]);
                    line_uncol_layer.getChildren().add(u);
                    
                }
            }
            System.out.println("printing graph content" + Arrays.toString(g[sub_val]));
            sub_val += 1;
        }
            Stage stagec = (Stage) exit_btn.getScene().getWindow();
            stagec.close();
            Stage stagea = new Stage();
           // Group root = new Group( line_layer, line_uncol_layer, uncol_vert_layer, vert_layer); 
            Group root = new Group(  line_uncol_layer, uncol_vert_layer); 
            
            //label
            Label nte = makeLabel("Notice that no two vertices with the same color are connected", 50,50);
            Label nte1 = makeLabel("Click the check button to see how the graph is colored", 90,80);
            //create back btn for 
            Button back = new Button("Back");
            back.setStyle("-fx-font: 18 Garamond; -fx-background-color: #011627; -fx-text-fill: #fdfffc; ");
            Button see_new = new Button("See another example");
            see_new.setStyle("-fx-font: 18 Garamond; -fx-background-color: #011627; -fx-text-fill: #fdfffc; ");
           Button check = new Button("Check");
            check.setStyle("-fx-font: 18 Garamond; -fx-background-color: #011627; -fx-text-fill: #fdfffc; ");
           //set positions of the buttons
            see_new.setLayoutX(530);
           see_new.setLayoutY(0);
           check.setLayoutX(330);
           check.setLayoutY(430);
           
            root.getChildren().add(back);
            root.getChildren().add(check);
            root.getChildren().add(see_new);
            root.getChildren().add(nte);
            root.getChildren().add(nte1);
            
              check.setOnAction(new EventHandler<ActionEvent>() {
            
            public void handle(ActionEvent event) {
           
                root.getChildren().add(line_layer);
                root.getChildren().add(vert_layer);
                
            }
        });
            Scene scenea = new Scene(root, width, height);  
            scenea.setFill(bgc);
            //Adding scene to the stage 
            stagea.setScene(scenea); 

            //Displaying the contents of the stage 
            stagea.show();       
            back.setOnAction(new EventHandler<ActionEvent>() {
            
            public void handle(ActionEvent event) {
                Stage stagex = (Stage) back.getScene().getWindow();
                stagex.close();
                 FXMLLoader fxmlLoader = new 
                FXMLLoader(getClass().getResource("Animationone.fxml"));
                Parent root1;
                try {
                    root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    //set what you want on your stage
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setTitle("M-Coloring problem");
                    stage.setScene(new Scene(root1));
                    stage.setResizable(false);
                    stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(AnimationoneController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
            
          see_new.setOnAction(new EventHandler<ActionEvent>() {
            
            public void handle(ActionEvent event) {
                Stage stager = (Stage) see_new.getScene().getWindow();
                stager.close();
                play_vert_and_m(event);
                
            }
        });
            
        System.out.println("Solution exists for v of " + V + "and m of " + m);
        return true;
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


    @FXML
    private void goto_introtypes(ActionEvent event) throws IOException {
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
        stage.setTitle("Knapsack problem");
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

}
    
    
    
    
