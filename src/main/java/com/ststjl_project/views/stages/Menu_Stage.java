package com.ststjl_project.views.stages;

import com.ststjl_project.views.Menu_Btn_List;
import com.ststjl_project.views.buttons.Still_Button;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Bounds;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
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
    // I do know this is dump, but it just works //
    //-------------------------------------------//
    private final double[] menu_btn_Pos = {0.05,0.30,0.09,0.91,0.30};



    private final double[] menu_board_Pos = {0.47,0.95,0.09,0.91};
    private double delta_For_Ball[] = {0.0005,0.0008};
    //-----------------//
    // The constructor //
    //-----------------//
    public Menu_Stage() {

    }

    Timeline game_loop = new Timeline(new KeyFrame(Duration.millis(1), actionEvent -> {
        menu_btn_list.update();

        double pane_Width = getPane().getWidth();
        double pane_Height = getPane().getHeight();

        double s_posX = pane_Width  * menu_board_Pos[0];
        double e_posX = pane_Width * menu_board_Pos[1];
        double s_posY = pane_Height * menu_board_Pos[2];
        double e_posY = pane_Height * menu_board_Pos[3];
        update_Menu_Board(s_posX, e_posX, s_posY, e_posY);
        update_Ball_In_Board();
        getCanvas().setWidth(pane_Width);
        getCanvas().setHeight(pane_Height);
        getGC().setFill(Color.WHITE);
        getGC().fillRect(0,0,pane_Width,pane_Height);
        getGC().setFill(Color.BLACK);
        getGC().fillRect(0,0,pane_Width*0.3,pane_Height*0.5);
    }));

    private Label Random_Label;
    private boolean Is_Labeled = false;

    private void animated_label(String name){
        double related_width = 0.2;
        double related_height= 1.1;
        Still_Button button = menu_btn_list.get_Button(name);
        if(button==null){
            System.exit(0);
        };
        Random_Label = new Label();
        String text="";
        switch (name){
            case "Start":
            {
                text = "Click me to play";
            }break;
            case "Credit":
            {
                text = "Support us by donation";
            }break;
            case "Option":
            {
                text = "Twist the game you like";
            }break;
            case "Exit":
            {
                text = "Master! Don't leave me";
            }break;
            case "Score":
            {
                int maximum = 3;
                int minimum = 1;
                int i = (int) (Math.random()*(maximum - minimum)) + minimum;
                text = (i==1)?"See how good you are":(i==2)?"Your glory battles":(i==3)?"Oh You are good":"";
            }break;
        }
        double btn_layX = button.getLayoutX();
        double btn_layY = button.getLayoutY()+button.getHeight()*related_height;
        Random_Label.setLayoutX(btn_layX);
        Random_Label.setLayoutY(btn_layY);
        getPane().getChildren().add(Random_Label);
        Random_Label.setText(text);
        Is_Labeled = true;
    }
    private void rm_animated_Button(){
        getPane().getChildren().remove(Random_Label);
        Is_Labeled = false;
    }

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

        getStage().setTitle("This is the Menu");
    }
    private void init_menu_button(){
        Still_Button b;
        for(String Button_Name : Menus){
            b = menu_btn_list.get_Button(Button_Name);
            if(b!=null){
                Still_Button finalB = b;
                b.setOnAction(actionEvent -> {
                        trigger_actions(Button_Name);
                });
                b.setOnMouseEntered(mouseEvent -> {
                    finalB.setTextFill(Color.RED);
                    animated_label(Button_Name);

                });
                b.setOnMouseExited(mouseEvent -> {
                    finalB.setTextFill(Color.BLACK);
                    rm_animated_Button();
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
    private void initBall_board(int radius, double LayoutX, double LayoutY) {
        ball = new Circle();
        ball.setRadius(radius);
        ball.setFill(Color.BLUE);
        getPane().getChildren().add(ball);
    }

    /* O Yes                    //
    private MediaPlayer mediaPlayer;
    private void play(){
        URL url = getClass().getResource("/Music/down.mp3");
        if(url!=null){
            mediaPlayer = new MediaPlayer(new Media(new File(url.getPath()).toURI().toString()));
            mediaPlayer.play();
        }
    }
    // Just blocking some code */
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
                //play();
            }else{
                System.out.println("Left");
                ball.setLayoutX(layX+radius);
                //play();
            }
        }
        if(TopBoards || BottomBoards){
            delta_For_Ball[1]*=-1;

            if(TopBoards) {
                System.out.println("Top");
                ball.setLayoutY(layY + radius);
                //play();
            }else {
                System.out.println("bottom");
                ball.setLayoutY(layY + Menu_board.getHeight() - radius);
                //play();
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
        if (Is_Labeled){
            getPane().getChildren().remove(Random_Label);
        }
        menu_btn_list.remove_Button(Menus);
        getPane().getChildren().remove(Menu_board);
        getPane().getChildren().remove(ball);
    }


    private void trigger_actions(String action_s){
        int index = Menus.indexOf(action_s);
        if(index>=0){
            enter_NextState(index);
        }else{
            // not implemented yet //
        }
    }

    @Override
    public void enter_NextState(int id){
        clean_Up();
        switch (id){
            case 0:{
                setState("game");
            }break;
            case 1:{
                setState("score");
            }break;
            case 2:{
                setState("option");
            }break;
            case 3:{
                setState("credit");
            }break;
            case 4:{
                System.exit(0);
            }break;
            default:
        }
        getStage().setTitle(String.format("This is the %s", Menus.get(id)));
        getState("current").getStage().setScene(getScene());
        getState("current").init();
    }

}
