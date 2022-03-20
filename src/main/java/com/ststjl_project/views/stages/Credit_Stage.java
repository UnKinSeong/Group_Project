package com.ststjl_project.views.stages;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Credit_Stage extends Stage_Generator{

    public Credit_Stage(double SCENE_WIDTH, double SCENE_HEIGHT) {
        super(SCENE_WIDTH, SCENE_HEIGHT);
        Button btn = new Button();
        btn.setText("Exit");
        btn.setOnAction(actionEvent -> {
            enter_NextState(1);
        });
        getPane().getChildren().add(btn);

    }

    @Override
    public void enter_NextState(int id) {
        if(id == 1){
            Scene credit_scene = Stage_Generator.menu.getScene();
            Stage currentStage = current.getStage();
            currentStage.setScene(credit_scene);

            current = Stage_Generator.credit;
            current.setStage(currentStage);
        }
    }

    @Override
    public void update_State(int id) {

    }

    @Override
    public void showUp() {

    }

    @Override
    public void cleanup() {

    }
}
