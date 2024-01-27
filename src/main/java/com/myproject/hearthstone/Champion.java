package com.myproject.hearthstone;

public class Champion extends Entity implements SpecialAbility {
    protected String specialAbility;

    public Champion (int id, String name, int healthPoints, String specialAbility){
        super(id, name, healthPoints);
        
       
    }

    
    public String setSpecialAbility(String specialAbility ){
        return specialAbility;
    }
    
    @Override
    public void useAbility(){
        System.out.println("Voici mon pouvoir spéciale");
    }
}
