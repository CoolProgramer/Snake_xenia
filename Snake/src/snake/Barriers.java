
package snake;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Barriers {
    public void setWalls(Group root){
        Rectangle[] Walls = new Rectangle[4];
        Walls[0] = new Rectangle(0,0,20,650);
        Walls[1] = new Rectangle(0,0,600,20);
        Walls[2] = new Rectangle(590,0,20,650);
        Walls[3] = new Rectangle(0,640,610,20);
        for(int x=0;x<4;x++)
            Walls[x].setFill(Color.AQUAMARINE);
        root.getChildren().addAll(Walls);
    }
}
