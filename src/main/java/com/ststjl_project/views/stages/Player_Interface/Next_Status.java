package com.ststjl_project.views.stages.Player_Interface;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Next_Status extends Status_Pane{

    @Override
    public void Init(Pane mainPane, GraphicsContext mainGc, double[] Related_pos) {
        super.setPane(mainPane);
        super.setGC(mainGc);
        super.setRelated_pos(Related_pos);
        button=new Circle();
        this.getChildren().add(button);
        button.setFill(Color.RED);
    }

    @Override
    public void update() {
        reSizing();
        double layoutX=this.getLayoutX();
        double layoutY=this.getLayoutY();
        double width=this.getWidth();
        double height=this.getHeight();

        double Button_PadX = width*0.5;
        double Button_PadY = height*0.5;

        double Button_Width = width-Button_PadX;

        setCirclePosWH(button,Button_PadX,Button_PadY,10);
    }

    private Circle button = new Circle();
}
