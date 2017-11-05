package midterm;

public class dice {
    int result;
    public int countNumberOfPossibleWays(int m, int n, int x){
        int number = 0;
        int sum = 0;
        result = 0;
        countNumberOfPossibleWays(n , m , number, sum, x);
        return result;
    }

    public void countNumberOfPossibleWays(int n, int m,
                                          int number,int sum, int x) {
        if (number == m && sum == x) {
            result++;
            return;
        }

        if (number == m) {
            return;
        }
        for (int i = 0; i < n; i++) {
            countNumberOfPossibleWays(n, m , number + 1, sum + i + 1, x);
        }
    }
}
