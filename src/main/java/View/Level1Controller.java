package View;

import HP.Game.Spell;
import HP.Game.Wizard;
import HP.Game.Enemy;
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

    }

    public void EnemyattackWizard() {

    }

}