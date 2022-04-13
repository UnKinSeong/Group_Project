package com.ststjl_project.Player;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Player_Database {
    public static ArrayList<Player> get_Player_History(){
        if(!isDataSecure)
            playerList = get_Player_History();
        return playerList;
    }
    public static void add_Player(Player player){
        if(playerList.size()<5){
            playerList.add(player);
        }
        double lowest = player.get_Over_Score();
        for(int i = 0;i<playerList.size();i++){
            if(playerList.get(i).get_Over_Score()<lowest){
                playerList.set(i,player);
            }
        }
        writeObjectToFile(playerList);
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

    private static boolean isDataSecure = false;
    private static ArrayList<Player> playerList;
    private static void writeObjectToFile(Object obj)
    {
        File file =new File("PlayerData.dat");
        FileOutputStream out;
        try {
            out = new FileOutputStream(file);
            ObjectOutputStream objOut=new ObjectOutputStream(out);
            objOut.writeObject(obj);
            objOut.flush();
            objOut.close();
            System.out.println("write object success!");
        } catch (IOException e) {
            System.out.println("write object failed");
            e.printStackTrace();
            System.exit(0);
        }
    }
    private static Object readObjectFromFile()
    {
        Object temp=null;
        File file =new File("PlayerData.dat");
        FileInputStream in;
        try {
            in = new FileInputStream(file);
            ObjectInputStream objIn=new ObjectInputStream(in);
            temp=objIn.readObject();
            objIn.close();
            System.out.println("read object success!");
        } catch (IOException e) {
            System.out.println("read object failed");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return temp;
    }
}
