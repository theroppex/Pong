/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprites;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author thero
 */
public class Score extends Sprite{
    private static final double FONT_SIZE = 40;
    private Text score = new Text("0");

    public Score(double startPositionX, double startPositionY) {
        score.setFont(new Font(FONT_SIZE));
        score.setFill(Color.WHITE);
        this.getChildren().add(score);
        this.setTranslateX(startPositionX);
        this.setTranslateY(startPositionY);
    }
    
    public void setScore(int score){
        this.score.setText(score + "");
    }
}
