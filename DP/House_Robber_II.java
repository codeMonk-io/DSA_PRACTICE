// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

// Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

// Example 1:

// Input: nums = [2,3,2]
// Output: 3
// Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
// Example 2:

// Input: nums = [1,2,3,1]
// Output: 4
// Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
// Total amount you can rob = 1 + 3 = 4.
// Example 3:

// Input: nums = [1,2,3]
// Output: 3


public class House_Robber_II {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,3,2}));
    }
    public static int rob(int[] nums) {
        int n=nums.length;
        if (n==1) return nums[0];
        int[] dp1 = new int[n];
        for(int i=0;i<n;i++) dp1[i] = -1;
        int case1 = solve(dp1, n-2, 0, nums);

        // Case 2: use 1..n-1
        int[] dp2 = new int[n];
        for(int i=0;i<n;i++) dp2[i] = -1;
        int case2 = solve(dp2, n-1, 1, nums);
        return Math.max(case1, case2);       
    }
    static int  solve(int []dp,int i,int start,int []nums){    
        if(i<start) return 0;
        if(dp[i]!=-1) return dp[i];

        int pick=nums[i]+solve(dp,i-2,start,nums);
        int notPick=solve(dp,i-1, start,nums);
        return dp[i]=Math.max(pick,notPick);
    }
}