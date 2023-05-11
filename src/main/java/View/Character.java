package View;

import HP.Game.Wizard;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class Character extends VBox {

    private ImageView CharacterAppearance;
    private ProgressBar HealthPoints;
    private Label CharacterName;

    public Character(String imageUrl, String name) {

        this.CharacterAppearance = new ImageView(new Image(getClass().getResourceAsStream(imageUrl)));
        this.HealthPoints = new ProgressBar();
        this.CharacterName = new Label(name);
        this.HealthPoints.setProgress(1);
        this.setSpacing(5);
        this.setAlignment(Pos.CENTER);

        this.getChildren().add(this.CharacterName);
        this.getChildren().add(this.CharacterAppearance);
        this.getChildren().add(this.HealthPoints);


    }

    public ProgressBar getHealthPoints() {
        return HealthPoints;
    }

    public void setHealthPoints(int Max_HP, float HP) {
        HealthPoints.setProgress(HP / Max_HP);
    }

    public float RatioPdv(int Max_HP, float HP) {
        return HP / Max_HP;
    }

    public Label getCharacterName() {
        return CharacterName;
    }
}