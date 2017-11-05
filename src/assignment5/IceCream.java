package assignment5;

class IceCream extends DessertItem{
    IceCream(String name, int cost) { super(name);
    this.cost = cost;}
    int getCost(){
        return cost;}

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        StringBuilder temp = new StringBuilder();
        while (temp.length() < 35 - name.length() -
                DessertShoppe.cents2dollarsAndCentsmethod(this.getCost()).length()){
            temp.append(" ");
        }

        sb.append(temp);
        sb.append(DessertShoppe.cents2dollarsAndCentsmethod(this.getCost()));
        return sb.toString();
    }
}