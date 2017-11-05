package midterm;

public class coins {
    int arrangeCoins(int n){
        int k;
        for( k = 1;k<n;k++){
            if(n<=0.5*k*k+1.5*k+1&&n>(k+1)*k/2){
                return k;
            }
        }
         System.out.println(k);
        return -1;
    }


    public static void main(String[] args) {
        coins a = new coins();
        System.out.println(a.arrangeCoins(Integer.MAX_VALUE));
    }
}