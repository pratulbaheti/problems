package codeforces;

import java.util.Scanner;

public class Problem338D {

	static long prime = (long) (Math.pow(10, 9)+7);
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long ans = 1;
		long temp=0;
		for(int i=0;i<n;i++) {
			temp = in.nextLong();
			temp = (long)Math.pow(temp, n);
			ans=modMul(ans%prime,temp);
		}
		System.out.println(ans);
		in.close();
	}
	
	static long modMul(long ans,long mul) {
		return (ans*mul)%prime;
	}
}