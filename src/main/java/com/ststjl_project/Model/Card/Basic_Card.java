package com.ststjl_project.Model.Card;

import com.ststjl_project.Utility.Random_Number;
import javafx.scene.paint.Color;

public class Basic_Card extends Card_Base {
    Basic_Card(){};
    public Basic_Card(String name,double base_Damage,double base_CritChanceBonus, double base_CritChance, double cost){
        super(name,base_Damage,base_CritChanceBonus,base_CritChance,cost);
        super.Boxes_Colors = Boxes_Colors;
        super.Text_Colors = Text_Colors;
    }

    @Override
    public String getTypeName() {
        return "Basic";
    }

    @Override
    public double getDamage() {
        return base_Damage+(((double) Random_Number.randInt(0,100))>=base_CritChance?base_CritChanceBonus:0d);
    }
    protected Color[] Boxes_Colors = {
            Color.BLACK,
            Color.GRAY,
            Color.GRAY,
            Color.GRAY,
            Color.GRAY,
    };
    protected Color [] Text_Colors = {
            Color.BLACK,
            Color.BLACK,
            Color.BLACK,
            Color.BLACK
    };
}
