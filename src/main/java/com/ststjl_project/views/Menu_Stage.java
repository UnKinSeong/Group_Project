package com.ststjl_project.views;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.util.*;

public class Menu_Stage extends Stage_Generator{
    private Vector<Button> menu_Btn = new Vector<>();
    private final String[] Menus = {"Start","Score","Option","Credit","Exit"};
    private final double menu_spacing = 0.3;
    private final double menu_left_related = 0.1;
    private final double menu_right_related = 0.3;
    private final double menu_top_related = 0.2;
    private final double menu_bottom_related = 0.2;
    private boolean menu_board = true;
    public Menu_Stage(double SCENE_WIDTH, double SCENE_HEIGHT){
        super(SCENE_WIDTH,SCENE_HEIGHT);
        init_btn();
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    };
    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), actionEvent -> {
        double init_width  = getPane().getWidth()  * menu_left_related;
        double end_width   = getPane().getWidth()  * menu_right_related;
        double init_height = getPane().getHeight() * (menu_top_related);
        double end_height  = getPane().getHeight() - getPane().getHeight() * (menu_bottom_related);

        setMenu_Btn(init_width, end_width, init_height, end_height, menu_spacing);
    }));
    private void setMenu_board(){
        AnchorPane anchorPane = new AnchorPane();
    }
    private void setMenu_Btn(double init_width, double end_width, double init_height, double end_height, double re_spacing){
        for(Button b : menu_Btn){
            b.setLayoutX(init_width);
            b.setMaxWidth(end_width-init_width);
            b.setMinWidth(end_width-init_width);
        }
        double height=Math.abs(end_height-init_height);
        double button_spacing = (height*re_spacing)/(menu_Btn.size()-1);
        double button_height = (height-height*re_spacing)/ menu_Btn.size();

        double next_h = init_height;
        for (Button b : menu_Btn){
            b.setLayoutY(next_h);
            b.setMaxHeight(button_height);
            b.setMinHeight(button_height);
            next_h+=button_height+button_spacing;
        }
    }
    private void init_plane() {
        for(String s:Menus){
            Button t_btn = new Button();
            t_btn.setText(s);
            menu_Btn.add(t_btn);
            getPane().getChildren().add(t_btn);
        }
    }
    private void init_btn() {
        for(String s:Menus){
            Button t_btn = new Button();
            t_btn.setText(s);
            menu_Btn.add(t_btn);
            getPane().getChildren().add(t_btn);
        }
    }
}
