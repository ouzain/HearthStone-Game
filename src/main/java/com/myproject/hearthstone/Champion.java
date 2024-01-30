package com.myproject.hearthstone;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Champion extends Entity implements SpecialAbility {
    protected String specialAbility;

    public Champion (int id, String name, int healthPoints, String specialAbility){
        super(id, name, healthPoints);
        
       
    }

    public String getName() {
        return name;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints =healthPoints ;
    }

    
    public String setSpecialAbility(String specialAbility ){
        return specialAbility;
    }

    // Méthode pour invoquer une carte et la placer sur le plateau
    public Monster placeCard(Card card) {
       
       return card.invokMonster();
        
    
    }
    
        /**
            * Demande au champion s'il souhaite utiliser sa capacité spéciale.
            * Si le champion choisit de l'utiliser, sa santé est augmentée de 10 points.
            * Affiche un message correspondant au choix du champion.
        */
    @Override
    public void useAbility(){
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.println(getName() + ", voulez-vous utiliser votre capacité spéciale ? entrez 1 si OUI, 2 sinon.");
            if (scanner.hasNextInt()) {
                int choix = scanner.nextInt();
                switch (choix) {
                    case 1:
                        setHealthPoints(10);
                        System.out.println(getName() + " a utilisé sa capacité spéciale pour augmenter son score de vie de 10 points." );
                        break;
                    case (2):
                        System.out.println(getName() + " a choisi de ne pas utiliser sa capacité spéciale.");
                        break;

                    default: System.out.println("Choix invalide !");
                        break;
                }
            } else {
                System.out.println("Entrée non valide. Veuillez entrer un entier.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Erreur : Entrée invalide. Veuillez entrer un entier.");
        } catch (NoSuchElementException e) {
            System.out.println("Erreur : NoSuchElementException. L'entrée n'est pas présente.");
        }

        scanner.close();
    }

    
}


