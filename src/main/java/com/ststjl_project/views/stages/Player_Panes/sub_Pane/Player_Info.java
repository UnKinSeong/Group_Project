package com.ststjl_project.views.stages.Player_Panes.sub_Pane;

public class Player_Info {

    private static int player_health_cap=50;
    private static int player_health=50;
    private static int player_blood_cap=40;
    private static int player_blood=40;
    private static int player_bone_cap=28;
    private static int player_bone=28;

    public static boolean isPlayer_Dead(){
        return player_health<=0;
    }
    public static void blood_lost(double cost){
        if(player_blood-cost<0){
            player_blood=0;
            player_health-=cost-player_blood;
        }else{
            player_blood-=cost;
        }
    }
    public static void bone_lost(double cost){
        if(player_bone-cost<0){
            player_bone=0;
            player_health-=cost-player_bone;
        }else{
            player_bone-=cost;
        }
    }
    public static void health_lost(double cost){
        player_health-=cost;
    }

    public static int getPlayer_health() {
        return player_health;
    }
    public static int getPlayer_health_cap() {
        return player_health_cap;
    }
    public static int getPlayer_blood() {
        return player_blood;
    }
    public static int getPlayer_blood_cap() {
        return player_blood_cap;
    }
    public static int getPlayer_bone() {
        return player_bone;
    }
    public static int getPlayer_bone_cap() {
        return player_bone_cap;
    }

    public static void setPlayer_health(int player_health) {
        Player_Info.player_health = player_health;
    }
    public static void setPlayer_health_cap(int player_health_cap) {
        Player_Info.player_health_cap = player_health_cap;
    }
    public static void setPlayer_blood(int player_blood) {
        Player_Info.player_blood = player_blood;
    }
    public static void setPlayer_blood_cap(int player_blood_cap) {
        Player_Info.player_blood_cap = player_blood_cap;
    }
    public static void setPlayer_bone(int player_bone) {
        Player_Info.player_bone = player_bone;
    }
    public static void setPlayer_bone_cap(int player_bone_cap) {
        Player_Info.player_bone_cap = player_bone_cap;
    }
}
