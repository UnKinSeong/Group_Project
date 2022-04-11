package com.ststjl_project.views.stages.Player_Panes.sub_Pane;

public class Player_Info {

    private static int player_health_cap;
    private static int player_health;
    private static int player_blood_cap;
    private static int player_blood;
    private static int player_bone_cap;
    private static int player_bone;

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
