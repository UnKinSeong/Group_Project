package com.ststjl_project.views.Game_Logic.Player;

import javafx.scene.shape.Shape;

public class Player_interface {
    private Player_interface(){};
    Shape player;
    public boolean check_collision(Shape shape){
        if(this.player.intersects(shape.getLayoutBounds())){
            return true;
        }
        return false;
    }
}
