package com.myproject.hearthstone;

public class Champion implements SpecialAbility {
    protected int id;
    protected String name;
    protected int healthPoints;
    protected SpecialAbility specialAbility;

    public Champion (int id, String name, int healthPoints){
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
    
    @Override
    public void useAbility(){
        System.out.println("Voici mon pouvoir spéciale");
    }
}
