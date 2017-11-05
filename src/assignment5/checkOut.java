package assignment5;
import java.util.ArrayList;
import java.lang.*;
public class checkOut {
    int numberOfItems = 0;
    int totalCost = 0;
    int totalTax = 0;
    ArrayList<DessertItem>dessertItems;
    checkOut(){
        dessertItems = new ArrayList<>();
    }


    void enterItem(DessertItem item) {
        dessertItems.add(item);
        numberOfItems += 1;
        totalCost += item.getCost();
    }

    void clear() {
        dessertItems.clear();
        numberOfItems = 0;
        totalCost = 0;
    }

    int numberOfItems() {
        return numberOfItems; }

    int totalCost() {
            return totalCost ;
        }

    int totalTax() {
        int totalTax = (int) (totalCost * 6.5 / 100);
        return totalTax;
    }

    @Override
    public String toString() {

        DessertShoppe dessertShoppe = new DessertShoppe();
        StringBuilder res = new StringBuilder();
        res.append(dessertShoppe.toString());
        for(DessertItem item: dessertItems){
        res.append(item + "\n");}
        res.append("\n");
        res.append("Tax");
        StringBuilder str = new StringBuilder();
        while(str.length() < 35 - 3 - 2 - String.valueOf(totalTax()).length()){
            str.append(" ");}
        res.append(str);
        res.append((double)(this.totalTax() )/ 100);
        res.append("\n");
        res.append("Total Cost");
        StringBuilder str1 = new StringBuilder();
        while(str1.length() < 35 - 9 - 2 - String.valueOf(totalCost()).length())
        {str1.append(" ");}
        res.append(str1);
        res.append((double)(this.totalCost())/ 100);

        return res.toString();
    }
}

