package assignment7;

public class findMaxValueThread extends Thread {
    int lo;
    int hi;
    int [] arr;
    int max =0;

    public findMaxValueThread(int[] arr, int lo, int hi) {
        this.lo = lo;
        this.hi = hi;
        this.arr = arr;
        }

    @Override
    public void run(){
        for (int i = lo;i<hi;i++){
            if(arr[i]>max) max = arr[i];
        }

    }

    public static int findMaxValue(int[] arr) throws InterruptedException{
        int len = arr.length;
        int max = 0;
        findMaxValueThread[] fm =new findMaxValueThread[4];
        for(int i = 0;i<4;i++) {
            fm[i] = new findMaxValueThread(arr,i*len/4,(i+1)*len/4);
            fm[i].start();

        }
        for(int i = 0;i<4;i++) {
            fm[i].join();
            if(fm[i].max>max) max = fm[i].max;
        }
        return max;
    }

    public static void main(String[] args) throws InterruptedException{

        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = (int) (Math.random() * 10);
            System.out.println(arr[i]);
        }
        int max = findMaxValue(arr);
        System.out.println();
        System.out.println(max);
    }
}
