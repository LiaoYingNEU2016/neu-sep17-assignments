package midterm;

public class reverseEvenIndex {

    int[] reverseEvenIndices(int[] nums){
        int temp;
        for(int i = 0;i < nums.length/2; i=i+2){
            if(nums.length%2 == 0){
                temp = nums[nums.length-i-2];
                nums[nums.length-i-2] = nums[i];
                nums[i] = temp;}
            else{temp = nums[nums.length-i-1];
                nums[nums.length-i-1] = nums[i];
                nums[i] = temp;
            }
                }
        return nums;
    }

}
class reverseEvenIndicesTest{


    public static void main(String[] args) {
        int[]b = {6,4,1,0,3,2};
        reverseEvenIndex a = new reverseEvenIndex();
        a.reverseEvenIndices(b);
        for(int j = 0 ;j <a.reverseEvenIndices(b).length;j++){
        System.out.println(a.reverseEvenIndices(b)[j]);}
    }
}