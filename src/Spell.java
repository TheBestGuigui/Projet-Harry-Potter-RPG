public class Spell {
    private String name;
    private int power;
    private int accuracy;

    public Spell(String name, int power, int accuracy) {
        this.name = name;
        this.power = power;
        this.accuracy = accuracy;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }
    public void setPower(int power) {
        this.power = power;
    }

    public int getAccuracy() {
        return accuracy;
    }
    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public static Spell Protego = new Spell("Protego", 999, 50);
    public static Spell Stupefix = new Spell("Stupefix", 20, 45);
    public static Spell WindgardiumLeviosa = new Spell("Windgardium Leviosa", 0, 40);
    public static Spell Accio = new Spell("Accio", 0, 40);
    public static Spell Expecto_patronum = new Spell("Expecto Patronum", 0, 0);
    public static Spell Sectumsempra = new Spell("Sectumsempra", 0, 0);
    public static Spell Expelliarmus = new Spell("Expelliarmus", 0, 0);
    public static Spell Avada_Kedavra = new Spell("Avada Kedavra", 999, 30);
}