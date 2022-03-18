package com.ststjl_project.controllers;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Main_Screen implements Initializable {
    @FXML
    public Button btn_start;
    @FXML
    public Button btn_option;
    @FXML
    public Button btn_exit;
    @FXML
    public Circle circle;
    @FXML
    public AnchorPane scene;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
