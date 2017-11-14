package assignment7;

class Partition
{
    static boolean isSubsetSum (int arr[], int n, int sum)
    {
        if (sum == 0)
            return true;
        if (n == 0 && sum != 0)
            return false;
        if (arr[n-1] > sum)
            return isSubsetSum (arr, n-1, sum);

        return isSubsetSum (arr, n-1, sum) ||
                isSubsetSum (arr, n-1, sum-arr[n-1]);
    }
    static boolean findPartition (int arr[], int n)
    {
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr[i];
        if (sum%2 != 0)
            return false;
        return isSubsetSum (arr, n, sum/2);
    }

    public static void main (String[] args)
    {
        int arr[] = {1,5,5,11};
        int n = arr.length;
        if (findPartition(arr, n) == true)
            System.out.println("The array can be partitioned ");
        else
            System.out.println("The array cannot be partitioned");
    }
}
