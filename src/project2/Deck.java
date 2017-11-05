package project2;

public class Deck extends GroupOfCards {
    final int TOTAL_CARDS = 52;
    Deck(){
        super(52);
        for(int i=0;i<4;i++){
            for(int j=2;j<15;j++){
                addCard(new Card(j,i));
            }
        }
    }
    void shuffle(){

        for(int i = getCurrentSize();i>0;i--){
            int index = (int)(Math.random()*i);
            Card a = getCards(index);
            removeCard(index);
            addCard(a);
        }
    }
    Card dealCard(){
        Card res = cards[0];
        removeCard(0);
        return res;
    }
}
