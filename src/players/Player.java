/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package players;

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import misc.Updatable;
import sprites.Paddle;
import pong.Pong;
import sprites.Sprite;

/**
 *
 * @author thero
 */
public class Player extends Sprite implements Updatable, EventHandler<KeyEvent>{
    private static final double SPEED = 4.f;
    
    private double direction = 0;
    
    private static final double PADDLE_START_X = 0.f;
    private static final double PADDLE_START_Y = Pong.HEIGHT/2 - Paddle.getPaddleHeight()/2;
    
    Paddle paddle;
    

    public Player() {
        this.paddle = new Paddle();
        
        getChildren().add(paddle);
        
        setTranslateX(PADDLE_START_X);
        setTranslateY(PADDLE_START_Y);
    }
    
    @Override
    public void update(){
        setTranslateY(getTranslateY() + SPEED*direction);
    }

    @Override
    public void handle(KeyEvent event) {
        KeyCode code = event.getCode();
        EventType type = event.getEventType();
        
        if(code == KeyCode.UP && type == KeyEvent.KEY_PRESSED){
            if(direction == 0)
                direction = direction - 1;
        }
        else if(code == KeyCode.UP && type == KeyEvent.KEY_RELEASED){
            direction = 0;
        }
        else if(code == KeyCode.DOWN && type == KeyEvent.KEY_PRESSED){
            if(direction == 0)
                direction = direction + 1;
        }
        else if(code == KeyCode.DOWN && type == KeyEvent.KEY_RELEASED){
            direction = 0;
        }
    }
}
