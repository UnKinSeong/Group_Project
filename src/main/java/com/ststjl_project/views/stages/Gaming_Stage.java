package com.ststjl_project.views.stages;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Gaming_Stage extends Stage_SM {
    private Button btn;
    Timeline game_loop = new Timeline(new KeyFrame(Duration.millis(1), actionEvent -> {
        double pane_Width = getPane().getWidth();
        double pane_Height = getPane().getHeight();
        getCanvas().setWidth(pane_Width);
        getCanvas().setHeight(pane_Height);

        // manual cleanup background //
        getGC().setFill(Color.WHITE);
        getGC().fillRect(0,0, pane_Width,pane_Height);


        getGC().setFill(Color.BLACK);
        // Player Status //
        getGC().fillRect(0,0, (pane_Width/3),pane_Height/9);
        // Predication, History, Player attack chances, Pass //
        getGC().fillRect((pane_Width/3)*2,0,pane_Width,pane_Height);

        getGC().setFill(Color.GOLD);
        // Top Middle Bones status //
        getGC().fillRect((pane_Width/3),0,(pane_Width/3),pane_Height/9);

        getGC().setFill(Color.BROWN);
        // Game Scene //
        getGC().fillRect(0,pane_Height/9,(pane_Width/3)*2,pane_Height-pane_Height/9);



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
    }
}
