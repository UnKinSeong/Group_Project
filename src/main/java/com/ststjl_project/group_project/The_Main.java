package com.ststjl_project.group_project;

import com.ststjl_project.views.stages.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCharacterCombination;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class The_Main extends Application {
    private double width = 800;
    private double height = 460;
    @Override
    public void start(Stage stage) throws Exception {
        //--------------------------------------------------//
        // Call init_Stage_SM to Declare the state variable //
        //--------------------------------------------------//
        init_Stage_SM(stage);

        //----------------//
        // Show the Stage //
        //----------------//
        Stage_SM.current.getStage().setFullScreenExitHint("");
        Stage_SM.current.showUp();
        Stage_SM.current.getStage().setFullScreen(true);
        Stage_SM.current.getStage().addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            if(new KeyCodeCombination(KeyCode.F11).match(event)) {
                stage.setFullScreen(!stage.isFullScreen());
            }
        });
    }
    private void init_Stage_SM(Stage stage){
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
    }
    public static void main(String[] args) {
        launch(args);
    }
}