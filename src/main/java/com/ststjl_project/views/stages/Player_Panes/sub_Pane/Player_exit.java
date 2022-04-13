package com.ststjl_project.views.stages.Player_Panes.sub_Pane;

import com.ststjl_project.utility.Audio_Codex;
import com.ststjl_project.views.stages._Stage_SM;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.NotActiveException;

import static com.ststjl_project.utility.Positioners.*;

public class Player_exit {
    Player_exit(Pane mainPane){
        this.mainPane = mainPane;
    }
    private void init(){
        is_init = true;
        Exit_Button = new Button("Exit to Menu");
        No_Exit_Button = new Button("Not Yet");
        Exit_Button.setOnAction(actionEvent -> {
            confirm_exit=true;
            show = false;
            this.self_destroy();
        });

        No_Exit_Button.setOnAction(actionEvent -> {
            show = false;
            this.self_destroy();
            Audio_Codex.play("Fire_Card_Failed.mp3");
        });
        mainPane.getChildren().addAll(Exit_Button,No_Exit_Button);
    }
    public void showUp(){
        show=true;
    }
    public boolean is_Show(){
        return show;
    }
    public boolean isConfirm_exit(){
        return confirm_exit;
    }
    public void update(){
        if(show){
            if(!is_init)
                init();
            double layX = mainPane.getLayoutX();
            double layY = mainPane.getLayoutY();
            double width = mainPane.getWidth();
            double height = mainPane.getHeight();

            Exit_Button.setLayoutX(layX);
            Exit_Button.setLayoutY(layY);
            Exit_Button.setPrefWidth(width/2);
            Exit_Button.setPrefHeight(height/2);

            No_Exit_Button.setLayoutX(layX+width/2);
            No_Exit_Button.setLayoutY(layY+height/2);
            No_Exit_Button.setPrefWidth(width/2);
            No_Exit_Button.setPrefHeight(height/2);
        }
        else{
        }
    }
    public void self_destroy(){
        try {
            mainPane.getChildren().removeAll(Exit_Button,No_Exit_Button);
            is_init=false;
        }catch (Exception e){
            System.out.println("In control");
        }

    }
    private boolean is_init = false;
    private boolean confirm_exit = false;
    private boolean show = false;
    private Pane mainPane;
    private Button Exit_Button;
    private Button No_Exit_Button;
}
