package com.ststjl_project.views.stages.Player_Interface;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Player_Status extends Status_Pane {
    public Player_Status(){
    }

    public void Init(Pane mainPane, GraphicsContext mainGc,double Related_pos[]){
        super.setPane(mainPane);
        super.setGC(mainGc);
        super.setRelated_pos(Related_pos);

        for(int i = 0; i < 4; i++){
            itemPane[i] = new Pane();
            itemBox[i]  = new Rectangle();
            itemText[i] = new Text();
            itemPane[i].getChildren().addAll(itemBox[i],itemText[i]);
            this.getChildren().add(itemPane[i]);

        }
        itemBox[0].setFill(Color.ORANGERED);
        itemBox[1].setFill(Color.YELLOW);
        itemBox[2].setFill(Color.CADETBLUE);
        itemBox[3].setFill(Color.BLUEVIOLET);
    }

    public void update(){
        reSizing();
        double layoutX=super.getLayoutX();
        double layoutY=super.getLayoutY();
        double width=super.getWidth();
        double height=super.getHeight();

        setPane(itemPane[0],layoutX,layoutY,width/2.0,height/2.0);
        setPane(itemPane[1],layoutX+(width)/2.0,layoutY,width/2.0,height/2.0);
        setPane(itemPane[2],layoutX,layoutY+(height)/2.0,width/2.0,height/2.0);
        setPane(itemPane[3],layoutX+(width)/2.0,layoutY+(height)/2.0,width/2.0,height/2.0);

        double itemBox_padX = (width/2)*0.01;
        double itemBox_padY = (height/2)*0.05;

        double rectangle_width = (width/2.0)-2.0*itemBox_padX;
        double rectangle_height = (height/2.0)-2.0*itemBox_padY;

        double text_Size;
        double text_padX;
        for(int i = 0; i < 4; i++){
            setRectanglePosWH(itemBox[i],itemBox_padX,itemBox_padY,rectangle_width,rectangle_height);

            text_Size = itemBox[i].getHeight()*0.8;
            text_padX = itemBox[i].getHeight()*0.2;

            setTextPosWH(itemText[i],itemBox[i].getLayoutX(),itemBox[i].getLayoutY()+itemBox[i].getHeight()-text_padX,rectangle_width,rectangle_height);
            itemText[i].setFont(Font.font ("arial", text_Size));

        }
        itemText[0].setText("health");
        itemText[1].setText("armor");
        itemText[2].setText("mana");
        itemText[3].setText("shield");

    }

    public double getHealth_() {
        return health_;
    }
    public double getArmor_() {
        return armor_;
    }
    public double getMana_() {
        return mana_;
    }
    public double getShield_() {
        return shield_;
    }

    public void setHealth_(double health_) {
        this.health_ = health_;
    }
    public void setArmor_(double armor_) {
        this.armor_ = armor_;
    }
    public void setMana_(double mana_) {
        this.mana_ = mana_;
    }
    public void setShield_(double shield_) {
        this.shield_ = shield_;
    }

    private double health_ =0;
    private double armor_  =0;
    private double mana_   =0;
    private double shield_ =0;
    private Pane[] itemPane = new Pane[4];
    private Rectangle[] itemBox  = new Rectangle[4];
    private Text[]      itemText = new Text[4];

}
