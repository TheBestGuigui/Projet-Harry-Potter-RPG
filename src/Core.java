public enum Core {
    PHOENIX_FEATHER,
    DRAGON_HEARTSTRING,
    UNICORN_TAIL_HAIR,
    VEELA_HAIR,
    THESTRAL_TAIL_HAIR,
    TROLL_WHISKER,
    CORAL,
    DITTANY_STALK,
    THUNDERBIRD_TAIL_FEATHER,
    WAMPUS_CAT_HAIR,
    WHITE_RIVER_MONSTER_SPINE,
    ROUGAROU_HAIR,
    HORNED_SERPENT_HORN,
    SNALLYGASTER_HEARTSTRING,
    JACKALOPE_ANTLER,
    KNEAZLE_WHISKER,
    KELPIE_HAIR,
    BASILISK_HORN,
    CURUPIRA_HAIR,
    AFRICAN_MERMAID_HAIR,
    FAIRY_WING;
    public final int index;
    public final String type;

    private Core(int index, String type) {
        this.index = index;
        this.type = type;
    }
}
