package com.ststjl_project.View;

import com.ststjl_project.Utility.Font_Scale_Rectangle;
import com.ststjl_project.Utility.Obj_Positions;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class Text_List_View {
    //--------------------------------------------------//
    // The reference to the anchorPane that targeted to //
    //--------------------------------------------------//
    private final Pane mainPane;

    //------------------------------------//
    // Related position to the AnchorPane //
    //------------------------------------//
    private double[] text_Related_Pos = new double[4];

    //-------------------------------//
    // Related spacing in AnchorPane //
    //-------------------------------//
    private double re_spacing = 0;

    //-----------------------------------------------------------------//
    //   Text List and Text name to id the index for later operation   // But why not map? -- quote by someone.
    //-----------------------------------------------------------------//
    private final List<Text> list_of_Text = new ArrayList<>();


    //----------------------------//
    // The state of the TextField //
    //----------------------------//
    private boolean is_init = false;

    //-------------//
    // Constructor //
    //-------------//
    public Text_List_View(Pane mainPane){
        this.mainPane =mainPane;
    }

    //----------------------------------------------//
    // Update is responsible for game loop resizing //
    //----------------------------------------------//
    public void update(){
        if(!is_init){
            init_Pane();
        }
        // Calculate the actual locations of the texts //
        double [] pos_ = Obj_Positions.Relative_Pos_TPos(mainPane.getWidth(), mainPane.getHeight(), text_Related_Pos);
        setTextPane(pos_[0],pos_[1],pos_[2],pos_[3]);
    }

    //---------//
    // Setters //
    //---------//
    public void init_Pane(){
        // Just add the button to the anchorPane //
        for(Text b : list_of_Text){
            if(!mainPane.getChildren().contains(b)) {
                mainPane.getChildren().add(b);
                b.setFont(Font.font("arial", 1));
            }
        }
        System.out.println("Init");
        is_init=true;
    }

    public void setTextPane_Position(double[] menu_related_Pos, double spacing){
        this.text_Related_Pos = menu_related_Pos;
        this.re_spacing = spacing;
    }


    public void setTextPane(double init_x, double init_y, double end_x, double end_y){
        double total_height  = Math.abs(init_y - end_y);
        double total_spacing = total_height*re_spacing;

        double button_total_height = total_height-total_spacing;
        double each_button_height  = button_total_height/ list_of_Text.size();
        double each_spacing_height = total_spacing/(list_of_Text.size()-1);

        double each_button_width = Math.abs(init_x-end_x)*0.94;

        for(Text b : list_of_Text){
            b.prefWidth(each_button_width);
            b.minWidth(each_button_width);
            b.maxWidth(each_button_width);
            b.prefWidth(each_button_height);
            b.maxHeight(each_button_height);
            b.minHeight(each_button_height);
            Font_Scale_Rectangle.scaleTextToFit_Rect(b,each_button_width,each_button_height);
        }
        double beginY = init_y+each_button_height;
        for (Text text : list_of_Text) {
            text.setLayoutX(init_x + each_button_width * 0.04);
            text.setLayoutY(beginY - each_button_height * 0.1);
            beginY += each_button_height + each_spacing_height;
        }
    }
    public void CleanUp(){
        mainPane.getChildren().removeAll(list_of_Text);
        list_of_Text.clear();
        System.out.println("Remove");
        is_init=false;
    }

    public void add_Text(String name){
        Text t_btn = new Text();
        t_btn.setText(name);
        list_of_Text.add(t_btn);
        is_init=false;
    }
}
