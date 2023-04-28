import java.util.Scanner;

public class Level_1 {
    public static void level1(Wizard wizard) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nFeeling the need to go to the toilet, you decide to leave your room and go in search of it." + "\nEventually you see one in the distance, and as you approach it, you hear low growls. " + "\nThat's when you see a huge troll destroy the door and jump out." + "\nYou engage in a fierce battle with it !");
        Enemy enemy = Enemy.troll;
        Character.Fight_enemy(wizard, enemy);
    }
}