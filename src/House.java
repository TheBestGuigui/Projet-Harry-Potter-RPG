public enum House {
    HUFFLEPUFF,
    SLYTHERIN,
    GRYFFINDOR,
    RAVENCLAW;

    private final String House_name;

    House(String name) {
        this.House_name = name;
    }

    @Override
    public String toString() {
        return this.House_name;
    }

    public void set_Bonus_House(House wizard) {
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
