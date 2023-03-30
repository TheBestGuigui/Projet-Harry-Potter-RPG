public enum Pet {
    OWL(0),
    RAT(1),
    CAT(2),
    DOG(3),
    TOAD(4),
    SNAKE(5),
    GIANT_SPIDER(6),
    PYGMY_PUFFS(7),
    HIPPOGRIFF(8),
    THREE_HEADED_DOG(9),
    DRAGON(10),
    PHOENIX(11);

    public final int index;

    private Pet(int index) {
        this.index = index;
    }
}
