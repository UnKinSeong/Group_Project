package com.ststjl_project.views.stages;

import com.ststjl_project.views.Menu_Btn_List;
import com.ststjl_project.views.buttons.Still_Button;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
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
    private final List<String> Menus =
            Arrays.asList(
                    "Start","Score",
                    "Option","Credit",
                    "Exit");

    //-----------------------------------------------------------//
    // I'm going to make a Rectangle and call it a developer log //
    //-----------------------------------------------------------//
    private Rectangle Menu_board;
    private Circle ball;

    private boolean cleanUp_Status;

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
    public Menu_Stage (Stage stage,
                       AnchorPane anchorPane,
                       Scene scene){
        super(stage,anchorPane,scene);
        cleanUp_Status = false;
    };
    public Menu_Stage() {

    }

    Timeline game_loop = new Timeline(new KeyFrame(Duration.millis(1), actionEvent -> {
        menu_btn_list.update();
        double pane_Width = get_Pane_WIDTH();
        double pane_Height = get_Pane_HEIGHT();
        double menu_board_init_X  = pane_Width  * menu_board_Pos[0];
        double menu_board_end_X   = pane_Width * menu_board_Pos[1];
        double menu_board_init_Y =  pane_Height * menu_board_Pos[2];
        double menu_board_end_Y  =  pane_Height * menu_board_Pos[3];

        double middleX = Math.abs(menu_board_init_X-menu_board_end_X);
        double middleY = Math.abs(menu_board_init_Y-menu_board_end_Y);
        update_Menu_Board(menu_board_init_X, menu_board_end_X, menu_board_init_Y, menu_board_end_Y);

        update_Ball_In_Board();
    }));

    @Override
    public void init(){
        menu_btn_list.add_Button(Menus);
        init_menu_button();
        menu_btn_list.setManu_Position(
                menu_btn_Pos[0],
                menu_btn_Pos[1],
                menu_btn_Pos[2],
                menu_btn_Pos[3],
                menu_btn_Pos[4]);
        game_loop.setCycleCount(Animation.INDEFINITE);
        game_loop.play();
        initMenu_board();
        initBall_board(1, Menu_board.getLayoutX()+1,Menu_board.getLayoutY()+1);

        super.setTitle("This is the Menu");
    }
    private void init_menu_button(){
        Still_Button b;
        for(String s : Menus){
            b = menu_btn_list.get_Button(s);
            if(b!=null){
                b.setOnAction(actionEvent -> {
                        trigger_actions(s);
                });
            }else{
                // not implemented yet //
            }
        }
    }
    private void initMenu_board(){
        Menu_board = new Rectangle();
        getPane().getChildren().add(Menu_board);

    }

    private double delta_For_Ball[] = {0.0001,0.0003};
    private void initBall_board(int radius, double LayoutX, double LayoutY) {
        ball = new Circle();
        ball.setRadius(radius);
        ball.setFill(Color.BLUE);
        getPane().getChildren().add(ball);
    }

    private MediaPlayer mediaPlayer;
    private void play(){
        mediaPlayer = new MediaPlayer(new Media(new File(getClass().getResource("/Music/down.mp3").getPath()).toURI().toString()));
        mediaPlayer.play();
    }
    private void update_Ball_In_Board(){
        Bounds bounds = Menu_board.getBoundsInLocal();
        double radius = ((Menu_board.getWidth()+ Menu_board.getHeight())/2)*0.05;
        ball.setRadius(radius);
        double right_bound = Menu_board.getLayoutX()+bounds.getMaxX() - radius;
        double left_bound = Menu_board.getLayoutX()+bounds.getMaxX() + radius;
        double top_bound = Menu_board.getLayoutY()+bounds.getMinY() + radius;
        double bottom_bound = Menu_board.getLayoutY()+bounds.getMaxY() - radius;

        double futureX = ball.getLayoutX()+Menu_board.getWidth()*delta_For_Ball[0];
        double futureY = ball.getLayoutY()+Menu_board.getHeight()*delta_For_Ball[1];

        double layX = Menu_board.getLayoutX();
        double layY = Menu_board.getLayoutY();


        ball.setLayoutX(ball.getLayoutX()+Menu_board.getWidth()*delta_For_Ball[0]);
        ball.setLayoutY(ball.getLayoutY()+Menu_board.getHeight()*delta_For_Ball[1]);
        boolean RightBoards = ball.getLayoutX() >= (layX+bounds.getMaxX()-radius);
        boolean LeftBoards = ball.getLayoutX() <= (layX+bounds.getMinX()+radius);
        boolean BottomBoards = ball.getLayoutY() >= (layY+bounds.getMaxY()-radius);
        boolean TopBoards = ball.getLayoutY() <= (layY+bounds.getMinY()+radius);
        if(RightBoards||LeftBoards){
            delta_For_Ball[0]*=-1;
            if(RightBoards) {
                System.out.println("Right");
                ball.setLayoutX(layX + Menu_board.getWidth() - radius);
                play();
            }else{
                System.out.println("Left");
                ball.setLayoutX(layX+radius);
                play();
            }
        }
        if(TopBoards || BottomBoards){
            delta_For_Ball[1]*=-1;

            if(TopBoards) {
                System.out.println("Top");
                ball.setLayoutY(layY + radius);
                play();
            }else {
                System.out.println("bottom");
                ball.setLayoutY(layY + Menu_board.getHeight() - radius);
                play();
            }
        }
    }

    private void update_Menu_Board(double init_width, double end_width, double init_height, double end_height){
        Menu_board.setFill(Paint.valueOf("#daff1f"));
        Menu_board.setLayoutX(init_width);
        Menu_board.setLayoutY(init_height);
        Menu_board.setWidth(end_width-init_width);
        Menu_board.setHeight(end_height-init_height);
    }
    public void clean_Up(){
        game_loop.stop();
        menu_btn_list.remove_Button(Menus);
        getPane().getChildren().remove(Menu_board);
        getPane().getChildren().remove(ball);
    }


    private void trigger_actions(String action_s){
        int index = Menus.indexOf(action_s);
        if(index>=0){
            enter_NextState(index);
        }
        else //do something else
        {
            // Not implemented yet //
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

}
