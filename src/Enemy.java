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

    public static Enemy troll = new Enemy("Troll des montagnes", "Troll", 100, 10, 30);
    public static Enemy basilic = new Enemy("Basilic de Salazar Serpentard", "Basilic", 100, 3, 20);
}
