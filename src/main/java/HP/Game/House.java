package HP.Game;

public enum House {
    GRYFFINDOR("GRYFFINDOR"),
    HUFFLEPUFF("HUFFLEPUFF"),
    RAVENCLAW("RAVENCLAW"),
    SLYTHERIN("SLYTHERIN");

    private String House_name;

    private House(String name) {
        this.House_name = name;
    }

    public String getHouse_name() {
        return House_name;
    }

    public void set_Bonus_House(Wizard wizard) {
        House house = wizard.getHouse();
        switch (house) {
            case HUFFLEPUFF:
                wizard.setEfficiencyPotionsBonus(10);
                break;
            case SLYTHERIN:
                wizard.setPowerBonus(10);
                break;
            case GRYFFINDOR:
                wizard.setResistanceBonus(10);
                break;
            case RAVENCLAW:
                wizard.setAccuracyBonus(10);
                break;
        }
    }
}
