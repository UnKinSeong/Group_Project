package com.ststjl_project.Cards;

import javafx.scene.control.RadioMenuItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static java.lang.Math.random;

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

    public static ArrayList<Card_Base> getRandom(int count) {
        ArrayList<Card_Base> listOf_Cards = new ArrayList<>();
        Card_Base randomName = null;
        int i = 0;
        while(i<count) {
            randomName = Card_DataBase.get(Card_DataBase.keySet().toArray()[new Random().nextInt(Card_DataBase.keySet().toArray().length)]);
            if (listOf_Cards.indexOf(randomName) == -1) {
                listOf_Cards.add(randomName);
                i = i + 1;
            }
        }
        return listOf_Cards;
    }
}
