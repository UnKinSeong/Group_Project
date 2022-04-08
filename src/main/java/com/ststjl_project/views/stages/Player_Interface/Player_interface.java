package com.ststjl_project.views.stages.Player_Interface;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Player_interface {
    // related Pos //
    private GraphicsContext mainGc;
    private Pane mainPane;

    private Player_Status player_status_pane;
    private double [] Player_Pane_Pos = {0,0,0.4,(double)1/(double)9};

    private Bonus_Status bonus_status;
    private double [] Bones_Pane_Pos = {0.4,0,0.8,(double)1/(double)9};

    private Timer_Status timer_status;
    private double [] Timer_Limit_Pane_Pos = {0.8,0,1,(double)1/(double)9};

    private History_Status history_status;
    private double Right_Most_Status_PosX = 0.8;
    private double Right_Most_Status_PosY = (double)1/(double)9;
    private double Right_Most_Status_Height = (double)1-(double)1/(double)9;
    private double Right_Most_Status_Each_Height = (double)(Right_Most_Status_Height)/(double)3;


    private double [] History_Pane_Pos = {
            Right_Most_Status_PosX,
            Right_Most_Status_PosY,
            1,
            Right_Most_Status_PosY+Right_Most_Status_Each_Height};

    private double [] Player_Hit_Chances_Pane_Pos = {
            Right_Most_Status_PosX,
            Right_Most_Status_PosY+Right_Most_Status_Each_Height,
            1,
            Right_Most_Status_PosY+Right_Most_Status_Each_Height*2};


    private double [] Player_Next_Pane_Pos = {
            Right_Most_Status_PosX,
            Right_Most_Status_PosY+Right_Most_Status_Each_Height*2,
            1,
            Right_Most_Status_PosY+Right_Most_Status_Each_Height*3};

    public Player_interface(GraphicsContext graphicsContext, Pane pane1){
        mainGc = graphicsContext;
        mainPane = pane1;
    };
    public double getRelated_(double width, double relatedx, double relatedx2){
        return Math.abs(width*relatedx-width*relatedx2);
    }

    public void Init(){
        player_status_pane=new Player_Status();
        bonus_status=new Bonus_Status();
        timer_status=new Timer_Status();
        history_status=new History_Status();
        mainPane.getChildren().addAll(player_status_pane,bonus_status,timer_status,history_status);

        player_status_pane.Init(mainPane, mainGc,Player_Pane_Pos);
        bonus_status.Init(mainPane,mainGc,Bones_Pane_Pos);
        timer_status.Init(mainPane,mainGc,Timer_Limit_Pane_Pos);
        history_status.Init(mainPane,mainGc,History_Pane_Pos);

    }
    public void setPPP(double[] related, Color color,String text){
        double width = mainPane.getWidth();
        double height = mainPane.getHeight();

        mainGc.setFill(color);
        mainGc.fillRect(related[0]*width,related[1]*height,getRelated_(width,related[0],related[2]),getRelated_(height,related[1],related[3]));
        mainGc.setFill(Color.WHITE);


    }

    public void Draw_Yourself(){
        player_status_pane.update();
        bonus_status.update();
        timer_status.update();
        history_status.update();
        setPPP(Player_Hit_Chances_Pane_Pos,Color.PURPLE,"");
        setPPP(Player_Next_Pane_Pos,Color.BEIGE,"");
    }
}
