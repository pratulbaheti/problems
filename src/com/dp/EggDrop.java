package com.dp;

public class EggDrop {

	static int F =30;
	static int E = 4;
	static int dp[][] = new int[E+1][F+1];
	
	public static void main(String[] args) {
		for (int i = 0; i <= E; i++) {
			for (int j = 0; j <= F; j++) {
				if(i ==0 || j==0) {
					dp[i][j] = 0;
				} else {
					dp[i][j] = j;
				}
			}
		}
		for (int i = 0; i < E; i++) {
			for (int j = 0; j <= F; j++) {
				System.out.format("%3d",dp[i][j]);
			}
			System.out.println();
		}
		System.out.format("%3d",dp[2][0]);
		System.out.format("%3d",dp[2][1]);
		int q =0;
		for (int e = 2; e <= E; e++) {
			for (int f = 2; f <= F; f++) {
				dp[e][f] = Integer.MAX_VALUE;
				for(int k = 1;k <= f;k++) {
					q = 1 + Math.max(dp[e-1][k-1], dp[e][f-k]);
					if(q < dp[e][f])
						dp[e][f] = q;
				}
				System.out.format("%3d",dp[e][f]);
			}
			System.out.println();
		}
	}		
}
