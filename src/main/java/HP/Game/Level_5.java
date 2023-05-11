package HP.Game;

import HP.Game.Character;
import HP.Game.Enemy;
import HP.Game.Wizard;

import java.util.Scanner;

public class Level_5 {
    public static void level5(Wizard wizard) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n" + "\nYou engage in a fierce battle with her !");
        Enemy enemy = Enemy.Dolores_Ombrage;
        Character.Fight_enemy(wizard, enemy);
    }
}
