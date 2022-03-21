package com.ststjl_project.views;

import com.ststjl_project.views.buttoms.Still_Button;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.lang.reflect.Array;
import java.util.*;

public class Menu_Btn_List {
    private double menu_left_related;
    private double menu_right_related;
    private double menu_top_related;
    private double menu_bottom_related;
    private List<Still_Button> list_of_Buttons = new ArrayList<>();
    private List<String> list_of_Buttons_Str = new ArrayList<>();
    private double re_spacing = 0;
    private boolean vertical = true;
    private boolean is_init = false;
    private AnchorPane anchorPane;
    public Menu_Btn_List(AnchorPane anchorPane){
        this.anchorPane=anchorPane;
    }

    public void setAnchorPane(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
        update();
    }

    private void set_related_Spacing(double re_spacing){
        this.re_spacing = re_spacing;
    }
    public void setManu_Position(double menu_left_related, double menu_right_related, double menu_top_related, double menu_bottom_related, double spacing){
        this.menu_left_related=menu_left_related;
        this.menu_right_related=menu_right_related;
        this.menu_top_related=menu_top_related;
        this.menu_bottom_related=menu_bottom_related;
        this.re_spacing = spacing;
    }
    public void update(){
        if(!is_init){
            init_Pane();
        }
        double menu_init_X  = anchorPane.getWidth()  * menu_left_related;
        double menu_end_X   = anchorPane.getWidth()  * menu_right_related;
        double menu_init_Y = anchorPane.getHeight() * menu_top_related;
        double menu_end_Y  = anchorPane.getHeight() * menu_bottom_related;
        setMenu_Btn(menu_init_X,menu_end_X,menu_init_Y,menu_end_Y);
    }
    public void setMenu_Btn(double init_x, double end_x, double init_y, double end_y){
        if (vertical) {
            for (Button b : list_of_Buttons) {
                b.setLayoutX(init_x);
                b.setMaxWidth(Math.abs(init_x - end_x));
                b.setMinWidth(Math.abs(init_x - end_x));
            }
            double height = Math.abs(init_y - end_y);
            double button_spacing = (height * re_spacing) / (list_of_Buttons.size() - 1);
            double button_height = (height - height * re_spacing) / list_of_Buttons.size();

            double next_h = init_y;
            for (Button b : list_of_Buttons) {
                b.setLayoutY(next_h);
                b.setMaxHeight(button_height);
                b.setMinHeight(button_height);
                next_h += button_height + button_spacing;
            }
        }else{
            return;
        }
    }
    public void init_Pane(){
        for(Still_Button b : list_of_Buttons){
            anchorPane.getChildren().add(b);
        }
        is_init=true;
    }
    public void remove_Button(String[] name){
        for(String s:name){
            remove_Button(s);
        }
    }
    public void remove_Button(List<String> name){
        for(String s:name){
            remove_Button(s);
        }
    }

    public void remove_Button(String name){
        int index = list_of_Buttons_Str.indexOf(name);
        if(index>=0){
            anchorPane.getChildren().remove(list_of_Buttons.get(index));
            list_of_Buttons.remove(index);
            list_of_Buttons_Str.remove(index);
        }else{
            System.out.printf("Button[%s] at Method remove_Button not found",name);
        }
        is_init=false;
    }
    public Still_Button get_Button(String name){
        int index = list_of_Buttons_Str.indexOf(name);
        if(index>=0){
            return list_of_Buttons.get(index);
        }else{
            return null;
        }
    }
    public void add_Button(String name){
        Still_Button t_btn = new Still_Button();
        t_btn.setText(name);
        list_of_Buttons.add(t_btn);
        list_of_Buttons_Str.add(name);

    }
    public void add_Button(String[] names){
        for(String s : names){
            add_Button(s);
        }
    }
    public void add_Button(List<String> names){
        for(String s : names){
            add_Button(s);
        }
    }
    public void hideButton(String s){
        int index = list_of_Buttons_Str.indexOf(s);
        if(index>=0){
            anchorPane.getChildren().remove(list_of_Buttons.get(index));
        }else{
            System.out.printf("Button[%s] at Method remove_Button not found",s);
        }
    }
    public void hideAllButton(){
        for(String s : list_of_Buttons_Str){
            hideButton(s);
        }
        is_init = false;
    }
}
