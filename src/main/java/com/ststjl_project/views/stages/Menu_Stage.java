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

import java.util.Arrays;
import java.util.List;


//----------------------------------------//
// In this Stage. Every thing is related. //
//----------------------------------------//
public class Menu_Stage extends Stage_SM {
    //---------------------------------------------//
    // Declare the Custom Menu Button List Manager // Oh yes it is dynamic resizing
    //---------------------------------------------//
    Menu_Btn_List menu_btn_list = new Menu_Btn_List(getPane());

    //-------------------------------------------------//
    // Just to take care of the declaration of the MBL //
    //-------------------------------------------------//
    private final List<String> Menus = Arrays.asList("Start","Score","Option","Credit","Exit");

    //-----------------------------------------------------------//
    // I'm going to make a Rectangle and call it a developer log //
    //-----------------------------------------------------------//
    private Rectangle Menu_board = new Rectangle();

    //-------------------------------------------//
    // Position Follow by Left, Right, Top, Down //
    //-------------------------------------------//
    //    Related position of the Menu_Button    //
    //-------------------------------------------//
    private final double[] menu_btn_Pos = {0.05,0.30,0.09,0.91,0.30};

    private final double[] menu_board_Pos = {0.47,0.95,0.09,0.91};

    //-----------------//
    // The constructor //
    //-----------------//
    public Menu_Stage (Stage stage, AnchorPane anchorPane, Scene scene){
        super(stage,anchorPane,scene);
    };
    public Menu_Stage() {

    }

    @Override
    public void init(){
        menu_btn_list.add_Button(Menus);
        init_menu_button();
        menu_btn_list.setManu_Position(menu_btn_Pos[0],menu_btn_Pos[1],menu_btn_Pos[2],menu_btn_Pos[3],menu_btn_Pos[4]);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        initMenu_board();
        super.setTitle("This is the Menu");
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
    public void clean_Up(){
        timeline.stop();
        menu_btn_list.remove_Button(Menus);
        getPane().getChildren().remove(Menu_board);
    }


    private void trigger_actions(String action_s){
        int index = Menus.indexOf(action_s);
        if(index>=0){
            enter_NextState(index);
        }
        else //do something else
        {

        }
    }
    @Override
    public void enter_NextState(int id){
        current.clean_Up();
        switch (id){
            case 0:{
                current = Stage_SM.game;
            }break;
            case 1:{
                current = Stage_SM.score;
            }break;
            case 2:{
                current = Stage_SM.option;
            }break;
            case 3:{
                current = Stage_SM.credit;
            }break;
            case 4:{
                System.exit(0);
            }break;
            default:
        }
        current.getStage().setTitle(String.format("This is the %s", Menus.get(id)));
        getStage().setScene(current.getScene());
        current.init();
    }

    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), actionEvent -> {
        menu_btn_list.update();
        double pane_Width = get_Pane_WIDTH();
        double pane_Height = get_Pane_HEIGHT();
        double menu_board_init_X  = pane_Width  * menu_board_Pos[0];
        double menu_board_end_X   = pane_Width * menu_board_Pos[1];
        double menu_board_init_Y =  pane_Height * menu_board_Pos[2];
        double menu_board_end_Y  =  pane_Height * menu_board_Pos[3];
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
