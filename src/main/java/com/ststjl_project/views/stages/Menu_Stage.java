package com.ststjl_project.views.stages;

import com.ststjl_project.views.Menu_Btn_List;
import com.ststjl_project.views.buttoms.Still_Button;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Menu_Stage extends State_Machine {
    Menu_Btn_List menu_btn_list = new Menu_Btn_List(getPane());
    private final String[] Menus = {"Start","Score","Option","Credit","Exit"};

    private Rectangle Menu_board = new Rectangle();

    private final double menu_plane_left_related = 0.47;
    private final double menu_plane_right_related = 0.95;
    private final double menu_plane_top_related = 0.09;
    private final double menu_plane_bottom_related = 0.91;

    private boolean menu_board = true;

    public Menu_Stage (Stage stage, AnchorPane anchorPane, Scene scene){
        super(stage,anchorPane,scene);
    };
    @Override
    public void init(){
        menu_btn_list.add_Button(Menus);
        init_menu_button();
        menu_btn_list.setManu_Position(0.05,0.30,0.09,0.91,0.30);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        initMenu_board();
        super.setTitle("This is the Menu");
    }
    public void clean_Up(){
        timeline.stop();
        menu_btn_list.remove_Button(Menus);
        getPane().getChildren().remove(Menu_board);
    }
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
        switch (action_s){
            case "Credit":{
                enter_NextState(3);
            }break;
            case "Exit":{
                System.exit(0);
            }break;
        }
    }
    @Override
    public void enter_NextState(int id){
        if(id == 3){
            current.clean_Up();
            current = State_Machine.credit;
            current.getStage().setTitle("This is the Credit");
            getStage().setScene(current.getScene());
            current.init();
        }
    }
    @Override
    public void update_State(int id) {

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
