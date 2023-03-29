package Game;

import Level.Introduction;
import Level.Level1;
import Level.Level2;
import Level.Level3;
import Level.Level4;
import Level.Level5;
import Level.Level6;
import Level.Level7;
import Levels.*;

public class Game {
    private Wizard wizard;

    public static void main(String[] args) {
        // initialisation
        Wizard wizard = new wizard(null, null, null, null);

//        Wizard wizard = new Wizard("mini", Pet.Owl, new Wand(Core.DragonHeartstring, 23), House.GRYFFINDOR);
        new Introduction().Introduction(wizard);
        Level_1.level1(wizard);
        if (!wizard.getIsAlive()) {
            return;
        }
        Level_2.level2(wizard);
        if (!wizard.getIsAlive()) {
            return;
        }
        Level_3.level3(wizard);
        if (!wizard.getIsAlive()) {
            return;
        }
        Level_4.level4(wizard);
        if (!wizard.getIsAlive()) {
            return;
        }
        Level_5.level5(wizard);
        if (!wizard.getIsAlive()) {
            return;
        }
        Level_6.level6(wizard);
        if (!wizard.getIsAlive()) {
            return;
        }
        Level_7.level7(wizard);
        if (!wizard.getIsAlive()) {
            return;
        }
    }

}