package HP.Game;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;

public class Game {
    private Wizard wizard;
    public void StartGame() {
        System.out.println("Disclaimer : Ceci est censé être la seule phrase en français de tout le jeu et sert à vous prévenir que je n'ai ni lu les ni vu les films Harry Potter ; " + "\nainsi, de nombreuses incohérences concernant l'histoire ou des éléments de jeu ont pu s'immiscer dans mon jeu, merci d'avance pour votre indulgence. :)" + "\n");
        wizard = new Introduction().Introduction();
        new Level_1().level1(wizard);
        new Level_2().level2(wizard);
        new Level_3().level3(wizard);
        new Level_4().level4(wizard);
        new Level_5().level5(wizard);
        new Level_6().level6(wizard);
        new Level_7().level7(wizard);
        System.out.println("Congratulations, you just completed this little Harry Potter's game !");
    }

}