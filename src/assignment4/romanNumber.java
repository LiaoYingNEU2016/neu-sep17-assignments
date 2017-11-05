package assignment4;

public class romanNumber {
    public static String convertIntToRoman(int num) {
        int[] n = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] str = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX",
                "V", "IV", "I" };
        StringBuilder romanNumber = new StringBuilder("");
        int i = 0;
        while (num != 0) {
            if (num >= n[i]) {
                num -= n[i];
                romanNumber.append(str[i]);
            } else
                i++;
        }
        return romanNumber.toString();
    }
}
