package com.ststjl_project.views.Game_Logic.Player;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Player_interface {
    // related Pos //
    private GraphicsContext gc;
    private Pane pane;
    private Rectangle Player_Pane_Box;
    private double [] Player_Pane_Pos = {0,0,0.4,(double)1/(double)9};

    private Rectangle Bones_Pane_Box;
    private double [] Bones_Pane_Pos = {0.4,0,0.8,(double)1/(double)9};

    private Rectangle Timer_Limit_Pane_Box;
    private double [] Timer_Limit_Pane_Pos = {0.8,0,1,(double)1/(double)9};

    private double Right_Most_Status_PosX = 0.8;
    private double Right_Most_Status_PosY = (double)1/(double)9;
    private double Right_Most_Status_Height = (double)1-(double)1/(double)9;
    private double Right_Most_Status_Each_Height = (double)(Right_Most_Status_Height)/(double)3;

    private Rectangle History_Pane_Box;
    private double [] History_Pane_Pos = {
            Right_Most_Status_PosX,
            Right_Most_Status_PosY,
            1,
            Right_Most_Status_PosY+Right_Most_Status_Each_Height};
    private Rectangle Player_Hit_Chances_Pane_Box;
    private double [] Player_Hit_Chances_Pane_Pos = {
            Right_Most_Status_PosX,
            Right_Most_Status_PosY+Right_Most_Status_Each_Height,
            1,
            Right_Most_Status_PosY+Right_Most_Status_Each_Height*2};

    private Rectangle Player_Next_Pane_Box;
    private double [] Player_Next_Pane_Pos = {
            Right_Most_Status_PosX,
            Right_Most_Status_PosY+Right_Most_Status_Each_Height*2,
            1,
            Right_Most_Status_PosY+Right_Most_Status_Each_Height*3};

    public Player_interface(GraphicsContext graphicsContext, Pane pane1){
        gc = graphicsContext;
        pane = pane1;
    };
    public double getRelated_(double width, double relatedx, double relatedx2){
        return Math.abs(width*relatedx-width*relatedx2);
    }

    public void draw_Rectangle(double posX, double posY, double width, double height, Color color){
        gc.setFill(color);
        gc.fillRect(posX,posY,width,height);
    }
    public void Init(){
        Player_Pane_Box = new Rectangle();
        Bones_Pane_Box = new Rectangle();
    }
    public void Draw_Yourself(){

        double pane_width = pane.getWidth();
        double pane_height = pane.getHeight();

        draw_Rectangle(
                Player_Pane_Pos[0]*pane_width,
                Player_Pane_Pos[1]*pane_height,
                getRelated_(pane_width,Player_Pane_Pos[0],Player_Pane_Pos[2]),
                getRelated_(pane_height,Player_Pane_Pos[1],Player_Pane_Pos[3]),
                Color.RED
        );

        draw_Rectangle(
                Bones_Pane_Pos[0]*pane_width,
                Bones_Pane_Pos[1]*pane_height,
                getRelated_(pane_width,Bones_Pane_Pos[0],Bones_Pane_Pos[2]),
                getRelated_(pane_height,Bones_Pane_Pos[1],Bones_Pane_Pos[3]),
                Color.GREEN
        );

        draw_Rectangle(
                Timer_Limit_Pane_Pos[0]*pane_width,
                Timer_Limit_Pane_Pos[1]*pane_height,
                getRelated_(pane_width,Timer_Limit_Pane_Pos[0],Timer_Limit_Pane_Pos[2]),
                getRelated_(pane_height,Timer_Limit_Pane_Pos[1],Timer_Limit_Pane_Pos[3]),
                Color.RED
        );

        draw_Rectangle(
                History_Pane_Pos[0]*pane_width,
                History_Pane_Pos[1]*pane_height,
                getRelated_(pane_width,History_Pane_Pos[0],History_Pane_Pos[2]),
                getRelated_(pane_height,History_Pane_Pos[1],History_Pane_Pos[3]),
                Color.BLUE
        );

        draw_Rectangle(
                Player_Hit_Chances_Pane_Pos[0]*pane_width,
                Player_Hit_Chances_Pane_Pos[1]*pane_height,
                getRelated_(pane_width,Player_Hit_Chances_Pane_Pos[0],Player_Hit_Chances_Pane_Pos[2]),
                getRelated_(pane_height,Player_Hit_Chances_Pane_Pos[1],Player_Hit_Chances_Pane_Pos[3]),
                Color.GREEN
        );

        draw_Rectangle(
                Player_Next_Pane_Pos[0]*pane_width,
                Player_Next_Pane_Pos[1]*pane_height,
                getRelated_(pane_width,Player_Next_Pane_Pos[0],Player_Next_Pane_Pos[2]),
                getRelated_(pane_height,Player_Next_Pane_Pos[1],Player_Next_Pane_Pos[3]),
                Color.BLUE
        );
    }
}
