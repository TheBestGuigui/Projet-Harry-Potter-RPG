import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

public abstract class Character {

    private final String name;
    private int health_point;
    private int max_health_point;
    private int combat_power;
    private int defense;

    private int accuracyBonus;

    private int powerBonus;

    private int efficiencyPotionsBonus;

    private int resistanceBonus;

    private int money;

    private boolean IsAlive;


    public Character(String name, int hp, int max_hp, int combat_power, int defense, int accuracyBonus, int powerBonus, int efficiencyPotionsBonus, int resistanceBonus, int money, boolean is_alive) {
        this.name = name;
        this.health_point = hp;
        this.max_health_point = max_hp;
        this.combat_power = combat_power;
        this.defense = defense;
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

    private static boolean wizardAttackTroll(Wizard wizard, Enemy enemy) {
        Scanner scanner = new Scanner(System.in);
        boolean success = false;
        boolean comeback = true;

        while (comeback) {
            String Stats = wizard.Stats(wizard);
            System.out.println(Stats);
            System.out.println("\n Vous rencontrez un " + enemy.getName() + "et il a " + enemy.getHealth_point() + " points de vie." + "\n Que faites vous ?");
            System.out.println("1: Utiliser un sort");
            System.out.println("2: Ouvrir votre inventaire");
            System.out.println("3: Essayer de vous enfuir");

            try {
                int WizardChoice = scanner.nextInt();
                scanner.nextLine();

                if (WizardChoice < 1 || WizardChoice > 4) {
                    System.out.println("You must choose a number between 1 and 3.");
                    continue;
                }

                switch (WizardChoice) {
                    case 1 -> {
                        comeback = Using_Spells(wizard, enemy);
                        if (enemy.getHealth_point() <= 0) {
                            return true;
                        }
                    }
                    case 2 -> {
                        comeback = Inventory.openInventory(wizard, enemy);
                    }

                }


            } catch (InputMismatchException e) {
                    System.out.println("Vous devez obligatoirement utiliser un nombre pour choisir votre action à effectuer.");
                scanner.next();
            }
        }
        return false;
    }



    private static boolean WizardAttacksEnemy(Wizard wizard, Enemy enemy) {
        if (enemy == Enemy.troll) {
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
        boolean enemyAlive = false;
        boolean wizardAlive = false;
        while (enemyAlive && !wizardAlive) {
            enemyAlive = WizardAttacksEnemy(wizard, enemy);
            if (enemyAlive || enemy.getHealth_point() <= 0) {
                break;
            }
            if (enemyAlive || enemy.getHealth_point() <= 0) {
                break;
            }
            wizardAlive = EnemyAttacksWizard(wizard, enemy);
        }
        if (enemyAlive || enemy.getHealth_point() <= 0) {
            System.out.println("You finally succeeded in defeating " + enemy.getName() + ", congratulations !");
        }
    }

    private static boolean WizardAttackTroll(Wizard wizard, Enemy enemy) {
        Scanner scanner = new Scanner(System.in);
        boolean WinCond = true;
        int EnemyHP = Enemy.troll.getHealth_point();
        while (EnemyHP < 0) {
            System.out.println("The battle against the Troll is on  !" + "\n The Troll has " + EnemyHP + "health points." + "\n What do you wish to do ?" + "\n 1: Use a spell." + "\n 2: Open your inventory." + "\n 3: Flee.");
            try {
                int WizardChoice = scanner.nextInt();
                scanner.nextLine();

                if (WizardChoice < 1 || WizardChoice > 3) {
                    System.out.println("You must choose a number between 1 and 3.");
                }

                switch (WizardChoice) {
                    case 1 -> {
                        WinCond = Using_Spells(wizard, enemy);
                        if (Enemy.troll.getHealth_point() <= 0) {
                            return true;
                        }
                    }
                }
                System.out.println("You are familiar with the following spells :" + "\n 1: " + "\n 2: Windgardium Leviosa");
                int SpellChosen = scanner.nextInt();
                scanner.nextLine();
                switch (SpellChosen) {
                    case 1 -> {

                    }
                    case 2 -> {

                    }
                }
            } catch(InputMismatchException e){
                System.out.println("You must use a number to choose your action.");
                scanner.nextLine();
            }
        }

    }

    private static boolean TrollAttackWizard(Wizard wizard, Enemy enemy) {
        Scanner scanner = new Scanner(System.in);
        int WizardHP = wizard.getHealth_point();
        int EnemyDamage = Enemy.troll.getAttack_damage() - (wizard.getDefense() + wizard.getResistanceBonus());
        wizard.setHealth_point(WizardHP - EnemyDamage);
        System.out.println("The Troll hits you with his club and takes " + EnemyDamage + " health points from you !");
        if (wizard.getHealth_point() <= 0) {
                System.out.println("You were killed by the Troll during your epic battle.");
                return true;
        } else {
            System.out.println("You handle the attack but you took some damage !");
        }
        return false;
    }

    private static boolean Using_Spells(Wizard wizard, Enemy enemy){
                Scanner scanner = new Scanner(System.in);
                int numSpells = wizard.getKnownSpells().size();
                System.out.println("You are familiar with the following spells :");
                for (int i = 0; i < numSpells; i++) {
                    System.out.println((i + 1) + " :" + wizard.getKnownSpells().get(i).getName());
                }
                int NumberChosen = 0;
                try {
                    NumberChosen = scanner.nextInt();
                    if (NumberChosen < 1 || NumberChosen > numSpells) {
                        System.out.println("You must choose a number between 1 and " + numSpells);
                    }
                } catch (InputMismatchException e) {
                    System.out.println("You must use a number to choose your action.");
                    scanner.next();
                }
                Spell SpellChosen = wizard.getKnownSpells().get(NumberChosen - 1);
                if (SpellChosen == Spell.Stupefix) {

                } else if (SpellChosen == Spell.Protego) {

                } else if (SpellChosen == Spell.WindgardiumLeviosa) {

                } else if (SpellChosen == Spell.WindgardiumLeviosa && Enemy.troll == enemy) {
                    Random random = new Random();
                    int nbr_random = random.nextInt(101);
                    if (nbr_random <= SpellChosen.getAccuracy()) {
                        System.out.println("You use the Wingardium Leviosa spell on the troll's club to stun it.");
                        enemy.setHealth_point(0);
                        return false;
                    } else {
                        System.out.println("You missed your spell on " + enemy.getName() + ".");
                    }

                } else if (SpellChosen == Spell.Accio && Enemy.basilic == enemy) {

                }




                return false;
            }
}

