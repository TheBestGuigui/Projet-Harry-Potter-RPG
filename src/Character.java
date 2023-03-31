import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

public abstract class Character {

    private final String name;
    private int health_point;
    private int max_health_point;
    private int combat_power;
    private int defense;
    private int accuracy;

    private int accuracyBonus;

    private int powerBonus;

    private int efficiencyPotionsBonus;

    private int resistanceBonus;

    private int money;

    private boolean IsAlive;


    public Character(String name, int hp, int max_hp, int combat_power, int defense, int accuracy, int accuracyBonus, int powerBonus, int efficiencyPotionsBonus, int resistanceBonus, int money, boolean is_alive) {
        this.name = name;
        this.health_point = hp;
        this.max_health_point = max_hp;
        this.combat_power = combat_power;
        this.defense = defense;
        this.accuracy = accuracy;
        this.accuracyBonus = accuracyBonus;
        this.powerBonus = powerBonus;
        this.efficiencyPotionsBonus = efficiencyPotionsBonus;
        this.resistanceBonus = resistanceBonus;
        this.money = money;
        this.IsAlive = is_alive;
    }

    public String getName() {
        return name;
    }

    public int getHealth_point() {
        return health_point;
    }
    public void setHealth_point(int hp) {
        this.health_point = hp;
    }

    public int getMax_Health_point() {
        return max_health_point;
    }
    public void setMax_Health_point(int max_hp) {
        this.max_health_point = max_hp;
    }

    public int getCombat_power() {
        return combat_power;
    }
    public void setCombat_power(int combat_power) {
        this.combat_power = combat_power;
    }

    public int getDefense() {
        return defense;
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getAccuracy() {
        return accuracy;
    }
    public void setAccuracy(int accuracy) {
            this.accuracy = accuracy;
    }

    public int getEfficiencyPotionsBonus() {
        return efficiencyPotionsBonus;
    }
    public void setEfficiencyPotionsBonus(int efficiencyPotionsBonus) {
        this.efficiencyPotionsBonus = efficiencyPotionsBonus;
    }

    public int getPowerBonus() {
        return powerBonus;
    }
    public void setPowerBonus(int PowerBonus) {
        this.powerBonus = PowerBonus;
    }

    public int getResistanceBonus() {
        return resistanceBonus;
    }
    public void setResistanceBonus(int ResistanceBonus) {
        this.resistanceBonus = ResistanceBonus;
    }

    public int getAccuracyBonus() {
        return accuracyBonus;
    }
    public void setAccuracyBonus(int AccuracyBonus) {
        this.accuracyBonus = AccuracyBonus;
    }

    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }

    public boolean getIsAlive() {
        return IsAlive;
    }

    public void setIsAlive(boolean alive) {
        IsAlive = alive;
    }

    public static boolean WizardAttacksEnemy(Wizard wizard, Enemy enemy) {
        if (enemy.getName() == Enemy.troll.getName()) {
            return WizardAttackTroll(wizard, enemy);
        }
        return false;
    }

    private static boolean EnemyAttacksWizard(Wizard wizard, Enemy enemy) {
        if (enemy == Enemy.troll) {
            return TrollAttackWizard(wizard, enemy);
        }
        return false;
    }

    public static void Fight_enemy(Wizard wizard, Enemy enemy) {
        boolean enemyAlive = true;
        boolean wizardAlive = true;
        while (enemyAlive && wizardAlive) {
            enemyAlive = WizardAttacksEnemy(wizard, enemy);
            if (enemy.getHealth_point() <= 0) {
                System.out.println("You finally succeeded in defeating " + enemy.getName() + ", congratulations !");
                break;
            }
            wizardAlive = EnemyAttacksWizard(wizard, enemy);
        }
    }

    private static boolean WizardAttackTroll(Wizard wizard, Enemy enemy) {
        Scanner scanner = new Scanner(System.in);
        int EnemyHP = enemy.getHealth_point();
        System.out.println("The battle against the Troll is on !");
        while (EnemyHP > 0) {
            System.out.println("The Troll has " + EnemyHP + " health points." + "\nWhat do you wish to do ?" + "\n1: Use a spell." + "\n2: Open your inventory." + "\n3: Flee.");
            try {
                int WizardChoice = scanner.nextInt();
                scanner.nextLine();

                if (WizardChoice < 1 || WizardChoice > 3) {
                    System.out.println("You must choose a number between 1 and 3.");
                }

                switch (WizardChoice) {
                    case 1 -> {
                        return Using_Spells(wizard, enemy);
                    }
                    case 2 -> {
                        return Inventory.openInventory(wizard, enemy);
                    }
                    case 3 -> {
                        System.out.println("You can't flee a fight against a boss !");
                    }
                }
            } catch(InputMismatchException e){
                System.out.println("You must use a number to choose your action.");
            }
        }
        return false;
    }

    private static boolean TrollAttackWizard(Wizard wizard, Enemy enemy) {
        Scanner scanner = new Scanner(System.in);
        int WizardHP = wizard.getHealth_point();
        int EnemyDamage = Enemy.troll.getAttack_damage() - (wizard.getDefense() + wizard.getResistanceBonus());
        wizard.setHealth_point(WizardHP - EnemyDamage);
        System.out.println("The Troll hits you with his club and takes " + EnemyDamage + " health points away from you !");
        if (wizard.getHealth_point() <= 0) {
                System.out.println("You were killed by the Troll during your epic battle.");
                return false;
        } else {
            System.out.println("You handle the attack but you took some damage !" + "\nYou now have " + wizard.getHealth_point() + " health points remaining.");
        }
        return true;
    }

    private static boolean Using_Spells(Wizard wizard, Enemy enemy){
                Scanner scanner = new Scanner(System.in);
                int numSpells = wizard.getKnownSpells().size();
                System.out.println("You are familiar with the following spells :");
                for (int i = 0; i < numSpells; i++) {
                    System.out.println((i + 1) + ": " + wizard.getKnownSpells().get(i).getName());
                }
                int NumberChosen = 0;
                try {
                    NumberChosen = scanner.nextInt();
                    if (NumberChosen < 1 || NumberChosen > numSpells) {
                        System.out.println("You must choose a number between 1 and " + numSpells);
                    }
                } catch (InputMismatchException e) {
                    System.out.println("You must use a number to choose your action.");
                }
                Spell SpellChosen = wizard.getKnownSpells().get(NumberChosen - 1);
                if (SpellChosen.getName() == Spell.Stupefix.getName()) {
                    return false;
                } else if (SpellChosen.getName() == Spell.Protego.getName()) {
                    return false;
                } else if (SpellChosen.getName() == Spell.WindgardiumLeviosa.getName() && Enemy.troll.getName() == enemy.getName()) {
                    Random random = new Random();
                    int nbr_random = random.nextInt(101);
                    int Accuracy = wizard.getAccuracy() + SpellChosen.getAccuracy();
                    if (nbr_random <= Accuracy) {
                        System.out.println("You use the Wingardium Leviosa spell on the troll's club to stun it.");
                        enemy.setHealth_point(0);
                        return false;
                    } else {
                        System.out.println("You missed your spell on " + enemy.getName() + ".");
                        return true;
                    }

                } else if (SpellChosen == Spell.Accio && Enemy.basilic == enemy) {

                }




                return true;
            }
}

