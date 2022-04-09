package com.ststjl_project.views.stages.Player_Interface;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class History_Status extends Status_Pane{
    @Override
    public void Init(Pane mainPane, GraphicsContext mainGc, double[] Related_pos) {
        super.setPane(mainPane);
        super.setGC(mainGc);
        super.setRelated_pos(Related_pos);
        for(int i = 0; i < 5;i++){
            history_Box[i]=new Rectangle();
            history_s[i]=new Text();
        }
        this.getChildren().addAll(history_Box);
        this.getChildren().addAll(history_s);
    }

    @Override
    public void reDraw() {
        reSizing();
        double layoutX=this.getLayoutX();
        double layoutY=this.getLayoutY();
        double width=this.getWidth();
        double height=this.getHeight();

        double historyBox_PadX = width*0.01;
        double historyBox_PadY = (height/2)*0.05;

        double historyBox_width = width-2.0* historyBox_PadX;
        double historyBox_Height = (height/5)-2.0* historyBox_PadY;


        double text_Size;
        double text_padX;

        for (int i = 0; i<5; i++){
            setRectanglePosWH(history_Box[i], historyBox_PadX, historyBox_PadY +(height/5)*i,historyBox_width,historyBox_Height);
            text_Size = history_Box[i].getHeight()*0.5;
            text_padX = history_Box[i].getHeight()*0.3;

            setTextPosWH(history_s[i],history_Box[i].getLayoutX(),history_Box[i].getLayoutY()+history_Box[i].getHeight()-text_padX,historyBox_width,historyBox_Height);
            history_s[i].setFont(Font.font ("arial", text_Size));
            history_s[i].setFill(Color.WHITE);
            history_s[i].setText("Demo History");
        }
    }
    private final Rectangle []history_Box=new Rectangle[5];
    private final Text []history_s = new Text[5];
}
