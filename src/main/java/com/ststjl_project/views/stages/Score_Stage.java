package com.ststjl_project.views.stages;

import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Score_Stage extends _Stage_SM {

    @FXML
    private Text Player_Text;

    @FXML
    private VBox Player_VBox;

    @FXML
    private Text Score_Text;

    @FXML
    private VBox Score_VBox;


    private Button btn;

    public Score_Stage(boolean is_fxml) {
        super.setFXML();
    }

    @Override
    public void enter_NextState(int id) {
        if(id == 0){
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
        btn.setOnAction(actionEvent -> {
            enter_NextState(0);
        });
        getPane().getChildren().add(btn);
        getStage().setTitle("This is the Score");
    }

}
