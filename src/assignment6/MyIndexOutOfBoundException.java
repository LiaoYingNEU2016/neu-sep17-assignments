package assignment6;

public class MyIndexOutOfBoundException extends Exception {
    int index;

    static void enterNumber(int index) throws MyIndexOutOfBoundException {
        if (index <= 9 && index >= 0) {
            System.out.println("index" + index);
        } else {
            throw new MyIndexOutOfBoundException(index);
        }
    }

    public MyIndexOutOfBoundException(int index) {
        int lowerBound = 0;
        int upperBound = 9;
        this.index = index;
        System.out.println("\"Error Message: " + "Index: " + this.index + ", but Lower bound: "
                + lowerBound + ", Upper bound: " + upperBound + "\"" + "\n");
    }

    public static void main(String[] args) {
        int index = 10;
        try {
            enterNumber(index);
        } catch (MyIndexOutOfBoundException ex) {
            ex.printStackTrace();
        }
    }
}





