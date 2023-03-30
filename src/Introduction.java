import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Introduction {
    public Wizard Introduction() {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Spell> spells = new ArrayList();
        spells.add(Spell.Stupefix);
        spells.add(Spell.Protego);
        spells.add(Spell.WindgardiumLeviosa);
        ArrayList<Potion> potions = new ArrayList();
        potions.add(Potion.HealingPotion);
        potions.add(Potion.DamagingPotion);
        potions.add(Potion.AccuracyPotion);
        potions.add(Potion.ResistancePotion);

        System.out.println("Greetings young wizard, what is your name ?");
        String name = scanner.nextLine();
        System.out.println("Pleased to meet you, " + name + "." + "\nWelcome to Hogwarts and may your adventure there go smoothly :)");

        System.out.println("We'll start by creating a wand for you. And in order to do so, you need to choose a core for your wand :" + "\n1: Phoenix Feather" + "\n2: Dragon Heartstring" + "\n3: Unicron Tail Hair" + "\n4: Veeela Hair" + "\n5: Thestral Tail Hair" + "\n6: Troll Whisker" + "\n7: Coral" + "\n8: Dittany Stalk" + "\n9: Thunderbird Tail Feather" + "\n10: Wampus Cat Hair" + "\n11: White River Monster Spine" + "\n12: Rougarou Hair" + "\n13: Horned Serpent Horn" + "\n14: Snallygaster Heartstring" + "\n15: Jackalope Antler" + "\n16: Kneazle Whisker" + "\n17: Kelpie Hair" + "\n18: Basilisk Horn" + "\n19: Curupira Hair" + "\n20: African Mermaid Hair" + "\n21: Fairy Wing");
        Wand wand = null;
        try {
            int Nbr_Choice_Core = scanner.nextInt();
            scanner.nextLine();
            if (Nbr_Choice_Core < 1 || Nbr_Choice_Core > 12) {
                System.out.println("You must choose a number between 1 and 21.");
            }
            Core[] cores = Core.values();
            Core CoreChosen = cores[Nbr_Choice_Core - 1];
            wand = new Wand(CoreChosen);
            Core core = wand.getCore();
            int size = wand.getSize();
        } catch (InputMismatchException e) {
            System.out.println("You must use a number to choose your action.");
            scanner.next();
        }

        System.out.println("Let's continue with your pet, after all, every good wizard has a faithful companion." + "\nYou can choose one from the list below :" + "\n1: Owl" + "\n2: Rat" + "\n3: Cat" + "\n4: Dog" + "\n5: Toad" + "\n6: Snake" + "\n7: Giant Spider" + "\n8: Pygmy Puffs" + "\n9: Hippogriff" + "\n10: Three Headed Dog" + "\n11: Dragon" + "\n12: Phoenix");
        Pet PetChosen = null;
        try {
            int Nbr_Choice_Pet = scanner.nextInt();
            if (Nbr_Choice_Pet < 1 || Nbr_Choice_Pet > 12) {
                System.out.println("You must choose a number between 1 and 12.");
            }
            Pet[] pets = Pet.values();
            PetChosen = pets[Nbr_Choice_Pet - 1];
        } catch (InputMismatchException e) {
            System.out.println("You must use a number to choose your action.");
            scanner.next();
        }

        System.out.println("Finally, you will join a house. To do this, we will place the Sorting Hat on your head and it will assign you to your house.");
        SortingHat sortingHat = new SortingHat();
        House HouseSelected = sortingHat.Select_House();
        Wizard wizard = new Wizard(name, PetChosen, wand, HouseSelected, spells, potions);
        String stats = wizard.Stats(wizard);
        System.out.println(stats);
        return wizard;
    }
}
