import java.util.Scanner;

public class Level_2 {
    public static void level2(Wizard wizard) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nOn an evening when you can't sleep, you decide to go for a walk but you accidentally get lost in the room of secrets." + "\nThen you come face to face with the Basilisk which attacks you ferociously." + "`\nYou engage in a fierce battle with it !");
        Enemy enemy = Enemy.basilic;
        Character.Fight_enemy(wizard, enemy);
    }
}
