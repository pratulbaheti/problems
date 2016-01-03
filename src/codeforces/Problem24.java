package codeforces;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem24 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int h = in.nextInt();
		String s = in.next();
		System.out.println(recur(s,0));
		System.out.println(list.toString());
		in.close();
	}
		static ArrayList<Integer> list = new ArrayList<Integer>();
	static int recur(String s,int min) {
		if(s.length() == 1 && parse(s) > min) {
			return 1;
		} else if(s.isEmpty()) {
			return 0;
		} else if(parse(s) < min) {
			return -1;
		}
		int counter=0;
		for(int i=1;i<=s.length();i++) {
			String a = s.substring(0,i);
			String b = s.substring(i);
			int a1 = parse(a);
			if(a1 > min) {
				list.add(a1);
				counter++;
			} else {
				continue;
			}
			int temp = recur(b,a1);
			if(temp == -1) {
				continue;
			}
			counter+=temp;
		}
		return counter;
	}
	
	static int parse(String s) {
		return Integer.parseInt(s);
	}
	
}