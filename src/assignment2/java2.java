package assignment2;

class PerfectNumbers {
    public void printPerfectNumbers(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }

        while (sum == n) {
            System.out.println("perfect number are" + n);
        }
    }
}




