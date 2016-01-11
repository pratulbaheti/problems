package codeforces;

import java.util.LinkedList;
import java.util.Scanner;

public class Problem338C {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
//		String s = in.next();
	//	String t = in.next();

		String s1 = "abc";
		String s2 = "cbaabc";
		String s1rev = new StringBuilder(s1).reverse().toString();
		int n = s1.length();
		String ans = "";
		String temp = "";//s2.substring(0,0);
		LinkedList<Integer> list = new LinkedList<Integer>(); 
		for(int i=1;i<=s2.length();i++) {
			ans = temp+s2.substring(i-1,i);
			if(s1.contains(ans) || s1rev.contains(ans)) {
				temp = ans;
			} else {
				if(ans.length() == 1) {
					System.out.println("-1");
				} else if(s1.contains(temp)){
					int start = s1.indexOf(temp);
					int end = start + temp.length() - 1;
					list.add(start);
					list.add(end);
				} else if(s1rev.contains(temp)) {
					int start = n - s1rev.indexOf(temp);
					int end = n - temp.length()+1;
					list.add(start);
					list.add(end);
				}
				temp = s2.substring(i-1,i);
			}
		}
		System.out.println(list.size()/2);
		for(int i=0;i<list.size();i+=2) {
			System.out.println(list.get(i)+" "+list.get(i+1));
		}
		in.close();
	}

}
