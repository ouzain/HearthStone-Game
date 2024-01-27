package com.myproject.hearthstone;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
       
        
    }

    public void placeCard(Card card, ArrayList<Monster> plateau) {
        Champion champion1 = new Champion(0, null, 0, null);
        
        Monster invokedMonster = card.invokMonster();
        plateau.add(invokedMonster);
        System.out.println(champion1.getName() + " a posé une carte et invoqué " + invokedMonster.getName() + " sur le plateau.");
    
    }
}