public enum Pet {
    OWL,
    RAT,
    CAT,
    DOG,
    TOAD,
    SNAKE,
    GIANT_SPIDER,
    PYGMY_PUFFS,
    HIPPOGRIFF,
    THREE_HEADED_DOG,
    DRAGON,
    PHOENIX;

    public final int index;
    public final String type;

    private Pet(int index, String type) {
        this.index = index;
        this.type = type;
    }
}
