public class Wand {
    private Core core;
    private int size;

    public Wand(String Core) {
        this.core = Core;
        this.size = (int)(Math.random() * 13.0) + 22;
    }
    public Wand(Core core, int size) {
        this.core = core;
        this.size = size;
    }

    public Core getCore() {
        return core;
    }

    public int getSize() {
        return size;
    }
}

