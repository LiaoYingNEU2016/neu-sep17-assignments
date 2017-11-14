package assignment7;

public class Controller extends Thread {
        Sensor heat;
        Sensor pressure;
        Device device;
    public Controller(Device device, Sensor heat, Sensor pressure){
        this.heat = heat;
        this.pressure = pressure;
        this.device = device;
        }
        public void run(){
            device.startup();
            synchronized (device) {
                while (heat.getValue() <= 70 && pressure.getValue() <= 100) {
                    System.out.println("heat -> " + String.format("%.2f", heat.getValue()) +
                            " ,pressure -> " + String.format("%.2f", pressure.getValue()));
                    try {
                        device.wait();
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                Sensor.exit = false;
                System.out.println("heat -> " + String.format("%.2f", heat.getValue())
                        + " ,pressure -> " + String.format("%.2f", pressure.getValue()));
            }
            device.shutdown();
        }
}
