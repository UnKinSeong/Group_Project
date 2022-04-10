package com.ststjl_project.views.stages.Player_Panes.sub_Pane;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import static com.ststjl_project.utility.Positioners.setRectanglePosWH;
import static com.ststjl_project.utility.Positioners.setTextPosWH;

public class Chance_Status extends _Status_Pane {
    @Override
    public void Init(double[] Related_pos) {
        super.setRelated_pos(Related_pos);
        for(int i = 0;i<2;i++){
            ChancesBox[i] = new Rectangle();
            ChancesText[i]=new Text();
        }
        ChancesText[0].setFill(Color.RED);
        ChancesText[1].setFill(Color.YELLOW);
        getChildren().addAll(ChancesBox);
        getChildren().addAll(ChancesText);
    }

    public void setHitChances(double chances){
        this.chances[0]=chances;
    }
    public void setCritChances(double chances){
        this.chances[1]=chances;
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
            //ChancesText[i].setFill(Color.WHITE);

        }
        ChancesText[0].setText("Crit : "+chances[0]);
        ChancesText[1].setText("Crit : "+chances[1]);
    }

    @Override
    public void CleanUp() {
        getChildren().removeAll(ChancesBox);
        getChildren().removeAll(ChancesText);
    }

    @Override
    public void updateData(double[] data) {
        for (int i = 0; i < 2; i++){
            chances[i]=data[i];
        }
    }

    private double chances[] = {0,0};
    private final Rectangle []ChancesBox = new Rectangle[2];
    private final Text []ChancesText = new Text[2];
}
