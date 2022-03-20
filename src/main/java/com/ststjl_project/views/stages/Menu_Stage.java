package com.ststjl_project.views.stages;

import com.ststjl_project.views.Menu_Btn_List;
import com.ststjl_project.views.buttoms.Still_Button;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Map;

public class Menu_Stage extends Stage_Generator {
    Menu_Btn_List menu_btn_list = new Menu_Btn_List(getPane());
    private final String[] Menus = {"Start","Score","Option","Credit","Exit"};

    private Rectangle Menu_board = new Rectangle();

    private final double menu_plane_left_related = 0.47;
    private final double menu_plane_right_related = 0.95;
    private final double menu_plane_top_related = 0.09;
    private final double menu_plane_bottom_related = 0.91;

    private boolean menu_board = true;
    public Menu_Stage(double SCENE_WIDTH, double SCENE_HEIGHT){
        super(SCENE_WIDTH,SCENE_HEIGHT);
        menu_btn_list.add_Button(Menus);
        init_menu_button();
        menu_btn_list.setManu_Position(0.05,0.30,0.09,0.91,0.30);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        initMenu_board();
    };
    private void init_menu_button(){
        Still_Button b;
        for(String s : Menus){
            b = menu_btn_list.get_Button(s);
            if(b!=null){
                b.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        trigger_actions(s);
                    }
                });
            }
        }
    }
    private void trigger_actions(String action_s){
        if(action_s=="Credit"){
            enter_NextState(3);
        }
    }
    @Override
    public void enter_NextState(int id){
        if(id == 3){
            Scene credit_scene = Stage_Generator.credit.getScene();
            Stage currentStage = this.getStage();
            currentStage.setScene(credit_scene);

            current = Stage_Generator.credit;
            current.setStage(currentStage);
        }
    }
    @Override
    public void update_State(int id) {

    }
    @Override
    public void showUp(){
        getStage().setScene(menu.getScene());
        getStage().show();
    }
    @Override
    public void cleanup(){
        getStage().show();
    }

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
