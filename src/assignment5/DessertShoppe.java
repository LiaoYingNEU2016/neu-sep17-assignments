package assignment5;

public class DessertShoppe {
    String name = "M & M Dessert Shoppe";
    double taxRate = 0.02;
    int maxOfItemName = 30;
    int widthOfReceipt = 38;

    public static String cents2dollarsAndCentsmethod(int cents) {
        double c = (double)cents;
        return String.format("%.2f",c / 100);
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("        " + name+ "\n");
        res.append("        --------------------\n");
        res.append("\n");
        return res.toString();
    }
}