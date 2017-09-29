package assignment2;


class perfectNumber {
    public static void main(String[]args){
        printPerfectNumbers(100);
    }
    public static void printPerfectNumbers(int n) {

        for (int j=1; j <= n; j++) {
            int sum = 0;
            for (int i = 1; i < j; i++) {
                if (j % i == 0) {
                    sum += i;
                }
            }

            if (sum == j) {
                System.out.println("perfect number are " + j);

            }
        }


    }

}

