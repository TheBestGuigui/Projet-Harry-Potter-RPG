import java.util.Scanner;

public class Level_3 {
    public static void level3(Wizard wizard) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n" + "\nYou engage in a fierce battle with them !");
        Enemy enemy = Enemy.Dementor;
        Character.Fight_enemy(wizard, enemy);
    }
}
