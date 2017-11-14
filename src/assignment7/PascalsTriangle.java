package assignment7;
import java.util.Scanner;
public class PascalsTriangle {

    public static void main(String[] args) {
        System.out.println("Please enter an interger n " +
                "to display the first n lines of the Pascal’s triangle");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //int n = (int) (Math.random() * 10);
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == n) {
                    a[i][j] = 1;
                    System.out.print(a[i][j] + " ");
                }
                else {
                    a[i][j] = a[i - 1][j - 1] + a[i - 1][j];
                    System.out.print(a[i][j] + " ");
                }
            }
            System.out.println("");
        }
    }
}

