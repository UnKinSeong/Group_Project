package com.ststjl_project.Cards;

import javafx.scene.paint.Color;

public class Bone_Card extends Card_Base{
    @Override
    public void drawYourself() {

    }

    public Bone_Card(
            String card_Name,
            double base_damage,
            double base_critical_chance,
            double self_damage
    ){
        super(
                card_Name,
                "Bone",
                base_damage,
                base_critical_chance,
                self_damage);

        Color[] BoxColors = {
                Color.BLACK,
                Color.BLUE,
                Color.YELLOW,
                Color.DARKCYAN,
                Color.YELLOW
        };
        Color[] TextColors = {
                Color.YELLOW,
                Color.RED,
                Color.DARKBLUE,
                Color.BLACK
        };
        setBoxes_Colors(BoxColors);
        setText_Colors(TextColors);
    }
}
