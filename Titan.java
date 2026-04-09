import java.util.Random;

public class Titan implements Observer, Runnable {
    private String name;
    private UI ui;
    private Eren eren;
    private Random rand = new Random();

    public Titan(String name, UI ui, Eren eren) {
        this.name = name;
        this.ui = ui;
        this.eren = eren;
        eren.addObserver(this);
        new Thread(this).start();
    }

    @Override
    public void update(int energy) {
        if (rand.nextBoolean()) {
            ui.print(name + ": Attacks Eren!");
            if (energy > 40)
                ui.print(name + ": Now we got problems, and I don't think we can solve 'em.");
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
