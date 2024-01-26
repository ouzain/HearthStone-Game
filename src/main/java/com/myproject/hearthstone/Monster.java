package com.myproject.hearthstone;

public class Monster {
    protected int id;
    protected String name;
    protected int healthPoints;
    protected int attackPoints;

    public Monster(int id, String name, int healthPoints, int attackPoints){
        this.id=id;
        this.name=name;
        this.attackPoints=attackPoints;
        this.healthPoints=healthPoints;
        
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