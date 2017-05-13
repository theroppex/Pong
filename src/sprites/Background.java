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
public class Background extends Sprite{
    private double width;
    private double height;

    public Background(double width, double height) {
        this.width = width;
        this.height = height;
        
        Rectangle bg = new Rectangle(width, height);
        bg.setFill(Color.BLACK);
        
        Rectangle net = new Rectangle(5, height, Color.WHITE);
        net.setTranslateX(width/2 - 2.5);
        
        getChildren().addAll(bg, net);
    }
    
    
}
