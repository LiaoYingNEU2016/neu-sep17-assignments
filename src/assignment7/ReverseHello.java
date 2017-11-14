package assignment7;

public class ReverseHello extends Thread{
int num ;
public ReverseHello(int num){
    this.num = num;
}
public void run() {
    if(num == 0){return;}
    System.out.println("Hello From Thread "+ num);
    num--;
    ReverseHello thread = new ReverseHello(num);
    thread.start();
}
public static void main(String[] args) {
        ReverseHello thread = new ReverseHello(50);
        thread.start();
    }
}
