package com.ststjl_project.views.stages.Player_Panes.sub_Pane;

import com.ststjl_project.Cards.Blood_Card;
import com.ststjl_project.Cards.Bone_Card;
import com.ststjl_project.Cards.Card_Base;
import com.ststjl_project.Cards.Card_Container;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Card_Deck extends _Status_Pane{
    private ArrayList<Card_Base> cards_in_deck;
    private ArrayList<Boolean>   is_Card_Displayed;
    @Override
    public void Init(double[] Related_pos) {
        Card_Area = new Rectangle();
        setRelated_pos(Related_pos);
        getChildren().add(Card_Area);
        cards_in_deck=new ArrayList<>();
        is_Card_Displayed=new ArrayList<>();
        for(int i = 0; i < 5; i++){
            cards_in_deck.add(Card_Container.getCard(i));
            is_Card_Displayed.add(false);
        }
    }

    @Override
    public void reDraw() {
        reSizing();
        double Stroke_Width = 0.05*getHeight();
        Paint Stroke_Paint = Paint.valueOf("black");
        Card_Area.setLayoutX(0+Stroke_Width);
        Card_Area.setLayoutY(0+Stroke_Width);
        Card_Area.setWidth(getWidth()-Stroke_Width*2);
        Card_Area.setHeight(getHeight()-Stroke_Width*2);
        Card_Area.setFill(Color.WHITE);
        Card_Area.setStrokeWidth(Stroke_Width);
        Card_Area.setStroke(Stroke_Paint);

        double Padding = 10;

        double card_init_layX = Card_Area.getLayoutX()+Padding;
        double card_init_layY = Card_Area.getLayoutY()+Padding;
        double card_height = Card_Area.getHeight()-Padding*2;
        double card_width = card_height/1.46;

        Card_Base card_;
        for(int i = 0; i < cards_in_deck.size();i++){
            if(is_Card_Displayed.get(i)){
                card_ = cards_in_deck.get(i);
                card_.setLayoutX(card_init_layX+(card_width+Padding)*i);
                card_.setLayoutY(card_init_layX);
                card_.setPrefHeight(card_height);
                card_.setPrefWidth(card_width);
                card_.renderCard();
            }else{
                getChildren().add(cards_in_deck.get(i));
                is_Card_Displayed.set(i,true);
                card_ = cards_in_deck.get(i);
                card_.setLayoutX(card_init_layX+(card_width+Padding)*i);
                card_.setLayoutY(card_init_layX);
                card_.setPrefHeight(card_height);
                card_.setPrefWidth(card_width);
                card_.renderCard();

            }

        }
    }

    @Override
    public void CleanUp() {
        getChildren().remove(Card_Area);
        int len_dk = cards_in_deck.size();
        for(int i = 0; i < len_dk;i++){

        }
        getChildren().remove(cards_in_deck);
    }

    @Override
    public void updateData(double[] data) {

    }
    private Rectangle Card_Area;
}
