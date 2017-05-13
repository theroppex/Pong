/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprites;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import misc.Updatable;
import pong.Pong;

/**
 *
 * @author thero
 */
public class Ball extends Sprite implements Updatable{
    private final double BALL_WIDTH = 10;
    private final double BALL_HEIGHT = 10;
    
    private boolean isUp = true;
    private boolean isRight = false;
    
    private double xSpeed;
    private double ySpeed;
    
    public Ball(double startX, double startY) {
        xSpeed = 6;
        ySpeed = Math.random()*4 + 1.5;
        Rectangle ball = new Rectangle(BALL_WIDTH, BALL_HEIGHT, Color.WHITE);
        setTranslateX(startX - BALL_WIDTH/2);
        setTranslateY(startY - BALL_HEIGHT/2);
        getChildren().add(ball);
    }

    @Override
    public void update() {
        calculateDirection();
        
        
        if(isUp){
            setTranslateY(getTranslateY() - ySpeed);
        }
        else{
            setTranslateY(getTranslateY() + ySpeed);
        }
        
        if(isRight){
            setTranslateX(getTranslateX() + xSpeed);
        }
        else{
            setTranslateX(getTranslateX() - xSpeed);
        }
    }
    
    private void calculateDirection(){
        if(getTranslateY() > Pong.HEIGHT - BALL_HEIGHT){
            isUp = true;
        }
        if(getTranslateY() < 0){
            isUp = false;
        }
    }
    
    public void setDirectionX(boolean direction){
        isRight = direction;
    }
}
