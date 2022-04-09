package com.ststjl_project.views.stages.Player_Interface;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Chance_Status extends Status_Pane{
    @Override
    public void Init(Pane mainPane, GraphicsContext mainGc, double[] Related_pos) {
        super.setPane(mainPane);
        super.setGC(mainGc);
        super.setRelated_pos(Related_pos);
        for(int i = 0;i<2;i++){
            ChancesBox[i] = new Rectangle();
            ChancesText[i]=new Text();
        }
        this.getChildren().addAll(ChancesBox);
        this.getChildren().addAll(ChancesText);
    }

    @Override
    public void reDraw() {
        reSizing();
        double layoutX=this.getLayoutX();
        double layoutY=this.getLayoutY();
        double width=this.getWidth();
        double height=this.getHeight();

        double ChancesBox_PadX = width*0.01;
        double ChancesBox_PadY = (height/2)*0.05;

        double ChancesBox_width = width-2.0* ChancesBox_PadX;
        double ChancesBox_Height = (height/2.0)-2.0* ChancesBox_PadY;


        double text_Size;
        double text_padX;

        for (int i = 0; i<2; i++){
            setRectanglePosWH(ChancesBox[i], ChancesBox_PadX, ChancesBox_PadY +(height/2.0)*i,ChancesBox_width,ChancesBox_Height);
            text_Size = ChancesBox[i].getHeight()*0.5;
            text_padX = ChancesBox[i].getHeight()*0.3;

            setTextPosWH(ChancesText[i],ChancesBox[i].getLayoutX(),ChancesBox[i].getLayoutY()+ChancesBox[i].getHeight()-text_padX,ChancesBox_width,ChancesBox_Height);
            ChancesText[i].setFont(Font.font ("arial", text_Size));
            ChancesText[i].setFill(Color.WHITE);
            ChancesText[i].setText("Demo Critical");
        }
    }
    private final Rectangle []ChancesBox = new Rectangle[2];
    private final Text []ChancesText = new Text[2];
}
