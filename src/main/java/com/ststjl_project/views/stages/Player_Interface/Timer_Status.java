package com.ststjl_project.views.stages.Player_Interface;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Timer_Status extends Status_Pane{
    @Override
    public void Init(Pane mainPane, GraphicsContext mainGc, double[] Related_pos) {
        super.setPane(mainPane);
        super.setGC(mainGc);
        super.setRelated_pos(Related_pos);
        TimeBox[0]=new Rectangle();
        TimeBox[1]=new Rectangle();
        TimeBox[0].setFill(Color.GREEN);
        TimeBox[1].setFill(Color.RED);
        this.getChildren().addAll(TimeBox[0],TimeBox[1]);
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
        double timeBox_Height = (height/2)-2.0* timeBox_PadY;

        setRectanglePosWH(TimeBox[0], timeBox_PadX,timeBox_PadY,timeBox_width,timeBox_Height);
        setRectanglePosWH(TimeBox[1],timeBox_PadX,timeBox_PadY+height/2,timeBox_width,timeBox_Height);

    }



    public void setTime_Limited(double time_Limited) {
        Time_Limited = time_Limited;
    }
    public double getTime_Limited(){return Time_Limited;};

    private double Time_Limited;
    private Rectangle TimeBox[] = new Rectangle[2];

}
