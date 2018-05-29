package com.saeed;

public class Match {

    private int week;
    private String area;
    private String level;
    private String referee1;
    private String referee2;

    //constructor
    public Match(int week, String area, String level, String referee1, String referee2){
        this.week = week;
        this.area = area;
        this.level = level;
        this.referee1 = referee1;
        this.referee2 = referee2;
    }

    //setters
    public void setWeek(int week){
        this.week = week;
    }

    public void setArea(String area){
        this.area = area;
    }

    public void setLevel(String level){
        this.level = level;
    }

    public void setReferee1(String referee1){
        this.referee1 = referee1;
    }

    public void setReferee2(String referee2){
        this.referee2 = referee2;
    }

    //getters
    public int getWeek(){
        return week;
    }

    public String getArea(){
        return area;
    }

    public String getLevel(){
        return level;
    }

    public String getReferee1(){
        return referee1;
    }

    public String getReferee2(){
        return referee2;
    }
}
