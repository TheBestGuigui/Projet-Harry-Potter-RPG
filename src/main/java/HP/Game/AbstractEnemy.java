package HP.Game;

public abstract class AbstractEnemy extends Character{
    public AbstractEnemy(String name, int hp, int max_hp, int combat_power, int defense){
        super(name, hp, max_hp, combat_power, defense, 100, 0, 0, 0, 0, 0, true);
    }
}
