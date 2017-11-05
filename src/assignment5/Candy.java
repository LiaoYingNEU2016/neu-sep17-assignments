package assignment5;

 class Candy extends DessertItem {
     double weight;
     double pricePerPound;

     Candy(String name, double weight, double pricePerPound) {
         super(name);
         this.weight = weight;
         this.pricePerPound = pricePerPound;
     }

     int getCost() {
         return (int)Math.round(weight * pricePerPound);
     }

     public String toString() {
         StringBuilder sb = new StringBuilder();
         String str = weight + " " + "lbs." + " @ " + this.pricePerPound + " " + "/lb." + "\n";
         sb.append(str);
         sb.append(this.name);
         StringBuilder temp = new StringBuilder();
         while (temp.length() < 35 - this.name.length() -
                 DessertShoppe.cents2dollarsAndCentsmethod(getCost()).length()){
         temp.append(" ");}
         sb.append(temp);
         sb.append(DessertShoppe.cents2dollarsAndCentsmethod(getCost()));
         return sb.toString();
     }
     }

