package Levels;

import java.util.Scanner;

public class Level_1 {

    public static void level1(Wizard wizard) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ressentant l'envie d'aller aux toilettes, vous décidez de quitter votre chambre et d'en partir à la recherche." + "\n Vous finissez par en apercevoir au loin, et au fur et à mesure que vous vous en approchez, vous entendez des grognements graves." + "\n C'est lors que vous voyez un énorme troll détruire la porte et surgir." + "`\n Vous vous engagez donc dans un combat féroce contre lui !");
        Enemy enemy = Enemy.troll;
        Character.Fight_enemy(wizard, enemy);
        wizard.is_alive(wizard);
        if (!wizard.getIsAlive()) {
            return;
        }
    }
}
