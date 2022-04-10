package com.ststjl_project.views.stages.Player_Panes.sub_Pane;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import static com.ststjl_project.utility.Positioners.setCirclePosWH;

public class Next_Round_Status_Pane extends _Status_Pane {

    @Override
    public void Init(double[] Related_pos) {
        super.setRelated_pos(Related_pos);
        button=new Circle();
        this.getChildren().add(button);
        button.setFill(Color.RED);
        clicked = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(button.getFill()==Color.RED){
                    button.setFill(Color.BLUE);
                }else{
                    button.setFill(Color.RED);
                }

            }
        };
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, clicked);
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


    private EventHandler<MouseEvent> clicked;
    private Circle button = new Circle();
}
