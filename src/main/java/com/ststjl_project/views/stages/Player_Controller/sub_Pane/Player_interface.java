package com.ststjl_project.views.stages.Player_Controller.sub_Pane;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Player_interface {
    // related Pos //
    private final GraphicsContext mainGc;
    private final Pane mainPane;

    private Player_Status player_status_pane;
    private final double [] player_status_pane_Pos = {0,0,0.4,(double)1/(double)9};

    private Bonus_Status bonus_status_pane;
    private final double [] bonus_status_pane_Pos = {0.4,0,0.8,(double)1/(double)9};

    private Timer_Status timer_status_pane;
    private final double [] timer_status_pane_Pos = {0.8,0,1,(double)1/(double)9};

    private final double Right_Most_Status_PosX = 0.8;
    private final double Right_Most_Status_PosY = (double)1/(double)9;
    private final double Right_Most_Status_Height = (double)1-(double)1/(double)9;
    private final double Right_Most_Status_Each_Height = Right_Most_Status_Height /(double)3;

    private Battle_Status battle_pane;
    private final double [] battle_pane_Pos = {0,(double)1/(double)9,Right_Most_Status_PosX,1};

    private History_Status history_status_pane;
    private final double [] history_status_pane_Pos = {
            Right_Most_Status_PosX,
            Right_Most_Status_PosY,
            1,
            Right_Most_Status_PosY+Right_Most_Status_Each_Height};

    private Chance_Status player_Hit_Chances_pane;
    private final double [] player_Hit_Chances_pane_Pos = {
            Right_Most_Status_PosX,
            Right_Most_Status_PosY+Right_Most_Status_Each_Height,
            1,
            Right_Most_Status_PosY+Right_Most_Status_Each_Height*2};


    private Next_Round_Status_Pane next_Round_Status_pane;
    private final double [] next_status_pane_Pos = {
            Right_Most_Status_PosX,
            Right_Most_Status_PosY+Right_Most_Status_Each_Height*2,
            1,
            Right_Most_Status_PosY+Right_Most_Status_Each_Height*3};


    public Player_interface(GraphicsContext graphicsContext, Pane pane1){
        mainGc = graphicsContext;
        mainPane = pane1;
        _Status_Pane.mainPane = pane1;
        _Status_Pane.mainGC = graphicsContext;
    }

    public double getRelated_(double size, double relatedX, double relatedX2){
        return Math.abs(size*relatedX-size*relatedX2);
    }

    public void Init(){
        player_status_pane=new Player_Status();
        bonus_status_pane =new Bonus_Status();
        timer_status_pane =new Timer_Status();
        history_status_pane =new History_Status();
        player_Hit_Chances_pane =new Chance_Status();
        next_Round_Status_pane =new Next_Round_Status_Pane();
        battle_pane=new Battle_Status();
        mainPane.getChildren().addAll(player_status_pane, bonus_status_pane, timer_status_pane, history_status_pane, player_Hit_Chances_pane, next_Round_Status_pane,battle_pane);

        player_status_pane.Init(player_status_pane_Pos);
        bonus_status_pane.Init(bonus_status_pane_Pos);
        timer_status_pane.Init(timer_status_pane_Pos);
        history_status_pane.Init(history_status_pane_Pos);
        player_Hit_Chances_pane.Init(player_Hit_Chances_pane_Pos);
        next_Round_Status_pane.Init(next_status_pane_Pos);
        history_status_pane.addHistory("Demo Add History:", Color.RED);
        battle_pane.Init(battle_pane_Pos);
    }
    public void setPPP(double[] related, Color color){ // Just some debug thingy.
        double width = mainPane.getWidth();
        double height = mainPane.getHeight();

        mainGc.setFill(color);
        mainGc.fillRect(related[0]*width,related[1]*height,getRelated_(width,related[0],related[2]),getRelated_(height,related[1],related[3]));
        mainGc.setFill(Color.WHITE);

    }

    public void Draw_Yourself(){
        player_status_pane.reDraw();
        bonus_status_pane.reDraw();
        timer_status_pane.reDraw();
        history_status_pane.reDraw();
        player_Hit_Chances_pane.reDraw();
        next_Round_Status_pane.reDraw();
        battle_pane.reDraw();
    }
    public Player_Status getPlayer_status_pane(){return player_status_pane;};
    public Bonus_Status getBonus_status_pane(){return bonus_status_pane;};
    public Timer_Status getTimer_status_pane(){return timer_status_pane;};
    public History_Status getHistory_status_pane(){return history_status_pane;};
    public Chance_Status getPlayer_Hit_Chances_pane(){return player_Hit_Chances_pane;};
    public Next_Round_Status_Pane getNext_Round_Status_pane(){return next_Round_Status_pane;};
    public Battle_Status getBattle_pane_pane(){return battle_pane;};

    public void clean_Up() {
        player_status_pane.CleanUp();
        bonus_status_pane.CleanUp();
        timer_status_pane.CleanUp();
        history_status_pane.CleanUp();
        player_Hit_Chances_pane.CleanUp();
        next_Round_Status_pane.CleanUp();
        battle_pane.CleanUp();
        mainPane.getChildren().removeAll(player_status_pane, bonus_status_pane, timer_status_pane, history_status_pane, player_Hit_Chances_pane, next_Round_Status_pane,battle_pane);
    }
}
