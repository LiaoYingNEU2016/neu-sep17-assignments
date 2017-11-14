package assignment7;

public class Sensor extends Thread {
    private final Device device;
    private double value;
    public static boolean exit = true;

    public Sensor(Device device) {
        this.device = device;
    }

    public double getValue() {
        return value;
    }

    public void updateValue() {
        this.value += 0.001; // you check with other values here and see how it works
    }

    public void run() {
        while (exit) {
            synchronized (device) {
                updateValue();
                device.notifyAll();
            }

        }
    }
}



