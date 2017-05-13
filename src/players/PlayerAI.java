/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package players;

import misc.Updatable;
import pong.Pong;
import sprites.Paddle;
import sprites.Sprite;

/**
 *
 * @author thero
 */
public class PlayerAI extends Sprite implements Updatable{
    private static final double SPEED = 2.5;
    
     private double direction = 0;
    
    private static final double PADDLE_START_X = Pong.WIDTH - Paddle.getPaddleWidth();
    private static final double PADDLE_START_Y = Pong.HEIGHT/2 - Paddle.getPaddleHeight()/2;
    
    Paddle paddle;

    public PlayerAI() {
        this.paddle = new Paddle();
        
        getChildren().add(paddle);
        
        setTranslateX(PADDLE_START_X);
        setTranslateY(PADDLE_START_Y);
    }
    
    @Override
    public void update(){
        calculateDirection();
        
        setTranslateY(getTranslateY() + SPEED*direction);
    }
    
    private void calculateDirection(){
        double ballPosition = Pong.getBall().getTranslateY();
        double ballPositionX = Pong.getBall().getTranslateX();
        
        if(ballPosition > getTranslateY() + 50 && ballPositionX > 600){
            direction = 1;
        }
        else if(ballPosition < getTranslateY() + 50 && ballPositionX > 600){
            direction = -1;
        }
        /*
        else if(getTranslateY() + 50 < Pong.HEIGHT/2){
            direction = 1;
        }
        else if(getTranslateY() + 50 > Pong.HEIGHT/2){
            direction = -1;
        }
        */
        else{
            direction = 0;
        }
    }
}
