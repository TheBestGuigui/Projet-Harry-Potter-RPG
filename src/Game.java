public class Game {
    private Wizard wizard;

    public static void main(String[] args) {
        Wizard wizard = new Wizard("Guillaume", new Pet(10), new Wand(1, 20), House.SLYTHERIN, new Spell("Wingardium Leviosa"), new Potion("Healing Potion"));
        String stats = wizard.Stats(wizard);
        System.out.println(stats);

        new Introduction().Introduction(wizard);
        Level_1.level1(wizard);
        if (!wizard.getIsAlive()) {
            return;
        }
    }

}