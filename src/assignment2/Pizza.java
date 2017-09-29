package assignment2;

public class Pizza {

    String pizzaType;
    double unitPrice;
    double loyaltyPoint;

    public Pizza() {
        Pizza Pizza1 = new Pizza();
        Pizza1.pizzaType = "pepper";
        Pizza1.unitPrice = 5;
        Pizza1.loyaltyPoint = 5;}

    public Pizza(String pizza, double unitPrice, double loyaltyPoint) {
            this.pizzaType = pizza;
            this.unitPrice = unitPrice;
            this.loyaltyPoint = loyaltyPoint;

    }

}
