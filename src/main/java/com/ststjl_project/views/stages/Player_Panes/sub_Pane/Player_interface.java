package com.ststjl_project.views.stages.Player_Panes.sub_Pane;

import com.ststjl_project.utility.Positioners;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static com.ststjl_project.utility.Positioners.*;

public class Player_interface {
    private final GraphicsContext mainGC;
    private final Pane mainPane;

    private Pane paneBoxes[] = new Pane[7];
    private Rectangle pane_border_box[] = new Rectangle[7];
    private Color paneBoxes_Color[] =
    {
            Color.YELLOW,
            Color.RED,
            Color.BLUE,
            Color.DEEPPINK,
            Color.GREEN,
            Color.PURPLE,
            Color.RED
    };
    private final double r_Panes_Pos[][]= {
            //-------//
            // ROW 1 //
            //-------//
            {
                    0,
                    0,
                    (double)820/(double)1920,
                    (double)200/(double)1080
            },
            {
                    (double)820/(double)1920,
                    0,
                    (double)1640/(double)1920,
                    (double)200/(double)1080
            },
            {
                    (double)1640/(double)1920,
                    0,
                    1,
                    (double)200/(double)1080
            },
            //-------//
            // ROW 2 //
            //-------//
            {
                    0,
                    (double)200/(double)1080,
                    (double)1230/(double)1920,
                    (double)760/(double)1080
            },
            {
                    (double)1230/(double)1920,
                    (double)200/(double)1080,
                    1,
                    (double)760/(double)1080
            },
            //-------//
            // ROW 3 //
            //-------//
            {
                    0,
                    (double)760/(double)1080,
                    (double)1600/(double)1920,
                    1
            },
            {
                    (double)1600/(double)1920,
                    (double)760/(double)1080,
                    1,
                    1
            },
    };



    public Player_interface(GraphicsContext GC, Pane pane){
        this.mainGC = GC;
        this.mainPane = pane;
    }

    public double getRelated_(double size, double relatedX, double relatedX2){
        return Math.abs(size*relatedX-size*relatedX2);
    }

    public void Init(){
        for(int i = 0; i < paneBoxes.length; i++){
            paneBoxes[i] = new Pane();
            pane_border_box[i] = new Rectangle();
            pane_border_box[i].setFill(paneBoxes_Color[i]);
            paneBoxes[i].getChildren().add(pane_border_box[i]);
            mainPane.getChildren().add((paneBoxes[i]));
        }
    }
    public void Draw_Yourself(){
        double paneBox_posX,paneBox_posY,paneBox_width,paneBox_height;
        for(int i = 0; i < paneBoxes.length; i++){

            paneBox_posX = mainPane.getWidth()*r_Panes_Pos[i][0];
            paneBox_posY = mainPane.getHeight()*r_Panes_Pos[i][1];
            paneBox_width = mainPane.getWidth()*r_Panes_Pos[i][2]-mainPane.getWidth()*r_Panes_Pos[i][0];
            paneBox_height = mainPane.getHeight()*r_Panes_Pos[i][3]-mainPane.getHeight()*r_Panes_Pos[i][1];
            paneBoxes[i].setLayoutX(paneBox_posX);
            paneBoxes[i].setLayoutY(paneBox_posY);
            paneBoxes[i].setPrefWidth(paneBox_width);
            paneBoxes[i].setPrefHeight(paneBox_height);


            pane_border_box[i].setLayoutX(0);
            pane_border_box[i].setLayoutY(0);
            pane_border_box[i].setWidth(paneBox_width);
            pane_border_box[i].setHeight(paneBox_height);
            pane_border_box[i].setFill(paneBoxes_Color[i]);
        }
    }

    public void clean_Up() {

    }
}
