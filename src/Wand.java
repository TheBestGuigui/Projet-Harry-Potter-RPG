public class Wand {
    private Core core;
    private int size;

    public Wand() {
    }

    public void Wand() {
        this.core = Core.values()[(int)(Math.random() * (double)Core.values().length - 1.0)];
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
}
