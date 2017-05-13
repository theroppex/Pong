/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import players.Player;
import players.PlayerAI;
import sprites.Background;
import sprites.Ball;
import sprites.Paddle;
import sprites.Score;

/**
 *
 * @author thero
 */
public class Pong extends Application {
    public static final double WIDTH = 800;
    public static final double HEIGHT = 400;
    public static final String TITLE = "Nubov pong";
    
    //Players
    Player player = new Player();
    
    PlayerAI computer = new PlayerAI();
    
    //Loptica
    static Ball ball = new Ball(WIDTH/2, HEIGHT/2);
    
    public static Ball getBall(){
        return ball;
    }
    
    //Scores
    Score playerScoreLabel = new Score(WIDTH/2 - 50, 50);
    Score computerScoreLabel = new Score(WIDTH/2 + 50, 50);
    
    int playerScore = 0;
    int computerScore = 0;
    
    private void update(){
        ball.update();
        player.update();
        computer.update();
        
        if(ball.getTranslateX() < 10 && ball.getTranslateX() > 0 &&
                ball.getTranslateY() > player.getTranslateY() && 
                ball.getTranslateY() < player.getTranslateY() + 100){
            ball.setDirectionX(true);
        }
        
        if(ball.getTranslateX() > computer.getTranslateX() - 10 && ball.getTranslateX() < WIDTH - 10 &&
                ball.getTranslateY() > computer.getTranslateY() && 
                ball.getTranslateY() < computer.getTranslateY() + 100){
            ball.setDirectionX(false);
        }
        
        if(ball.getTranslateX() > WIDTH){
            ball.setTranslateX(WIDTH/2);
            ball.setTranslateY(HEIGHT/2);
            playerScore++;
            playerScoreLabel.setScore(playerScore);
        }
        
        if(ball.getTranslateX() < - 10){
            ball.setTranslateX(WIDTH/2);
            ball.setTranslateY(HEIGHT/2);
            computerScore++;
            computerScoreLabel.setScore(computerScore);
        }
    }
    
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        
        Background bg = new Background(WIDTH, HEIGHT);
        
        root.getChildren().add(bg);
        root.getChildren().add(ball);
        root.getChildren().addAll(player, computer);
        root.getChildren().addAll(playerScoreLabel, computerScoreLabel);
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        
        Timeline tick = new Timeline(new KeyFrame(Duration.millis(1000/60), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               update();
            }
        }));
        
        tick.setCycleCount(Timeline.INDEFINITE);
        tick.play();
        
        scene.addEventHandler(KeyEvent.KEY_PRESSED, player);
        scene.addEventHandler(KeyEvent.KEY_RELEASED, player);
        
        primaryStage.setTitle(TITLE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
