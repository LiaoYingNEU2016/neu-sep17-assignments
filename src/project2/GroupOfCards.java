package project2;


import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.ArrayList;

public class GroupOfCards {
    public Card[] cards;
    public int currentSize = 0;

    GroupOfCards(int num){
        cards = new Card[num];
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public Card getCards(int i) {
        return cards[i];
    }
    void addCard(Card card){

        cards[currentSize] = card;
        currentSize++;
    }
    Card removeCard(int index){
        Card res = getCards(index);
        for(int i = index; i < currentSize-1; i++){
            cards[i] = cards[i+1] ;
        }
        cards[currentSize-1] = null;
        currentSize--;
        return res;
    }


        public void display(){for(int i=0;i<currentSize;i++) cards[i].display();}
}
