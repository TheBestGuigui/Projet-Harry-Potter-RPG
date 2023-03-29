public class Spell {
    private String name;

    public Spell(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public static Spell windgardiumLeviosa = new Spell("Windgardium Leviosa");
    public static Spell accio = new Spell("Accio");
    public static Spell Expecto_patronum = new Spell("Expecto Patronum");
    public static Spell Sectumsempra = new Spell("Sectumsempra");
    public static Spell Expelliarmus = new Spell("Expelliarmus");
    public static Spell Avada_Kedavra = new Spell("Avada Kedavra");
}
