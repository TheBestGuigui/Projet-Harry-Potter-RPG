import java.sql.Array;
import java.util.ArrayList;

public class Game {
    private Wizard wizard;

    public static void main(String[] args) {
        ArrayList<Spell> spells = new ArrayList();
        spells.add(Spell.WindgardiumLeviosa);
        ArrayList<Potion> potions = new ArrayList();
        potions.add(Potion.HealingPotion);
        Wizard wizard = new Wizard("Guillaume", Pet.values()[10], new Wand(Core.values()[1], 20), House.SLYTHERIN, spells, potions);

        new Introduction().Introduction(wizard);

        Level_1.level1(wizard);
        if (!wizard.getIsAlive()) {
            return;
        }
    }
}