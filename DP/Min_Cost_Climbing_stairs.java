// 746. Min Cost Climbing Stairs

// You are given an integer array cost where cost[i] is the cost of ith step on a staircase. 
// Once you pay the cost, you can either climb one or two steps.
// You can either start from the step with index 0, or the step with index 1.
// Return the minimum cost to reach the top of the floor.
// Example 1:

// Input: cost = [10,15,20]
// Output: 15
// Explanation: You will start at index 1.
// - Pay 15 and climb two steps to reach the top.
// The total cost is 15.
// Example 2:

// Input: cost = [1,100,1,1,1,100,1,1,100,1]
// Output: 6
// Explanation: You will start at index 0.
// - Pay 1 and climb two steps to reach index 2.
// - Pay 1 and climb two steps to reach index 4.
// - Pay 1 and climb two steps to reach index 6.
// - Pay 1 and climb one step to reach index 7.
// - Pay 1 and climb two steps to reach index 9.
// - Pay 1 and climb one step to reach the top.
// The total cost is 6.


//bottom up
// class Solution {
//     public int minCostClimbingStairs(int[] cost) {
//         int n = cost.length;
//         int dp[] = new int[n + 1];
//         Arrays.fill(dp, -1);
//         return solve(n, dp, cost);
//     }

//     int solve(int i, int dp[], int cost[]) {
//         if (i == 0) return cost[0];
//         if (i == 1) return cost[1];
//         if (dp[i] != -1) return dp[i];
//         if (i == cost.length)
//             return dp[i] = Math.min(solve(i - 1, dp, cost),solve(i - 2, dp, cost));
//         dp[i] = cost[i] + Math.min(solve(i - 1, dp, cost),solve(i - 2, dp, cost));
//         return dp[i];
//     }
// }


//top down
// class Solution {
//     public int minCostClimbingStairs(int[] cost) {
//         int n = cost.length;
//         int[] dp = new int[n];
//         Arrays.fill(dp, -1);
//         return Math.min(solve(0, cost, dp), solve(1, cost, dp));
//     }
//     int solve(int i, int[] cost, int[] dp) {
//         // Base Case
//         if (i >= cost.length)
//             return 0;
//         // Memoization
//         if (dp[i] != -1)
//             return dp[i];
//         int oneStep = cost[i] + solve(i + 1, cost, dp);
//         int twoStep = cost[i] + solve(i + 2, cost, dp);
//         dp[i] = Math.min(oneStep, twoStep);
//         return dp[i];
//     }
// }