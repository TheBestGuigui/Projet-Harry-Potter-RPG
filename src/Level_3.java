import java.util.Scanner;

public class Level_3 {
    public static void level3(Wizard wizard) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nAfter the second year of study at Hogwarts, the long awaited summer holidays are finally here. You decide to go swimming at the lake in the Forbidden Forest." + "\nWhile swimming, you are attacked by Dementors." + "\nYou engage in a fierce battle with them !");
        Enemy enemy = Enemy.Dementor;
        Character.Fight_enemy(wizard, enemy);
    }
}
