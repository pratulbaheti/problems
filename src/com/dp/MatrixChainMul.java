package com.dp;

public class MatrixChainMul {

	static int p[] = {10, 20, 30, 40, 30};
	static int dp[][] = new int[p.length][p.length];
	
	public static void main(String[] args) {
		int q = bottomUpDp();
		System.out.println("Bottom Up approach: "+q);
		printarr();
		// Initialize to max
		for(int i=0;i<dp.length;i++)
			for(int j=0;j<dp[i].length;j++)
				dp[i][j]=Integer.MAX_VALUE;
		
		q = topDownDp(1, p.length-1);
		System.out.println("Top Down approach: "+q);
		printarr();
	}
	
	static void printarr() {
		for(int i=0;i<p.length;i++) {
			for(int j=0;j<p.length;j++)
				System.out.print(dp[i][j] + " ");
			System.out.println();
		}
	}
	
	static int bottomUpDp() {
		int n = p.length;
		for(int l=2;l<n;l++) {
			for(int i=1;i<n-l+1;i++) {
				int j = i + l -1;
				dp[i][j] = Integer.MAX_VALUE;
				for(int k=i;k<j;k++) {
					int q = dp[i][k] + dp[k+1][j] + p[i-1]*p[k]*p[j];
					if(q < dp[i][j]) {
						dp[i][j] = q;
					}
				}
			}
		}
		return dp[1][n-1];
	}
	
	static int topDownDp(int i, int j) {
		if(i == j) return 0;
		if(dp[i][j] != Integer.MAX_VALUE) 
			return dp[i][j];
		
		for(int k=i;k<j;k++) {
			int q = topDownDp(i,k) + topDownDp(k+1,j) + p[i-1]*p[k]*p[j];
			if(q < dp[i][j]) 
				dp[i][j] = q;
		}
		return dp[i][j];
	}

}
