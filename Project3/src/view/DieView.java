//CS 2450 001 
//Shreyesh Arangath 
//shreyesh.arangath@ttu.edu

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import project3.Die;

/**
 *
 * @author shreyesh
 */
public class DieView{
    
    //SIZE Attributes
    public static final int WIDTH = 120;
    public static final int HEIGHT = 120;
    
    //Current Dice as per the roll
    public static List remainingDice = new ArrayList<Die>();
    public static List selectedDice = new ArrayList<Die>();
    
   
    public enum AssetsURL{
        ARROW("assets/arrow.png"),
        BEER("assets/beer.png"),
        DYNAMITE("assets/dynamite.png"),
        GATLING("assets/gatling.png"),
        ONE("assets/1.png"),
        TWO("assets/2.png");
        
        public String url;
        
        AssetsURL(String url){
            this.url = url;
        }

        public static String getImage(String face){
            switch(face.toLowerCase()){
                case "arrow":
                    return AssetsURL.ARROW.url;
                case "beer": 
                    return AssetsURL.BEER.url;
                case "dynamite":
                    return AssetsURL.DYNAMITE.url;
                case "gatling":
                    return AssetsURL.GATLING.url;
                case "one": 
                    return AssetsURL.ONE.url;
                default:
                    return AssetsURL.TWO.url;
            }
        }
        
    };
    
    
    public static HBox display(List<Die> dice){
        
        Die die1 = (Die) dice.get(0);
        Die die2 = (Die) dice.get(1);
        Die die3 = (Die) dice.get(2);
        Die die4 = (Die) dice.get(3);
        Die die5 = (Die) dice.get(4);
        
        remainingDice = dice;
       
        Button oneButton = assignDie(die1);
        oneButton.setOnAction(e->{
            oneButton.setVisible(false);
            remainingDice.remove(die1);
            selectedDice.add(die1);
        });
        
        Button twoButton = assignDie(die2);
        twoButton.setOnAction(e->{
            twoButton.setVisible(false);
            remainingDice.remove(die2);
            selectedDice.add(die2); 
        });
        
        Button threeButton = assignDie(die3);
        threeButton.setOnAction(e->{
            threeButton.setVisible(false);
            remainingDice.remove(die3);
            selectedDice.add(die3);
        });
        
        Button fourButton = assignDie(die4);
        fourButton.setOnAction(e->{
            fourButton.setVisible(false);
            remainingDice.remove(die4);
            selectedDice.add(die4);
        });
        
        Button fiveButton = assignDie(die5);
        fiveButton.setOnAction(e->{
            fiveButton.setVisible(false);
            remainingDice.remove(die5);
            selectedDice.add(die5);
        });
        

        HBox diceLayout = new HBox(20);
        diceLayout.getChildren().addAll(oneButton, twoButton, threeButton, fourButton, fiveButton);
        
        return diceLayout;
    }
    
    public static Button assignDie(Die die){
        
        String url = AssetsURL.getImage(die.getFace());
        
        Button button = new Button();
        button.setPrefSize(WIDTH, HEIGHT);
        button.setStyle( "-fx-background-image: url("+ url
                + ");"
                + "");
        
        return button;
    }
    
    
    
}
