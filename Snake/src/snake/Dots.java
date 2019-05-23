/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.util.Random;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Touseef Ahmad
 */
public class Dots {
    Random Random = new Random();
    
    private int Randomx,Randomy;
    int getRandX(){
        Randomx=1;
        while(Randomx%10!=0){
            Randomx = Random.nextInt(560)+20;
        }
        return Randomx;
    }
    int getRandY(){
        Randomy=1;
        while(Randomy%10!=0){
            Randomy = Random.nextInt(560)+20;
        }
        return Randomy;
    }
}
