package View;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class StartGame extends VBox {
    Label TitleLabel = new Label("Harry Potter Game");
    Button StartButton = new Button("New Game");

    public StartGame() {
        TitleLabel.getStyleClass().add("MainTitle");
        StartButton.getStyleClass().add("StartButton");
        this.getChildren().addAll(TitleLabel, StartButton);
    }


}
