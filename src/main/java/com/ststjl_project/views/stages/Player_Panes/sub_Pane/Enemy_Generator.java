package com.ststjl_project.views.stages.Player_Panes.sub_Pane;

import com.ststjl_project.utility.Random_Number;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

public class Enemy_Generator{
    public Enemy_Generator(Pane mainPane){
        this.mainPane = mainPane;
    }
    public ImageView getEnemy(){
        File[] enemy_array;
        URL url;
        File Enemy_Image_Assert;
        enemy_array = null;
        url = getClass().getResource("/Images/Enemy/");
        Enemy_Image_Assert = null;
        if(url != null) {
            Enemy_Image_Assert = new File(url.getPath());
            enemy_array = Enemy_Image_Assert.listFiles();
            if (enemy_array != null) {
                File choOne;
                choOne = enemy_array[new Random().nextInt(enemy_array.length)];
                enemyName = choOne.getName().substring(0,choOne.getName().length()-4);
                return new ImageView(choOne.toURI().toString());
            }
        }
        return null;
    }
    public void update(double width, double height){
        if(Enemy_Image_View!=null) {
            Enemy_Image_View.setLayoutX(0);
            Enemy_Image_View.setLayoutY(0);
            Enemy_Image_View.setFitWidth(width);
            Enemy_Image_View.setFitHeight(height);
        }
    }
    public boolean isEnemy_Exist(){
        return Enemy_Image_View!=null&&health>1;
    }

    public void newEnemy(){
        if(Enemy_Image_View!=null){
            mainPane.getChildren().remove(Enemy_Image_View);
        }
        Enemy_Image_View = getEnemy();
        if(Enemy_Image_View!=null) {
            mainPane.getChildren().add(Enemy_Image_View);
            health = Random_Number.randInt(5,10);
            damage = Random_Number.randInt(1,5);
            bonus = Random_Number.randInt(1,5);
        }
    }
    public double attack(){
        return damage;
    }
    public void getDamage(double rdamage){
        health -= rdamage;
    }
    public void CleanUp(){
        if(Enemy_Image_View!=null)
            mainPane.getChildren().remove(Enemy_Image_View);
    }
    public double damage(){
        return damage;
    }
    private String enemyName="Undefine";
    private double damage;
    private double health=0;
    private double bonus=0;
    private ImageView Enemy_Image_View;
    private Pane mainPane;

    public String getName() {
        return enemyName;
    }

    public double getHealth() {
        return health;
    }
}
