package com.ststjl_project.Cards;

public class Basic_Card extends Card_Base{
    @Override
    public void drawYourself() {

    }


    public Basic_Card(
            String card_Name,
            double cost,
            double base_damage,
            double base_critical_chance
    ){
        super(
                card_Name,
                "Basic",
                cost,
                base_damage,
                base_critical_chance);
    }
}
