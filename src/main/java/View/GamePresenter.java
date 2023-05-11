package View;

import HP.Game.*;
import View.HelloApplication;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Objects;

public class GamePresenter {
    private Stage stage;
    private StartGame startGame;
    public static Wizard wizard;

    public GamePresenter(StartGame startGame, HelloApplication helloApplication) {
        this.startGame = startGame;
        this.startGame.StartButton.setOnAction(this::onPlayAction);
    }

    public void onPlayAction(ActionEvent e) {
        wizard = new Introduction().Introduction();

    }
}
