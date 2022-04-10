package com.ststjl_project.views.stages.Player_Panes.sub_Pane;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;

public abstract class _Status_Pane extends Pane {
    public static Pane mainPane;
    public static GraphicsContext mainGC;
    public _Status_Pane(){}
    public abstract void Init(double[] Related_pos);
    public abstract void reDraw();
    public abstract void CleanUp();
    public abstract void updateData(double [] data);


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
    private double[] Related_pos;
}
