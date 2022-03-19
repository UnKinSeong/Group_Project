package com.ststjl_project.Game_Logic.Player;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class player_base extends Shape {
    private player_base(){};
    Shape player;
    public boolean check_collision(Shape shape){
        if(this.player.intersects(shape.getLayoutBounds())){
            return true;
        }
        return false;
    }
}
