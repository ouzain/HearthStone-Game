# Jeu de Plateau de Type HearthStone

## Introduction
Ce projet consiste à développer les bases d'un jeu de plateau inspiré de HearthStone, où deux champions s'affrontent en utilisant des cartes pour invoquer des monstres sur le plateau. Ce README vous guidera à travers les fonctionnalités principales et les exigences techniques de ce projet.

## Description du Jeu

### Champions
- **Caractéristiques:** Chaque champion possède un id, un nom, un certain nombre de points de vie, et une capacité spéciale.
- **Actions:** Un champion peut poser des cartes et utiliser sa capacité spéciale.

### Cartes et Monstres
Chaque carte invoque un monstre sur le plateau. Les monstres ont les caractéristiques suivantes :
- **id**
- **nom**
- **points de vie**
- **force d'attaque**

### Types de Monstres
- **Classiques:** Attaquent les ennemis.
- **Protecteurs:** Empêchent les attaques directes contre le champion ou d'autres monstres non protecteurs.
- **Soigneurs:** Soignent un allié ou un ennemi, mais ne peuvent pas attaquer.
- **Mascottes:** Boostent une cible alliée ou ennemie.
- **Autres:** Des monstres avec des capacités uniques selon votre imagination (ex: mort vivant, pilote de ligne, etc.).

### Déroulement d'un Tour de Jeu
1. Le champion peut poser une carte.
2. Le champion peut utiliser sa capacité spéciale.
3. Le champion et ses monstres peuvent attaquer des cibles.
4. Le tour se termine et passe au champion adverse.
5. La partie se termine lorsqu'un des champions a ses points de vie réduits à 0 ou moins.

## Exigences Techniques

### Partie 1
- **Utilisation d'au moins 1 interface.**
- **Implémentation d'un héritage minimum.**
- **Journalisation:** Tracer les actions importantes dans un fichier de log (ex: "champion 1 invoque protecteur 1").
- **Tests Unitaires:** Au moins 5 tests unitaires, incluant :
  - Simulation d'une attaque de monstre avec des points d'attaque égaux aux points de vie du monstre attaqué.
  - Instanciation et résolution d'un combat entre deux champions.
- **Conventions de codage:** Respect des conventions Java (UpperCamelCase pour les noms de classes, lowerCamelCase pour les noms de variables et méthodes, etc.).
- **Commentaires et Javadoc:** Insister sur les commentaires et la documentation Javadoc.
- **Optionnel:** Utilisation de streams et fonctions anonymes.

### Partie 2
- **Ajout de l'attribut "élément" aux monstres** avec des valeurs prédéfinies (ex: FEU, EAU, GUIMAUVE).
- **Effets des éléments:** Modifier la valeur d'attaque en fonction de l'élément (ex: eau efficace contre feu).
- **Tests Unitaires:** Vérifier la validité des tests existants et les corriger si nécessaire. Noter les explications dans un fichier texte.
- **Journalisation:** Tracer les actions importantes dans un fichier de log.
- **Conventions de codage et documentation:** Maintenir les conventions de codage et la documentation.
- **Facultatif:** Utilisation de streams et fonctions anonymes.

## Conclusion
Ce projet vise à appliquer des concepts de programmation orientée objet, y compris l'utilisation des interfaces, l'héritage, et les tests unitaires, dans un cadre ludique et engageant. Suivez les directives ci-dessus pour assurer le bon déroulement du développement et la validation de votre projet.
