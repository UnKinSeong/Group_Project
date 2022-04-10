package com.ststjl_project.views.stages.Player_Panes.sub_Pane;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import static com.ststjl_project.utility.Positioners.*;

public class Player_Status extends _Status_Pane {
    public Player_Status(){
    }

    public void Init(double[] Related_pos){

        super.setRelated_pos(Related_pos);

        for(int i = 0; i < 4; i++){
            itemPane[i] = new Pane();
            itemText[i] = new Text();
            percentBars[i*2] = new Rectangle();
            percentBars[i*2+1] = new Rectangle();
            itemPane[i].getChildren().add(percentBars[i*2+1]);
            itemPane[i].getChildren().add(percentBars[i*2]);
            itemPane[i].getChildren().addAll(itemText[i]);
            this.getChildren().add(itemPane[i]);

        }
        percentBars[0].setFill(Color.ORANGERED);
        percentBars[1].setFill(Color.BLACK);
        percentBars[2].setFill(Color.YELLOW);
        percentBars[3].setFill(Color.BLACK);
        percentBars[4].setFill(Color.CADETBLUE);
        percentBars[5].setFill(Color.BLACK);
        percentBars[6].setFill(Color.BLUEVIOLET);
        percentBars[7].setFill(Color.BLACK);
    }

    public void reDraw(){
        reSizing();
        double layoutX=super.getLayoutX();
        double layoutY=super.getLayoutY();
        double width=super.getWidth();
        double height=super.getHeight();

        setPanePosWH(itemPane[0],layoutX,layoutY,width/2.0,height/2.0);
        setPanePosWH(itemPane[1],layoutX+(width)/2.0,layoutY,width/2.0,height/2.0);
        setPanePosWH(itemPane[2],layoutX,layoutY+(height)/2.0,width/2.0,height/2.0);
        setPanePosWH(itemPane[3],layoutX+(width)/2.0,layoutY+(height)/2.0,width/2.0,height/2.0);

        double itemBox_padX;
        double itemBox_padY;

        double rectangle_width;
        double rectangle_height;

        double text_Size;
        double text_padX;
        for(int i = 0; i < 4; i++){

            itemBox_padX = (width/2)*0.01;
            itemBox_padY = (height/2)*0.05;
            rectangle_width = ((width/2.0)-2.0*itemBox_padX)/2;
            rectangle_height = (height/2.0)-2.0*itemBox_padY;

            text_Size = rectangle_height*0.8;
            text_padX = rectangle_height*0.2;

            setRectanglePosWH(percentBars[i*2],itemBox_padX+text_Size*3,itemBox_padY,rectangle_width*(status_[i]/status_caps_[i]),rectangle_height);
            setRectanglePosWH(percentBars[i*2+1],itemBox_padX+text_Size*3,itemBox_padY,rectangle_width*1,rectangle_height);

            setTextPosWH(itemText[i],itemPane[0].getLayoutX(),itemBox_padY+rectangle_height-text_padX,rectangle_width,rectangle_height);
            itemText[i].setFont(Font.font ("arial", text_Size));
            itemText[i].setFill(Color.BLACK);
        }
        itemText[0].setText("health");
        itemText[1].setText("armor");
        itemText[2].setText("mana");
        itemText[3].setText("shield");


    }

    @Override
    public void CleanUp() {
        for(int i = 0; i < 4; i++){
            itemPane[i].getChildren().remove(percentBars[i*2+1]);
            itemPane[i].getChildren().remove(percentBars[i*2]);
            itemPane[i].getChildren().removeAll(itemText[i]);
            getChildren().remove(itemPane[i]);

        }
    }

    @Override
    public void updateData(double[] data) {
        for(int i = 0; i < 4; i++){
            status_caps_[i*2] = data[i*2];
            status_caps_[i*2+1] = data[i*2+1];
        }
    }


    private double [] status_caps_ = {
            100,50,40,10
    };
    private double [] status_ = {
            30,50,20,10
    };


    private final Pane[] itemPane = new Pane[4];
    private final Text[]      itemText    = new Text[4];
    private final Rectangle[] percentBars = new Rectangle[8];

}
