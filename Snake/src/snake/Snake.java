/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.util.List;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Touseef Ahmad
 */
public class Snake extends Dots{
    public boolean BiteItself(List<Rectangle> Snake){
       for(int x=0;x<Snake.size();x++){
           for(int y=0;y<Snake.size();y++){
               if(x == y)
                   continue;
               if(Snake.get(x).getX() == Snake.get(y).getX() && Snake.get(x).getY() == Snake.get(y).getY()){
                   return true;
               }
            }
       }
       return false;
    }
    public boolean hitTheWall(List<Rectangle> Snake){
        if(Snake.get(0).getX()==10||Snake.get(0).getX()==590||Snake.get(0).getY()==10||Snake.get(0).getY()==640){
            return true;
        }
        return false;
    }
    public void SnakeOnScene(Group root,List<Rectangle> Snake){
        for(int x=0;x<10;x++){
            
            Snake.add(new Rectangle(100+x*10,100,10,10));
            if(x==0)
                Snake.get(0).setFill(Color.DARKORANGE);
            root.getChildren().add(Snake.get(x));
        }
        
    }
    public void moveRight(List<Rectangle> Snake){
        Rectangle[] temp = new Rectangle[Snake.size()];
        for(int x=0;x<Snake.size();x++){
            temp[x]=new Rectangle(Snake.get(x).getX(),Snake.get(x).getY(),10,10);
        }
        Snake.get(0).setX(Snake.get(0).getX()+10);
        for(int x=1;x<Snake.size();x++){
            
            Snake.get(x).setX(temp[x-1].getX());
            Snake.get(x).setY(temp[x-1].getY());
        }
       
    }
    public void moveLeft(List<Rectangle> Snake){
        Rectangle[] temp = new Rectangle[Snake.size()];
        for(int x=0;x<Snake.size();x++){
            temp[x]=new Rectangle(Snake.get(x).getX(),Snake.get(x).getY(),10,10);
        }
        Snake.get(0).setX(Snake.get(0).getX()-10);
        for(int x=1;x<Snake.size();x++){
            
            Snake.get(x).setX(temp[x-1].getX());
            Snake.get(x).setY(temp[x-1].getY());
        }
       
    }
    public void moveUp(List<Rectangle> Snake){
        Rectangle[] temp = new Rectangle[Snake.size()];
        for(int x=0;x<Snake.size();x++){
            temp[x]=new Rectangle(Snake.get(x).getX(),Snake.get(x).getY(),10,10);
        }
        Snake.get(0).setY(Snake.get(0).getY()-10);
        for(int x=1;x<Snake.size();x++){
            
            Snake.get(x).setX(temp[x-1].getX());
            Snake.get(x).setY(temp[x-1].getY());
        }
       
    }
    public void moveDown(List<Rectangle> Snake){
        Rectangle[] temp = new Rectangle[Snake.size()];
        for(int x=0;x<Snake.size();x++){
            temp[x]=new Rectangle(Snake.get(x).getX(),Snake.get(x).getY(),10,10);
        }
        Snake.get(0).setY(Snake.get(0).getY()+10);
        for(int x=1;x<Snake.size();x++){
            
            Snake.get(x).setX(temp[x-1].getX());
            Snake.get(x).setY(temp[x-1].getY());
        }
       
    }
    public void GrowUp(List<Rectangle> Snake,Group root){
        Snake.add(new Rectangle(Snake.get(Snake.size()-1).getX(),Snake.get(Snake.size()-1).getY(),10,10));
        root.getChildren().add(Snake.get(Snake.size()-1));
    }

    
}
