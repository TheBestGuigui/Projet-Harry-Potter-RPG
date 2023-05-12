package View;

import HP.Game.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


public class Level1Controller {

    private Stage stage;
    private Scene scene;
    @FXML
    private ImageView ImageWizard;
    @FXML
    private ImageView ImageEnemy;


    public void initialize(){
        ImageWizard.setImage(new Image(getClass().getResource("/Images/Wizard.png").toExternalForm()));
        ImageEnemy.setImage(new Image(getClass().getResource("/Images/Troll.png").toExternalForm()));
    }

    public void startLevel1(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/HP Game/Level2.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
