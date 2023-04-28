import java.util.Scanner;

public class Level_4 {
    public static void level4(Wizard wizard) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n" + "\nYou engage in a fierce battle with them !");
        Enemy enemy1 = Enemy.Voldemort_First_Appearance;
        Enemy enemy2 = Enemy.Peter_Pettigrow;
        Character.Fight_enemies(wizard, enemy1, enemy2);
    }
}
