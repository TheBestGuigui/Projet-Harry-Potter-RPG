import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Introduction {
    public void Introduction(Wizard wizard) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Greetings young wizard, what is your name ?");

        String name = scanner.nextLine();

        System.out.print("Pleased to meet you, " + name + "." + "\n Welcome to Hogwarts and may your adventure there go smoothly :)");

        System.out.print("We'll start by creating a wand for you. And in order to do so, you need to choose a core for your wand :" + "\n 1: Phoenix Feather" + "\n 2: Dragon Heartstring" + "\n 3: Unicron Tail Hair" + "\n 4: Veeela Hair" + "\n 5: Thestral Tail Hair" + "\n 6: Troll Whisker" + "\n 7: Coral" + "\n 8: Dittany Stalk" + "\n 9: Thunderbird Tail Feather" + "\n 10: Wampus Cat Hair" + "\n 11: White River Monster Spine" + "\n 12: Rougarou Hair" + "\n 13: Horned Serpent Horn" + "\n 14: Snallygaster Heartstring" + "\n 15: Jackalope Antler" + "\n 16: Kneazle Whisker" + "\n 17: Kelpie Hair" + "\n 18: Basilisk Horn" + "\n 19: Curupira Hair" + "\n 20: African Mermaid Hair" + "\n 21: Fairy Wing");
        int Nbr_Choice_Core;
        try {
            Nbr_Choice_Core = scanner.nextInt();
            if (Nbr_Choice_Core < 1 || Nbr_Choice_Core > 12) {
                System.out.println("You must choose a number between 1 and 21.");
            }
        } catch (InputMismatchException e) {
            System.out.println("You must use a number to choose your action.");
            scanner.next();
        }
        Core[] cores = Core.values();
        Core CoreChosen = cores[Nbr_Choice_Core - 1];

        Wand wand = new Wand(CoreChosen);
        Core core = wand.getCore();
        int size = wand.getSize();

        System.out.print("Let's continue with your pet, after all, every good wizard has a faithful companion." + "\n You can choose one from the list below :" + "\n 1: Owl" + "\n 2: Rat" + "\n 3: Cat" + "\n 4: Dog" + "\n 5: Toad" + "\n 6: Snake" + "\n 7: Giant Spider" + "\n 8: Pygmy Puffs" + "\n 9: Hippogriff" + "\n 10: Three Headed Dog" + "\n 11: Dragon" + "\n 12: Phoenix");
        int Nbr_Choice_Pet;
        try {
            Nbr_Choice_Pet = scanner.nextInt();
            if (Nbr_Choice_Pet < 1 || Nbr_Choice_Pet > 12) {
                System.out.println("You must choose a number between 1 and 12.");
            }
        } catch (InputMismatchException e) {
            System.out.println("You must use a number to choose your action.");
            scanner.next();
        }
        Pet[] pets = Pet.values();
        Pet PetChosen = pets[Nbr_Choice_Pet - 1];

        System.out.print("Finally, you will join a house. To do this, we will place the Sorting Hat on your head and it will assign you to your house.");
        SortingHat sortingHat = new SortingHat();
        House HouseSelected = sortingHat.Select_House();

        wizard.setName(name);
        wizard.setWand(wand);
        wizard.setPet(PetChosen);
        wizard.setHouse(HouseSelected);
    }
}
