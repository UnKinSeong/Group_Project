package com.ststjl_project.views.stages;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public abstract class State_Machine {
    public static State_Machine current, menu,game,score,option,credit;
    public static int id[] = {0,1,2,3,4,5};

    private AnchorPane mainPane;
    private Scene mainScene;
    private Stage mainStage;
    public State_Machine(Stage stage,AnchorPane anchorPane, Scene scene){
        this.mainPane = anchorPane;
        this.mainStage = stage;
        this.mainScene = scene;
    }

    public void setTitle(String title){
        mainStage.setTitle(title);
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
    public void showUp() {
        getStage().setScene(current.getScene());
        getStage().show();
    }

    protected abstract void clean_Up();

    public abstract void init();
}
