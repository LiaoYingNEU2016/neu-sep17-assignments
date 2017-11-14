package project2;

import project1.Hangman;

public class Game {
    final int PLAYERS;
    Hand[] players;
    Deck deck;
    Trick[] tricks ;
    int numberOfTricks = 0;
    int playerNum;
    boolean hearts = false;
    boolean queenOfSpades = false;
    Game(int numberOfPlayers){
        PLAYERS = numberOfPlayers;
        players = new Hand[PLAYERS];
        deck = new Deck();
        for(int i=0;i<PLAYERS;i++){
            players[i] = new Hand(i,deck.TOTAL_CARDS/PLAYERS);
        }
        tricks = new Trick[deck.TOTAL_CARDS / PLAYERS];
        for(int i=0;i<tricks.length;i++){
            tricks[i] = new Trick(PLAYERS);
        }

    }

    public int getNumberOfTricks() {
        return numberOfTricks;
    }
    boolean getHearts(){return  hearts;}
    boolean getQueenOfSpades(){return queenOfSpades;}

    void playAGame() {
        //assign cards to players[]

        deck.shuffle();
        int cardsleft = deck.TOTAL_CARDS % PLAYERS;
        while (deck.getCurrentSize() > cardsleft) {

            for (int i = 0; i < PLAYERS; i++) {
                players[i].addCard(deck.dealCard());
            }
        }
        System.out.println("Output - first part: ");
        System.out.println();

        //sort and print the cards of players[]
        for (int i = 0; i < PLAYERS; i++) {
            players[i].setShortest();
            players[i].sort();
            if (players[i].find(0, 2) != -1) {
                playerNum = i;
            }
            System.out.println("    player " + i + " shortest= " + players[i].getShortest());
            for (int j = tricks.length-1; j >=0; j--) {
                players[i].getCards(j).display();
            }
        }
        System.out.println();
        System.out.println();
        System.out.println("Output - second part: ");
        System.out.println();
        System.out.println("Trick: "+ 0);
        //assign cards to tricks[0]
        for (int i = playerNum; i < PLAYERS; i++) {
            Card c = players[i].playACard(this, tricks[0]);
            tricks[0].addCard(c);
            System.out.print("player" + players[i].Num+"    ");
            c.display();
            updateHeartsAndQueen(c);
        }
        for (int i = 0; i < playerNum; i++) {
            Card c = players[i].playACard(this, tricks[0]);
            tricks[0].addCard(c);
            System.out.print("player" + players[i].Num+"    ");
            c.display();
            updateHeartsAndQueen(c);
        }
        for (int i = 0; i < cardsleft; i++) {
            tricks[0].addCard(deck.getCards(i));
            System.out.print("undelt card: " );
            deck.getCards(i).display();

        }

        int index = tricks[0].getWinner();


        //assign cards to tricks
        for (int i = 1; i < tricks.length; i++) {
            System.out.println();
            System.out.println("Trick: "+ i);
            for (int j = index; j < PLAYERS; j++) {
                Card c = players[j].playACard(this, tricks[i]);
                tricks[i].addCard(c);
                System.out.print("player" + players[j].Num+"    ");
                c.display();
                updateHeartsAndQueen(c);

            }
            for (int k = 0; k < index; k++) {
                Card c = players[k].playACard(this, tricks[i]);
                tricks[i].addCard(c);
                System.out.print("player" + players[k].Num+"    ");
                c.display();
                updateHeartsAndQueen(c);
            }
            index = tricks[i].getWinner();
        }


        //compute each player's count
        for (int i = 0; i < PLAYERS; i++) {
            computePoints(i);
        }



        //display each player's score
        for(int i = 0; i < PLAYERS; i++){
            System.out.println("player " + i + " score = "+ computePoints(i));
        }
        System.out.println("Play another game (y/n)?");
        System.out.println("***  THIS IS THE END OF GAME  ***");
    }



    void updateHeartsAndQueen(Card card){
        if(card.getSuit() == 2 && hearts == false) {
            System.out.println("hearts is now broken");
            hearts = true;
        }
        if(card.getSuit() == 3 && card.getNum() == 12){queenOfSpades = true;}
    }
    int computePoints(int playerNum){
        int sum = 0;
        for(int i = 0;i<tricks.length;i++){
            for(int j = 0;j<tricks[i].getCurrentSize();j++) {
                if (players[playerNum].Num==(tricks[i].getWinner())
                        && tricks[i].getCards(j).getSuit()==2)
                    sum += 1;
                if (players[playerNum].Num==(tricks[i].getWinner())
                        && tricks[i].getCards(j).getSuit()==3&&tricks[i].getCards(j).getNum()==12)
                    sum += 13;
            }
        }
        return sum;
    }
}

