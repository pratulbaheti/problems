package com.dp;

public class SubsetSum {

	public static void main(String[] args) {
		int arr[] = {3, 2, 5, 9, 13};
		int sum =  17;
		boolean dp[][] = new boolean[arr.length+1][sum+1];
		
		for(int i=0;i<arr.length+1;i++) {
			dp[i][0]=true;
		}
		for(int i=0;i<sum+1;i++) {
			dp[0][i]=false;
		}
		
		for(int i=1;i<=arr.length;i++) {
			for(int j=1;j<=sum;j++) {
				if(arr[i-1] > j) {
					dp[i][j] = dp[i-1][j];
				} else {
					dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
				}
			}
		}
		System.out.println(dp[arr.length][sum]);
	}
}
