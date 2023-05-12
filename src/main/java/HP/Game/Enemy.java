package HP.Game;

public class Enemy extends AbstractEnemy{
    private String status;

    public Enemy(String name, String status, int health_point, int attack_damage, int defense) {
        super(name, health_point, health_point, attack_damage, defense);
        this.status = status;
    }


    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public static Enemy troll = new Enemy("The Troll of the dungeon", "Hostile", 300,50, 10);
    public static Enemy basilic = new Enemy("The Basil of the Chamber of Secrets", "Hostile", 300, 60, 10);
    public static Enemy Dementor = new Enemy("The Dementors", "Hostile", 300, 70, 10);
    public static Enemy Voldemort_First_Appearance = new Enemy("Voldemort", "Hostile",200,60, 30);
    public static Enemy Voldemort_Final_Appearance = new Enemy("Voldemort", "Hostile",600,80, 30);
    public static Enemy Peter_Pettigrow = new Enemy("Peter Pettigrow", "Hostile",200, 40, 10);
    public static Enemy Dolores_Ombrage = new Enemy("Dolores Ombrage", "Hostile",300, 50, 10);
    public static Enemy Death_Eater = new Enemy("The Death Eater", "Hostile",400, 60, 10);
    public static Enemy Bellatrix_Lestrange = new Enemy("Bellatrix Lestrange", "Hostile",300, 30, 10);

}
