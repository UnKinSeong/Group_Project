package com.ststjl_project.group_project;

import com.ststjl_project.Cards.Blood_Card;
import com.ststjl_project.Cards.Bone_Card;
import com.ststjl_project.Cards.Card_Container;
import com.ststjl_project.Cards.Energy_Card;
import com.ststjl_project.views.stages.*;
import eu.hansolo.tilesfx.Demo;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

public class The_Main extends Application {
    private final double width = 800;
    private final double height = 460;
    @Override
    public void start(Stage stage) {
        //--------------------------------------------------//
        // Call init_Stage_SM to Declare the state variable //
        //--------------------------------------------------//

        for(int i=0;i<20;i++){
            Card_Container.addCards(i*3, new Blood_Card("dummy card"+i,1,1,0));
            Card_Container.addCards(i*3+1, new Bone_Card("dummy card"+i,1,1,0));
            Card_Container.addCards(i*3+2, new Energy_Card("dummy card"+i,1,1,0));
        }





        /*private MediaPlayer mediaPlayer;
        private void play(){
            URL url = getClass().getResource("/Music/down.mp3");
            if(url!=null){
                mediaPlayer = new MediaPlayer(new Media(new File(url.getPath()).toURI().toString()));
                mediaPlayer.play();
            }
        }*/
        Stage_SM.setCanvas(new Canvas(710,400));
        Stage_SM.initGraphicsContext();
        Stage_SM.setPane(new Pane(Stage_SM.getCanvas()));
        Stage_SM.setScene(new Scene(Stage_SM.getPane()));
        Stage_SM.setStage(stage);
        Stage_SM.getStage().setScene(Stage_SM.getScene());

        Stage_SM.addState("game",new Gaming_Stage());
        Stage_SM.addState("score",new Score_Stage());
        Stage_SM.addState("option",new Option_Stage());
        Stage_SM.addState("credit",new Credit_Stage());
        Stage_SM.addState("menu",new Menu_Stage());
        Stage_SM.addState("demo",new Demo_Stage());
        Stage_SM.addState("current",Stage_SM.getState("game"));
        //----------------//
        // Show the Stage //
        //----------------//


        Stage_SM.getState("current").init();
        Stage_SM.getStage().setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        Stage_SM.getStage().setFullScreenExitHint("");
        Stage_SM.getStage().show();
        Stage_SM.getStage().setFullScreen(false);
        Stage_SM.getStage().addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            if(new KeyCodeCombination(KeyCode.F11).match(event)) {
                stage.setFullScreen(!stage.isFullScreen());
            }
        });
    }
/*    private void init_Stage_SM(Stage stage){
        //--------------------------------------//
        // Construct stage of the State machine //
        //--------------------------------------//
        Stage_SM.current = new Menu_Stage();
        Stage_SM.current.setPane(new AnchorPane());
        Stage_SM.current.setScene(new Scene(Stage_SM.current.getPane(),710,400));
        Stage_SM.current.setStage(stage);
        Stage_SM.current.setScene(Stage_SM.current.getScene());

        //--------------------------------------------------------//
        //           Assign each state to Stage machine           //
        //--------------------------------------------------------//
        // State [ menu | credit | option | game | score | current ]
        //--------------------------------------------------------//
        Stage_SM.menu = new Menu_Stage();
        Stage_SM.credit = new Credit_Stage();
        Stage_SM.option = new Option_Stage();
        Stage_SM.game = new Gaming_Stage();
        Stage_SM.score = new Score_Stage();

        //-----------------------------------//
        // initialization of the entry stage //
        //-----------------------------------//
        
        Stage_SM.current = Stage_SM.menu;
        Stage_SM.current.init();
    }*/
    public static void main(String[] args) {
        launch(args);
    }
}