package Levels;

import java.util.Scanner;

public class Level_1 {

    public static void level1(Wizard wizard) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ressentant l'envie d'aller aux toilettes, vous vous en approchez et voyez un énorme troll détruire la porte et surgir." + "`\n Vous vous engagez alors dans un combat féroce contre le troll !");
        Enemy enemy = Enemy.troll;
        Character.fight(wizard, enemy, listFriendsWithYou);
        wizard.checkIsAlive(wizard);
        if (!wizard.getIsAlive()) {
            return;
    }
}
