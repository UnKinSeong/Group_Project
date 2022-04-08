package com.ststjl_project.views.stages.Player_Interface;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class History_Status extends Status_Pane{
    @Override
    public void Init(Pane mainPane, GraphicsContext mainGc, double[] Related_pos) {
        super.setPane(mainPane);
        super.setGC(mainGc);
        super.setRelated_pos(Related_pos);
        for(int i = 0; i < 5;i++){
            history_Box[i]=new Rectangle();
        }
        this.getChildren().addAll(history_Box);
    }

    @Override
    public void update() {
        reSizing();
        double layoutX=this.getLayoutX();
        double layoutY=this.getLayoutY();
        double width=this.getWidth();
        double height=this.getHeight();

        double timeBox_PadX = width*0.01;
        double timeBox_PadY = (height/2)*0.05;

        double timeBox_width = width-2.0* timeBox_PadX;
        double timeBox_Height = (height/5)-2.0* timeBox_PadY;

        for (int i = 0; i<5; i++){
            setRectangle(history_Box[i],timeBox_PadX,timeBox_PadY+(height/5)*i,timeBox_width,timeBox_Height);
        }
    }
    private Rectangle []history_Box=new Rectangle[5];
}
