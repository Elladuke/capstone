/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//simulated annealing implementation of code for knapsack by Immanuella Duke- Algorithms project
package ccvis.project;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.Math.random;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;
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
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Pair;

/**
 * FXML Controller class
 *
 * @author Immanuella Duke
 */
public class AnimationtwoController implements Initializable {

    @FXML
    private MenuBar menu_bar;
    @FXML
    private MenuItem welcome_id;
    @FXML
    private MenuItem types_id;
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
    private Button see_anim;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
   
    
    /*    
    acceptance probablity function based on katrinaeg.com/simulated annealing.html
    it gives a number between 0 and 1 which is a recommendation on whether to change the solution
    or not.
     */
    private double accept_prob(double cur_temp, double c_new, double c_old){
        double ap = Math.exp(-(c_new - c_old)/cur_temp);   //check exp if any later errors
        return ap;
    }

    /*returns a random solution
    of a val and a weight as a tuple
    
    */
    private Pair<Integer, Integer >  random_solution(int []vals, int [] weights){
        int val = new Random().nextInt(vals.length);
        int weight = new Random().nextInt(weights.length);
        Pair<Integer, Integer> val_and_weight = new Pair<>(val, weight);
        return val_and_weight;
    }
    
    //helper function to find the sum of an array of numbers
    private int sum(int []numbers){
        
        int acc = 0;
        for (int i = 0; i < numbers.length; i++){
            acc  = acc + numbers[i];
        }
        return acc;
    }
    
    private void print_a(int a[]){
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
    }
    
    //helper function to find the max of an array of numners.
    private int max (int [] numbers){
        int max = -1;
        for (int i = 0; i < numbers.length; i++){
            if (numbers[i] > max)
                max = numbers[i];
        }  
        return max;
    }
   
    //helper function to find the minimum of an array of numbers
    private int min (int [] numbers){
        int min = 1000;
        for (int i = 0; i < numbers.length; i++){
            if (numbers[i] < min)
                min = numbers[i];
        }  
        return min;
    }
    
    private double cost_function( Pair<Integer, Integer > sol, int []vals, int []weights, int weight_cap){
        //for the values
        double avg_val = sum(vals)/vals.length;
        //avg of avg_val and highest val
        int highest_val = max(vals);
        double avg_up_val = (avg_val + highest_val)/2;
        int lowest_val = min(vals);
        double avg_down_val = (avg_val + lowest_val)/2;
        
        //for the weights
        double avg_weight = weight_cap/2;
        int highest_weight = max(weights);
        double avg_up_weight = (avg_weight + weight_cap)/2;
        int lowest_weight = min(weights);
        double avg_down_weight = (avg_weight + lowest_weight)/2;
        
        Integer val_sol = sol.getKey();
        Integer weight_sol = sol.getValue();
        
        //calculate costs
        if (val_sol < avg_down_val && weight_sol < avg_down_weight) //poor choice
            return 4;

        else if(val_sol < avg_down_val && weight_sol >= avg_down_weight && weight_sol <= avg_up_weight)
            return 3;

        else if (val_sol < avg_down_val && weight_sol > avg_up_weight)
            return 0.8;
    
        else if (val_sol >= avg_down_val && val_sol <= avg_up_val && weight_sol< avg_down_weight)
            return 0.7;

        else if (val_sol >= avg_down_val && val_sol <= avg_up_val && weight_sol >= avg_down_weight && val_sol <= avg_up_weight)
            return 0.6;

        else if (val_sol >= avg_down_val && val_sol <= avg_up_val && weight_sol > avg_up_weight)
            return 0.5;

        else if (val_sol > avg_up_val && weight_sol < avg_down_weight)
            return 0.4;

        else if (val_sol > avg_up_val && weight_sol >= avg_down_weight && weight_sol <= avg_up_weight)
            return 0.3;

        else if (val_sol > avg_up_val && weight_sol > avg_up_weight)
            return 0.2;

        else if (weight_sol == weight_cap && val_sol > avg_up_val)
            return 0.00001;
        
        else
            return 10000; //check if any later errors
  
    }
    //check if an arrya contains a certain val
    
    private boolean contains_val(int val, int []a){
        for (int i = 0; i < a.length; i++ ){
            if (a[i] == val)
                return true;        
        } 
        return false;  
    }
    
