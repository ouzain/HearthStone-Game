package com.myproject.hearthstone;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Random;


public class Main {
    static String logFileName = "game_log.txt";
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception{
        System.out.println("\n=======Ousmane DIALLO & Islem ZOUAOUI=======");
        
        
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

    public static boolean isKO(Champion champion) {
        return champion.getHealthPoints() <= 0;
    }

    /**
        * Pioche au hasard une carte.
        *
        * @param Card 
        * @return true si le champion est KO, false sinon.
        
    */
    public static Card getRandomCard(List<Card> list) {
        if (!list.isEmpty()) {
            Random random = new Random();
            int cardIndex = random.nextInt(list.size());
            return list.remove(cardIndex);
        } else {
            System.out.println( "Plus de cartes dans sa réserve.");
            return null;
        } 
    }


    static void startGame(){
        System.out.print("Nom du Champion1 : ");
        String _name1 = scanner.nextLine();
        System.out.print("Nom du Champion2 : ");
        String _name2 = scanner.nextLine();

        Champion champion1 = new Champion(1, _name1, 100, null);
        Champion champion2 = new Champion(2, _name2, 100, null);

        Map<String, Integer> listeMonstres = new HashMap<>(); // Un map pour stocker les noms et force d'attaque des monstres

        
        listeMonstres.put("Gobelin", 2);
        listeMonstres.put("Orc", 3);
        listeMonstres.put("Loup", 4);
        listeMonstres.put("Dragonnet", 5);
        listeMonstres.put("Fantôme", 1);
        listeMonstres.put("Golem", 6);
        listeMonstres.put("Chimère", 7);
        listeMonstres.put("Banshee", 5);
        listeMonstres.put("Hydre", 8);
        listeMonstres.put("Spectre", 3);
        listeMonstres.put("Basilic", 6);
        listeMonstres.put("Succube", 4);
        listeMonstres.put("Phoenix", 9);
        listeMonstres.put("Garde Royal", 2);
        listeMonstres.put("Chevalier", 4);
        listeMonstres.put("Clerc", 1);
        listeMonstres.put("Guérisseur", 3);
        listeMonstres.put("Fée", 2);
        listeMonstres.put("Dragon de Compagnie", 3);
        listeMonstres.put("Serpent Géant", 7);
        listeMonstres.put("Géant des Montagnes", 10);
        listeMonstres.put("Elémentaire de Feu", 8);

        
        List<Champion> myChampions = new ArrayList<>();
        myChampions.add(champion1);
        myChampions.add(champion2);
        List<Monster> plateau = new ArrayList<>();       // Liste pour stocker les cartes sur le plateau par les champions 
        List<Card> reserveChampion1 = new ArrayList<>(); // Cartes que le champion1 possède dans sa main
        List<Card> reserveChampion2 = new ArrayList<>(); // Cartes que le champion2 possède dans sa main


        List<Card> cardList = new ArrayList<>(); // Une liste pour stocker l'ensemble des cartes

        // Création des cartes et chaque carte est associé à un monstre en utilisant le Map listeMonstres le nom et la force d'attaque des monstres
        int idMonster = 1; // Utilisez un ID unique pour chaque monstre
        for (Map.Entry<String, Integer> monstre : listeMonstres.entrySet()) {
            String nomMonstre = monstre.getKey();
            int pointsAttaque = monstre.getValue();
            
            Card newCard = new Card(new Monster(idMonster++, nomMonstre, 10, pointsAttaque));
            cardList.add(newCard);
        }

        // On créé une réserve de carte pour le 2 champions, c'est à dire les cartes que chaque champion dispose dans ses mains
        for (Card card : cardList) {
            reserveChampion1.add(card);// CARTE DANS TES MAINS
            reserveChampion2.add(card);
        }

        while(!isKO(champion1) && !isKO(champion2)){

            // Champion1 pose une carte sur le plateau
            Card chosenCardCh1 = getRandomCard(reserveChampion1);// Le champion1 pioche une carte au hasard dans sa reserve
            plateau.add(chosenCardCh1.monstre); // On Crée Ajoute la carte  sur le plateau ie champion2 pose à son tour sa carte sur la table
            System.out.println(champion1.getName()+ " a posé la carte " + chosenCardCh1.monstre.getName()+ " dont le type est : "+chosenCardCh1.monstre.getMonsterType());
            //champion1.useAbility();
            // Champion2 pose une carte sur le plateau
            Card chosenCardCh2 = getRandomCard(reserveChampion2); // Le champion2 pioche une carte au hasard dans sa reserve
            plateau.add(chosenCardCh2.monstre); // On Crée Ajoute la carte  sur le plateau ie champion2 pose à son tour sa carte sur la table
            System.out.println(champion2.getName()+ " a posé la carte " + chosenCardCh2.monstre.getName()+ " dont le type est : "+chosenCardCh2.monstre.getMonsterType());
            //champion2.useAbility();
            if (chosenCardCh1.monstre.getMonsterType().equals(Monster.MonsterType.CLASSIC)){
               attack(chosenCardCh1.monstre, champion2);
            }
        
            if (chosenCardCh2.monstre.getMonsterType().equals(Monster.MonsterType.CLASSIC)){
                attack(chosenCardCh2.monstre, champion1);

            }


            if (chosenCardCh1.monstre.getMonsterType().equals(Monster.MonsterType.HEALER)){
                toHeal(chosenCardCh1.monstre, champion1);
            }
            if (chosenCardCh2.monstre.getMonsterType().equals(Monster.MonsterType.HEALER)){
                toHeal(chosenCardCh2.monstre, champion2);
            }
            if (chosenCardCh1.monstre.getMonsterType().equals(Monster.MonsterType.PROTECTOR)){
                toProtect(chosenCardCh1.monstre, champion1);
            }

            if (chosenCardCh2.monstre.getMonsterType().equals(Monster.MonsterType.PROTECTOR)){
                toProtect(chosenCardCh2.monstre, champion2);
        }

        if (isKO(champion1) || isKO(champion2)){
            System.out.println("Votre partie viens de se terminer ");
            whoIsWiner(champion1, champion2);
        }

        }

        

    }

    public static void showMenu(){
        System.out.println("\nMenu:");
        System.out.println("1. Commencer une partie ");
        System.out.println("2. Quitter");
        System.out.print("Choix: ");
    }

    public static void attack(Monster attacker, Champion target) {
        target.healthPoints-= (attacker.attackPoints + 20);
        System.out.println("Le monstre " +attacker.getName()+ " attaque "+target.getName());
        System.out.println(target.getName()+ " perd " +attacker.attackPoints + " points. Son nouveau score de vie est de "+ target.healthPoints );
        
    }

    public static void toHeal(Monster healer, Champion target){
        target.healthPoints+= healer.attackPoints;
        System.out.println("Le monstre " +healer.getName()+ " a soigné " + target.getName()+ " et augmente son score de vie de " +healer.attackPoints + " points.");
        System.out.println("Le nouveau score de vie de " + target.getName()+" est"+target.healthPoints + " points.");

    }

    public static void toProtect(Monster protector, Champion target){

        System.out.println("Le monstre " +protector.getName()+ " a protégé " + target.getName() +" contre un potentiel attaque " );
        System.out.println("Le nouveau score de vie de " + target.getName()+" est "+target.healthPoints + " points.");

    }

    public static void whoIsWiner(Champion champion1, Champion champion2) {
        if (isKO(champion1) && isKO(champion2)) {
            System.out.println("La partie est un match nul.");
        } else if (isKO(champion1)) {
            System.out.println(champion2.getName() + " remporte la partie !");
        } else if (isKO(champion2)) {
            System.out.println(champion1.getName() + " remporte la partie !");
        } else {
            System.out.println("La partie n'est pas encore terminée.");
        }
    }
    
    
static void log(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFileName, true))) {
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            writer.write(timeStamp + " - " + message + "\n");
        } catch (IOException e) {
            System.err.println("Erreur lors de l'écriture dans le fichier de log : " + e.getMessage());
        }
    }
}