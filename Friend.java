import java.util.Random;

public class Friend implements Observer, Runnable {
    private String name;
    private UI ui;
    private Eren eren;
    private Random rand = new Random();

    public Friend(String name, UI ui, Eren e) {
        this.name = name;
        this.ui = ui;
        this.e = eren;
        e.addObserver(this);
        new Thread(this).start();
    }

    @Override
    public void update(int energy) {
        if (rand.nextBoolean()) {
            ui.print(name + ": Eren, please be safe!");
            if (energy < 20)
                ui.print(name + ": Rage, rage against the dying of the light.");
        }
    }

    @Override
    public void run() {
        // Just reacts to notification
        while (eren.getEnergy() > 0) {
            try { Thread.sleep(200); } catch (Exception ignore) {}
        }
    }
}
