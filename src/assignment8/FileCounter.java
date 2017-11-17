package assignment8;

import java.io.IOException;
import java.util.Scanner;

public class FileCounter {

    private int characterCount =0;
    private int wordCount = 0;
    private int lineCount = 0;

    public FileCounter() { }


    /**
     * Processes an input source and adds its character, word, and line
     * counts to the respective variables.
     *
     * @param in the scanner to process
     */
    public void read(Scanner in) throws IOException {
        while(in.hasNextLine()) {
            String[] s = in.nextLine().split(" ");
            lineCount++;
            wordCount += s.length;
            for(int i = 0; i<s.length;i++){
                characterCount += s[i].length();
            }
        }
    }

    public int getCharacterCount() {
        return characterCount;
    }

    public int getWordCount() {
        return wordCount;
    }

    public int getLineCount() {
        return lineCount;
    }
}
