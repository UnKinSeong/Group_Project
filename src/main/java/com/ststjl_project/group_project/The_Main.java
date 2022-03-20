package com.ststjl_project.group_project;

import com.ststjl_project.views.stages.Menu_Stage;
import com.ststjl_project.views.stages.Stage_Generator;
import javafx.application.Application;
import javafx.stage.Stage;

public class The_Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Stage_Generator manager = new Menu_Stage(795.3,461.5);
        stage = manager.getStage();
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}