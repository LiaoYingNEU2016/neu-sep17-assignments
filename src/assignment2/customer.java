package assignment2;

import java.util.HashMap;

public class customer {
    String name;
    HashMap<Pizza, Integer>  map;

    public static void main(String[] args) {
        customer rock = new customer("Gordon");
        rock.order("Sandwich", 5, 5, 1);
        rock.order("Classic", 4, 5, 2);
        rock.order("Mushroom", 6, 5, 3);
        System.out.println(rock.sum());
    }



    public customer(String name) {
        map = new HashMap<>();
        this.name = name;
    }

    public void order(String name, double price, double point, int orderNumber) {
        map.put(new Pizza(name, price, point), orderNumber);
    }

    public int sum() {
        int sum = 0;
        for (Pizza pizza : map.keySet()) {
            sum += map.get(pizza) * pizza.unitPrice;
        }

        return sum;
    }
}
