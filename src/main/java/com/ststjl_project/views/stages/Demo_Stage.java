package com.ststjl_project.views.stages;

import javafx.scene.control.Button;

public class Demo_Stage extends Stage_SM{
    private Button btn;
    @Override
    public void enter_NextState(int id) {
        switch (id){
            case 0:{
            clean_Up();
            setState("menu");
            getStage().setScene(getScene());
            getState("current").init();
            }break;
        }
    }

    @Override
    public void clean_Up() {

    }

    @Override
    public void init() {
        btn = new Button();
        btn.setText("Exit");
        btn.setOnAction(actionEvent -> enter_NextState(0));
        getPane().getChildren().add(btn);

        getStage().setTitle("This is the Gaming");
    }
}
