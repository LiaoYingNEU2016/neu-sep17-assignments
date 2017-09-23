package assignment2;
class Digits {
    public static void main(String[] args) {
        Digits test = new Digits();
        System.out.println(test.addDigits(1561));

    }
    public int addDigits(int input) {
        int i;
        int result;
        i = 0;
        result = 0;
        while (input > 0) {
            i = input % 10;
            result += i;
            input = input / 10;
        }
        result = (result < 10)? result : addDigits(result);
        return result;
    }
}




