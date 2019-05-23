package snake;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class Main extends Application {
    boolean GameKhtm = false;
    Label label ;
    TimerTask tt;
    int ScheduleTime =100;
    boolean DialogueFlag = true;
    boolean grow = false;
    boolean growUP2 = false;
    Timer t = new Timer();
    public int Scores = 0;
    public int Direction ;
    Snake Snake1 = new Snake();
    Food Food;
    Group root;
    Barriers Barriers = new Barriers();
    public List<Rectangle> Snake = new ArrayList<Rectangle>();
    Dots Dots = new Dots();

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        label = new Label();
        label.setFont(new Font("Blackadder ITC",72));
        
        primaryStage.setTitle("Snake Game");
        root = new Group();
        Scene scene = new Scene(root, 600, 650, Color.WHITE);
        Food = new Food(root);
        label.setLayoutX(100);
        label.setLayoutY(200);
        Food.r1.setFill(Color.RED);
        Snake1.SnakeOnScene(root, Snake);
        Barriers.setWalls(root);
        label.setVisible(false);
        root.getChildren().add(label);
        //root.setC
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        scene.setOnKeyPressed(e -> {
            if(GameKhtm)
            {}
            else{
                
            if (e.getCode() == KeyCode.RIGHT && Direction != 1&& Direction != 2) {
                Snake1.moveRight(Snake);
                Direction = 1;
            } else if (e.getCode() == KeyCode.LEFT && Direction != 2 && Direction != 1) {
                Snake1.moveLeft(Snake);
                Direction = 2;

            } else if (e.getCode() == KeyCode.UP && Direction != 3&& Direction != 4) {
                Snake1.moveUp(Snake);
                Direction = 3;
            } else if (e.getCode() == KeyCode.DOWN && Direction != 4&& Direction != 3) {
                Snake1.moveDown(Snake);
                Direction = 4;
                //Snake1.GrowUp(Snake,root);

            }
            if (Snake.get(0).getX() == Food.r1.getX() && Snake.get(0).getY() == Food.r1.getY()) {
                //Snake1.GrowUp(Snake, root);
                Food.NewPosition();
                Scores++;
                grow = true;
                growUP2 = true;

            }
            if (Snake1.hitTheWall(Snake)||Snake1.BiteItself(Snake)) {
                t.cancel();
                if(DialogueFlag){
                    JOptionPane.showMessageDialog(null, "game over\nYour Scores "+Scores, "Hahaha " , JOptionPane.INFORMATION_MESSAGE);
                       
                    DialogueFlag = !DialogueFlag;
                }
            }
            if(grow){
               Snake1.GrowUp(Snake, root);
               grow = !grow;
            }
            else if(growUP2){
                Snake1.GrowUp(Snake, root);
               growUP2 = !true;
            }
            }
        });

        tt = new TimerTask() {
            public void run() {
                if (Direction == 1) {
                    Snake1.moveRight(Snake);
                } else if (Direction == 2) {
                    Snake1.moveLeft(Snake);
                } else if (Direction == 3) {
                    Snake1.moveUp(Snake);
                } else if (Direction == 4) {
                    Snake1.moveDown(Snake);
                }
                if (Snake.get(0).getX() == Food.r1.getX() && Snake.get(0).getY() == Food.r1.getY()) {
                    //Snake1.GrowUp(Snake, root);
                    Food.NewPosition();
                    Scores++;
                    grow = true;
                       growUP2 = true;
                }
                if (Snake1.hitTheWall(Snake)||Snake1.BiteItself(Snake)) {
                    //System.out.println("Scores ="+Scores);
                    t.cancel();
                    if(DialogueFlag){
                         JOptionPane.showMessageDialog(null, "game over\nYour Scores "+Scores, "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
                        DialogueFlag = !DialogueFlag;
                }
                }
             
            }
        };
        t.schedule(tt, 40, 40);

    }
}
