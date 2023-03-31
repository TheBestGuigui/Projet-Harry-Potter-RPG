import java.util.InputMismatchException;
import java.util.Scanner;
public class Inventory {
    public static boolean openInventory(Wizard wizard, Enemy enemy, int Timer) {
        Scanner scanner = new Scanner(System.in);
        int Condition_Vérif = 0;
        System.out.println("\nYou open your inventory, which potion do you want to use ?" + "\n1: Healing Potion" + "\n2: Damaging Potion" + "\n3: Accuracy Potion" + "\n4: Resistance Potion" + "\n5: Close Inventory");
        while (Condition_Vérif == 0) {
            try {
                int InventoryChoice = scanner.nextInt();
                scanner.nextLine();

                if (InventoryChoice < 1 || InventoryChoice > 5) {
                    System.out.println("You must choose a number between 1 and 5.");
                }

                switch (InventoryChoice) {
                    case 1 -> {
                        if (Potion.HealingPotion.getQuantity() == 0) {
                            System.out.println("You are out of healing potions." + "\nChoose another option :" + "\n1: Healing Potion" + "\n2: Damaging Potion" + "\n3: Accuracy Potion" + "\n4: Resistance Potion" + "\n5: Close Inventory");
                        } else {
                            if (wizard.getHealth_point() + Potion.HealingPotion.getValue() > wizard.getMax_Health_point()) {
                                wizard.setHealth_point(wizard.getMax_Health_point());
                                Potion.HealingPotion.setQuantity(Potion.HealingPotion.getQuantity() - 1);
                            } else {
                                wizard.setHealth_point(wizard.getHealth_point() + Potion.HealingPotion.getValue());
                                Potion.HealingPotion.setQuantity(Potion.HealingPotion.getQuantity() - 1);
                            }
                            String stats = wizard.Stats(wizard);
                            System.out.println(stats);
                            int Condtion_Vérif = 1;
                            return true;
                        }
                    }
                    case 2 -> {
                        if (Potion.DamagingPotion.getQuantity() == 0) {
                            System.out.println("You are out of damaging potions." + "\nChoose another option :" + "\n1: Healing Potion" + "\n2: Damaging Potion" + "\n3: Accuracy Potion" + "\n4: Resistance Potion" + "\n5: Close Inventory");
                        } else {
                            enemy.setHealth_point(enemy.getHealth_point() - Potion.DamagingPotion.getValue());
                            Potion.DamagingPotion.setQuantity(Potion.DamagingPotion.getQuantity()- 1);
                            System.out.println("You throw a damaging potion in the face of " + enemy.getName() + " and you take " + Potion.DamagingPotion.getValue() + " health points away from this enemy.");
                            System.out.println(enemy.getName() + " now has " + enemy.getHealth_point() + " health points remaining.");
                            int Condtion_Vérif = 1;
                            return true;
                        }
                    }
                    case 3 -> {
                        if (Potion.AccuracyPotion.getQuantity() == 0) {
                            System.out.println("You are out of accuracy potions." + "\nChoose another option :" + "\n1: Healing Potion" + "\n2: Damaging Potion" + "\n3: Accuracy Potion" + "\n4: Resistance Potion" + "\n5: Close Inventory");
                        } else {
                            wizard.setAccuracy(wizard.getAccuracy() + Potion.AccuracyPotion.getValue());
                            Potion.AccuracyPotion.setQuantity(Potion.AccuracyPotion.getQuantity() - 1);
                            String stats = wizard.Stats(wizard);
                            System.out.println(stats);
                            int Condtion_Vérif = 1;
                            return true;
                        }
                    }
                    case 4 -> {
                        if (Potion.ResistancePotion.getQuantity() == 0) {
                            System.out.println("You are out of resistance potions." + "\nChoose another option :" + "\n1: Healing Potion" + "\n2: Damaging Potion" + "\n3: Accuracy Potion" + "\n4: Resistance Potion" + "\n5: Close Inventory");
                        }
                        wizard.setDefense(wizard.getDefense() + Potion.ResistancePotion.getValue());
                        Potion.ResistancePotion.setQuantity(Potion.ResistancePotion.getQuantity() - 1);
                        String stats = wizard.Stats(wizard);
                        System.out.println(stats);
                        int Condtion_Vérif = 1;
                        return true;
                    }
                    case 5 -> {
                        System.out.println("You close your inventory.");
                        return Character.WizardAttacksEnemy(wizard, enemy, Timer);
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("You must use a number to choose your action.");
            }
        }
        return true;
    }
}
