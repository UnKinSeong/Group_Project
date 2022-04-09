package com.ststjl_project.views.stages.Player_Controller.sub_Pane;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Next_Round_Status_Pane extends _Status_Pane {

    @Override
    public void Init(double[] Related_pos) {
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

    @Override
    public void CleanUp() {
        getChildren().removeAll(button);
    }

    @Override
    public void updateData(double[] data) {

    }


    private Circle button = new Circle();
}
