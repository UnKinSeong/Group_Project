package com.ststjl_project.Cards;

import javafx.scene.paint.Color;

import java.nio.charset.Charset;

public class Blood_Card extends Card_Base{
    @Override
    public void drawYourself() {

    }
    public Blood_Card(
            String card_Name,
            double base_damage,
            double base_critical_chance,
            double self_damage
    ){
        super(
                card_Name,
                "Blood",
                base_damage,
                base_critical_chance,
                self_damage);
        Color[] BoxColors = {
                Color.BLACK,
                Color.GREEN,
                Color.WHITE,
                Color.LIGHTGRAY,
                Color.RED
        };
        Color[] TextColors = {
                Color.WHITE,
                Color.BLUE,
                Color.RED,
                Color.BLUE
        };
        setBoxes_Colors(BoxColors);
        setText_Colors(TextColors);
    }

    @Override
    public void Update_Card_Detail() {
    }
}
