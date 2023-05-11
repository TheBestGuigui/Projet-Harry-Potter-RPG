package View;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class StartGame extends VBox {
    Label titleLabel = new Label("Harry Potter Game");
    Button startButton = new Button("New Game");

    public StartGame() {
        titleLabel.getStyleClass().add("title");
        startButton.getStyleClass().add("btn");
        this.getChildren().addAll(titleLabel, startButton);
    }


}
