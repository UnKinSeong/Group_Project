package com.ststjl_project.views.stages.Player_Panes.sub_Pane;

import com.ststjl_project.Cards.Bone_Card;
import com.ststjl_project.Cards.Card_Base;
import com.ststjl_project.Cards.Card_Container;
import com.ststjl_project.utility.Positioners;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.concurrent.TransferQueue;

import static com.ststjl_project.utility.Positioners.*;

public class Player_interface {
    public Player_interface(Pane pane){
        this.mainPane = pane;
    }
    public void Init(){
        for(int i = 0; i < paneBoxes.length; i++){
            paneBoxes[i] = new Pane();
            pane_border_box[i] = new Rectangle();
            pane_border_box[i].setFill(paneBoxes_Color[i]);
            paneBoxes[i].getChildren().add(pane_border_box[i]);
            mainPane.getChildren().add((paneBoxes[i]));
        }
        pane_border_box[5].setFill(Color.TRANSPARENT);
        paneBoxes[7].addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            for(int i = 0; i < card_baseArrayList.size();i++){
                if(card_baseArrayList.get(i).isSelect()){
                    card_marked_As_Destroy.set(i,true);
                }
            }
        });
        paneBoxes[6].addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            Card_Container.Draw_Card(card_baseArrayList, 1);
            card_marked_As_Destroy.add(false);
        });
        Card_Container.Draw_Card(card_baseArrayList,5);
        for(int i = 0; i < 5; i++){
            card_marked_As_Destroy.add(false);
        }
    }
    boolean is_begin = false;
    private void Positioning_Pane_Box(){
        for(int i = 0; i < paneBoxes.length; i++){
            {
                double paneBox_posX,paneBox_posY,paneBox_width,paneBox_height;
                double Stroke_Width = 0.005*Math.min(mainPane.getHeight(),mainPane.getWidth());
                paneBox_posX = mainPane.getWidth()*r_Panes_Pos[i][0];
                paneBox_posY = mainPane.getHeight()*r_Panes_Pos[i][1];
                paneBox_width = mainPane.getWidth()*r_Panes_Pos[i][2]-mainPane.getWidth()*r_Panes_Pos[i][0];
                paneBox_height = mainPane.getHeight()*r_Panes_Pos[i][3]-mainPane.getHeight()*r_Panes_Pos[i][1];
                setPanePosWH(paneBoxes[i],paneBox_posX, paneBox_posY, paneBox_width, paneBox_height);

                setRectanglePosWH(
                        pane_border_box[i],
                        0+Stroke_Width,0+Stroke_Width,
                        paneBox_width-Stroke_Width*2,
                        paneBox_height-Stroke_Width*2);
                pane_border_box[i].setStrokeWidth(Stroke_Width);
                pane_border_box[i].setStroke(Color.BLACK);
                pane_border_box[i].setFill(paneBoxes_Color[i]);
            }
        }
    }
    private void Rendering_Cards(){

        double card_PosX = pane_border_box[5].getLayoutX()+2;
        double card_PosY = pane_border_box[5].getLayoutY()+2;

        double card_height = pane_border_box[5].getHeight()-4;
        double card_width = pane_border_box[5].getHeight()*0.6;
        for(int i = card_baseArrayList.size()-1;i>-1;i--){
            if(card_marked_As_Destroy.get(i)==true){
                card_baseArrayList.get(i).CleanUp();
                paneBoxes[5].getChildren().remove(card_baseArrayList.get(i));
            }
        }
        for(int i = card_baseArrayList.size()-1;i>-1;i--){
            if(card_marked_As_Destroy.get(i)==true){
                card_marked_As_Destroy.remove(i);
                card_baseArrayList.remove(i);
            }
        }


        for(Card_Base cb: card_baseArrayList){
            cb.setPrefHeight(card_height);
            cb.setPrefWidth(card_width);
        }
        for(int i = 0;i< card_baseArrayList.size();i++){
            card_baseArrayList.get(i).setLayoutX(card_PosX+card_width*i);
        }
        if(is_begin){
            for(int i = 0; i < card_baseArrayList.size();i++){
                try{
                    if(card_baseArrayList.get(i).getLayoutX()>card_PosX){
                        card_baseArrayList.get(i).setLayoutX(card_baseArrayList.get(i).getLayoutX()-1);
                    }else{
                        card_baseArrayList.get(i).setLayoutX(card_baseArrayList.get(i).getLayoutX()+1);
                    }
                    card_baseArrayList.get(i).renderCard();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }else{
            for(Card_Base rb : card_baseArrayList){
                rb.setLayoutY(paneBoxes[5].getHeight());
                rb.renderCard();
            }
            is_begin=true;
        }
    }
    public void Draw_Yourself(){
        Positioning_Pane_Box();
        for(Card_Base cb : card_baseArrayList){
            if(cb.getParent()!=paneBoxes[5]){
                paneBoxes[5].getChildren().add(cb);
            }
        }
        Rendering_Cards();
    }

    public void clean_Up() {
        for(Card_Base r : card_baseArrayList)
        {
            r.unselect();
        }
        mainPane.getChildren().removeAll(paneBoxes);
    }

    private final ArrayList<Card_Base> card_baseArrayList = new ArrayList<>();
    private final ArrayList<Boolean> card_marked_As_Destroy = new ArrayList<>();
    private final Pane mainPane;
    private Pane paneBoxes[] = new Pane[8];
    private Rectangle pane_border_box[] = new Rectangle[8];
    private Color paneBoxes_Color[] = {Color.YELLOW,Color.RED,Color.BLUE,Color.DEEPPINK,Color.GREEN,Color.PURPLE,Color.GOLDENROD,Color.RED};
    private final double[][] r_Panes_Pos;
    {
        final double Row_1_EndY = (double) 100 / (double) 1080;
        final double Row_2_EndY = (double) 760 / (double) 1080;
        final double Row_3_EndY = 1;
        r_Panes_Pos = new double[][]{
                // ROW 1 //
                {0,0,(double)820/(double)1920,Row_1_EndY},
                {(double)820/(double)1920,0,(double)1640/(double)1920,Row_1_EndY},
                {(double)1640/(double)1920,0,1,Row_1_EndY},
                // ROW 2 //
                {0,Row_1_EndY,(double)1230/(double)1920,Row_2_EndY},
                {(double)1230/(double)1920,Row_1_EndY,1,Row_2_EndY},
                // ROW 3 //
                {0,Row_2_EndY,(double)1230/(double)1920,Row_3_EndY},
                {(double)1230/(double)1920,Row_2_EndY,(double)1600/(double)1920,Row_3_EndY},
                {(double)1600/(double)1920,Row_2_EndY,1,Row_3_EndY},
        };
    }
}
