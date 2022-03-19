package com.ststjl_project.group_project;

import com.ststjl_project.views.Menu_Stage;
import com.ststjl_project.views.Stage_Generator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class The_Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Stage_Generator manager = new Menu_Stage(800,600);
        stage = manager.getStage();
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}