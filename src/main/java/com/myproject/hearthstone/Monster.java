package com.myproject.hearthstone;
import java.util.Random;

public class Monster extends Entity implements MonsterTurnBehavior{
    public enum MonsterType {
        CLASSIC, PROTECTOR, HEALER, MASCOT,
    
    }

    protected int attackPoints;
    protected MonsterType monsterType;

    public Monster(int id, String name, int healthPoints, int attackPoints){
       super(id, name, healthPoints);
        this.attackPoints=attackPoints;
        this.monsterType=setMonsterType();
        
    }

    public MonsterType getMonsterType(){
        return this.monsterType;
    }

    public MonsterType setMonsterType() {
       Random random = new Random();
        int randomIndex = random.nextInt(MonsterType.values().length);
        return MonsterType.values()[randomIndex];
        
        
        
    }

    public int getAttackpoints(){
        return this.attackPoints;
    }

   
    @Override
    public void performTurnAction() {
        // TODO Auto-generated method stub
        
    }

}