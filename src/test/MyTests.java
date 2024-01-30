import static org.junit.Assert.*;
import org.junit.Test;

import com.myproject.hearthstone.Card;
import com.myproject.hearthstone.Champion;
import com.myproject.hearthstone.Monster;

public class HearthStoneGameTest {

    @Test
     /**
            * Tester si l'attaque du monstre est bien effectif sur un champion
        */
    public void testMonsterAttackChampion() {
        // Création de deux monstres pour le test
        Monster attacker = new Card(new Monster(0, null, 5, 0));
        Champion target = new Champion(0, null, 30, null);

        // Simulation de l'attaque
        attacker.attack(target);

        // Vérification que la cible a 5 points de vie après avoir subi une attaque d'un monstre dont la force de frappe est de 5 points
        assertEquals(5, target.getHealthPoints());
    }

    @Test
    public void testBattlebetweChampions() {
        // Création de deux champions pour le test
        Champion champion1 = new Champion(1, "Joueur1", 20, "Capacite1");
        Champion champion2 = new Champion(2, "Joueur2", 20, "Capacite2");

        // Simulation d'un combat jusqu'à ce que l'un des champions soit KO
        while (!champion1.isKO() && !champion2.isKO()) {
            // Supposons que les champions s'attaquent mutuellement à chaque tour
            champion1.attackBetweenChampions(champion2);
            champion2.attackBetweenChampions(champion1);
        }

        // Vérification que le combat s'arrête avec le bon vainqueur
        if (champion1.isKO()) {
            assertTrue(champion2.isKO());
        } else if (champion2.isKO()) {
            assertTrue(champion1.isKO());
        } else {
            fail("Aucun champion KO.");
        }
    }
}
