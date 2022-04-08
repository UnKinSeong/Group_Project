package com.ststjl_project.views.stages.Player_Interface;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Bonus_Status extends Status_Pane {
    public Bonus_Status(){}
    public void Init(Pane mainPane, GraphicsContext mainGc,double Related_pos[]){
        super.setPane(mainPane);
        super.setGC(mainGc);
        super.setRelated_pos(Related_pos);
        Bonus_Box = new Rectangle();
        Bonus_Text = new Text();
        this.getChildren().addAll(Bonus_Box,Bonus_Text);
    }

    @Override
    public void update() {
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

        double text_Size=Bonus_Box.getHeight()*0.5;
        double text_padX=Bonus_Box.getHeight()*0.3;
        setTextPosWH(Bonus_Text,Bonus_Box.getLayoutX(),Bonus_Box.getLayoutY()+Bonus_Box.getHeight()-text_padX,itemBox_width,itemBox_height);
        Bonus_Text.setFont(Font.font ("arial", text_Size));
        Bonus_Text.setText("Demo History");
        Bonus_Box.setFill(Color.BLUE);

    }

    public void setPhysical_(double physical) {
        this.physical_ = physical;
    }
    public void setMagic_(double magic) {
        this.magic_ = magic;
    }
    public void setCritical_(double critical) {
        this.critical_ = critical;
    }
    public void setEffect_(double effect) {
        this.effect_ = effect;
    }

    public double getPhysical_() {
        return physical_;
    }
    public double getMagic_() {
        return magic_;
    }
    public double getCritical_() {
        return critical_;
    }
    public double getEffect_() {
        return effect_;
    }

    private double physical_;
    private double magic_;
    private double critical_;
    private double effect_;
    private Rectangle Bonus_Box = new Rectangle();
    private Text Bonus_Text = new Text();
}
