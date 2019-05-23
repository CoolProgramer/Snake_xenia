/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import javafx.scene.Group;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Touseef Ahmad
 */
public class Food extends Dots{
    Rectangle r1 ;
    public Food(Group root){
        r1  = new Rectangle(super.getRandX(),super.getRandY(),10,10);
        root.getChildren().add(r1);
    }
    public void NewPosition(){
       r1.setX(super.getRandX());
       r1.setY(super.getRandY());
    }
}
