package codeforces;

import java.math.BigInteger;
import java.util.Scanner;

public class Educational5 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String a = in.nextLine();
		String b = in.nextLine();
		
		Double a1 = new Double(a);
		Double b1 = new Double(b);
		int x = a1.compareTo(b1);
		if(x==0) {
			System.out.println("=");
		} else if (x>0) {
			System.out.println(">");
		} else {
			System.out.println("<");
		}
		in.close();
	}
	
	static String trimZero(String s) {
		char arr[] = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<s.length();i++) {
			if(arr[i] != '0') {
				sb.append(arr[i]);
			}
		}
		return sb.toString();
	}
}
