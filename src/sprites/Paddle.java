/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprites;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author thero
 */
public class Paddle extends Sprite{
    private static final double PADDLE_WIDTH = 10;
    private static final double PADDLE_HEIGHT = 100;
    
    private static final double SPEED = 4;

    public Paddle() {
        Rectangle paddle = new Rectangle(PADDLE_WIDTH, PADDLE_HEIGHT, Color.WHITE);
        getChildren().add(paddle);
    }

    public static double getPaddleHeight() {
        return PADDLE_HEIGHT;
    }

    public static double getPaddleWidth() {
        return PADDLE_WIDTH;
    }
}
