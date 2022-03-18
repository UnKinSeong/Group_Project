package com.ststjl_project.controllers;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Gaming_Scene implements Initializable {

    @FXML
    private AnchorPane scene;

    @FXML
    private Circle circle;
    //1 Frame evey 10 millis, which means 100 FPS
    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {

        double deltaX = 2;
        double deltaY = 2;
        private boolean initi = false;
        @Override
        public void handle(ActionEvent actionEvent) {
            if (!initi){
                circle.setLayoutX(scene.getWidth()/2);
                circle.setLayoutY(scene.getHeight()/2);
                initi=true;
            }

            Bounds bounds = scene.getBoundsInLocal();
            double dis_to_right_border = bounds.getMaxX()-circle.getRadius();
            double dis_to_left_border = bounds.getMinX()+circle.getRadius();
            double dis_to_top_border = bounds.getMaxY()-circle.getRadius();
            double dis_to_bottom_border = bounds.getMinY()+circle.getRadius();
            double next_x = circle.getLayoutX()+deltaX;
            double next_y = circle.getLayoutY()+deltaY;

            if(next_x<=dis_to_right_border){
                circle.setLayoutX(next_x);
            } else{
                deltaX*=-1;
                circle.setLayoutX(dis_to_right_border*2-next_x);
            }
            if(next_x>=dis_to_left_border){
                circle.setLayoutX(next_x);
            }else{
                deltaX*=-1;
                circle.setLayoutX(dis_to_left_border*2-next_x);
            }
            if(next_y<=dis_to_top_border){
                circle.setLayoutY(next_y);
            }else{
                deltaY*=-1;
                circle.setLayoutY(dis_to_top_border*2-next_y);
            }
            if(next_y>=dis_to_bottom_border){
                circle.setLayoutY(next_y);
            }else{
                deltaY*=-1;
                circle.setLayoutY(dis_to_bottom_border*2-next_y);
            }
        }
    }));

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
}