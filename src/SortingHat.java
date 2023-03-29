import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class SortingHat {
    public final House[] houses = {House.RAVENCLAW, House.SLYTHERIN, House.GRYFFINDOR, House.HUFFLEPUFF};

        public House Select_House(Scanner scanner) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("The Sorting Hat whispers to you inwardly :" + "\n Is there a House you really want to join ?" + "\n Choose your House :" + "\n 1: HUFFLEPUFF," + "\n 2: SLYTHERIN," + "\n 3: GRYFFINDOR," + "\n 4: RAVENCLAW," + "\n 5: Let the Sorting Hat decide.");
            try {
                int Choice_House = scanner.nextInt();
                scanner.nextLine();

                if (Choice_House < 1 || Choice_House > 4) {
                    System.out.println("Vous devez choisir un nombre compris entre 1 et 3.");
                    continue;
                }

                switch (Choice_House) {
                    case 1 -> {
                        System.out.println("Very well, I have made up my mind, your house will be: 'HUFFLEPUFF'");
                        return houses[0];
                    }
                    case 2 -> {
                        System.out.println("Very well, I have made up my mind, your house will be: 'SLYTHERIN'");
                        return houses[1];
                    }
                    case 3 -> {
                        System.out.println("Very well, I have made up my mind, your house will be: 'GRYFFINDOR'");
                        return houses[2];
                    }
                    case 4 -> {
                        System.out.println("Very well, I have made up my mind, your house will be: 'RAVENCLAW'");
                        return houses[3];
                    }
                    case 5 -> {
                        int nbr_random = 0 + (int)(Math.random() * 4);
                        return houses[nbr_random];
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Vous devez obligatoirement utiliser un nombre pour choisir votre action à effectuer.");
                scanner.next();
            }
        }
}
