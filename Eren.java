import java.util.*;


public class Eren extends Thread {
    private int energy;
    private UI ui;
    private List<Observer> observers = new ArrayList<>();
    private Random rand = new Random();

    public Eren(int energy, UI ui) {
        this.energy = energy;
        this.ui = ui;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public int getEnergy() {
        return energy;
    }

    private void notifyObservers() {
        for (Observer o : observers)
            o.update(energy);
    }

    @Override
    public void run() {
        while (energy > 0) {
            try {
                int sleepTime = 5 + rand.nextInt(6); // 5-10 seconds
                Thread.sleep(sleepTime * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ui.print("Eren transforms into a Titan! (energy = " + energy + ")");
            notifyObservers();
            try {
                Thread.sleep(10000); // stay transformed for 10 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            energy -= 5;
        }
        ui.print("Eren has no more energy to transform.");
    }
}
