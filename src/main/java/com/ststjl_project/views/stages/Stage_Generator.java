package com.ststjl_project.views.stages;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Map;
import java.util.Vector;

public abstract class Stage_Generator {
    public static Stage_Generator current, menu,game,score,option,credit;
    public static int id[] = {0,1,2,3,4,5};

    private double SCENE_WIDTH;
    private double SCENE_HEIGHT;
    private AnchorPane mainPane;
    private Scene mainScene;
    private Stage mainStage;

    public Stage_Generator(double SCENE_WIDTH, double SCENE_HEIGHT){
        this.SCENE_HEIGHT=SCENE_HEIGHT;
        this.SCENE_WIDTH=SCENE_WIDTH;
        mainPane = new AnchorPane();
        mainScene = new Scene(mainPane, SCENE_WIDTH, SCENE_HEIGHT);
        mainStage = new Stage();
        mainStage.setScene(mainScene);
    }

    public void set_WIDTH(double SCENE_WIDTH) {
        this.SCENE_WIDTH = SCENE_WIDTH;
    }
    public void set_HEIGHT(double SCENE_HEIGHT) {
        this.SCENE_HEIGHT = SCENE_HEIGHT;
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

    public double get_WIDTH() {
        return SCENE_WIDTH;
    }
    public double get_HEIGHT() {
        return SCENE_HEIGHT;
    }
    public double get_Pane_WIDTH() {
        return mainPane.getWidth();
    }
    public double get_Pane_HEIGHT() {
        return mainPane.getHeight();
    }
    public AnchorPane getPane() {
        return mainPane;
    }
    public Scene getScene() {
        return mainScene;
    }
    public Stage getStage() {
        return mainStage;
    };

    public abstract void enter_NextState(int id);
    public abstract void update_State(int id);
    public abstract void showUp();
    public abstract void cleanup();

}
