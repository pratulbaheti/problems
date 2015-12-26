package codeforces;

import java.util.Scanner;

public class Problem1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int p = in.nextInt();
		int q = in.nextInt();
		String s = in.next();
		int a,b =0;
		
		boolean flag = true;
		for(a=0;a<=n/p;a++) {
			if((n-p*a) % q == 0) {
				b = (n-p*a) / q;
				flag=false;
				break;
			}
		}
		if(flag) {
			System.out.println(-1);
			in.close();
			return ;
		}
		System.out.println(a+b);
		for(int i=0;i<a;i++) {
			String s1 = s.substring(i*p, (i+1)*p);
			System.out.println(s1);
		}
		for(int i=0;i<b;i++) {
			String s2 = s.substring(a*p+i*q, (i+1)*q + a*p);
			System.out.println(s2);
		}
		in.close();
	}

}
