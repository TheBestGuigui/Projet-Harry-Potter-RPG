public class Potion {
    private String name;
    private String type;
    private int effect_value;
    private int cost;

    public Potion(String name, String type, int value, int cost) {
        this.name = name;
        this.type = type;
        this.effect_value = value;
        this.cost = cost;
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

    public int getValue() {
        return effect_value;
    }

    public void setValue(int value) {
        this.effect_value = value;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public static Potion potionHeal = new Potion("Healing Potion", "heal", 20, 10);
    public static Potion potionDamage = new Potion("Damaging Potion", "damage", 10, 20);
    public static Potion potionPrecision = new Potion("Accuracy Potion", "accuracy", 5, 20);
    public static Potion potionResistance = new Potion("Resistance Potion", "resistance", 5, 30);
}

