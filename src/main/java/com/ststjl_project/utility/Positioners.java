package com.ststjl_project.utility;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Positioners {
    public static void setCirclePosWH(Circle circle, double layX, double layY, double radius){
        circle.setLayoutX(layX);
        circle.setLayoutY(layY);
        circle.setRadius(radius);
    }

    public static void setRectanglePosWH(Rectangle rectangle, double layX, double layY, double width, double height) {
        rectangle.setLayoutX(layX);
        rectangle.setLayoutY(layY);
        rectangle.setWidth(width);
        rectangle.setHeight(height);
    }

    public static void setPanePosWH(Pane pane, double layX, double layY, double width, double height){
        pane.setLayoutX(layX);
        pane.setLayoutY(layY);
        pane.minWidth(width);
        pane.maxWidth(width);
        pane.minHeight(height);
        pane.maxWidth(width);
    }
    public static void setTextPosWH(Text text, double layX, double layY, double width, double height){
        text.setLayoutX(layX);
        text.setLayoutY(layY);
        text.prefWidth(width);
        text.prefHeight(height);
    }

    public static void setLabelPosWH(Label label, double layX, double layY, double width, double height){
        label.setLayoutX(layX);
        label.setLayoutY(layY);
        label.minWidth(width);
        label.minHeight(height);
        label.resize(width,height);
    }
}
