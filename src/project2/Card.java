package project2;

public class Card {
    private int num;
    private int suit;
    public Card(int num,int suit){
       this.num = num;
       this.suit = suit;
    }
int getNum(){ return num; }
int getSuit(){return suit;}
void display(){
    if(num>=11) {
        switch (num) {
            case 11:
                System.out.print("Jack of ");
                break;
            case 12:
                System.out.print("Queen of ");
                break;
            case 13:
                System.out.print("King of ");
                break;
            case 14:
                System.out.print("Ace of ");
                break;
        }
    }
    else
        System.out.print(num+" of ");
    switch (suit){
        case 0:
            System.out.print("clubs");
            break;
        case 1:
            System.out.print("diamonds");
            break;
        case 2:
            System.out.print("hearts");
            break;
        case 3:
            System.out.print("spades");
            break;}
    System.out.println();
}

}
