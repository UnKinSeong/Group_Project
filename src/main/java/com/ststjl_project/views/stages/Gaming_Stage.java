package com.ststjl_project.views.stages;

import com.ststjl_project.utility.Sprite;
import com.ststjl_project.views.Game_Logic.Player.Player_interface;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Gaming_Stage extends Stage_SM {
    private Button btn;
    private Player_interface playerInterface;
    private List<Rectangle> rectangles = new ArrayList<>();

    Timeline game_loop = new Timeline(new KeyFrame(Duration.millis(1), actionEvent -> {
        double pane_Width = getPane().getWidth();
        double pane_Height = getPane().getHeight();
        getCanvas().setWidth(pane_Width);
        getCanvas().setHeight(pane_Height);

        // manual cleanup background //
        getGC().setFill(Color.WHITE);
        playerInterface.Draw_Yourself();



    }));
    public Gaming_Stage() {

    }

    @Override
    public void enter_NextState(int id) {
        if(id == 0){
            clean_Up();
            setState("menu");
            getState("current").getStage().setScene(getScene());
            getState("current").init();
        }
    }


    @Override
    public void clean_Up() {
        game_loop.stop();
        getPane().getChildren().remove(btn);
        getGC().setFill(Color.WHITE);
        getGC().fillRect(0,0, getPane().getWidth(), getPane().getHeight());
    }

    @Override
    public void init() {
        btn = new Button();
        btn.setText("Exit");
        btn.setOnAction(actionEvent -> {
            enter_NextState(0);
        });
        getPane().getChildren().add(btn);
        game_loop.setCycleCount(Animation.INDEFINITE);
        game_loop.play();
        getStage().setTitle("This is the Gaming");
        playerInterface = new Player_interface(getGC(),getPane());
    }
}
