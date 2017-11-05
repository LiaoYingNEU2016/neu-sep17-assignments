package project2;

public class Trick extends GroupOfCards {
    int winner;
    Card winningCard;
    boolean hearts = false;
    boolean queen = false;

    Trick(int players) {
        super(players * 2 - 1);
    }

    public Card getWinningCard() {
        return winningCard;
    }

    public int getWinner() {
        return winner;
    }

    boolean getHearts() {
    return hearts;}

    boolean getQueen() {
    return queen;}

    boolean isWinner(Card card) {
        if (getWinningCard() != null && (card.getSuit() != getWinningCard().getSuit()
                || card.getNum() < getWinningCard().getNum())) {
            return false;
        } else {
            return true;
        }
    }
    void update(int playerNum, Card card) {
        if (isWinner(card)){
            winner = playerNum;
            winningCard = card;
        }
        if(card.getSuit()==2){
            this.hearts = true;
        }

        if(card.getSuit()==3&&card.getNum()==12){
            this.queen = true;
        }
    }

}
