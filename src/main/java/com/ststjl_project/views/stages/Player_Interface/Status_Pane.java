package com.ststjl_project.views.stages.Player_Interface;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public abstract class Status_Pane extends Pane {
    public Status_Pane(){}
    public abstract void Init(Pane mainPane, GraphicsContext mainGc,double Related_pos[]);
    public abstract void update();

    public void setCirclePosWH(Circle circle, double layX, double layY, double radius){
        circle.setLayoutX(layX);
        circle.setLayoutY(layY);
        circle.setRadius(radius);
    }

    public void setRectanglePosWH(Rectangle rectangle, double layX, double layY, double width, double height) {
        rectangle.setLayoutX(layX);
        rectangle.setLayoutY(layY);
        rectangle.setWidth(width);
        rectangle.setHeight(height);
    }
    public void setPane(Pane pane, double layX, double layY, double width, double height){
        pane.setLayoutX(layX);
        pane.setLayoutY(layY);
        pane.prefWidth(width);
        pane.prefHeight(height);
    }
    public void setTextPosWH(Text text, double layX, double layY, double width, double height){
        text.setLayoutX(layX);
        text.setLayoutY(layY);
        text.minWidth(width);
        text.minHeight(height);
    }

    public void setPane(Pane pane){this.mainPane=pane;}
    public void setGC(GraphicsContext graphicsContext){this.mainGC=graphicsContext;}
    public void setRelated_pos(double [] related_pos){this.Related_pos=related_pos;}
    public Pane getPane() {
        return mainPane;
    }

    public GraphicsContext getGC() {
        return mainGC;
    }

    public void reSizing(){
        double layoutX=mainPane.getWidth()*Related_pos[0];
        double layoutY=mainPane.getHeight()*Related_pos[1];
        double width=mainPane.getWidth()*Related_pos[2]-layoutX;
        double height=mainPane.getHeight()*Related_pos[3]-layoutY;

        this.setLayoutX(layoutX);
        this.setLayoutY(layoutY);
        this.setWidth(width);
        this.setHeight(height);
    }
    private Pane mainPane;
    private GraphicsContext mainGC;
    private double[] Related_pos;
}
