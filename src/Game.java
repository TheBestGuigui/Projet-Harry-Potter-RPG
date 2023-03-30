import java.sql.Array;
import java.util.ArrayList;

public class Game {
    private Wizard wizard;
    public void StartGame() {
        wizard = new Introduction().Introduction();
        new Level_1().level1(wizard);

    }

}