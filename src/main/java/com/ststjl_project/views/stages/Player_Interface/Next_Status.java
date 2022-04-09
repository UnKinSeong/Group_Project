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
    public void reDraw() {
        reSizing();
        double layoutX=this.getLayoutX();
        double layoutY=this.getLayoutY();
        double width=this.getWidth();
        double height=this.getHeight();

        double Button_Radius = (width/2+height/2)/4;
        double Button_LayX = width/2;
        double Button_LayY = height/2;

        setCirclePosWH(button,Button_LayX,Button_LayY,Button_Radius);
    }

    private Circle button = new Circle();
}
