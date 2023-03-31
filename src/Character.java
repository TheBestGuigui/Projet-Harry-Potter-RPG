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

    public static boolean WizardAttacksEnemy(Wizard wizard, Enemy enemy, int Timer) {
        if (enemy.getName() == Enemy.troll.getName()) {
            return WizardAttackTroll(wizard, enemy, Timer);
        } else if (enemy == Enemy.basilic) {
            return WizardAttackBasilic(wizard, enemy, Timer);
        } else if (enemy == Enemy.Dementor) {
            return WizardAttackDementor(wizard, enemy, Timer);
        } else if (enemy == Enemy.Peter_Pettigrow) {
            return WizardAttackPeterPettigrow(wizard, enemy, Timer);
        } else if (enemy == Enemy.Voldemort_First_Appearance) {
            return WizardAttackVoldemort_First_Appearance(wizard, enemy, Timer);
        } else if (enemy == Enemy.Dolores_Ombrage) {
            return WizardAttackDolores_Ombrage(wizard, enemy, Timer);
        }
        return false;
    }

    private static boolean EnemyAttacksWizard(Wizard wizard, Enemy enemy) {
        if (enemy == Enemy.troll) {
            return TrollAttackWizard(wizard, enemy);
        } else if (enemy == Enemy.basilic) {
            return BasilicAttackWizard(wizard, enemy);
        } else if (enemy == Enemy.Dementor) {
            return DementorAttackWizard(wizard, enemy);
        } else if (enemy == Enemy.Peter_Pettigrow) {
            return PeterPettigrowAttackWizard(wizard, enemy);
        } else if (enemy == Enemy.Voldemort_First_Appearance) {
            return Voldemort_First_AppearanceAttackWizard(wizard, enemy);
        } else if (enemy == Enemy.Dolores_Ombrage) {
            return DoloresAttackWizard(wizard, enemy);
        }
        return false;
    }

    public static void Fight_enemy(Wizard wizard, Enemy enemy) {
        boolean enemyAlive = true;
        boolean wizardAlive = true;
        wizard.setCombat_power(20);
        wizard.setDefense(20);
        wizard.setAccuracy(40);
        int Timer = 4;
        while (enemyAlive && wizardAlive) {
            enemyAlive = WizardAttacksEnemy(wizard, enemy, Timer);
            if (enemy.getHealth_point() <= 0) {
                System.out.println("You finally succeeded in defeating " + enemy.getName() + ", congratulations !");
                break;
            }
            if (wizard.getHealth_point() <= 0) {
                System.out.println("You got killed by " + enemy.getName() + "." + "\nGame Over !");
                break;
            }
            wizardAlive = EnemyAttacksWizard(wizard, enemy);
            if (wizard.getHealth_point() <= 0) {
                System.out.println("You got killed by " + enemy.getName() + "." + "\nGame Over !");
                break;
            }
            Timer--;
        }
    }

    public static void Fight_enemies(Wizard wizard, Enemy enemy1, Enemy enemy2) {
        boolean enemy1Alive = true;
        boolean enemy2Alive = true;
        boolean wizard1Alive = true;
        boolean wizard2Alive = true;
        wizard.setCombat_power(20);
        wizard.setDefense(20);
        wizard.setAccuracy(40);
        int Timer = 4;
        while ((enemy1Alive || enemy2Alive) && wizard2Alive) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("There are two enemies in front of you but you can only target one, which one do you choose to target ?" + "\n1: " +enemy1.getName() + "\n2: " +enemy2.getName());
            int target = 0;
            try {
                target = scanner.nextInt();
                if (target < 1 || target > 2) {
                    System.out.println("You must choose a number between 1 and 2.");
                } else if (target == 1 && enemy1.getHealth_point() > 0) {
                    enemy1Alive = WizardAttacksEnemy(wizard, enemy1, Timer);
                } else if (target == 1 && enemy1.getHealth_point() <= 0) {
                    System.out.println(enemy1.getName() + " has already been defeated !" + "\nYou should target a different enemy.");
                } else if (target == 2 && enemy2.getHealth_point() > 0) {
                    enemy2Alive = WizardAttacksEnemy(wizard, enemy2, Timer);
                } else if (target == 2 && enemy2.getHealth_point() <= 0) {
                    System.out.println(enemy2.getName() + " has already been defeated !" + "\nYou should target a different enemy.");
                }
            } catch (InputMismatchException e) {
                System.out.println("You must use a number to choose your action.");
            }
            if (enemy1.getHealth_point() <= 0 && enemy1.getHealth_point() > 0) {
                System.out.println("You finally succeeded in defeating " + enemy1.getName() + ", congratulations !" + "\n But there is still " + enemy2.getName() + " to overcome !");
            } else if (enemy1.getHealth_point() > 0 && enemy1.getHealth_point() <= 0) {
                System.out.println("You finally succeeded in defeating " + enemy2.getName() + ", congratulations !" + "\n But there is still " + enemy1.getName() + " to overcome !");
            } else if (enemy1.getHealth_point() <= 0 && enemy1.getHealth_point() <= 0) {
                System.out.println("You finally succeeded in defeating " + enemy1.getName() + " and " + enemy2.getName() + ", congratulations !");
                break;
            }
            wizard1Alive = EnemyAttacksWizard(wizard, enemy1);
            wizard2Alive = EnemyAttacksWizard(wizard, enemy2);
        }
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
            Random random = new Random();
            int nbr_random = random.nextInt(101);
            int Accuracy = wizard.getAccuracy() + SpellChosen.getAccuracy();
            if (nbr_random <= Accuracy) {
                enemy.setHealth_point(enemy.getHealth_point() - (wizard.getCombat_power() + wizard.getPowerBonus() + SpellChosen.getPower()));
                System.out.println("You used the " + SpellChosen.getName() + " spell on " + enemy.getName() + " and took " + (wizard.getCombat_power() + wizard.getPowerBonus() + SpellChosen.getPower()) + " health points away from him/her.");
                return true;
            } else {
                System.out.println("You missed your spell on " + enemy.getName() + ".");
                return true;
            }
        } else if (SpellChosen.getName() == Spell.Protego.getName()) {
            Random random = new Random();
            int nbr_random = random.nextInt(101);
            int Accuracy = wizard.getAccuracy() + SpellChosen.getAccuracy();
            if (nbr_random <= Accuracy) {
                System.out.println("You used the " + SpellChosen.getName() + " spell to protect yourself.");
                wizard.setDefense(wizard.getDefense() + SpellChosen.getPower());
                return true;
            } else {
                System.out.println("You failed to protect yourself using the " + SpellChosen.getName() + " spell.");
                return true;
            }
        } else if (SpellChosen.getName() == Spell.WindgardiumLeviosa.getName() && Enemy.troll.getName() == enemy.getName()) {
            Random random = new Random();
            int nbr_random = random.nextInt(101);
            int Accuracy = wizard.getAccuracy() + SpellChosen.getAccuracy();
            if (nbr_random <= Accuracy) {
                System.out.println("You use the Wingardium Leviosa spell on the troll's club to stun it.");
                enemy.setHealth_point(0);
                System.out.println("You have also learned a new spell: 'Accio' which allows you to attract objects to you.");
                wizard.addSpell(Spell.Accio);
                return false;
            } else {
                System.out.println("You missed your spell on " + enemy.getName() + ".");
                return true;
            }
        } else if (SpellChosen.getName() == Spell.Accio.getName() && Enemy.basilic.getName() == enemy.getName()) {
            Random random = new Random();
            int nbr_random = random.nextInt(101);
            int Accuracy = wizard.getAccuracy() + SpellChosen.getAccuracy();
            if (nbr_random <= Accuracy) {
                System.out.println("You use the Accio spell on the Basilisk's fang and use it to kill it.");
                enemy.setHealth_point(0);
                System.out.println("You have also learned a new spell: 'Expecto Patronum' which allows you to summon your patronus to protect you");
                wizard.addSpell(Spell.Expecto_patronum);
                return false;
            } else {
                System.out.println("You missed your spell on " + enemy.getName() + ".");
                return true;
            }
        } else if (SpellChosen.getName() == Spell.Expecto_patronum.getName() && Enemy.Dementor.getName() == enemy.getName()) {
            Random random = new Random();
            int nbr_random = random.nextInt(101);
            int Accuracy = wizard.getAccuracy() + SpellChosen.getAccuracy();
            if (nbr_random <= Accuracy) {
                System.out.println("You used the Expecto Patronum spell to summon your Patronus and put the Dementors on the run.");
                enemy.setHealth_point(0);
                System.out.println("Unfortunately, you did not learn a new spell this time.");
                return false;
            } else {
                System.out.println("You missed your spell on " + enemy.getName() + ".");
                return true;
            }
        } else if (SpellChosen.getName() == Spell.Accio.getName() && Enemy.Peter_Pettigrow.getName() == enemy.getName()) {
            Random random = new Random();
            int nbr_random = random.nextInt(101);
            int Accuracy = wizard.getAccuracy() + SpellChosen.getAccuracy();
            if (nbr_random <= Accuracy) {
                System.out.println("You used the Accio spell on the Portoloin to draw it to you and use it to escape.");
                enemy.setHealth_point(0);
                System.out.println("Unfortunately, you did not learn a new spell this time.");
                return false;
            } else {
                System.out.println("You missed your spell on the Portoloin.");
                return true;
            }
        } else if (SpellChosen.getName() == Spell.Accio.getName() && Enemy.Voldemort_First_Appearance.getName() == enemy.getName()) {
            Random random = new Random();
            int nbr_random = random.nextInt(101);
            int Accuracy = wizard.getAccuracy() + SpellChosen.getAccuracy();
            if (nbr_random <= Accuracy) {
                System.out.println("You used the Accio spell on the Portoloin to draw it to you and use it to escape.");
                enemy.setHealth_point(0);
                System.out.println("Unfortunately, you did not learn a new spell this time.");
                return false;
            } else {
                System.out.println("You missed your spell on the Portoloin.");
                return true;
            }
        }




        return true;
    }

    private static boolean WizardAttackTroll(Wizard wizard, Enemy enemy, int Timer) {
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
                        return Inventory.openInventory(wizard, enemy, Timer);
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

    private static boolean WizardAttackBasilic(Wizard wizard, Enemy enemy, int Timer) {
        Scanner scanner = new Scanner(System.in);
        int EnemyHP = enemy.getHealth_point();
        System.out.println("The battle against the Basilisk is on !");
        while (EnemyHP > 0) {
            System.out.println("The Basilisk has " + EnemyHP + " health points." + "\nWhat do you wish to do ?" + "\n1: Use a spell." + "\n2: Open your inventory." + "\n3: Flee.");
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
                        return Inventory.openInventory(wizard, enemy, Timer);
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

    private static boolean WizardAttackDementor(Wizard wizard, Enemy enemy, int Timer) {
        Scanner scanner = new Scanner(System.in);
        int EnemyHP = enemy.getHealth_point();
        System.out.println("The battle against the Dementors is on !");
        while (EnemyHP > 0) {
            System.out.println("The Dementors have " + EnemyHP + " health points." + "\nWhat do you wish to do ?" + "\n1: Use a spell." + "\n2: Open your inventory." + "\n3: Flee.");
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
                        return Inventory.openInventory(wizard, enemy, Timer);
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

    private static boolean WizardAttackPeterPettigrow(Wizard wizard, Enemy enemy, int Timer) {
        Scanner scanner = new Scanner(System.in);
        int EnemyHP = enemy.getHealth_point();
        System.out.println("The battle against Peter Pettigrow is on !");
        while (EnemyHP > 0) {
            System.out.println("Peter Pettigrow has " + EnemyHP + " health points." + "\nWhat do you wish to do ?" + "\n1: Use a spell." + "\n2: Open your inventory." + "\n3: Flee.");
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
                        return Inventory.openInventory(wizard, enemy, Timer);
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

    private static boolean WizardAttackVoldemort_First_Appearance(Wizard wizard, Enemy enemy, int Timer) {
        Scanner scanner = new Scanner(System.in);
        int EnemyHP = enemy.getHealth_point();
        System.out.println("The battle against Voldemort is on !");
        while (EnemyHP > 0) {
            System.out.println("Voldemort has " + EnemyHP + " health points." + "\nWhat do you wish to do ?" + "\n1: Use a spell." + "\n2: Open your inventory." + "\n3: Flee.");
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
                        return Inventory.openInventory(wizard, enemy, Timer);
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

    private static boolean WizardAttackDolores_Ombrage(Wizard wizard, Enemy enemy, int Timer) {
        Scanner scanner = new Scanner(System.in);
        int EnemyHP = enemy.getHealth_point();
        while (EnemyHP > 0) {
            if (Timer == 1) {
                System.out.println("The fireworks are now within your reach, you catch them. Do you want to use them ?" + "\n1: Yes" + "\n2: No");
                int FireworksChoice = scanner.nextInt();
                try {
                    if (FireworksChoice < 1 || FireworksChoice > 2) {
                        System.out.println("You must choose a number between 1 and 2.");
                    }
                    switch (FireworksChoice) {
                        case 1 -> {
                            System.out.println("You use the fireworks and manage to defeat Dolores Ombrage.");
                            enemy.setHealth_point(0);
                            System.out.println("You have also learned a new spell: 'Sectumsempra' which causes a cut which will not heal ever on your target.");
                            wizard.addSpell(Spell.Sectumsempra);
                            return false;
                        }
                        case 2 -> {
                            System.out.println("You do not use the fireworks.");
                            return true;
                        }
                    }
                } catch(InputMismatchException e){
                    System.out.println("You must use a number to choose your action.");
                }

            } else if (Timer < 1) {
                System.out.println("You chose not to use the fireworks in the previous turn and Dolores Umbridge ended up killing you.");
                wizard.setHealth_point(0);
                return false;
            } else {
                System.out.println("The battle against Dolores Ombrage is on !");
                System.out.println("The fireworks glide slowly towards you, they are " + Timer + " meters away from you.");
                System.out.println("Dolores Ombrage has " + EnemyHP + " health points." + "\nWhat do you wish to do ?" + "\n1: Use a spell." + "\n2: Open your inventory." + "\n3: Flee.");
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
                            return Inventory.openInventory(wizard, enemy, Timer);
                        }
                        case 3 -> {
                            System.out.println("You can't flee a fight against a boss !");
                        }
                    }
                } catch(InputMismatchException e){
                    System.out.println("You must use a number to choose your action.");
                }
            }
        }
        return false;
    }

    private static boolean TrollAttackWizard(Wizard wizard, Enemy enemy) {
        Scanner scanner = new Scanner(System.in);
        int WizardHP = wizard.getHealth_point();
        int EnemyDamage = Enemy.troll.getAttack_damage() - (wizard.getDefense() + wizard.getResistanceBonus());
        if (EnemyDamage >= 0) {
            wizard.setHealth_point(WizardHP - EnemyDamage);
        } else {
            EnemyDamage = 0;
        }
        System.out.println("The Troll hits you with his club and takes " + EnemyDamage + " health points away from you !");
        if (wizard.getHealth_point() <= 0) {
                System.out.println("You were killed by the Troll during your epic battle.");
                return false;
        } else {
            System.out.println("You now have " + wizard.getHealth_point() + " health points remaining.");
        }
        return true;
    }

    private static boolean BasilicAttackWizard(Wizard wizard, Enemy enemy) {
        Scanner scanner = new Scanner(System.in);
        int WizardHP = wizard.getHealth_point();
        int EnemyDamage = Enemy.basilic.getAttack_damage() - (wizard.getDefense() + wizard.getResistanceBonus());
        if (EnemyDamage >= 0) {
            wizard.setHealth_point(WizardHP - EnemyDamage);
        } else {
            EnemyDamage = 0;
        }
        System.out.println("The Basilisk strikes you with its tail and takes " + EnemyDamage + " health points away from you !");
        if (wizard.getHealth_point() <= 0) {
            System.out.println("You were killed by the Basilisk during your epic battle.");
            return false;
        } else {
            System.out.println("You now have " + wizard.getHealth_point() + " health points remaining.");
        }
        return true;
    }

    private static boolean DementorAttackWizard(Wizard wizard, Enemy enemy) {
        Scanner scanner = new Scanner(System.in);
        int WizardHP = wizard.getHealth_point();
        int EnemyDamage = Enemy.Dementor.getAttack_damage() - (wizard.getDefense() + wizard.getResistanceBonus());
        if (EnemyDamage >= 0) {
            wizard.setHealth_point(WizardHP - EnemyDamage);
        } else {
            EnemyDamage = 0;
        }
        System.out.println("The Dementors are trying to suck out your soul and take " + EnemyDamage + " health points away from you !");
        if (wizard.getHealth_point() <= 0) {
            System.out.println("You were killed by the Dementors during your epic battle.");
            return false;
        } else {
            System.out.println("You now have " + wizard.getHealth_point() + " health points remaining.");
        }
        return true;
    }

    private static boolean PeterPettigrowAttackWizard(Wizard wizard, Enemy enemy) {
        Scanner scanner = new Scanner(System.in);
        int WizardHP = wizard.getHealth_point();
        int EnemyDamage = Enemy.Peter_Pettigrow.getAttack_damage() - (wizard.getDefense() + wizard.getResistanceBonus());
        if (EnemyDamage >= 0) {
            wizard.setHealth_point(WizardHP - EnemyDamage);
        } else {
            EnemyDamage = 0;
        }
        System.out.println("Peter Pettigrow uses the Stupefix spell against you and takes " + EnemyDamage + " health points away from you !");
        if (wizard.getHealth_point() <= 0) {
            System.out.println("You were killed by Peter Pettigrow during your epic battle.");
            return false;
        } else {
            System.out.println("You now have " + wizard.getHealth_point() + " health points remaining.");
        }
        return true;
    }

    private static boolean Voldemort_First_AppearanceAttackWizard(Wizard wizard, Enemy enemy) {
        Scanner scanner = new Scanner(System.in);
        int WizardHP = wizard.getHealth_point();
        int EnemyDamage = Enemy.Voldemort_First_Appearance.getAttack_damage() - (wizard.getDefense() + wizard.getResistanceBonus());
        if (EnemyDamage >= 0) {
            wizard.setHealth_point(WizardHP - EnemyDamage);
        } else {
            EnemyDamage = 0;
        }
        System.out.println("Voldemort uses the Stupefix spell against you and takes " + EnemyDamage + " health points away from you !");
        if (wizard.getHealth_point() <= 0) {
            System.out.println("You were killed by Voldemort during your epic battle.");
            return false;
        } else {
            System.out.println("You now have " + wizard.getHealth_point() + " health points remaining.");
        }
        return true;
    }

    private static boolean DoloresAttackWizard(Wizard wizard, Enemy enemy) {
        Scanner scanner = new Scanner(System.in);
        int WizardHP = wizard.getHealth_point();
        int EnemyDamage = Enemy.Dolores_Ombrage.getAttack_damage() - (wizard.getDefense() + wizard.getResistanceBonus());
        if (EnemyDamage >= 0) {
            wizard.setHealth_point(WizardHP - EnemyDamage);
        } else {
            EnemyDamage = 0;
        }
        System.out.println("Dolores Ombrage uses the Stupefix spell against you and takes " + EnemyDamage + " health points away from you !");
        if (wizard.getHealth_point() <= 0) {
            System.out.println("You were killed by Dolores Ombrage during your epic battle.");
            return false;
        } else {
            System.out.println("You now have " + wizard.getHealth_point() + " health points remaining.");
        }
        return true;
    }

}

