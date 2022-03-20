package com.ststjl_project.group_project;

import com.ststjl_project.views.stages.Credit_Stage;
import com.ststjl_project.views.stages.Menu_Stage;
import com.ststjl_project.views.stages.State_Machine;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class The_Main extends Application {
    private double width = 800;
    private double height = 460;
    @Override
    public void start(Stage stage) throws Exception {

        AnchorPane anchorPane = new AnchorPane();
        Scene scene = new Scene(anchorPane);
        stage.setScene(scene);
        stage.setTitle("This is the Title");

        State_Machine.menu = new Menu_Stage(stage,anchorPane,scene);
        State_Machine.credit = new Credit_Stage(stage,anchorPane,scene);
        State_Machine.current = State_Machine.menu;
        State_Machine.current.init();
        State_Machine.current.showUp();
        State_Machine.current.getStage().setFullScreen(true);
    }

    public static void main(String[] args) {
        launch(args);
    }
}