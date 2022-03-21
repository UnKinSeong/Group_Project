package com.ststjl_project.views.stages;

import com.ststjl_project.views.buttoms.Still_Button;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Option_Stage extends State_Machine{
    private Button btn;
    public Option_Stage(Stage stage, AnchorPane anchorPane, Scene scene) {
        super(stage, anchorPane, scene);
    }

    @Override
    public void enter_NextState(int id) {
        if(id == 0){
            current.clean_Up();
            current = State_Machine.menu;
            current.getStage().setTitle("This is the Credit");
            getStage().setScene(current.getScene());
            current.init();
        }
    }

    @Override
    public void update_State(int id) {

    }

    @Override
    protected void clean_Up() {
        getPane().getChildren().remove(btn);
    }

    @Override
    public void init() {
        btn = new Button();
        btn.setText("Exit");
        btn.setOnAction(actionEvent -> {
            enter_NextState(0);
        });
        getPane().getChildren().add(btn);
        super.setTitle("This is the Option");
    }
}
