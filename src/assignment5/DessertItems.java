package assignment5;

abstract class DessertItem{
    protected String name;
    protected int cost;
    DessertItem(String name){
        this.name = name;
    }
    int getCost(){return cost;}

}