package assignment2;

public class printIsoscelesTriangle {
    public static void main(String[] args) {
        printIsoscelesTriangle test = new printIsoscelesTriangle();
        test.printIsoscelesTriangle(7);
    }
    public void printIsoscelesTriangle(int n) {

        for (int i = 1; i <= n;i++) {
            for (int j=1; j <= i;j++){
                if (j==1 || j==i) {
                    System.out.print("*");
                }else if (i==n) {
                    System.out.print("*");
                } else {
                        System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

}


