public enum Pet {
    OWL,
    RAT,
    CAT,
    TOAD,
    DRAGON,
    DOG,
    PYGMY_PUFFS,
    THREE_HEADED_DOG,
    GIANT_SPIDER,
    SNAKE,
    HIPPOGRIFF,
    PHOENIX;

    public final int index;
    public final String type;

    private Pet(int index, String type) {
        this.index = index;
        this.type = type;
    }
}
