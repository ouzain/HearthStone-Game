package com.myproject.hearthstone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Ousmane DIALLO ");
        
        while (true) {
            showMenu();

            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    startGame();
                    break;

                case 2:
                    System.out.println("Au revoir !");
                    System.exit(0);
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }   

        
        
    }

    static void startGame(){
        System.out.print("Nom du Champion1 : ");
        String _name1 = scanner.nextLine();
        System.out.print("Nom du Champion2 : ");
        String _name2 = scanner.nextLine();

        Champion champion1 = new Champion(1, _name1, 100, null);
        Champion champion2 = new Champion(2, _name2, 100, null);

        List<Monster> plateau = new ArrayList<>();

        // Champion1 pose une carte sur le plateau
        Card cardChampion1 = new Card(new Monster(0, null, 0, 0));
        plateau.add(champion1.placeCard(cardChampion1));
        
        // Champion2 pose une carte sur le plateau
        Card cardChampion2 = new Card(new Monster(0, null, 0, 0));
        plateau.add(champion2.placeCard(cardChampion2));
       
    }

    public static void showMenu(){
        System.out.println("\nMenu:");
        System.out.println("1. Commencer une partie ");
        System.out.println("2. Quitter");
        System.out.print("Choix: ");
    }

    public void attack(Monster attacker, Monster target) {
        target.healthPoints-= attacker.attackPoints;

        
    }


   
    
}