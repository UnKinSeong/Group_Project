package com.ststjl_project.views;

import com.ststjl_project.views.buttoms.Still_Button;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.*;

public class Menu_Stage extends Stage_Generator{
    private Vector<Still_Button> menu_Btn = new Vector<>();
    private final String[] Menus = {"Start","Score","Option","Credit","Exit"};
    private Rectangle Menu_board = new Rectangle();
    private final double menu_spacing = 0.30;
    private final double menu_left_related = 0.05;
    private final double menu_right_related = 0.30;
    private final double menu_top_related = 0.09;
    private final double menu_bottom_related = 0.91;
    private final double menu_plane_left_related = 0.47;
    private final double menu_plane_right_related = 0.95;
    private final double menu_plane_top_related = 0.09;
    private final double menu_plane_bottom_related = 0.91;

    private boolean menu_board = true;
    public Menu_Stage(double SCENE_WIDTH, double SCENE_HEIGHT){
        super(SCENE_WIDTH,SCENE_HEIGHT);
        init_btn();
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        initMenu_board();
    };
    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), actionEvent -> {
        double menu_init_X  = getPane().getWidth()  * menu_left_related;
        double menu_end_X   = getPane().getWidth()  * menu_right_related;
        double menu_init_Y = getPane().getHeight() * menu_top_related;
        double menu_end_Y  = getPane().getHeight() * menu_bottom_related;
        setMenu_Btn(menu_init_X, menu_end_X, menu_init_Y, menu_end_Y, menu_spacing);

        double menu_board_init_X  = getPane().getWidth()  * menu_plane_left_related;
        double menu_board_end_X   = getPane().getWidth()  * menu_plane_right_related;
        double menu_board_init_Y = getPane().getHeight() * menu_plane_top_related;
        double menu_board_end_Y  = getPane().getHeight() * menu_plane_bottom_related;
        setMenu_board(menu_board_init_X, menu_board_end_X, menu_board_init_Y, menu_board_end_Y);

    }));
    private void initMenu_board(){
        getPane().getChildren().add(Menu_board);
    }
    private void setMenu_board(double init_width, double end_width, double init_height, double end_height){
        Menu_board.setFill(Paint.valueOf("#daff1f"));
        Menu_board.setLayoutX(init_width);
        Menu_board.setLayoutY(init_height);
        Menu_board.setWidth(end_width-init_width);
        Menu_board.setHeight(end_height-init_height);

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
            Still_Button t_btn = new Still_Button();
            t_btn.setText(s);
            menu_Btn.add(t_btn);
            getPane().getChildren().add(t_btn);
        }
    }
    private void init_btn() {
        for(String s:Menus){
            Still_Button t_btn = new Still_Button();
            t_btn.setText(s);
            menu_Btn.add(t_btn);
            getPane().getChildren().add(t_btn);
        }
    }
}
