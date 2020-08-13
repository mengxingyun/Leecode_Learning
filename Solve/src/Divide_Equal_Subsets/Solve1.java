package Divide_Equal_Subsets;

import java.util.Arrays;
import java.util.Comparator;

public class Solve1 {
    public static boolean DFS(int [] nums, int half_sum, int cur_sum, int start)
    {
        for(int i = start; i < nums.length; i++)
        {
            if(nums[i] == half_sum - cur_sum)
            {
                return true;
            }
            else if(nums[i] < half_sum - cur_sum)
            {
                if(DFS(nums, half_sum, cur_sum + nums[i], i + 1))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean canPartition(int [] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length / 2; i++)
        {
            int temp = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = nums[i];
            nums[i] = temp;
        }
        int sum = 0;
        for(int num: nums)
        {
            sum = sum + num;
        }
        if(sum % 2 == 1) {
            return false;
        }
        sum = sum / 2;
        if(nums[0] > sum)
        {
            return false;
        }
        return DFS(nums, sum, 0, 0);
    }

    public static void main(String [] args)
    {
        int [] arr = {4, 5, 1, 4, -5, 24};
        System.out.print(canPartition(arr));
    }
}