    private int[] random_sample (int k, int[]population){
        int rans  = ThreadLocalRandom.current().nextInt(1, k+1);
        int[] cards = ThreadLocalRandom.current().ints(0, k).distinct().limit(rans).toArray();
        //k is the num of random samples
        int [] sample = new int[cards.length];
        //print_a(cards);
        
        for (int i = 0; i < cards.length; i++){
            sample[i] = population[cards[i]];
        }
        return sample;
    }
    
    //finds the index of an item in an array
    
    private int index_of(int [] arr, int val){
        
        for (int i = 0; i < arr.length; i++ ){
            if (arr[i] == val)
                return i;   
       }
        return -1;
    }
    //function to convert arraylist to array
    public static int[] convertIntegers(List<Integer> integers){
        int[] array = new int[integers.size()];
        for (int i=0; i < array.length; i++){
            array[i] = integers.get(i).intValue();
        }
        return array;
    }
    
    //sum of array list
    private int sum_list(List<Integer> list){
        int sum = 0;
        for (int i: list){
            sum += i;
        }
        return sum;
    }
    /*generates a random solution
    //random_sample_weights is a sample of weights
    //intgeres is an array list of sample values
    */
    private Pair<Pair<Integer, Integer>, Pair<int[], int[]>> generate_random_solution(int []vals, int [] weights, int weight_cap){
        
        ArrayList<Integer> sample_values = new ArrayList<Integer>();
        int num_rand_samples  = ThreadLocalRandom.current().nextInt(1, vals.length+1);
        int [] random_sample_weights = random_sample(num_rand_samples,weights );
    
        while(((sum(random_sample_weights)) > weight_cap) && num_rand_samples != 1) {
            num_rand_samples = ThreadLocalRandom.current().nextInt(1, vals.length+1);
            random_sample_weights = random_sample(num_rand_samples,weights );
        }

        int count_adder = 0;
        for (int w: random_sample_weights){
      
            //get index of w in weights
            int index_w = index_of(weights, w);
            //find the value item in "values" that has the same index
            int val_to_weight = vals[index_w];
          
            sample_values.add(val_to_weight);
            count_adder++;
        }
        
        int sum_value_list = sum_list(sample_values);
        int[] new_value_list = convertIntegers(sample_values);
        Pair<Integer, Integer> sum_vals_weights = new Pair<>(sum(random_sample_weights), sum_value_list);
        
        Pair<int[], int[]> val_and_weight = new Pair<>(random_sample_weights, new_value_list);
        
        Pair<Pair<Integer, Integer>, Pair<int[], int[]>> sumlist_singlelist = new Pair<>(sum_vals_weights, val_and_weight);
         
        return sumlist_singlelist;
    }
    
    //the main function using simulated annealing to bring it all together
     
    private Pair<Pair<Integer, Integer>, Pair<int[], int[]>> knapsack_main(int []vals, int[]weights, int weight_cap){
        
        double alpha = 0.9; //constant value multiplied by temp on each iteration.
        double temp = 0.9;   //this value is important in SA. It's the value we are iterating on
                           //it is decreased after every iteration by multipling it by the constant alpha
        double min_temp = 0.00001; //minimum value for temperature or cooling temp as is peculiar to SA
        
        Pair<Integer, Integer >cur_sol = random_solution(vals,weights);
        
        
        double new_cost;
        double accept_p;
        double old_cost = cost_function(cur_sol, vals, weights, weight_cap);
        Pair<Pair<Integer, Integer>, Pair<int[], int[]>> new_solution;
        
        Pair<int[], int[]> whole_sol = null;
        
        while(temp > min_temp){
            int i = 0;
            
            while(i <= 100){
                new_solution = generate_random_solution(vals, weights, weight_cap);
                new_cost = cost_function(new_solution.getKey(), vals, weights, weight_cap);
                
                accept_p = accept_prob(temp, new_cost, old_cost);
                
                Random r = new Random();
                double rand_num = 0.7 + r.nextDouble() * (1 - 0.7);
                
                if (accept_p > rand_num){
                    cur_sol = new_solution.getKey();
                    whole_sol = new_solution.getValue();
                    
                    old_cost = new_cost;
                }             
                i++;            
            }           
            temp = temp * alpha;        
        }
         Pair<Pair<Integer, Integer>, Pair<int[], int[]>> final_answer = new Pair<>(cur_sol, whole_sol);
   
        return final_answer;  
    }
    
    //function to return the pair with the highest value
    
