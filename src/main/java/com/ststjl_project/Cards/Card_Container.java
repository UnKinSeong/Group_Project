package com.ststjl_project.Cards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Card_Container {

    private static Map<Integer,Card_Base> Card_DataBase = new HashMap<>();

    public static void addCards(int ids, Card_Base cards){
        Card_DataBase.put(ids,cards);
    }
    public static Card_Base getCard(int ids){
        if(Card_DataBase.containsKey(ids)){
            return Card_DataBase.get(ids);
        }
        return null;
    }
    public static int size(){
        return Card_DataBase.size();
    }
}
