public enum House {
    HUFFLEPUFF,
    SLYTHERIN,
    GRYFFINDOR,
    RAVENCLAW;

    final String name;

    @Override
    public String toString() {
        return this.name;
    }

    public void setHouseBonus(Wizard wizard) {
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
