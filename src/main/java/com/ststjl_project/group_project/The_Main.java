package com.ststjl_project.group_project;

import com.ststjl_project.views.stages.*;
import javafx.application.Application;
import javafx.scene.Scene;
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
    }
    private void init_Stage_SM(Stage stage){
        //--------------------------------------//
        // Construct stage of the State machine //
        //--------------------------------------//
        Stage_SM.mainPane = new AnchorPane();
        Stage_SM.mainScene = new Scene(Stage_SM.mainPane);
        Stage_SM.mainStage = stage;
        Stage_SM.mainStage.setScene(Stage_SM.mainScene);

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