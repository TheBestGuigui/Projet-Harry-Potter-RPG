import java.sql.Array;
import java.util.ArrayList;

public class Game {
    private Wizard wizard;
    public void StartGame() {
        wizard = new Introduction().Introduction();
        new Level_1().level1(wizard);
        new Level_2().level2(wizard);
        new Level_3().level3(wizard);
        new Level_4().level4(wizard);
        new Level_5().level5(wizard);
        new Level_6().level6(wizard);
    }

}