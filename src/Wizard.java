import java.util.ArrayList;
import java.util.List;

public class Wizard extends Character {
    private String name;
    private Pet pet;
    private Wand wand;
    private House house;
    private List<Spell> knownspells;
    private List<Potion> potions;

    public Wizard(String name, Pet pet, Wand wand, House house, Spell knownspells, Potion potions) {
            super(name, 500,500, 20 , 20 , 0 , 0, 0, 0, 200, true);
            this.name = name;
            this.pet = pet;
            this.wand = wand;
            this.house = house;
            this.knownspells = new ArrayList<Spell>();
            this.knownspells.add(knownspell);
            this.potions = new ArrayList<Potion>();
            this.potions.add(potion);
        }

    public Wizard(String name, Pet pet, Wand wand, House house) {
        super();
        this.name = name;
        this.pet = pet;
        this.wand = wand;
        this.house = house;
        this.knownspells = new ArrayList<Spell>();
        this.potions = new ArrayList<Potion>();
    }

    public String Stats(Wizard wizard) {
        return "\n Your Statistics :" + "\n Name :" + wizard.getName() + "\n Health Points :" + wizard.getHealth_point() + "/" + wizard.getMax_Health_point() + "\n Defense :" + wizard.getDefense() + "\n Combat Power :" + wizard.getCombat_power() + "\n Potion Efficiency :" + wizard.getEfficiencyPotionsBonus() + "\n Money :" + wizard.getMoney() + "€";
    }

    public void is_alive(Wizard wizard) {
        if (wizard.getHealth_point() <= 0) {
            wizard.setIsAlive(false);
        }
    }

    @Override
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Pet getPet() {
        return pet;
    }
    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Wand getWand() {
        return wand;
    }
    public void setWand(Wand wand) {
        this.wand = wand;
    }

    public House getHouse() {
        return house;
    }
    public void setHouse(House house) {
        this.house = house;
    }

    public List<Spell> getKnownSpells() {
        return knownspells;
    }
    public void setKnownSpells(List<Spell> knownSpells) {
        this.knownspells = knownSpells;
    }
    public void addSpell(Spell spell) {
        this.knownspells.add(spell);
    }

    public List<Potion> getPotions() {
        return potions;
    }
    public void setPotions(List<Potion> potions) {
        this.potions = potions;
    }
}

