package midterm;

public class minMove {
    int Moves = 0;
    public int minMoves(int[] nums) {

        while (!allElementsAreEqual(nums)) {
            int temp = indexOfMax(nums);
            for (int i = 0; i < nums.length; i++) {
                if (i != temp) {
                    nums[i] = nums[i] + 1;
                }
            }
            Moves++;
            for(int num:nums) System.out.print(num+",");
            System.out.println();

        }
        return Moves;
    }

    boolean allElementsAreEqual(int[] nums) {
        //System.out.println(Moves);
        int temp = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                temp++;
            }
        }
        if (temp == nums.length - 1) {
            return true;
        }
        return false;
    }

    int indexOfMax(int[] nums) {
        int location = 0;
        int max = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > max) {
                max = nums[i];
                location = i;
            }
        }
       // System.out.println(location);
        return location;
    }
}

class minMoveTest{
    public static void main(String[] args) {
        minMove min = new minMove();
        int[] a = {1, 2, 3, 4};
        System.out.println(min.minMoves(a));
    }
}