package com.ststjl_project.Utility;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;






public class Obj_Positions {
        public static double[] Relative_Pos_TPos(double _width, double _height, double[] relPos){
            assert relPos.length>=4 : "relPos must be >= 4";
            double [] result = new double[4];
            result[0] = relPos[0]*_width;
            result[1] = relPos[1]*_height;
            result[2] = relPos[2]*_width;
            result[3] = relPos[3]*_height;
            return result;
        }

        public static void setRectanglePosWH(Rectangle rectangle, double layX, double layY, double width, double height) {
            rectangle.setLayoutX(layX);
            rectangle.setLayoutY(layY);
            rectangle.setWidth(width);
            rectangle.setHeight(height);
        }


        static void setPanePosWH(Pane pane, double layX, double layY, double width, double height){
            pane.setLayoutX(layX);
            pane.setLayoutY(layY);
            pane.minWidth(width);
            pane.maxWidth(width);
            pane.minHeight(height);
            pane.maxWidth(width);
        }
        static void setTextPosWH(Text text, double layX, double layY, double width, double height){
            text.setLayoutX(layX);
            text.setLayoutY(layY);
            text.prefWidth(width);
            text.prefHeight(height);
        }

        static void setLabelPosWH(Label label, double layX, double layY, double width, double height){
            label.setLayoutX(layX);
            label.setLayoutY(layY);
            label.minWidth(width);
            label.minHeight(height);
            label.resize(width,height);
        }
}
