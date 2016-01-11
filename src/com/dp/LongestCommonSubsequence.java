package com.dp;

public class LongestCommonSubsequence {

	static char str1[] = {' ','a','b','c','q','r'};
	static char str2[] = {' ','a','c','p','r','q'};
	static int dp[][] = new int[str2.length+1][str1.length+1];

	public static void main(String[] args) {
		// Using recursion || Top Down approach
		int len = recursion(str1.length-1,str2.length-1);
		System.out.println("LCS using recursion " + len);
		// Using DP || Bottom Up approach
		dynamicProg();
	}
	
	static int max(int a,int b,int c) {
		return Math.max(Math.max(a, b),c);
	}
	
	static void dynamicProg() {
		for(int i=0;i<str2.length;i++) dp[i][0] = 0;
		for(int i=0;i<str1.length;i++) dp[0][i] = 0;

		for(int i=1;i<str2.length;i++) {
			for(int j=1;j<str1.length;j++) {
				if(str1[i] == str2[j]) {
					dp[i][j] = 1 +  dp[i-1][j-1];
				} else {
					dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}
		System.out.println("LCS using dp " + dp[str1.length-1][str2.length-1]);
	}
	
	static int recursion(int m,int n) {
		int len=0;
		if(m == 0 || n ==0) return 0;
		
		if(str1[m] == str2[n]) {
			len = 1 + recursion(m-1,n-1);
		} else {
			len = Math.max(recursion(m-1,n), recursion(m,n-1));
		}
		return len;
	}

}
