package com.ststjl_project.views;

import com.ststjl_project.views.buttoms.Still_Button;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.lang.reflect.Array;
import java.util.*;

public class Menu_Btn_List {
    //--------------------------------------------------//
    // The reference to the anchorPane that targeted to //
    //--------------------------------------------------//
    private AnchorPane anchorPane;

    //------------------------------------//
    // Related position to the AnchorPane //
    //------------------------------------//
    private double menu_related_Pos[] = new double[4];

    //-------------------------------//
    // Related spacing in AnchorPane //
    //-------------------------------//
    private double re_spacing = 0;

    //------------------//
    // vertical listing // false for horizontal
    //------------------//
    private boolean vertical = true;

    //-----------------------------------------------------------------//
    // Button List and button name to id the index for later operation // But why not map? -- quote by someone.
    //-----------------------------------------------------------------//
    private List<Still_Button> list_of_Buttons = new ArrayList<>();
    private List<String> list_of_Buttons_Str = new ArrayList<>();

    //--------------------------//
    // The state of the menuBtn //
    //--------------------------//
    private boolean is_init = false;

    //-------------//
    // Constructor //
    //-------------//
    public Menu_Btn_List(AnchorPane anchorPane){
        this.anchorPane=anchorPane;
    }

    //----------------------------------------------//
    // Update is responsible for game loop resizing //
    //----------------------------------------------//
    public void update(){
        if(!is_init){
            init_Pane();
        }
        double menu_init_X  = anchorPane.getWidth()  * menu_related_Pos[0];
        double menu_end_X   = anchorPane.getWidth()  * menu_related_Pos[1];
        double menu_init_Y = anchorPane.getHeight() * menu_related_Pos[2];
        double menu_end_Y  = anchorPane.getHeight() * menu_related_Pos[3];
        setMenu_Btn(menu_init_X,menu_end_X,menu_init_Y,menu_end_Y);
    }

    //---------//
    // Setters //
    //---------//
    public void init_Pane(){
        for(Still_Button b : list_of_Buttons){
            if(!anchorPane.getChildren().contains(b))
                anchorPane.getChildren().add(b);
        }
        is_init=true;
    }
    public void setAnchorPane(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
        update();
    }
    private void set_related_Spacing(double re_spacing){
        this.re_spacing = re_spacing;
    }
    public void setManu_Position(double menu_left_related, double menu_right_related, double menu_top_related, double menu_bottom_related, double spacing){
        this.menu_related_Pos[0]=menu_left_related;
        this.menu_related_Pos[1]=menu_right_related;
        this.menu_related_Pos[2]=menu_top_related;
        this.menu_related_Pos[3]=menu_bottom_related;
        this.re_spacing = spacing;
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
            //---------------------//
            // Not implemented yet //
            //---------------------//
            return;
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
            System.out.printf("Button[%s] at Method remove_Button not found\n",name);
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
    public void add_Button(List<String> names){
        for(String s : names){
            add_Button(s);
        }
    }
}
