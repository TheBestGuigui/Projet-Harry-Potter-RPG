package Game;

import Levels.Introduction;
import Levels.Level_1;
import Levels.Level_2;
import Levels.Level_3;
import Levels.Level_4;
import Levels.Level_5;
import Levels.Level_6;
import Levels.Level_7;
import Levels.*;

public class Game {
    private Wizard wizard;

    public static void main(String[] args) {
        Wizard wizard = new wizard(null, null, null, null);

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