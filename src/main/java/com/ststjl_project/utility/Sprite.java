package com.ststjl_project.utility;

import com.ststjl_project.views.stages.Stage_SM;
import javafx.scene.image.Image;
import javafx.scene.shape.Shape;


public class Sprite {
    public Vector2D position;
    public Vector2D velocity;
    public double rotation;
    private Shape boundary;
    private Image image;
    private boolean is_Displayed = false;
    public Sprite(){
        position = new Vector2D();
        velocity = new Vector2D();
        rotation = 0;
    }
    public Sprite(String ImageFileName){
        this();
        setImage(ImageFileName);
    }
    public void setSprite(Shape rectangle){
        boundary = rectangle;
    }
    public Shape getSprite(){
        return boundary;
    }
    public Shape getBoundary() {
        return boundary;
    }
    public void setImage(String ImageFileName){
        image = new Image(ImageFileName);
        boundary.resize(image.getWidth(),image.getHeight());
    }
    public boolean update(double deltaTime){
        position.add(velocity.x * deltaTime, velocity.y * deltaTime);
        render();

        return true;
    }
    public void destory(){
        Stage_SM.getState("current").getPane().getChildren().remove(boundary);
        is_Displayed=false;
    }
    public void setPosition(double x, double y){
        position.x = x;
        position.y = y;
    }

    public void render(){
        if(!is_Displayed){
            Stage_SM.getState("current").getPane().getChildren().add(boundary);
            is_Displayed=true;
        }
        boundary.setLayoutX(position.x);
        boundary.setLayoutY(position.y);
        boundary.setRotate(rotation);

    }

}
