package assignment5;

class Cookies extends DessertItem{
    int number;
    double  pricePerDozen;
    Cookies(String name,int number,double  pricePerDozen){
        super(name);
        this.number = number;
        this.pricePerDozen = pricePerDozen;
    }
    int getCost(){
        return (int)(number * pricePerDozen / 12);
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String str = number + " " + "lbs." + " @ " + this.pricePerDozen + " " + "/lb." + "\n";
        sb.append(str);
        sb.append(this.name);
        StringBuilder temp = new StringBuilder();
        while (temp.length() < 35 - this.name.length() -
                DessertShoppe.cents2dollarsAndCentsmethod(this.getCost()).length()) {
        temp.append(" ");}
        sb.append(temp);
        sb.append(DessertShoppe.cents2dollarsAndCentsmethod(this.getCost()));
        return sb.toString();
    }
}