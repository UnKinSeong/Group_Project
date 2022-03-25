package com.ststjl_project.views.stages;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public abstract class Stage_SM {
    //-------------------------------------//
    // Static Stage_Sm(s) for finite state //
    //-------------------------------------//
    public static Stage_SM current, menu,game,score,option,credit;

    //---------------------------//
    // Static Variable for Stage //
    //---------------------------//
    private static AnchorPane mainPane;
    private static Scene mainScene;
    private static Stage mainStage;

    //--------------------------//
    // Constructor for Stage_SM //
    //--------------------------//
    public Stage_SM(){}
    public Stage_SM(Stage stage, AnchorPane anchorPane, Scene scene){
        this.mainPane = anchorPane;
        this.mainStage = stage;
        this.mainScene = scene;
    }

    //---------------------------//
    //   make a separator init   //
    // AKA manual Re-constructor //
    //---------------------------//
    public abstract void init();

    //---------//
    // Setters //
    //---------//
    public void setTitle(String title){
        this.mainStage.setTitle(title);
    }
    public void setPane(AnchorPane mainPane) {
        this.mainPane = mainPane;
    }
    public void setScene(Scene mainScene) {
        this.mainScene = mainScene;
    }
    public void setStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

    //---------//
    // Getters //
    //---------//
    public double get_Pane_WIDTH() {
        return this.mainPane.getWidth();
    }
    public double get_Pane_HEIGHT() {
        return this.mainPane.getHeight();
    }
    public AnchorPane getPane() {
        return this.mainPane;
    }
    public Scene getScene() {
        return this.mainScene;
    }
    public Stage getStage() {
        return this.mainStage;
    };


    //------------------------------------------------------//
    // State Switcher                                       //
    // All declaration must follow the Cleanup before Enter //
    //     AKA the manual trigger to Garbage collection     //
    //------------------------------------------------------//
    protected abstract void clean_Up();
    public abstract void enter_NextState(int id);

    //----------------//
    // Show the State //
    //----------------//
    public void showUp() {
        this.getStage().setScene(current.getScene());
        this.getStage().show();
    }


}
