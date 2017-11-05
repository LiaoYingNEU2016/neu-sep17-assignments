package project2;

public class GameDriver {

    public static void main(String[] args) {
        for(int i=0;i<20000;i++) {
            Game game = new Game(5);
            game.playAGame();
        }
    }
}
