package project1;
import java.io.Console;
import java.util.*;

public class Hangman {
    private ArrayList<String> words;
    private ArrayList<Character> wrongList;
    private String correctList;
    char[] guessLetter;
    private String chosenWord;

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("wrgwes");
        list.add("rwgre");
        list.add("gerge");
        list.add("wgrwg");
        Hangman hangman = new Hangman(list);
        hangman.playGame();

    }

    public Hangman(ArrayList<String> words) {
        this.words = words;
        wrongList = new ArrayList<>();

    }

    private void chooseWord() {
        chosenWord = words.get((int) (Math.random() * words.size()));
    }

    private void handleGuess(char c) {
        if (chosenWord.contains(String.valueOf(c))) {
            for (int i = 0; i < chosenWord.length(); i++) {
                if (chosenWord.charAt(i) == c) {
                    guessLetter[i] = c;
                }
            }

            correctList = correctList.replaceAll(String.valueOf(c), "");
            displayWord();
        } else {
            wrongList.add(c);

            if (wrongList.size() == 1) {
                System.out.println("           -----------\n          |           |\n" +
                        "          |           0\n          |\n          |\n" +
                        "          |\n          |\n          |\n          |" +
                        "\n           ----------------");
            }

            if (wrongList.size() == 2) {
                System.out.println("           -----------\n          |           |\n" +
                        "          |           0\n          |           |\n          |\n" +
                        "          |\n          |\n          |" +
                        "\n          |\n           ----------------");
            }
            if (wrongList.size() == 3) {
                System.out.println("           -----------\n          |           |\n" +
                        "          |           0\n          |           |\n" +
                        "          |        ---\n          |\n          |\n          |\n          |" +
                        "\n           ----------------");
            }
            if (wrongList.size() == 4) {
                System.out.println("           -----------\n          |           |\n" +
                        "          |           0\n          |           |\n" +
                        "          |        --- ---\n          |\n          |\n          |" +
                        "\n          |\n           ----------------");
            }
            if (wrongList.size() == 5) {
                System.out.println("           -----------\n          |           |\n" +
                        "          |           0\n          |           |\n" +
                        "          |        --- ---\n          |          /\n          |         /\n          |" +
                        "\n          \n           ----------------");
            }
            if (wrongList.size() == 6) {
                System.out.println("           -----------\n          |           |\n" +
                        "          |           0\n          |           |\n" +
                        "          |        --- ---\n          |          / " + "\\" +
                        "\n          |         /   \\\n          |" +
                        "\n          |\n           ----------------");
            }
            if (wrongList.size() == 7) {
                System.out.println("           -----------\n          |           |\n" +
                        "          |           0\n          |           |\n" +
                        "          |        --- ---\n          |          / " + "\\" +
                        "\n          |         /   \\\n          |      --" +
                        "\n          |\n           ----------------");
            }
            if (wrongList.size() == 8) {
                System.out.println("           -----------\n          |           |\n" +
                        "          |           0\n          |           |\n" +
                        "          |        --- ---\n          |          / " + "\\" +
                        "\n          |         /   \\\n          |      --       --" +
                        "\n          |\n           ----------------");
            }
            return;
        }
    }

    private boolean gameWon() {
        if (correctList.length() == 0) {
            return true;
        }

        return false;
    }



    void playGame() {

        chooseWord();
        StringBuilder sb = new StringBuilder(chosenWord);
        correctList = sb.toString();
        guessLetter = new char[chosenWord.length()];
        for (int i = 0; i < chosenWord.length(); i++) {
            guessLetter[i] = '-';
        }

        System.out.println("*** Welcome to the Hangman game ***");
        System.out.println(String.valueOf(guessLetter));
        System.out.println("Please enter a letter: ");
        Scanner reader = new Scanner(System.in);


        while (!gameWon()) {
            String letter = reader.next();
            if (letter.length() > 1) {
                System.out.println("Please enter valid letter");
            }

            handleGuess(letter.charAt(0));
            if (wrongList.size() == 8) {

                break;
            }
        }
        gameOver();
        }
    private void gameOver() {
        if (wrongList.size() == 8) {
            System.out.println("defeat!");
        } else {
            System.out.println("ace!");
        }
    }
    private void displayWord() {
        System.out.println(String.valueOf(guessLetter));
    }
}
