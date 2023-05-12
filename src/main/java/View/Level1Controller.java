package View;

import HP.Game.Spell;
import HP.Game.Wizard;
import HP.Game.Enemy;
import HP.Game.Character;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


public class Level1Controller {

    private Stage stage;
    private Scene scene;
    @FXML
    private ImageView ImageWizard;
    @FXML
    private ImageView ImageEnemy;
    @FXML
    private Button UseSpells;
    @FXML
    private Button OpenInventory;
    @FXML
    private Button Flee;
    @FXML
    private Button ValidateAction;
    @FXML
    private ListView<Object> List;
    @FXML
    private Label WizardHP;
    @FXML
    private Label EnemyHP;
    @FXML
    private ProgressBar EnemyHPBar;
    @FXML
    private ProgressBar WizardHPBar;

    private final ObservableList<Object> dataList = FXCollections.observableArrayList();


    public void initialize(){
        ImageWizard.setImage(new Image(getClass().getResource("/Images/Wizard.png").toExternalForm()));
        ImageEnemy.setImage(new Image(getClass().getResource("/Images/Troll.png").toExternalForm()));
        show_HP();
    }

    public void startLevel1(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/HP Game/Level2.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void show_HP() {
        WizardHP.setText(Data.getPlayer().getHealth_point() + " / " + Data.getPlayer().getMax_Health_point());
        EnemyHP.setText(Enemy.troll.getHealth_point() + " / " + Enemy.troll.getMax_Health_point());
        WizardHPBar.setProgress((float)Data.getPlayer().getHealth_point() / (float)Data.getPlayer().getMax_Health_point());
        EnemyHPBar.setProgress((float)Enemy.troll.getHealth_point() / (float)Enemy.troll.getMax_Health_point());
    }

    public void showSpell() {
        dataList.clear();
        ArrayList<Spell> spells = new ArrayList();
        spells.add(Spell.Stupefix);
        spells.add(Spell.Protego);
        spells.add(Spell.WindgardiumLeviosa);

        for (Spell spell: spells) {
            dataList.add(spell);
        }
        List.setCellFactory(new Callback<ListView<Object>, ListCell<Object>>() {
            @Override
            public ListCell<Object> call(ListView<Object> param) {
                ListCell<Object> cell = new ListCell<Object>(){
                    @Override
                    protected void updateItem(Object object, boolean bt1){
                        super.updateItem(object, bt1);
                        if(object != null && object instanceof Spell){
                            Spell spell = (Spell) object;
                            setText(spell.getName());
                        }
                    }
                };
                return cell;
            }
        });
        List.setItems(dataList);
    }

    public void WizardattackEnemy() {
        Spell selectedSpell = (Spell) dataList.get(List.getSelectionModel().getSelectedIndex());
        if(selectedSpell.getName().equals("Stupefix")){
            Random random = new Random();
            int nbr_random = random.nextInt(101);
            int Accuracy = Data.getPlayer().getAccuracy() + Data.getPlayer().getAccuracyBonus() + Spell.Stupefix.getAccuracy();
            if (nbr_random <= Accuracy) {
                Enemy.troll.setHealth_point(Enemy.troll.getHealth_point() - (Data.getPlayer().getCombat_power() + Data.getPlayer().getPowerBonus() + Spell.Stupefix.getPower()));
                System.out.println("You used the " + Spell.Stupefix.getName() + " spell on " + Enemy.troll.getName() + " and took " + (Data.getPlayer().getCombat_power() + Data.getPlayer().getPowerBonus() + Spell.Stupefix.getPower()) + " health points away from him/her.");
            } else {
                System.out.println("You missed your spell on " + Enemy.troll.getName() + ".");
            }
        }
        if(selectedSpell.getName().equals("Protego")){
            Random random = new Random();
            int nbr_random = random.nextInt(101);
            int Accuracy = Data.getPlayer().getAccuracy() + Data.getPlayer().getAccuracyBonus() + Spell.Protego.getAccuracy();
            if (nbr_random <= Accuracy) {
                System.out.println("You used the " + Spell.Protego.getName() + " spell to protect yourself.");
                Data.getPlayer().setDefense(Data.getPlayer().getDefense() + Spell.Protego.getPower());
            } else {
                System.out.println("You failed to protect yourself using the " + Spell.Protego.getName() + " spell.");
            }
        }
        if(selectedSpell.getName().equals("WindgardiumLeviosa")) {
            Random random = new Random();
            int nbr_random = random.nextInt(101);
            int Accuracy = Data.getPlayer().getAccuracy() + Data.getPlayer().getAccuracyBonus() + Spell.WindgardiumLeviosa.getAccuracy();
            if (nbr_random <= Accuracy) {
                System.out.println("You use the Wingardium Leviosa spell on the troll's club to stun it.");
                Enemy.troll.setHealth_point(0);
                System.out.println("You have also learned a new spell: 'Accio' which allows you to attract objects to you.");
                Data.getPlayer().addSpell(Spell.Accio);
            } else {
                System.out.println("You missed your spell on " + Enemy.troll.getName() + ".");
            }
            Character.WizardAttackTroll(Data.getPlayer(), Enemy.troll, 50);
        }
        show_HP();
        EnemyattackWizard();
        show_HP();
    }

    public void EnemyattackWizard() {
        Character.TrollAttackWizard(Data.getPlayer(), Enemy.troll);
    }

}