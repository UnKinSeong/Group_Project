package com.ststjl_project.Cards;

import com.ststjl_project.utility.Audio_Codex;
import com.ststjl_project.utility.Random_Number;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import static com.ststjl_project.utility.Positioners.*;

public class Card_Base extends Pane {
    public static double scaleFontToFit(double width,double stringWidth,double fontSize) {
        if(stringWidth <= width)
            return fontSize;
        fontSize = (width / stringWidth) * fontSize;
        return fontSize;
    }
    public void renderCard(){
        double Stroke_Width = 0.05*getHeight();

        double main_LayX = 0+Stroke_Width;
        double main_LayY = 0+Stroke_Width;
        double main_Width = getWidth()-Stroke_Width*2;
        double main_Height = getHeight()-Stroke_Width*2;

        boxes[4].setLayoutX(main_LayX);
        boxes[4].setLayoutY(main_LayY);
        boxes[4].setWidth(main_Width);
        boxes[4].setHeight(main_Height);
        boxes[4].setFill(Color.TRANSPARENT);
        boxes[4].setStrokeWidth(Stroke_Width);
        if(is_selected && is_over){
            boxes[4].setStroke(Color.PURPLE);
        }else if(is_selected) {
            boxes[4].setStroke(Color.RED);
        }else if(is_over){
            boxes[4].setStroke(Color.GREEN);
        }else {
            boxes[4].setStroke(Boxes_Colors[0]);
        }

        main_LayX   = main_LayX+Stroke_Width/2;
        main_LayY   = main_LayY+Stroke_Width/2;
        main_Width  = main_Width-Stroke_Width;
        main_Height = main_Height-Stroke_Width;

        setRectanglePosWH(boxes[0],main_LayX,main_LayY,main_Width,main_Height*0.15);
        setRectanglePosWH(boxes[1],main_LayX,boxes[0].getLayoutY()+boxes[0].getHeight(),main_Width,main_Height*0.15);

        setRectanglePosWH(boxes[2],main_LayX,main_LayX+main_Height-main_Height*0.2,main_Width*0.2,main_Height*0.2);

        setRectanglePosWH(boxes[3],(main_LayX+main_Width)-(main_Width)*0.2,main_LayX+main_Height-main_Height*0.2,main_Width*0.2,main_Height*0.2);


        double text_width,text_height,text_Size;
        double rec_layX, rec_layY, rec_width, rec_height;
        for (int i = 0; i < 4;i++) {
            text_width = texts[i].getLayoutBounds().getWidth();
            text_height = texts[i].getLayoutBounds().getHeight();
            text_Size = texts[i].getFont().getSize();

            texts[i].setFont(Font.font("arial", text_height));
            texts[0].setText(card_Name);
            texts[1].setText(type_name);
            texts[2].setText(Integer.toString((int) base_damage));
            texts[3].setText(Integer.toString((int)self_damage));
            rec_layX = boxes[i].getLayoutX();
            rec_layY = boxes[i].getLayoutY()+boxes[i].getHeight();
            rec_width = boxes[i].getWidth();
            rec_height = boxes[i].getHeight();

            if(text_height<rec_height) {
                if(text_width>rec_width){
                    text_Size = scaleFontToFit(rec_width,text_width,text_Size);
                }else if(Math.abs(text_width-rec_width)>0.2){
                    text_Size = rec_height;
                }else{
                    text_Size = scaleFontToFit(rec_width,text_width,text_Size);
                }
            }else if(text_height>rec_height){
                if(text_width>rec_width){
                    text_Size = scaleFontToFit(rec_width,text_width,text_Size);
                }else if (Math.abs(text_width-rec_width)>0.2){
                    text_Size = rec_height;
                }else{
                    text_Size = scaleFontToFit(rec_width,text_width,text_Size);
                }
            }

            texts[i].setLayoutX(rec_layX);
            texts[i].setLayoutY(rec_layY-text_Size*0.15);
            texts[i].setFont(Font.font("arial", text_Size));
        }


        for(int i = 0; i < 4; i++){
            boxes[i].setFill(Boxes_Colors[i+1]);
            texts[i].setFill(Text_Colors[i]);
        }
    }
    public void Update_Card_Detail(){
    }
    public void setBoxes_Colors(Color[] colors){
        Boxes_Colors=colors;
    }
    public void setText_Colors(Color[] colors){
        Text_Colors=colors;
    }

