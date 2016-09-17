package com.microsoft;

import java.util.*;

class Solution2 {
	static char[] str;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			String input = in.nextLine();
			try {
				str = input.substring(0, 64).toCharArray();
			} catch(IndexOutOfBoundsException e) {
				break;
			}
			char[] key = input.substring(65).toCharArray();
			int mod = key.length;
			char[] res = new char[str.length];
			int cnt=0;
			for(int i=0;i<str.length;i++) {
				int c = str[i];
				int t = key[cnt%mod];
				if('a' <= c && c <= 'z') {
					c = (c - 'a');
					t = (t - 'A');
					res[i] = (char) ((c + t + 1)%26 + 'a');
					cnt++;
				} else if('A' <= c && c <= 'Z') {
					c = (c - 'A');
					t = (t - 'A');
					res[i] = (char) ((c + t + 1)%26 + 'A');
					cnt++;
				} else {
					res[i] = (char)c;
					//cnt++;
				}
				System.out.print(res[i]);
			}
			String output = new String(res);
//			System.out.println(output);
		}
		in.close();
	}
	
}