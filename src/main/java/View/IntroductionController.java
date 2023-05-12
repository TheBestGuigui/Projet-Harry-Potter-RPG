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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


public class IntroductionController {

    private Stage stage;
    private Scene scene;

    @FXML
    private TextField CreateName;
    @FXML
    private ChoiceBox CreatePet;
    @FXML
    private ChoiceBox CreateHouse;
    @FXML
    private Button CreateWizard;


    public void initialize(){
        for (House house: House.values()) {
            CreateHouse.getItems().add(house.name());
        }
        for (Pet pet: Pet.values()) {
            CreatePet.getItems().add(pet.name());
        }
    }

    public void startLevel1(ActionEvent actionEvent) throws IOException {
        String name = CreateName.getText();
        String pet = (String) CreatePet.getValue();
        String house = (String) CreateHouse.getValue();

        ArrayList<Spell> spells = new ArrayList();
        spells.add(Spell.Stupefix);
        spells.add(Spell.Protego);
        spells.add(Spell.WindgardiumLeviosa);
        ArrayList<Potion> potions = new ArrayList();
        potions.add(Potion.HealingPotion);
        potions.add(Potion.DamagingPotion);
        potions.add(Potion.AccuracyPotion);
        potions.add(Potion.ResistancePotion);

        Wizard wizard = null;
        if (house == House.HUFFLEPUFF.getHouse_name()) {
            wizard = new Wizard(name, Pet.valueOf(pet), new Wand(), House.valueOf(house), spells, potions, 0, 0, 20, 0);
        }
        if (house == House.RAVENCLAW.getHouse_name()) {
            wizard = new Wizard(name, Pet.valueOf(pet), new Wand(), House.valueOf(house), spells, potions, 10, 0, 0, 0);
        }
        if (house == House.GRYFFINDOR.getHouse_name()) {
            wizard = new Wizard(name, Pet.valueOf(pet), new Wand(), House.valueOf(house), spells, potions, 0, 0, 0, 10);
        }
        if (house == House.SLYTHERIN.getHouse_name()) {
            wizard = new Wizard(name, Pet.valueOf(pet), new Wand(), House.valueOf(house), spells, potions, 0, 10, 0, 0);
        }else{
            wizard = new Wizard(name, Pet.valueOf(pet), new Wand(), House.values()[(int) (House.values().length * Math.random())], spells, potions, 0, 10, 0, 0);
        }


        Data.setPlayer(wizard);
        Parent root = FXMLLoader.load(getClass().getResource("/HP Game/Level1.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
