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
    public void setHealth_point(int health_point) {
        this.health_point = health_point;
    }

    public int getAttack_damage() {
        return attack_damage;
    }
    public void setAttack_damage(int attack_damage) {
        this.attack_damage = attack_damage;
    }

    public int getDefense() {
        return defense;
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }

    public static Enemy troll = new Enemy("The Troll of the dungeon", 300,50, 10);
    public static Enemy basilic = new Enemy("The Basil of the Chamber of Secrets", 300, 60, 10);
    public static Enemy Dementor = new Enemy("The Dementors", 300, 70, 10);
    public static Enemy Voldemort_First_Appearance = new Enemy("Voldemort", 200,60, 20);
    public static Enemy Peter_Pettigrow = new Enemy("Peter Pettigrow", 200, 40, 10);
    public static Enemy Dolores_Ombrage = new Enemy("Dolores Ombrage", 300, 50, 10);
    public static Enemy Death_Eater = new Enemy("The Death Eater", 300, 10, 10);
    public static Enemy Bellatrix_Lestrange = new Enemy("Bellatrix Lestrange", 300, 10, 10);
}
