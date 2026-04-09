public class TeamLeader implements Observer, Runnable {
    private String name;
    private int patience;
    private UI ui;
    private Eren eren;
    private boolean active = true;

    public TeamLeader(String name, int patience, UI ui, Eren eren) {
        this.name = name;
        this.patience = patience;
        this.ui = ui;
        this.eren = eren;
        eren.addObserver(this);
        new Thread(this).start();
    }

    @Override
    public void update(int energy) {
        if (!active) return;
        patience -= 5;
        if (patience == 10) ui.print(name + ": My patience is waning!");
        else if (patience == 5) ui.print(name + ": Is this entertaining?");
        else if (patience == 0) {
            ui.print(name + ": Omae wa mou shindeiru");
            active = false;
        }
    }

    @Override
    public void run() {
        // Only reacts to notifications
        while (active && eren.getEnergy() > 0) {
            try { Thread.sleep(200); } catch (Exception ignore) {}
        }
    }
}
