/*Kaitlin Giles, Lab 5, 03/12/2021
Create three stage javafx program */

package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;
import javafx.scene.input.MouseEvent;
import java.util.Random;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class Giles_Lab5 extends Application {
    //initiate variables to be used for row/column placement logic
    int j = 0;
    int k = 0;
    int jj = 0;
    int kk = 0;
    int count = 0;
    Button[] buttArr = new Button[100];
    Label[] labArr = new Label[100];

    @Override //override the start method in the application class
    public void start(Stage primaryStage){

        //create pane and image
        Pane pane3 = new HBox(); //create pane
        Image doge = new Image("https://images2.imgbox.com/db/53/pA0Fq3bJ_o.jpg"); //do not click on this link because image hosting site is sketchy and has NSFW ads
        ImageView iv = new ImageView(doge);
        iv.setFitHeight(732);
        iv.setFitWidth(386);
        pane3.getChildren().add(iv); //put image in pane

        //create scene and place it in stage
        Scene scene3 = new Scene(pane3); //create scene
        Stage stage3 = new Stage(); //create new stage
        stage3.setTitle("Third Stage/Best Stage"); //set stage title
        stage3.setScene(scene3); //place scene in stage
        stage3.show(); //display stage

        //create and align pane for stage two
        GridPane pane2 = new GridPane(); //create pane
        pane2.setAlignment(Pos.CENTER); //align pane

        //this logic creates a 10x10 grid of labels (j==columns, k==rows)
        while (jj < 10) {
            labArr[count] = new Label(getInt());//label placed into array; content generated via getInt method
            pane2.add(labArr[count], jj, kk); //label placed in position in pane
            kk++;
            count++;
            if (kk == 10){
                jj++;
                kk = 0;
            }
        }
        //iterate through array and apply labCent method to each label
        for (int i = 0; i < labArr.length; i++) {
            labCent(labArr[i]);
        }

        //this block sets and runs stage two
        Scene scene2 = new Scene(pane2, 300, 300);//create scene
        Stage stage2 = new Stage(); //create new stage
        stage2.setTitle("Second Stage"); // set stage title
        stage2.setScene(scene2); //place scene in stage
        stage2.show(); // display stage

        //create and align pane for stage one
        GridPane pane = new GridPane(); //create pane
        pane.setAlignment(Pos.CENTER); //align pane
        pane.setStyle("-fx-background-color:#000000"); //set pane background color
        count = 0; //resets count from prior stage loop

            //this logic creates a 10x10 grid of buttons (j==columns, k==rows)
            while (j < 10) {
                buttArr[count] = new Button(" "); //places each button into array
                pane.add(buttArr[count], j, k); //place button into position in pane
                buttArr[count].setStyle("-fx-background-color:#951aa1; -fx-border-color: #ffffff; -fx-border-width: 2px"); //make it pretty
                k++;
                count++;
                if (k == 10){
                    j++;
                    k = 0;
                }
            }
            //iterate through array and apply mouseButt method to each label
            for (int i = 0; i < buttArr.length; i++) {
                mouseButt(buttArr[i]);
            }

        //this block sets and runs stage one
        Scene scene1 = new Scene(pane, 300, 300); //create scene
        primaryStage.setTitle("First Stage"); //set stage title
        primaryStage.setScene(scene1); //place scene in stage
        primaryStage.show(); //display the stage
    }

    //main method
    public static void main(String[] args) {
        launch(args);
    }

    //this method randomly generates 0 or 1 and returns as string
    public static String getInt() {
        Random number = new Random(); //instance of random class
        int upperbound = 2;
        int random = number.nextInt(upperbound);
        return String.valueOf(random);
    }

    //this method sets a drop shadow when mouse is over button area
    public static void mouseButt(Button butt) {
        DropShadow shadow = new DropShadow();
        butt.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle (MouseEvent e) {
                        butt.setEffect(shadow);
                }
            });
        butt.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle (MouseEvent e) {
                        butt.setEffect(null);
                    }
                });
    }

    //this method centers text within label
    public static void labCent(Label lab) {
        lab.setTextAlignment(TextAlignment.CENTER);
    }
}
