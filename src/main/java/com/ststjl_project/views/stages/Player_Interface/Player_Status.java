package com.ststjl_project.views.stages.Player_Interface;

import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Player_Status extends Pane {
    public Player_Status(){
    }
    public Player_Status(double health, double armor, double mana, double shield) {
        this.health = health;
        this.armor = armor;
        this.mana = mana;
        this.shield = shield;
    }
    public Player_Status(double health, double armor, double mana, double shield, Node... nodes) {
        super(nodes);
        this.health = health;
        this.armor = armor;
        this.mana = mana;
        this.shield = shield;
    }

    public void Init(Pane mainPane, GraphicsContext mainGc,double Related_pos[]){
        this.mainPane=mainPane;
        this.mainGc=mainGc;
        this.Related_pos=Related_pos;

        for(int i = 0; i < 4; i++){
            itemPane[i] = new StackPane();
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
        double layoutX=mainPane.getHeight()*Related_pos[0];
        double layoutY=mainPane.getWidth()*Related_pos[1];
        double width=mainPane.getWidth()*Related_pos[2]-layoutX;
        double height=mainPane.getHeight()*Related_pos[3]-layoutY;

        double padX = width*0.01;
        double padY = height*0.02;

        this.setLayoutX(layoutX);
        this.setLayoutY(layoutY);
        this.setWidth(width);
        this.setHeight(height);


        itemPane[0].setLayoutX(layoutX);
        itemPane[1].setLayoutX(layoutX+(width)/2);
        itemPane[2].setLayoutX(layoutX);
        itemPane[3].setLayoutX(layoutX+(width)/2);

        itemBox[0].setLayoutX(layoutX+padX);
        itemBox[1].setLayoutX(layoutX+width/2+padX);
        itemBox[2].setLayoutX(layoutX+padX);
        itemBox[3].setLayoutX(layoutX+width/2+padX);

        itemPane[0].setLayoutY(layoutY);
        itemPane[1].setLayoutY(layoutY);
        itemPane[2].setLayoutY(layoutY+(height)/2);
        itemPane[3].setLayoutY(layoutY+(height)/2);

        itemBox[0].setLayoutY(layoutY+padY);
        itemBox[1].setLayoutY(layoutY+padY);
        itemBox[2].setLayoutY(layoutY+height/2+padY);
        itemBox[3].setLayoutY(layoutY+height/2+padY);

        itemPane[0].setMinWidth(width/2);
        itemPane[1].setMinWidth(width/2);
        itemPane[2].setMinWidth(width/2);
        itemPane[3].setMinWidth(width/2);

        itemBox[0].setWidth((width/2)-2*padX);
        itemBox[1].setWidth((width/2)-2*padX);
        itemBox[2].setWidth((width/2)-2*padX);
        itemBox[3].setWidth((width/2)-2*padX);

        itemPane[0].setMinHeight(height/2);
        itemPane[1].setMinHeight(height/2);
        itemPane[2].setMinHeight(height/2);
        itemPane[3].setMinHeight(height/2);

        itemBox[0].setHeight((height/2)-2*padY);
        itemBox[1].setHeight((height/2)-2*padY);
        itemBox[2].setHeight((height/2)-2*padY);
        itemBox[3].setHeight((height/2)-2*padY);
    }

    public double getHealth() {
        return health;
    }
    public double getArmor() {
        return armor;
    }
    public double getMana() {
        return mana;
    }
    public double getShield() {
        return shield;
    }

    public void setHealth(double health) {
        this.health = health;
    }
    public void setArmor(double armor) {
        this.armor = armor;
    }
    public void setMana(double mana) {
        this.mana = mana;
    }
    public void setShield(double shield) {
        this.shield = shield;
    }

    private double health;
    private double armor;
    private double mana;
    private double shield;
    private Pane mainPane;
    private GraphicsContext mainGc;
    private StackPane[] itemPane = new StackPane[4];
    private Rectangle[] itemBox  = new Rectangle[4];
    private Text[]      itemText = new Text[4];

    private double[] Related_pos;
}
