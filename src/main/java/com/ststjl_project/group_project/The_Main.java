package com.ststjl_project.group_project;

import com.ststjl_project.Cards.*;
import com.ststjl_project.utility.Audio_Codex;
import com.ststjl_project.utility.Random_Number;
import com.ststjl_project.views.stages.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

public class The_Main extends Application {
    private final double width = 800;
    private final double height = 460;
    @Override
    public void start(Stage stage) {
        //--------------------------------------------------//
        // Call init_Stage_SM to Declare the state variable //
        //--------------------------------------------------//

        int CardPool = 60;

        int first_ = 0;
        int second_ = 0;

        int Blood_Card_Count = Random_Number.randInt(10,20);
        int Bone_Card_Count = Random_Number.randInt(Blood_Card_Count,20);
        int Basic_Card_Count = CardPool - Blood_Card_Count-Bone_Card_Count;


        System.out.println("First : "+first_+" Second : "+second_ );

        System.out.println("Blood Card Count : "+Blood_Card_Count);
        System.out.println("Bone Card Count : "+Bone_Card_Count);
        System.out.println("Basic Card Count : "+Basic_Card_Count);

        String []Blood_Card_Names = {
                "grizzly bear","lizard",
                "chinchilla","crow",
                "weasel", "highland cow","hammer",
        };

        String []Bone_Card_Names = {
                "skeleton", "zombie",
                "wolverine", "Tortoise",
                "Giraffes","Tortoise"
        };
        String []Basic_Card_Names = {
                "computer", "terminator",
                "mouse", "keyboard",
                "hard drive","clock"
        };


        double damage;
        double criticalChance;
        double self_damage;

        Random random_gener;
        int randomNumber;

        for(int i=0;i<Blood_Card_Count;i++){
            random_gener=new Random();
            damage = Random_Number.randInt(2,5);
            criticalChance = Random_Number.randDouble(10,50)/100;
            self_damage = Random_Number.randInt(0,5);
            randomNumber=random_gener.nextInt(Blood_Card_Names.length);
            Card_Container.addCards(i,new Blood_Card(Blood_Card_Names[randomNumber],damage,criticalChance,self_damage));
        }

        for(int i=Blood_Card_Count;i<Bone_Card_Count+Blood_Card_Count;i++){
            random_gener=new Random();
            damage = Random_Number.randInt(1,4);
            criticalChance = Random_Number.randDouble(30,70)/100;
            self_damage = Random_Number.randInt(0,10);
            randomNumber=random_gener.nextInt(Bone_Card_Names.length);
            Card_Container.addCards(i,new Bone_Card(Bone_Card_Names[randomNumber],damage,criticalChance,self_damage));
        }

        for(int i=Blood_Card_Count+Bone_Card_Count;i<Bone_Card_Count+Blood_Card_Count+Basic_Card_Count;i++){
            random_gener=new Random();
            damage = Random_Number.randInt(3,7);
            criticalChance = Random_Number.randDouble(0,50)/100;
            self_damage = Random_Number.randInt(0,2);
            randomNumber=random_gener.nextInt(Basic_Card_Names.length);
            Card_Container.addCards(i,new Basic_Card(Basic_Card_Names[randomNumber],damage,criticalChance,self_damage));
        }



        ArrayList<String> Temp;
        Temp = initAudio("/Music/In_Game_Audio_Effects");
        if(Temp!=null) {
            Card_Base.setAudioList(Temp);
        }


        _Stage_SM.setPane(new Pane());
        _Stage_SM.setScene(new Scene(_Stage_SM.getPane(),710,400));
        _Stage_SM.setStage(stage);
        _Stage_SM.getStage().setScene(_Stage_SM.getScene());

        _Stage_SM.addState("game",new Gaming_Stage());
        _Stage_SM.addState("score",new Score_Stage());
        _Stage_SM.addState("option",new Option_Stage());
        _Stage_SM.addState("credit",new Credit_Stage());
        _Stage_SM.addState("menu",new Menu_Stage());
        _Stage_SM.addState("demo",new Demo_Stage());
        _Stage_SM.addState("current", _Stage_SM.getState("game"));

        Temp = initAudio("/Music/Menu_Music/");
        if(Temp!=null){
            _Stage_SM.getState("game").setAudioList(Temp);
        }
        Temp = initAudio("/Music/Battle_Music/");
        if(Temp!=null){
            _Stage_SM.getState("menu").setAudioList(Temp);
        }
        //----------------//
        // Show the Stage //
        //----------------//


        _Stage_SM.getState("current").init();
        _Stage_SM.getStage().setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        _Stage_SM.getStage().setFullScreenExitHint("");
        _Stage_SM.getStage().show();
        _Stage_SM.getStage().setFullScreen(false);
        _Stage_SM.getStage().addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            if(new KeyCodeCombination(KeyCode.F11).match(event)) {
                stage.setFullScreen(!stage.isFullScreen());
            }
        });
    }
    private ArrayList<String> initAudio(String path_to_location){
        ArrayList<String> audio_file_name = new ArrayList();
        File[] songArray;
        URL url;
        File Menu_Music_Asserts_Directory;
        songArray = null;
        url = getClass().getResource(path_to_location);
        Menu_Music_Asserts_Directory = null;
        if(url != null) {
            Menu_Music_Asserts_Directory = new File(url.getPath());
            songArray = Menu_Music_Asserts_Directory.listFiles();
            if (songArray != null) {
                for(File file : songArray){
                    Audio_Codex.add(file.getName(),file.toURI());
                    audio_file_name.add(file.toString());
                }
            }
        }
        if(audio_file_name.size()>0){
            return audio_file_name;
        }else{
            return null;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}