package Divide_Equal_Subsets;

public class Solve2 {
    public static boolean canPartition(int [] nums) {
        if(nums.length == 0)//空集
        {
            return false;
        }

        int sum = 0;
        for(int num : nums)
        {
            sum = sum + num;
        }
        if((sum & 1) == 1)//奇数
        {
            return false;
        }
        sum = sum / 2;
        boolean [][] dp = new boolean[nums.length][sum + 1];

        for(int i = 0; i < sum + 1; i++)
        {
            if(nums[0] == i)
            {
                dp[0][nums[0]] = true;
            }
            else
            {
                dp[0][i] = false;
            }
        }

        for(int i = 1; i < nums.length; i++)
        {
            for(int j = 0; j < sum + 1; j++)
            {
                dp[i][j] = dp[i - 1][j];

                if(nums[i] == j)
                {
                    dp[i][j] = true;
                }
                else if(nums[i] < j)
                {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }

        return dp[nums.length - 1][sum];
    }
}
