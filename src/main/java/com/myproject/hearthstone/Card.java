package com.myproject.hearthstone;

public class Card {
    private Monster monstre;

    public Card(Monster monstre) {
        this.monstre = monstre;
    }


    public Monster invokMonster() {
        return monstre;
    }
}
