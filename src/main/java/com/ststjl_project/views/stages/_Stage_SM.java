package com.ststjl_project.views.stages;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public abstract class _Stage_SM {
    private static final Map<String , _Stage_SM> State_SMs = new TreeMap<>();

    public static void addState(String stageN, _Stage_SM stageSm){
        State_SMs.put(stageN,stageSm);
    }
    public static _Stage_SM getState(String stage){
        return State_SMs.get(stage);
    }
    public static boolean setState(String stage){
        _Stage_SM stage_sm_tar = getState(stage);
        if(stage_sm_tar!=null){
            State_SMs.replace("current",stage_sm_tar);
            return true;
        }
        return false;
    }

    public ArrayList<String> getAudioList() {
        return audioList;
    }

    public void setAudioList(ArrayList<String> audioList) {
        this.audioList = audioList;
    }

    private ArrayList<String> audioList = new ArrayList<>();
    private static Stage mainStage;
    private static Scene mainScene;
    private static Pane mainPane;



    public static void setStage(Stage stage) {
        mainStage = stage;
    }
    public static void setScene(Scene scene) {
         mainScene = scene;
    }
    public static void setPane(Pane pane) {
        mainPane = pane;
    }



    public static Stage getStage() {
        return mainStage;
    }
    public static Scene getScene() {
        return mainScene;
    }
    public static Pane getPane() {
        return mainPane;
    }


    public abstract void enter_NextState(int id);

    public abstract void clean_Up();

    public abstract void init();
}
