package com.ststjl_project.views.stages.Player_Panes.sub_Pane;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import static com.ststjl_project.utility.Positioners.setRectanglePosWH;
import static com.ststjl_project.utility.Positioners.setTextPosWH;

public class Bonus_Status extends _Status_Pane {
    public Bonus_Status(){}
    public void Init(double[] Related_pos){
        super.setRelated_pos(Related_pos);
        Bonus_Box = new Rectangle();
        Bonus_Text = new Text();
        this.getChildren().addAll(Bonus_Box,Bonus_Text);
    }

    @Override
    public void reDraw() {
        reSizing();
        double layoutX=this.getLayoutX();
        double layoutY=this.getLayoutY();
        double width=this.getWidth();
        double height=this.getHeight();

        double itemBox_padX = width*0.01;
        double itemBox_padY = height*0.05;

        double itemBox_width = width-2.0*itemBox_padX;
        double itemBox_height = height-2.0*itemBox_padY;

        setRectanglePosWH(Bonus_Box,itemBox_padX,itemBox_padY,itemBox_width,itemBox_height);

        double text_Size=Bonus_Box.getHeight()*0.3;
        double text_padX=Bonus_Box.getHeight()*0.3;
        setTextPosWH(Bonus_Text,Bonus_Box.getLayoutX(),Bonus_Box.getLayoutY()+Bonus_Box.getHeight()-text_padX,itemBox_width,itemBox_height);
        Bonus_Text.setFont(Font.font ("arial", text_Size));
        Bonus_Text.setText(String.format("BONUS : %.2f[D] %.2f[H] %.2f[C]",bonuss[0],bonuss[1],bonuss[2]));
        Bonus_Box.setFill(Color.BLUE);
    }

    @Override
    public void CleanUp() {
        getChildren().removeAll(Bonus_Box,Bonus_Text);
    }

    @Override
    public void updateData(double[] data) {
        for(int i = 0 ; i < 3; i++){
            bonuss[i]=data[i];
        }
    }
    private double bonuss[] = {0,0,0};
    private Rectangle Bonus_Box = new Rectangle();
    private Text Bonus_Text = new Text();
}
