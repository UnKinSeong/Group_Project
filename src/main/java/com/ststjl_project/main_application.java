package com.ststjl_project;


import com.ststjl_project.Controller.Controller_SM;
import com.ststjl_project.Controller.Game_Controller;
import com.ststjl_project.Controller.Menu_Controller;
import com.ststjl_project.Controller.Score_Controller;
import com.ststjl_project.Model.Card.Card_Container;
import com.ststjl_project.Model.Player;
import com.ststjl_project.Model.Player_Database;
import com.ststjl_project.Utility.Audio_Codex;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class main_application extends Application {
    private static Stage mainStage;
    public static Stage getStage(){
        return mainStage;
    }
    @Override
    public void start(Stage stage) throws IOException, ClassNotFoundException {
        String audios[] = {
                "/Music/Card_Base_Audio_Effects",
                "/Music/Game_Stage_Audio/",
                "/Music/Menu_Music/",
                "/Music/Battle_Music/",
                "/Music/Score_Music/"
        };
        initAudio(audios[0]);
        initAudio(audios[1]);
        Card_Container.init_card_Pool(50);
        Controller_SM.setPane(new Pane());
        Controller_SM.setScene(new Scene(Controller_SM.getPane(),710,400));
        Controller_SM.setStage(stage);
        Controller_SM.getStage().setScene(Controller_SM.getScene());



        Controller_SM.addState("Menu",new Menu_Controller());
        Controller_SM.addState("Game",new Game_Controller());
        Controller_SM.addState("Score",new Score_Controller());
        Controller_SM.setState("Menu");

        Controller_SM.getState("Menu").setAudios(initAudio(audios[2]));
        Controller_SM.getState("Game").setAudios(initAudio(audios[3]));
        Controller_SM.getState("Score").setAudios(initAudio(audios[4]));


        Controller_SM.getState("current").init();
        Controller_SM.getStage().show();
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
                    audio_file_name.add(file.getName());
                }
            }
        }
        if(audio_file_name.size()>0){
            return audio_file_name;
        }else{
            return null;
        }
    }
    private void initStage(){

    }

    public static void main(String[] args) {
        launch();
    }
}
