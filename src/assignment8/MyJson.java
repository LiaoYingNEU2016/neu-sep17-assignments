package assignment8;

import java.io.File;
import java.io.IOException;

public class MyJson {
    private static ArrayList<Vehicle> readAndGetVehicles(File file)；
    public static void writeToFile(String inputToWrite, String filePath)；
    public static void main(String[] args) throws IOException {
        File file = new File("your file path");
        ArrayList<Vehicle> vehicles = readAndGetVehicles(file);
        String s = getJsonString(vehicles);
        writeToFile(s, file.getParent());
    }
}
