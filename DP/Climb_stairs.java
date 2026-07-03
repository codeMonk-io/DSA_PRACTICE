// There are n stairs, a person standing at the bottom wants to reach the top. 
// The person can climb either 1 stair or 2 stairs at a time.
// Your task is to count the number of ways, the person can reach the top (order does matter).
// Examples:
// Input: n = 1
// Output: 1
// Explanation: There is only one way to climb 1 stair. 
// Input: n = 3
// Output: 3
// Explanation: The following are three ways to reach the n-th stair.

// //memoization
// class Solution {
//     public int countWays(int n) {
//         int dp []=new int [n+1];
//         Arrays.fill(dp,-1);
//         return solve(n,dp);
//     }
//     int solve(int n,int []dp){
//         if(n==1)return 1;
//         if(n==0)return 1;
        
//         if(dp[n]!=-1)return dp[n];
//         int fir=solve(n-1,dp);
//         int sec=solve(n-2,dp);
//         dp[n]=fir+sec;
//         return dp[n];
//     }
// }
