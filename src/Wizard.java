import java.util.ArrayList;
import java.util.List;

public class Wizard extends Character{
    private String name;
    private Pet pet;
    private Wand wand;
    private House house;
    private List<AbstractSpell> knownspells;
    private List<Potion> potions;

    public String Stats(String name, int hp, int max_hp, int defense, int power, int potion_efficiency, int money) {
        return "\n Your Statistics :" + "\n Name :" + name + "\n Health Points :" + hp + "/" + max_hp + "\n Defense :" + defense + "\n Combat Power :" + power + "\n Potion Efficiency :" + potion_efficiency + "\n Money :" + money + "€";
    }

    public Wizard(String name, Pet pet, Wand wand, House house, AbstractSpell knownspells, Potion potions) {
            super(name, 500,500, 0 , 0 , 0 , 0, 200, true);
            this.name = name;
            this.pet = pet;
            this.wand = wand;
            this.house = house;
            this.knownspells = knownspells;
            this.potions = potions;
        }

        public void is_alive () {
            if (Wizard.getHealth_point() <= 0) {
                Wizard.setIsAlive(false);
            }
        }

        public Wizard(String name, Pet pet, Wand wand, House house) {
            this(name, pet, wand, house, new ArrayList<>(), new ArrayList<>());
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
        return knownSpells;
    }
    public void setKnownSpells(List<Spell> knownSpells) {
        this.knownSpells = knownSpells;
    }
    public void addSpell(Spell spell) {
        this.knownSpells.add(spell);
    }

    public List<Potion> getPotions() {
        return potions;
    }
    public void setPotions(List<Potion> potions) {
        this.potions = potions;
    }
    public void addPotion(Potion potion) {
        this.potions.add(potion);
    }
}

