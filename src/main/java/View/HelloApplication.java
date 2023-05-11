package View;

import HP.Game.Game;
import View.GameView;
import View.GamePresenter;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        StartGame startGame = new StartGame();
        GamePresenter gamePresenter = new GamePresenter(startGame, this);
        System.out.println("A new game has been started");
        Scene scene = new Scene(startGame, 600, 600);
        this.stage.setTitle("Hello!");
        this.stage.setScene(scene);
        this.stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
