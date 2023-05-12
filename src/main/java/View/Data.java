package View;

import HP.Game.Game;
import HP.Game.Main;
import HP.Game.Wizard;

import java.io.IOException;

public class Data {
    private static Game game;

    private static Wizard player;

    private Main app;

    public static Wizard getPlayer() {
        return player;
    }

    public static void setPlayer(Wizard player) {
        Data.player = player;
    }

    public Main getApp() {
        return app;
    }

    public void setApp(Main app) {
        this.app = app;
    }

    public static Game getGame() {
        return game;
    }

    public static void setGame(Game game) {
        Data.game = game;
    }


}
