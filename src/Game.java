public class Game {
    private Wizard wizard;

    public static void main(String[] args) {
        Wizard wizard = new Wizard("Guillaume", Pet.values()[10], new Wand(Core.values()[1], 20), House.SLYTHERIN, wizard.getKnownSpells().get(1), wizard.getPotions().get(0));
        String stats = wizard.Stats(wizard);
        System.out.println(stats);

        new Introduction().Introduction(wizard);
        Level_1.level1(wizard);
        if (!wizard.getIsAlive()) {
            return;
        }
    }
}