package com.ststjl_project.Cards;

public class Card_Base {

    private double energy_required=0;
    private double bone_required=0;
    private double blood_required=0;
    private double base_damage=1;
    private double base_critical_chance=0.1;
    private double base_shield_damage=0;
    private double base_armor_damage=0;
    public Card_Base(
        double energy_required,
        double bone_required,
        double blood_required,
        double base_damage,
        double base_critical_chance,
        double base_shield_damage
    )
    {
        this.energy_required = energy_required;
        this.bone_required = bone_required;
        this.blood_required = blood_required;
        this.base_damage = base_damage;
        this.base_critical_chance = base_critical_chance;
    }
    public double getEnergy_required(){return this.energy_required;};
    public double getBone_required(){return this.bone_required;};
    public double getBlood_required(){return this.blood_required;};
    public double getBase_damage(){return this.base_damage;};
    public double getBase_critical_chance(){return this.base_critical_chance;};

    public void setEnergy_required(double energy_required){this.energy_required = energy_required;};
    public void setBone_required(double bone_required){this.bone_required = bone_required;};
    public void setBlood_required(double blood_required){this.blood_required = blood_required;};
    public void setBase_damage(double base_damage){this.base_damage = base_damage;};
    public void setBase_critical_chance(double base_critical_chance){this.base_critical_chance = base_critical_chance;};
}
