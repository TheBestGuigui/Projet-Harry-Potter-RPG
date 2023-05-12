package View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private Stage stage;

    @Override
    public void start(Stage stage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/HP Game/Main Start.fxml"));
        stage.setTitle("Hello World");
        stage.setScene(new Scene(root, 800, 600));
        this.stage = stage;
        System.out.println("A new game has been started");
        this.stage.setTitle("Jeu Harry Potter - CHAPUIS Guillaume");
        stage.setResizable(false);
        this.stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
