package com.saeed;

public class Referee {

    private String id;
    private String name;
    private String qualification;
    private int allocations;
    private String home;
    private String localities;

    //constructor
    public Referee(String id, String name, String qualification, int allocations, String home, String localities) {
        this.id = id;
        this.name = name;
        this.qualification = qualification;
        this.allocations = allocations;
        this.home = home;
        this.localities = localities;
    }

    //setters
    public void setQualification(String qualification){

        this.qualification = qualification;
    }

    public void setHome(String home){

        this.home = home;
    }

    public void setLocalities(String localities){
        //validation required - Or can be implemented in UI: combo boxes
        this.localities = localities;
    }

    //getters
    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getQualification(){
        return qualification;
    }

    public int getAllocations(){
        return allocations;
    }

    public String getHome(){
        return home;
    }

    public String getLocalities(){
        return localities;
    }
}
