package com.ststjl_project.views.stages;

import javafx.scene.control.Button;

public class Credit_Stage extends Stage_SM {

    private Button btn;

    public Credit_Stage() {

    }

    @Override
    public void enter_NextState(int id) {
        if(id == 1){
            clean_Up();
            setState("menu");
            getStage().setScene(getScene());
            getState("current").init();
        }
    }

    @Override
    public void clean_Up() {
        getPane().getChildren().remove(btn);
    }

    @Override
    public void init() {
        btn = new Button();
        btn.setText("Exit");
        btn.setOnAction(actionEvent -> enter_NextState(1));
        getPane().getChildren().add(btn);
        getStage().setTitle("This is the Credit");
    }
}
