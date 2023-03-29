import java.util.InputMismatchException;
import java.util.Scanner;
public class Inventory {
    public static boolean openInventory(Wizard wizard, Enemy enemy) {
        boolean comeback2 = true;
        Scanner scanner = new Scanner(System.in);
        while (comeback2) {
            System.out.println("\nVous ouvrez votre inventaire, que souhaitez-vous utiliser ?");
            System.out.println("1: Utiliser une potion");
            System.out.println("2: Utiliser un item");
            System.out.println("3: Quitter votre inventaire");

            try {
                int UserChoice = scanner.nextInt();
                scanner.nextLine();

                if (UserChoice < 1 || UserChoice > 3) {
                    System.out.println("Vous devez choisir un nombre compris entre 1 et 3.");
                }

                switch (UserChoice) {
                    case 1 -> {
                        comeback2 = UsePotions(wizard);
                    }
                    case 2 -> {
                        ///comeback2 = findItems(wizard, enemy);
                    }
                    case 3 -> {
                        return true;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Vous devez obligatoirement utiliser un nombre pour choisir votre action à effectuer.");
                scanner.nextLine();
            }
        }
        return false;
        }

    private static boolean UsePotions(Wizard wizard) {
        int numPotions = wizard.getPotions().size();
        if (numPotions == 0) {
            System.out.println("Vous n'avez aucune potion dans votre inventaire." + "\n Vous ne pouvez donc pas en utiliser.");
            return true;
        } else {
            System.out.println("\n Choisissez une potion parmi les suivantes :");
            for (int i = 0; i < numPotions; i++) {
                System.out.println((i + 1) + " : " + wizard.getPotions().get(i).getName());
            }
            System.out.println((numPotions + 1) + " : Retourner dans le sac");
            int choice = -1;
            do {
                Scanner scanner = new Scanner(System.in);
                try {
                    choice = scanner.nextInt();
                    if (choice < 1 || choice > numPotions + 1) {
                        System.out.println("Vous devez choisir un nombre compris entre 1 et 3.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Vous devez obligatoirement utiliser un nombre pour choisir votre action à effectuer.");
                    scanner.next();
                }
            } while (choice < 1 || choice > numPotions + 1);
            if (choice == numPotions + 1) {
                return true;
            }
            Potion chosenPotion = wizard.getPotions().get(choice - 1);
            System.out.println("Vous avez choisi la " + chosenPotion.getName() + ".");
            if (chosenPotion == Potion.potionHeal) {
                if (wizard.getLifePoint() >= 80) {
                    wizard.setLifePoint(wizard.getMaxHealth_point());
                } else
                    wizard.setHealth_point(wizard.getHealthpoint() + chosenPotion.getValue() + (chosenPotion.getValue() * wizard.getEfficiencyPotionsBonus()) / 100);
                wizard.getPotions().remove(choice - 1);
            } else if (chosenPotion == Potion.potionDamage) {
                wizard.setPowerBonus(wizard.getPowerBonus() + chosenPotion.getValue() + (chosenPotion.getValue() * wizard.getEfficiencyPotionsBonus()) / 100);
                wizard.getPotions().remove(choice - 1);
            } else if (chosenPotion == Potion.potionResistance) {
                wizard.setResistanceBonus(wizard.getResistanceBonus() + chosenPotion.getValue() + (chosenPotion.getValue() * wizard.getEfficiencyPotionsBonus()) / 100);
                wizard.getPotions().remove(choice - 1);
            } else if (chosenPotion == Potion.potionPrecision) {
                wizard.setAccuracyBonus(wizard.getAccuracyBonus() + chosenPotion.getValue() + (chosenPotion.getValue() * wizard.getEfficiencyPotionsBonus()) / 100);
                wizard.getPotions().remove(choice - 1);
            }
        }
        return false;
    }
}
