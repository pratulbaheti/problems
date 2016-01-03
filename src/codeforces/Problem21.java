package codeforces;

import java.util.Scanner;

public class Problem21 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long x = in.nextLong();
		long y = in.nextLong();
		long counter =0;
		double maxx = (long)(Math.log10(x)/Math.log10(2));
		maxx++;
		double maxy = (long)(Math.log10(y)/Math.log10(2));
		maxy++;
		
		long num =(long)Math.pow(2, maxx);
		long temp = --num;
		String s="";
		for(int i=0;i<=y && temp>=x;i++) {
			s= Long.toBinaryString(temp);
			if(s.indexOf('0') == s.lastIndexOf('0') && s.indexOf('0') > -1 && temp <=y) {
				counter++;
			}
			temp=num - (long)Math.pow(2, i);
		}

		if(maxx == maxy) {
			System.out.println(counter);
			return ;
		}
		long num1 = num+2;
		num =(long)Math.pow(2, maxy);
		temp = --num;
		for(int i=0;i<=y && temp>=num1;i++) {
			s= Long.toBinaryString(temp);
			s.trim();
			if(s.indexOf('0') == s.lastIndexOf('0') && s.indexOf('0') > -1  && temp <=y) {
				counter++;
			}
			temp=num - (long)Math.pow(2, i);
		}
		System.out.println(counter);
		
	}

}
