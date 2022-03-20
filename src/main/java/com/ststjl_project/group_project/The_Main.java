package com.ststjl_project.group_project;

import com.ststjl_project.views.stages.Credit_Stage;
import com.ststjl_project.views.stages.Menu_Stage;
import com.ststjl_project.views.stages.Stage_Generator;
import javafx.application.Application;
import javafx.stage.Stage;

public class The_Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        double width = 800;
        double height = 460;
        Stage_Generator.menu = new Menu_Stage(width,height);
        Stage_Generator.credit = new Credit_Stage(width,height);
        Stage_Generator.current = Stage_Generator.menu;
        Stage_Generator.current.setStage(stage);
        Stage_Generator.current.showUp();
    }

    public static void main(String[] args) {
        launch(args);
    }
}