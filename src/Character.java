import java.util.Scanner;
import java.util.InputMismatchException;
import Levels.Level_1;
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


    public Character(String name, int hp, int max_hp, int combat_power, defense, int accuracyBonus, int powerBonus, int efficiencyPotionsBonus, int resistanceBonus, int money, boolean is_alive) {
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
            String Stats = wizard.Stats(wizard.getName(), wizard.getHealth_point(), wizard.getResistanceBonus(), wizard.getPowerBonus(), wizard.getAccuracyBonus(), wizard.getEfficiencyPotionsBonus(), wizard.getMoney());
            System.out.println(Stats);
            System.out.println("\n Vous rencontrez un " + enemy.getName() + "et il a " + enemy.getHealth_point() + " points de vie." + "\n Que faites vous ?");
            System.out.println("1: Utiliser un sort");
            System.out.println("2: Ouvrir votre inventaire");
            System.out.println("3: Essayer de vous enfuir");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice < 1 || choice > 4) {
                    System.out.println("Vous devez choisir un nombre compris entre 1 et 3.");
                    continue;
                }

                switch (choice) {
                    case 1 -> {
                        comeback = spellList(wizard, enemy);
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
            if (enemy.getDistance() == 1 && Level2.tooth) {
                System.out.println("Vous ramassez la dent du basilic pour le frappez ce qui lui enlève 50 points de vie.");
                enemy.setLifePoints(enemy.getLifePoints() - 50 - (50 * wizard.getPowerBonus()) / 100);
                if (enemy.getLifePoints() > 0) {
                    System.out.println("mais celui-ci riposte,vous lâchez la dents et vous êtes repoussé d'un mètre.");
                    enemy.setDistance(2);
                } else {
                    return true;
                }


            }
        }
        return false;
    }



    private static boolean WizardAttacksEnemy(Wizard wizard, Enemy enemy) {
        if (enemy == Enemy.troll) {
            return WizardAttackTroll(wizard, enemy);
        } else if (enemy == Enemy.basilic) {
            return WizardAttackBasilic(wizard, enemy);
        } else if (enemy == ) {

        }
        return false;
    }

    private static boolean EnemyAttacksWizard(Wizard wizard, Enemy enemy) {
        if (enemy == Enemy.troll) {
            return TrollAttackWizard(wizard, enemy);
        } else if (enemy == Enemy.basilic) {
            return BasilicAttackWizard(wizard, enemy);
        } else if (enemy == ) {

        }
        return false;
    }

    public static void Fight_enemy(Wizard wizard, Enemy enemy) {
        boolean enemyAlive = false;
        boolean wizardAlive = false;
        while (enemyAlive && !wizardAlive) {
            enemyAlive = WizardAttacksEnemy(wizard, enemy);
            if (enemy.getDistance() < 1) {
                wizardAlive = true;
                break;
            }
            if (enemyAlive || enemy.getHealth_point() <= 0) {
                break;
            }
            for (int i = 0; i < listFriendsWithYou.size(); i++) {
                System.out.println("\nVotre ami " + listFriendsWithYou.get(i).getName() + " peut aussi attaquer le " + enemy.getName() + ".");
                enemyAlive = WizardAttacksEnemy(wizard, enemy);
                if (enemy.getDistance() < 1) {
                    wizardAlive = true;
                    break;
                }
                if (enemyAlive) {
                    break;
                }
            }
            if (enemy.getDistance() < 1) {
                wizardAlive = true;
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
        int EnemyHP = Enemy.troll.getHealth_point();
        int YourDamage = (wizard.getCombat_power() + wizard.getPowerBonus()) - Enemy.troll.getDefense();
        Enemy.setHealth_point(EnemyHP - YourDamage);
        System.out.println("" + YourDamage + "");
        if (Enemy.troll.getHealth_point() <= 0) {
            System.out.println("");
            return true;
        } else {
        System.out.println("");
        }
        return false;
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

    private static boolean spellList(Wizard wizard, Enemy enemy) {
        int numSpells = wizard.getKnownSpells().size();
        if (numSpells == 0) {
            System.out.println("Vous n'avez appris aucun sort.");
            return true;
        } else {
            System.out.println(ConsoleColors.BLUE + "\nVeuillez choisir un sort :" + ConsoleColors.RESET);
            for (int i = 0; i < numSpells; i++) {
                System.out.println((i + 1) + " : " + wizard.getKnownSpells().get(i).getName());
            }
            System.out.println((numSpells + 1) + " : Ne pas utiliser de sort.");
            int choice = -1;
            do {
                Scanner scanner = new Scanner(System.in);
                try {
                    choice = scanner.nextInt();
                    if (choice < 1 || choice > numSpells + 1) {
                        System.out.println("Veuillez entrer un choix valide.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Veuillez entrer un choix valide.");
                    scanner.next();
                }
            } while (choice < 1 || choice > numSpells + 1);
            if (choice == numSpells + 1) {
                return true;
            }
            Spell chosenSpell = wizard.getKnownSpells().get(choice - 1);
            System.out.println("Vous avez choisi le sort " + chosenSpell.getName() + ".");
            if (chosenSpell == Spell.windgardiumLeviosa && Enemy.troll == enemy) {
                int chanceOfSuccess = 0;
                if (enemy.getDistance() <= 7) {
                    System.out.println("Vous utilisez Windgardium Leviosa sur la massue du troll !");
                    chanceOfSuccess = 100 - (enemy.getDistance() * 5) + wizard.getAccuracyBonus();
                    System.out.println("Vous êtes à " + enemy.getDistance() + " mètres du troll. Votre chance de réussite est de " + chanceOfSuccess + "%.");
                    Random random = new Random();
                    int randomValue = random.nextInt(101);
                    if (randomValue <= chanceOfSuccess) {
                        System.out.println("Votre sort atteint la massue du troll, vous diriger alors la massue plusieurs mètres au dessus de ca tete et la laisser tombé ce qui assomme le troll.");
                        enemy.setLifePoints(0);
                        return true;
                    } else {
                        System.out.println("Vous ratez votre sort de justesse.");
                    }
                } else {
                    System.out.println("Vous êtes à " + enemy.getDistance() + " mètres du troll. Votre chance de réussite est de " + chanceOfSuccess + "%., si vous aviez mieux écouter le cours vous sauriez que pour utiliser Windgarium leviosa \nil faut etre à 7 mètres ou moins pour que le sort est une chance de reussir et que plus vous etes proche plus vous augementer vos chances.");
                }
            } else if (chosenSpell == Spell.aloomora) {
                //effet aloomora
            } else if (chosenSpell == Spell.immobulus) {
                // effet imobulus
            } else if (chosenSpell == Spell.accio && enemy == Enemy.basilic) {
                int chanceOfSuccess = 0;
                if (enemy.getDistance() <= 7) {
                    System.out.println("Vous utilisez Accio en visant la machoire du basilic !");
                    chanceOfSuccess = 100 - (enemy.getDistance() * 5) + wizard.getAccuracyBonus();
                    System.out.println("Vous êtes à " + enemy.getDistance() + " mètres du basilic. Votre chance de réussite est de " + chanceOfSuccess + "%.");
                    Random random = new Random();
                    int randomValue = random.nextInt(101);
                    if (randomValue <= chanceOfSuccess) {
                        System.out.println("Votre sort atteint les dents du basilic, une d'entre elles se décroche commence à venir vers vous mais vous la faite tomber au sol à 1m du basilic.");
                        Level2.tooth = true;
                        return true;
                    } else {
                        System.out.println("Vous ratez votre sort de justesse.");
                    }
                }
            }
            System.out.println("Votre sort n'a rien fait au " + enemy.getName());
        }
        return false;
}
