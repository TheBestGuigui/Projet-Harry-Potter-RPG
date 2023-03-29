package Game;

import Level.Introduction;
import Level.Level1;
import Level.Level2;
import Level.Level3;
import Level.Level4;
import Level.Level5;
import Level.Level6;
import Level.Level7;

public class Game {
    private Wizard wizard;

    public static void main(String[] args) {
        // initialisation
        Wizard wizard = new Wizard(null, null, null, null);

//        Wizard wizard = new Wizard("mini", Pet.Owl, new Wand(Core.DragonHeartstring, 23), House.GRYFFINDOR);
        new Introduction().Introduction(wizard);
        Level1.level1(wizard);
        if (!wizard.getIsAlive()) {
            return;
        }
        Level2.level2(wizard);
        if (!wizard.getIsAlive()) {
            return;
        }
    }

}