    private static Pair<Integer, Integer> get_max_val(ArrayList <Pair<Integer,Integer>> list){
        int max = Integer.MIN_VALUE;
        
        Pair <Integer, Integer> highest_val_pair = new Pair <> (0, 0);
        for (Pair < Integer, Integer> cur_pair: list){
            int val = cur_pair.getValue();
            if (val > max){
                max = val;
                highest_val_pair = cur_pair;                      
            }    
        }
        return highest_val_pair;

}
    
    //function to return the corresponding weights and values lists with the highest value
    
    private static Pair<int[], int[]> get_max_val_weight_list(ArrayList <Pair<Pair<Integer, Integer>, Pair<int[], int[]>>> list,
                                                              Pair<Integer, Integer> max_val_pair){
        int max = Integer.MIN_VALUE;
        
        Pair <Integer, Integer> highest_val_pair = new Pair <> (0, 0);
        for (Pair<Pair<Integer, Integer>, Pair<int[], int[]>> cur_pair: list){
            //int val = cur_pair.getValue();
            if (cur_pair.getKey().equals(max_val_pair)){
                return cur_pair.getValue();
            }    
        }
       return null;

}
 
    //main main function to do seventy runs of the algoritnms
    private Pair<Pair<Integer, Integer>, Pair<int[], int[]>> final_main_knapsack(int []vals, int[]weights, int weight_cap){
     
        ArrayList< Pair<Integer, Integer>> tracklist = new ArrayList<>();
        ArrayList< Pair<Pair<Integer, Integer>, Pair<int[], int[]>>> tracklist_two = new ArrayList<>();
        int n = 0;
        
        System.out.println("70 runs of the algorithm");
        
        while (n <= 70){
            Pair<Pair<Integer, Integer>, Pair<int[], int[]>> answer = knapsack_main(vals, weights, weight_cap);
            //System.out.print(answer.toString());
            //answer.getKey() contains the sum of the weigths and vals that will be put in the knapsack.
            //answer.getValue() on the other hand, contains the lists of weights and values that were chosen to be in the knapsack.
            
            if( !(tracklist.contains(answer.getKey()))){
                tracklist.add(answer.getKey());
                tracklist_two.add(answer);
                }
            n++;              
        }
         System.out.println("\n\n ");
        System.out.println("tracklist " + tracklist.toString());
        Pair<Integer, Integer> max_val_pair = get_max_val(tracklist);
        System.out.println("max pair is " + max_val_pair );
        
        //get the correspinding lists for weights and values
        Pair<int[], int[]> max_val_weight_list= get_max_val_weight_list(tracklist_two, max_val_pair);
        System.out.println("corresponding list is " + Arrays.toString(max_val_weight_list.getKey()) + Arrays.toString(max_val_weight_list.getValue()));

        Pair<Pair<Integer, Integer>, Pair<int[], int[]>> final_final_answer  = new Pair<>(max_val_pair, max_val_weight_list);
        
        return final_final_answer;
    }
    
    
    //function that animates knapsack
    @FXML
    private void animate_knapsack(ActionEvent jevent) throws FileNotFoundException{
        
       
      Image image;
  String imageLocation = "/other_useful_resources/knapsack.png";

      image = new Image(this.getClass().getResourceAsStream(imageLocation));
   
      //Setting the image view 
      ImageView imageView = new ImageView(image); 
      
      //Setting the position of the image 
      imageView.setX(200); 
      imageView.setY(170); 
       //Setting the preserve ratio of the image view 
      imageView.setPreserveRatio(true); 
      //here!!!
      Stage stagec = (Stage) exit_btn.getScene().getWindow();
      stagec.close();
      Stage stagea = new Stage();
      //Creating a Group object  
      Group root = new Group(imageView);  
        int randomNum = ThreadLocalRandom.current().nextInt(1, 4);
        //hopefully these values will be replaced with real values
        int[] values = new int[]{ 60, 100, 120 };
        int[] weights = new int[]{10, 20, 30};
        int weight_capacity = 50;
        if (randomNum == 1){
            values = new int[]{ 60, 100, 120 };
            weights = new int[]{10, 20, 30};
            weight_capacity = 50;
             Label t;
            t = new Label ( "W: " + Integer.toString(weight_capacity)+ "g");
            t.setLayoutX(280);
            t.setLayoutY(250);
            t.setStyle("-fx-font: 24 Garamond; -fx-text-fill: #000000; ");
            root.getChildren().add(t);
            System.out.println("random number is "+ randomNum);

        }
        
        else if(randomNum == 2){
            values = new int[]{ 10, 40, 30, 50 };
            weights = new int[]{5, 4, 6, 3};
            weight_capacity = 10;
            Label r;
            r = new Label ( "W: " + Integer.toString(weight_capacity) + "kg");
            r.setLayoutX(280);
            r.setLayoutY(250);
            r.setStyle("-fx-font: 24 Garamond; -fx-text-fill: #000000; ");
            root.getChildren().add(r);
            System.out.println("random number is "+ randomNum);

        }
        
        else if(randomNum == 3){
            values = new int[]{ 15, 10, 9, 5 };
            weights = new int[]{1, 5, 3, 4};
            weight_capacity = 8;
            Label s;
            s = new Label ( "W: " + Integer.toString(weight_capacity)+ "kg");
            s.setLayoutX(280);
            s.setLayoutY(250);
            s.setStyle("-fx-font: 24 Garamond; -fx-text-fill: #000000; ");
            root.getChildren().add(s);
            System.out.println("random number is "+ randomNum);
   
        }
          System.out.println("works till here 1");
        Pair<Pair<Integer, Integer>, Pair<int[], int[]>> knapsack_vals =  final_main_knapsack(values, weights, weight_capacity);
        
        //back button to leave animation
         Button back = new Button("Back");
         back.setStyle("-fx-font: 18 Garamond; -fx-background-color: #011627; -fx-text-fill: #fdfffc; ");
       //see an example
       Button see_new = new Button("See another example");
         see_new.setStyle("-fx-font: 18 Garamond; -fx-background-color: #011627; -fx-text-fill: #fdfffc; ");
      
         Button check = new Button("Check");
         check.setStyle("-fx-font: 18 Garamond; -fx-background-color: #011627; -fx-text-fill: #fdfffc; ");
    
          //Creating an image 
       System.out.println("works till here 2");
      Color bgc = Color.valueOf("#f71735");
      Label info;
      info = new Label ("We need to put a combination of items in the bag with");
      info.setLayoutX(85);
      info.setLayoutY(30);
      info.setStyle("-fx-font: 22 Garamond; -fx-text-fill: #fdfffc; ");
    
       Label info1;
      info1 = new Label ( "the greatest value and still remain within the weight capacity(W).");
      info1.setLayoutX(40);
      info1.setLayoutY(60);
      info1.setStyle("-fx-font: 22 Garamond; -fx-text-fill: #fdfffc; ");
      
       Label info2;
      info2 = new Label ( "Click the check button to see which gold bars made it!");
      info2.setLayoutX(90);
      info2.setLayoutY(90);
      info2.setStyle("-fx-font: 22 Garamond; -fx-text-fill: #fdfffc; ");
      
      Label info3;
      info3 = new Label ( "Weights\t\tValues\t\t\t\t  Weights\t\tValues");
      info3.setLayoutX(30);
      info3.setLayoutY(140);
      info3.setStyle("-fx-font: 22 Garamond; -fx-text-fill: #fdfffc; ");
      
       System.out.println("works till here 3");
      
      //Creating a scene object 
      Scene scene = new Scene(root, 600, 500);  
      scene.setFill(bgc);
      //add all attributes
      root.getChildren().add(back);
      root.getChildren().add(check);
      root.getChildren().add(see_new);
      root.getChildren().add(info);
      root.getChildren().add(info1);
      root.getChildren().add(info2);
      root.getChildren().add(info3);
      //set position of check button
      check.setLayoutX(280.0);
      check.setLayoutY(420.0);
      //set position of see new button
      see_new.setLayoutX(430.0);
      see_new.setLayoutY(0.0);
      
      //drawing the gold bars
      
      Pair<int[], int[]> weight_vals = knapsack_vals.getValue();
      int [] weight_list = weight_vals.getKey();
      int [] values_list = weight_vals.getValue();
      
      int goldy_height = 140;
      int goldx_width = 30;
      int texty_height = 145;
      int textx_width = 45; 
      
             
         System.out.println("works till here 4");
    check.setOnAction(new EventHandler<ActionEvent>() {

       public void handle(ActionEvent event) {
            int goldy_rightheight = 140;
           int gold_rightx = 400;
           int texty_rightheight = 145;
           int text_rightx = 410;

      //put the right gold bars on the right side of the knapsack
      for (int i = 0; i < weight_list.length; i++){
          Image gold;
          String goldLocation = "/other_useful_resources/gold.png";
          gold = new Image(this.getClass().getResourceAsStream(goldLocation));
          //Setting the image view
          ImageView goldview = new ImageView(gold);
          //Setting the position of the gold bar
          goldview.setX(gold_rightx);
          goldy_rightheight = goldy_rightheight + 60;
          goldview.setY(goldy_rightheight);
          goldview.setPreserveRatio(true);
          root.getChildren().add(goldview);
          Label n = new Label(Integer.toString(weight_list[i]) + "g\t\t\t$"+ Integer.toString(values_list[i]));
          n.setLayoutX(text_rightx);
          texty_rightheight = texty_rightheight + 60;
          n.setLayoutY(texty_rightheight );
          n.setStyle("-fx-font: 22 Garamond; -fx-text-fill: #fdfffc; ");
          root.getChildren().add(n);
      
      }
      System.out.println("works till here 5");
      Pair<Integer, Integer> totals = knapsack_vals.getKey();
      int total_w = totals.getKey();
      int total_v = totals.getValue();
      
        Label q = new Label( "Total Weight: "+ Integer.toString(total_w));
        q.setLayoutX(text_rightx);
        texty_rightheight = texty_rightheight + 50;
        q.setLayoutY(texty_rightheight );
        q.setStyle("-fx-font: 22 Garamond; -fx-text-fill: #fdfffc; ");
        root.getChildren().add(q);
        Label m = new Label( "Total Value: "+ Integer.toString(total_v));
        m.setLayoutX(text_rightx);
        texty_rightheight = texty_rightheight + 40;
        m.setLayoutY(texty_rightheight );
        m.setStyle("-fx-font: 22 Garamond; -fx-text-fill: #fdfffc; ");
        root.getChildren().add(m);
      
                
            }
        });
      
      System.out.println("works till here 6");
      //put the gold bars on the left side of the knapsack...animate the left side.
      for (int i = 0; i < weights.length; i++){
        Image gold;
       String goldLocation = "/other_useful_resources/gold.png";
          gold = new Image(this.getClass().getResourceAsStream(goldLocation));
        ImageView goldview = new ImageView(gold); 
        //Setting the position of the gold bar 
        goldview.setX(goldx_width); 
        goldy_height = goldy_height + 60;
        goldview.setY(goldy_height); 
        goldview.setPreserveRatio(true);
        root.getChildren().add(goldview);

        Label j = new Label(Integer.toString(weights[i]) + "g\t\t\t$"+ Integer.toString(values[i]));
        j.setLayoutX(textx_width);
        texty_height = texty_height + 60;
        j.setLayoutY(texty_height );
        j.setStyle("-fx-font: 22 Garamond; -fx-text-fill: #fdfffc; ");
        root.getChildren().add(j);
      
      }
     
     System.out.println("works till here 7");
      back.setOnAction(new EventHandler<ActionEvent>() {
            
            public void handle(ActionEvent event) {
                Stage stagex = (Stage) back.getScene().getWindow();
                stagex.close();
                 FXMLLoader fxmlLoader = new 
                FXMLLoader(getClass().getResource("Animationtwo.fxml"));
                Parent root1;
                try {
                    root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    //set what you want on your stage
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setTitle("NP-problem");
                    stage.setScene(new Scene(root1));
                    stage.setResizable(false);
                    stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(AnimationoneController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
      
    //Setting title to the Stage 
  
    stagea.setTitle("Knapsack Problem");  
      
      //Adding scene to the stage 
      stagea.setScene(scene);
      stagea.show();
      
      System.out.println("works till here 9");
      see_new.setOnAction(new EventHandler<ActionEvent>() {
          public void handle(ActionEvent event) {
              Stage stager = (Stage) see_new.getScene().getWindow();
              stager.close();
              try {
                  //start here
                  animate_knapsack(event);
                  //end here
              } catch (FileNotFoundException ex) {
                  Logger.getLogger(AnimationtwoController.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
         });
      
      
      System.out.println("works till here 10");
    
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
    private void goto_preduc(ActionEvent event) throws IOException {
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

    private boolean contains_val(Pair<Pair<Integer, Integer>, Pair<int[], int[]>> answer, Pair<Pair<Integer, Integer>, Pair<int[], int[]>>[] tracklist) {
        
        for (int i = 0; i < tracklist.length; i++ ){
            if (tracklist[i] == answer)
                return true;        
        } 
        return false;  
    }

   
    
}
