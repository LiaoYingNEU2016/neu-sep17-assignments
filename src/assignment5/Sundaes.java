package assignment5;

class Sundaes extends IceCream {
    private String icecreamName;
    int cost;

    public Sundaes(String icecream, int cost, String topping, int costOfTopping) {
        super(icecream, cost);
        this.cost = super.cost + costOfTopping;
        this.name = topping;
        icecreamName = icecream;

    }
    int getCost(){
        return cost;}

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name + " Sundaes with\n");
        sb.append(icecreamName);
        StringBuilder temp = new StringBuilder();
        while (temp.length() < 35 - icecreamName.length() -
                DessertShoppe.cents2dollarsAndCentsmethod(this.getCost()).length()){
            temp.append(" ");}
        sb.append(temp);
        sb.append(DessertShoppe.cents2dollarsAndCentsmethod(this.getCost()));
        return sb.toString();
    }
}



