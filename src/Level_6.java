import java.util.Scanner;

public class Level_6 {
    public static void level6(Wizard wizard) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n" + "\nYou engage in a fierce battle with them !");
        Enemy enemy = Enemy.Death_Eater;
        Character.Fight_enemy(wizard, enemy);
    }
}
