package com.myproject.hearthstone;

public class Entity {
    protected int id;
    protected String name;
    protected int healthPoints;
    
    public Entity(int id, String name, int healthPoints){
        this.id=id;
        this.healthPoints=healthPoints;
        this.name=name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getHealthPoints() {
        return healthPoints ;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints =healthPoints ;
    }
}
