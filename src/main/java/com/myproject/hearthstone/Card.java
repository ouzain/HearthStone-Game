package com.myproject.hearthstone;


public class Card {
    protected Monster monstre;

    public Card(Monster monstre) {
        this.monstre = monstre;
    }

    // Méthode pour retourner le monstre associé à la carte
    public Monster invokMonster() {
        return monstre;
    }
    
}