    public String getType_name(){
        return type_name;
    }
    private String card_Name;
    private String type_name;
    private final double[][] Boxes_Pos;
    {
        final double ResulX = 1080;
        final double ResulY = 1640;
        final double Row_1_EndY = (double) 410 / ResulY;
        final double Row_2_EndY = (double) 660 / ResulY;
        final double Row_4_EndY = (double) 570 / ResulY;
        final double Row_E_EndY = 1;
        Boxes_Pos = new double[][]{
                // ROW 1 //
                {
                        (double)0/ResulX,
                        (double)0/ResulY,
                        1,
                        Row_1_EndY
                },
                // ROW 2 //
                {
                        (double)0/ResulX,
                        Row_1_EndY,
                        1,
                        Row_2_EndY
                },
                // ROW 4 //
                {
                        (double)0/ResulX,
                        Row_4_EndY,
                        410/ResulX,
                        Row_1_EndY
                },
                {
                        (double)670/ResulX,
                        Row_4_EndY,
                        1,
                        Row_1_EndY
                },
        };
    }

    private Color [] Boxes_Colors = {
            Color.BLACK,
            Color.BLUE,
            Color.LIGHTBLUE,
            Color.GRAY,
            Color.GRAY,
    };
    private Color [] Text_Colors = {
            Color.BLACK,
            Color.BLACK,
            Color.BLACK,
            Color.BLACK
    };


    private EventHandler<MouseEvent> Mouse_On;
    private EventHandler<MouseEvent> Mouse_Leave;
    private EventHandler<MouseEvent> UnSelected_Event;
    private EventHandler<MouseEvent> Mouse_Click;

    public void unselect(){
        is_selected = false;
    }
    public void drawYourself(){};
    public boolean isSelect(){
        return is_selected;
    }
    public boolean is_removed = false;
    public void CleanUp(){
        removeEventFilter(MouseEvent.MOUSE_ENTERED, Mouse_On);
        removeEventFilter(MouseEvent.MOUSE_EXITED, Mouse_Leave);
        removeEventFilter(MouseEvent.MOUSE_CLICKED, Mouse_Click);
        getChildren().removeAll(boxes);
        getChildren().removeAll(texts);
    }
    private Rectangle[] boxes = new Rectangle[5];
    private Text[] texts = new Text[4];
    private double
            base_damage=0,
            base_critical_chance=0,
            self_damage=0;
    private boolean is_selected = false;
    public void setType_name(String str){
        type_name = str;
    }

    public double getCost() {
        return self_damage;
    }
    public double getDamage(){
        return base_damage + (1+(base_critical_chance-Random_Number.randDouble(0.0,base_critical_chance)))*base_damage;
    }

    private boolean is_over = false;
    public Card_Base(
            String card_Name,
            String type_name,
            double base_damage,
            double base_critical_chance,
            double self_damage
    )
    {
        this.card_Name = card_Name;
        this.type_name=type_name;
        this.base_damage = base_damage;
        this.base_critical_chance = base_critical_chance;
        this.self_damage = self_damage;
        for(int i=0;i<boxes.length;i++){
            boxes[i]=new Rectangle();
        }
        for(int i =0; i < texts.length;i++){
            texts[i]=new Text();
        }

        Mouse_On = mouseEvent -> {
            is_over=true;
            Audio_Codex.play("Item_Over.mp3");
        };
        Mouse_Leave = mouseEvent -> {
            is_over=false;
        };
        Mouse_Click = mouseEvent -> {
            is_selected=!is_selected;
            Audio_Codex.play("Item_Selected.mp3");
        };

        this.addEventHandler(MouseEvent.MOUSE_ENTERED, Mouse_On);
        this.addEventHandler(MouseEvent.MOUSE_EXITED, Mouse_Leave);
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, Mouse_Click);

        getChildren().addAll(boxes);
        getChildren().addAll(texts);
    }
    public static ArrayList<String> getAudioList() {
        return audioList;
    }

    public static void setAudioList(ArrayList<String> audioList2) {
        audioList = audioList2;
    }

    private static ArrayList<String> audioList = new ArrayList<>();

    public double getBase_damage(){return this.base_damage;}
    public double getBase_critical_chance(){return this.base_critical_chance;}
    public void setBase_damage(double base_damage_){this.base_damage = base_damage_;}
    public void setBase_critical_chance(double base_critical_chance_){this.base_critical_chance = base_critical_chance_;}

}
