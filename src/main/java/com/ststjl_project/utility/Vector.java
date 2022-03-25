package com.ststjl_project.utility;

public class Vector {
    public double x,y;
    public Vector(){
        set(0,0);
    }
    public Vector(double x, double y){
        set(x,y);
    }
    public void set(double x, double y){
        this.x = x;
        this.y = y;
    }
    public void add(double x, double y){
        this.x+=x;
        this.y+=y;
    }
    public void subtract(double x, double y){
        this.x-=x;
        this.y-=y;
    }
    public void multiple(double m){
        this.x*=m;
        this.y*=m;
    }
    public double getLength(){
        return Math.sqrt(x*x+y*y);
    }
    public void setLength(double des_l){
        double len = getLength();
        if(len==0)
            return;
        multiple(1/len);
        multiple(des_l);
    }
    public double getAngle(){
        return Math.toDegrees(Math.atan2(y,x));
    }
    public void setAngle(double tarRads){
        double len = getLength();
        double angRads = Math.toRadians(tarRads);
        this.x = len * Math.cos(angRads);
        this.y = len * Math.sin(angRads);
    }
}
