package com.ststjl_project.Cards;

public class Energy_Card extends Card_Base{
    @Override
    public void drawYourself() {

    }


    public Energy_Card(
            String card_Name,
            double base_damage,
            double base_critical_chance,
            double self_damage
    ){
        super(
                card_Name,
                "Energy",
                base_damage,
                base_critical_chance,
                self_damage);
    }
}
