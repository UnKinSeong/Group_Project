package com.ststjl_project.Model;

import java.io.*;
import java.util.ArrayList;

import static com.ststjl_project.Utility.ObjectIO.readObjectFromFile;
import static com.ststjl_project.Utility.ObjectIO.writeObjectToFile;

public class Player_Database {
    private final static String SavePath="PlayerData.dat";
    public static ArrayList<Player> get_Player_History(){
        if(!isDataSecure) {
            try {
                Object object= readObjectFromFile(SavePath);
                if(object!=null)
                    playerList = (ArrayList<Player>) object;
                else {
                    playerList = new ArrayList<>();
                    writeObjectToFile(playerList,SavePath);
                }
            }
            catch (Exception e){
                playerList = new ArrayList<>();
            }
            isDataSecure=true;
        }
        return playerList;
    }
    public static void add_Player(Player player){
        if(!isDataSecure) {
            System.out.println("Read data");
            playerList = get_Player_History();
        }
        if(playerList==null){
            playerList = new ArrayList<>();
            playerList.add(player);
            Save_Data();
            return;
        }
        if(playerList.size()<5){
            for(int i = 0;i<playerList.size();i++){
                if(player.get_Over_Score()> playerList.get(i).get_Over_Score()){
                    playerList.add(i,player);
                    System.out.println("add player data A");
                    writeObjectToFile(playerList,SavePath);
                    return;
                }
            }
            System.out.println("add player data B");
            playerList.add(player);
            writeObjectToFile(playerList,SavePath);
            return;
        }
        double lowest = player.get_Over_Score();
        int lowest_index = 0;
        for(int i = 0;i<playerList.size();i++){
            if(playerList.get(i).get_Over_Score()<=lowest){
                System.out.println("get Lowest player data");
                lowest_index = i;
            }
        }
        System.out.println("remove Lowest player data");
        if(playerList.get(lowest_index).get_Over_Score()<player.get_Over_Score()) {
            playerList.remove(lowest_index);
        }else{
            return;
        }
        for(int i = 0;i<playerList.size();i++){
            if(player.get_Over_Score()> playerList.get(i).get_Over_Score()){
                System.out.println("add player data C");
                playerList.add(i,player);
                writeObjectToFile(playerList,SavePath);
                return;
            }
        }
        System.out.println("add player data D");
        playerList.add(player);
        writeObjectToFile(playerList,SavePath);
    }
    public static boolean is_better(double score){
        if(playerList.size()<5){
            return true;
        }
        double lowest = playerList.get(0).get_Over_Score();
        for(int i = 0; i < playerList.size();i++){
            if(playerList.get(i).get_Over_Score()<=score){
                return true;
            }
        }
        return false;
    };
    public static void Save_Data(){
        writeObjectToFile(playerList,SavePath);
    }

    private static boolean isDataSecure = false;
    private static ArrayList<Player> playerList = new ArrayList<>();
}
