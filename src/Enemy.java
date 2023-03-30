public class Enemy {
    private String name;
    private int health_point;
    private int attack_damage;
    private int defense;

    public Enemy(String name, int health_point, int attack_damage, int defense) {
        this.name = name;
        this.health_point = health_point;
        this.attack_damage = attack_damage;
        this.defense = defense;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getHealth_point() {
        return health_point;
    }
    public void setHealth_point(int lifePoints) {
        this.health_point = health_point;
    }

    public int getAttack_damage() {
        return attack_damage;
    }
    public void setAttack_damage(int dommage) {
        this.attack_damage = attack_damage;
    }

    public int getDefense() {
        return defense;
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }

    public static Enemy troll = new Enemy("The Troll of the dungeon", 100,10, 10);
    public static Enemy basilic = new Enemy("The Basil of the Chamber of Secrets", 100, 10, 10);
    public static Enemy Dementor = new Enemy("The Dementor", 100, 10, 10);
    public static Enemy Voldemort = new Enemy("Voldemort", 100,10, 10);
    public static Enemy Peter_Pettigrow = new Enemy("Peter Pettigrow", 100, 10, 10);
    public static Enemy Dolores_Ombrage = new Enemy("Dolores Ombrage", 100, 10, 10);
    public static Enemy Death_Eater = new Enemy("The Death Eater", 100, 10, 10);
    public static Enemy Bellatrix_Lestrange = new Enemy("Bellatrix Lestrange", 100, 10, 10);
}
