public class Game {
    private Wizard wizard;

    public static void main(String[] args) {
        Wizard wizard = new Wizard(null, null, null, null);

        new Introduction().Introduction(wizard);
        Level_1.level1(wizard);
        if (!wizard.getIsAlive()) {
            return;
        }
    }

}