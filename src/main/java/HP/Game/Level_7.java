package HP.Game;

import HP.Game.Character;
import HP.Game.Enemy;

import java.util.Scanner;

public class Level_7 {
    public static void level7(Wizard wizard) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n" + "\nYou engage in a fierce battle with them !");
        Enemy enemy1 = Enemy.Voldemort_Final_Appearance;
        Enemy enemy2 = Enemy.Bellatrix_Lestrange;
        Character.Fight_enemies(wizard, enemy1, enemy2);
    }
}
