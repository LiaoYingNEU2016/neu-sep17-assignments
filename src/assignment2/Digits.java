package assignment2;
class addDigits {

    public int addDigits(int input) {
        int i;
        int result;
        i = 0;
        result = 0;
        while (input >= 10) {
            i = input % 10;
            result += i;
            input /= input / 10;
        }
        result = (result < 10)? result : addDigits(result);
        return result;
    }
}




