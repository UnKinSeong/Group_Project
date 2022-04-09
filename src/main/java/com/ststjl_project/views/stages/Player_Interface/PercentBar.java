package com.ststjl_project.views.stages.Player_Interface;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PercentBar extends Status_Pane{


    @Override
    public void Init(Pane mainPane, GraphicsContext mainGc, double[] Related_pos) {
        super.setPane(mainPane);
        super.setGC(mainGc);
        super.setRelated_pos(Related_pos);
        rectangle[0]=new Rectangle();
        rectangle[1]=new Rectangle();
        getPane().getChildren().addAll(rectangle);
    }

    @Override
    public void reDraw() {
        reSizing();
        double layoutX=super.getLayoutX();
        double layoutY=super.getLayoutY();
        double width=super.getWidth();
        double height=super.getHeight();


        setRectanglePosWH(rectangle[0],layoutX,layoutY,width,height);

    }
    public void setBarFill(Color barColor){
        rectangle[1].setFill(barColor);
    }


    public void setBoxFill(Color boxColor){
        rectangle[0].setFill(boxColor);
    }
    private final Rectangle[] rectangle  = new Rectangle[2];
}
