package com.ststjl_project.views.stages;

import com.ststjl_project.views.Menu_Btn_List;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Menu_Stage extends Stage_Generator {
    Menu_Btn_List menu_btn_list = new Menu_Btn_List(getPane());
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
        menu_btn_list.add_Button(Menus);
        menu_btn_list.setManu_Position(0.05,0.30,0.09,0.91,0.30);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        initMenu_board();
    };
    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), actionEvent -> {
        menu_btn_list.update();
        double pane_Width = get_Pane_WIDTH();
        double pane_Height = get_Pane_HEIGHT();
        double menu_board_init_X  = pane_Width  * menu_plane_left_related;
        double menu_board_end_X   = pane_Width * menu_plane_right_related;
        double menu_board_init_Y =  pane_Height * menu_plane_top_related;
        double menu_board_end_Y  =  pane_Height * menu_plane_bottom_related;
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
}
