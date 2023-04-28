public class Potion {
    private String name;
    private String type;
    private int effect_value;
    private int quantity;

    public Potion(String name, String type, int value, int quantity) {
        this.name = name;
        this.type = type;
        this.effect_value = value;
        this.quantity = quantity;
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

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static Potion HealingPotion = new Potion("Healing Potion", "heal", 80, 5);
    public static Potion DamagingPotion = new Potion("Damaging Potion", "damage", 50, 5);
    public static Potion AccuracyPotion = new Potion("Accuracy Potion", "accuracy", 10, 5);
    public static Potion ResistancePotion = new Potion("Resistance Potion", "resistance", 20, 5);
}

