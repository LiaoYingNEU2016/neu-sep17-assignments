package project2;

public class Hand extends GroupOfCards{
    final int Num;
    int shortest = 0;
    Hand(int playerNum,int numberOfCards){
        super(numberOfCards);
        this.Num = playerNum;
    }
    void sort(){
        for(int i = 0;i<getCurrentSize();i++){
            int sumi = cards[i].getSuit()*13 + cards[i].getNum();
            for(int j = i+1;j<getCurrentSize();j++){
                int sumj = cards[j].getSuit() *13 + cards[j].getNum();
                if(sumi>sumj){
                    sumi = sumj;
                    Card tmp = cards[i];
                    cards[i] = cards[j];
                    cards[j] = tmp;
                }
            }
        }
    }

    int findLowest(int suit){
        for(int i = 0;i<getCurrentSize();i++){
            if(cards[i].getSuit() == suit) return  i;
        }
        return  -1;
    }
    int count(int suit){
        int num = 0;
        for(int i = 0;i<getCurrentSize()-1;i++) {
            if (cards[i].getSuit() == suit) num++;
        }
        return num;}

    int find(int suit,int num){
        for(int index = 0;index<getCurrentSize();index++) {
            if (cards[index].getSuit() == suit && cards[index].getNum() == num)
        return index;}
        return -1;
    }

    public void setShortest() {
        if(count(1)<=count(0)){shortest = 1;}
        else if(count(3)<=count(1) &&
                count(3)<=count(0) &&
                find(3,12) == -1 &&
                find(3,13) == -1 &&
                find(3,14) == -1)
        {shortest = 3;}
        else shortest = 0;
    }
    public int getShortest() {
        return shortest;
    }

    int findHighest(int suit){
        for(int i = getCurrentSize() - 1;i >=0 ; i--) {
          if(cards[i].getSuit() == suit){
              return i;
          } }
                return -1;}

    int findLowest(Game game) {
        int min = Integer.MAX_VALUE;
        int pos = -1;
        if (game.hearts == true) {
            for (int i = 0; i < getCurrentSize(); i++) {
                if (cards[i].getNum() <= min) {
                    min = cards[i].getNum();
                    pos = i;
                }
            }
        }
        else {
              for (int j = 0; j < getCurrentSize(); j++) {
                  if (cards[j].getSuit() != 2) {
                      if (cards[j].getNum() <= min) {
                          min = cards[j].getNum();
                          pos = j;
                      }
                  }
              }
              pos = pos == -1 ?  0 : pos;
        }
        return pos;
    }


    int findLastHigh(int suit) {
        for (int i = 0; i < getCurrentSize()-1; i++) {
            if (cards[i].getSuit() == suit) {
                if (cards[i].getNum() == 12) {
                    if (cards[i + 1].getSuit() == suit) return i + 1;
                    else return -1;
                } else return i;
            }
        }
        return -1;
    }

    int findHighestBelow(Card winningCard){
        for (int i = getCurrentSize() - 1; i >= 0; i--) {
            if (cards[i].getSuit() == winningCard.getSuit()
                    &&cards[i].getNum() < winningCard.getNum())
                return i;
            }
        return  -1;
    }


    int findMiddleHigh(Game game,int suit) {
        if (suit == 3) {
            if (game.queenOfSpades == false) {
                for(int i=currentSize-1;i>=0;i--){
                    if(cards[i].getSuit()==3){
                        if (cards[i].getNum() <= 11) return i;
                        if(i==0||(i>0&&cards[i-1].getSuit()!=3)) {
                            if (cards[i].getNum() == 12) {
                                if (i < currentSize - 1 && cards[i + 1].getSuit() == 3) return i + 1;
                                else return i;
                            }
                            else return i;
                        }
                    }
                }
                return -1;
            }
            else return findHighest(suit);
        }
        else return findHighest(suit);
    }


    int findHighest(){
        int max = 0;
        int pos = 0;
        for (int i = 0; i < getCurrentSize()-1; i++) {
                if(cards[i].getNum()>=max){
                max = cards[i].getNum();
                pos = i;
                }
            }
        return pos;
    }

    Card playACard(Game game,Trick trick) {
        int index;
        if (trick.getCurrentSize() == 0) {
            if (count(shortest) == 0){
                index = findLowest(game);
            }
            else if (game.hearts == true || game.queenOfSpades == true)
                index = findLowest(game);
            else   index = findHighest(shortest);
        }
        else if ((trick.getCurrentSize() == game.PLAYERS - 1)
                && !trick.getHearts() && !trick.getQueen()
                && (index = findLastHigh(trick.winningCard.getSuit())) >= 0);
        else if ((index = findHighestBelow(trick.winningCard)) >= 0);
        else if ((index = findMiddleHigh(game, trick.winningCard.getSuit())) >= 0);
        else if ((index = find(12, 3)) >= 0); // queen of Spades
        else if ((index = find(14, 3)) >= 0); // Ace of Spades
        else if ((index = find(13, 3)) >= 0); // King of Spades
        else if ((index = findHighest(2)) >= 0); // heart
        else { index = findHighest(); }
        Card a = cards[index];
        trick.update(Num,a);
        game.updateHeartsAndQueen(a);
        removeCard(index);
        return a;
    }
}
