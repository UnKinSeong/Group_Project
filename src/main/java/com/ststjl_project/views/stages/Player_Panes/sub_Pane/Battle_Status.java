package com.ststjl_project.views.stages.Player_Panes.sub_Pane;

import com.ststjl_project.views.stages.Stage_SM;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Battle_Status extends _Status_Pane {
    @Override
    public void Init(double[] Related_pos) {
        super.setRelated_pos(Related_pos);
        Battle_Box = new Rectangle();
        this.getChildren().add(Battle_Box);
        eventHandler = keyEvent -> {
            if(new KeyCodeCombination(KeyCode.ESCAPE).match(keyEvent)) {
                Stage_SM.getState("current").enter_NextState(0);
            }
        };
        mainPane.addEventHandler(KeyEvent.KEY_PRESSED,eventHandler);
    }

    @Override
    public void reDraw() {
        reSizing();
        double Stroke_Width = 0.025*getHeight();
        Paint Stroke_Paint = Paint.valueOf("black");
        Battle_Box.setLayoutX(0+Stroke_Width);
        Battle_Box.setLayoutY(0+Stroke_Width);
        Battle_Box.setWidth(getWidth()-Stroke_Width*2);
        Battle_Box.setHeight(getHeight()-Stroke_Width*2);
        Battle_Box.setFill(Color.WHITE);
        Battle_Box.setStrokeWidth(Stroke_Width);
        Battle_Box.setStroke(Stroke_Paint);
    }

    @Override
    public void CleanUp() {

        getChildren().remove(Battle_Box);
        mainPane.removeEventHandler(KeyEvent.KEY_PRESSED,eventHandler);
    }

    @Override
    public void updateData(double[] data) {

    }

    private Rectangle Battle_Box;
    private EventHandler<KeyEvent> eventHandler;
}
