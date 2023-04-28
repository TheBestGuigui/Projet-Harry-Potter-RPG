import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class SortingHat {
    public final House[] houses = {House.RAVENCLAW, House.SLYTHERIN, House.GRYFFINDOR, House.HUFFLEPUFF};

        public House Select_House() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("The Sorting Hat whispers to you inwardly :" + "\nIs there a House you really want to join ?" + "\nChoose your House :" + "\n1: HUFFLEPUFF," + "\n2: SLYTHERIN," + "\n3: GRYFFINDOR," + "\n4: RAVENCLAW," + "\n5: Let the Sorting Hat decide.");
            try {
                int Choice_House = scanner.nextInt();
                scanner.nextLine();

                if (Choice_House < 1 || Choice_House > 5) {
                    System.out.println("Vous devez choisir un nombre compris entre 1 et 5.");
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
                        Random random = new Random();
                        int nbr_random = random.nextInt(4);
                        System.out.println("Very well, I have made up my mind, your house will be: '" + houses[nbr_random] + "'.");
                        return houses[nbr_random];
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Vous devez obligatoirement utiliser un nombre pour choisir votre action à effectuer.");
                scanner.next();
            }
            return houses[0];
        }
}
