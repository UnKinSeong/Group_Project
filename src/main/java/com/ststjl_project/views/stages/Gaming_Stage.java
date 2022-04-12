package com.ststjl_project.views.stages;

import com.ststjl_project.utility.Audio_Codex;
import com.ststjl_project.views.stages.Player_Panes.sub_Pane.PlayerScene;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class Gaming_Stage extends _Stage_SM {
    private Button btn;
    private PlayerScene playerInterface;
    private final List<Rectangle> rectangles = new ArrayList<>();
    private int frames = 0;
    private Timeline game_loop = new Timeline(new KeyFrame(Duration.millis(1), actionEvent -> {
        double pane_Width = getPane().getWidth();
        double pane_Height = getPane().getHeight();
        frames++;
        if(frames>=1000){
            if(!Audio_Codex.is_Playing("epic_battle_music_1-6275.mp3")){
                Audio_Codex.play("epic_battle_music_1-6275.mp3");
            }
            frames=0;
        }
        btn.setLayoutX(0);
        btn.setLayoutY(pane_Height-btn.getHeight());
        // manual cleanup background //
        playerInterface.Draw_Yourself();


    }));
    public Gaming_Stage() {

    }

    @Override
    public void enter_NextState(int id) {
        if(id == 0){
            clean_Up();
            setState("menu");
            getStage().setScene(getScene());
            getState("current").init();
        }
    }


    @Override
    public void clean_Up() {
        game_loop.stop();
        Audio_Codex.stop("epic_battle_music_1-6275.mp3");
        getPane().getChildren().remove(btn);
        playerInterface.clean_Up();
    }

    @Override
    public void init() {
        game_loop.setCycleCount(Animation.INDEFINITE);
        playerInterface = new PlayerScene(getPane());
        playerInterface.Init();

        btn = new Button();
        btn.setText("Exit");
        btn.setOnAction(actionEvent -> enter_NextState(0));
        getPane().getChildren().add(btn);

        getStage().setTitle("This is the Gaming");
        game_loop.play();
    }


}
