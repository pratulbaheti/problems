package com.dp;

public class EditDistance {

	static char str1[] = {' ','a','c','p','r','q'};
	static char str2[] = {' ','a','b','c','q','r'};
	static int dp[][] = new int[str2.length+1][str1.length+1];

	public static void main(String[] args) {
		// Using recursion || Top Down approach
		int len = recursion(str1.length-1,str2.length-1);
		System.out.println("Edit Distance using recursion " + len);
		// Using DP || Bottom Up approach
		dynamicProg();
	}
	
	static int recursion(int a, int b) {
		if(a == 0) return b;
		if(b == 0) return a;
		
		if(str1[a] == str2[b]) {
			return recursion(a-1,b-1);
		} else {
			return 1 + Math.min(recursion(a-1,b-1), Math.min(recursion(a-1,b),recursion(a,b-1)));
		}
	}
	
	static void dynamicProg() {
		
	}

}
