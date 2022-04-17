package com.ststjl_project.Controller;



import com.ststjl_project.Utility.Audio_Codex;
import com.ststjl_project.View.Menu_View;
import javafx.animation.AnimationTimer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Menu_Controller extends Controller_SM{
    private final Map<Integer,String> Menus = new HashMap<>();
    {
        //"Start","Score",
        //                    "Option","Credit",
        //                    "Exit"
        Menus.put(0,"Start"); // game //
        Menus.put(1,"Score");
        Menus.put(2,"Exit");

    }
    @Override
    public void enter_NextState(int id) {
        clean_Up();
        switch (id){
            case 0->{setState("Game");}
            case 1->{setState("Score");}
            case 2->{System.exit(0);}
        }
        getStage().setScene(getScene());
        getState("current").init();
    }
    @Override
    public void clean_Up() {
        gameLoop.stop();
        menu_view.clean_Up();
        ArrayList<String> audios = getAudios();
        for(String s : audios)
            Audio_Codex.stop(s);
    }
    @Override
    public void init() {
        menu_view = new Menu_View();
        menu_view.init(getPane());
        for(int i = 0; i < Menus.size();i++){
            int temp_i = i;
            menu_view.add_Button(Menus.get(i),()->{enter_NextState(temp_i);});
        }
        gameLoop.start();
    }

    private String currentAudio;
    protected void draw(double v) {
        menu_view.render(v);
    }

    protected void update() {
        menu_view.update(null);
    }
    private Menu_View menu_view;

}
