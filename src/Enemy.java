public class Enemy {
    private String name;
    private String type;
    private int health_point;
    private int attack_damage;

    public Enemy(String name, String type, int health_points, int attack_damage) {
        this.name = name;
        this.type = type;
        this.health_point = health_point;
        this.attack_damage = attack_damage;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
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

    public static Enemy troll = new Enemy("Troll of the dungeon", "Troll", 100, 10);
    public static Enemy basilic = new Enemy("Basil of the Chamber of Secrets", "Basilic", 100, 3);
    public static Enemy Dementor = new Enemy("Dementor", "Unknown", 100, 10);
    public static Enemy Voldemort = new Enemy("Voldemort", "Unknown", 100, 10);
    public static Enemy Peter_Pettigrow = new Enemy("Peter Pettigrow", "Human", 100, 10);
    public static Enemy Dolores_Ombrage = new Enemy("Dolores Ombrage", "Human", 100, 10);
    public static Enemy Death_Eater = new Enemy("Death Eater", "Unknown", 100, 10);
    public static Enemy Bellatrix_Lestrange = new Enemy("Bellatrix Lestrange", "Human", 100, 10);
}
