package assignment6;

import java.io.File;
import java.io.RandomAccessFile;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Parse {
        public static void parse(File file) throws IOException {
            RandomAccessFile input = null;
            String line = null;

            try {
                input = new RandomAccessFile(file, "r");
                while ((line = input.readLine()) != null) {
                    System.out.println(line);
                }
                return;
            } catch (FileNotFoundException ex){
                ex.printStackTrace();
            } catch (IOException ex){
                ex.printStackTrace();
            } finally {
                if (input != null) {
                    input.close();
                }
            }
        }
}
