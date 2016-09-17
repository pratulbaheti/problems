package com.microsoft;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution1 {

	final static InputReader in = new InputReader(System.in);
	final static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		String arr[] = str.split(" ");
		List<String> list = new ArrayList<String>();
		list.add(arr[0]);
		String old = arr[0];
		for(int i=1;i<arr.length-1;i++) {
			old = nextColor(arr[i],old);
			list.add(old);
		}
		list.add(arr[arr.length-1]);
		for(int i=0;i<arr.length-2;i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.print(list.get(arr.length-1));
		in.close();
	}
	
	static String nextColor(String s, String old) {
		if(s.equals("purple")) {
			if(old.equals("red"))
				return "blue";
			else
				return "red";
		} else if(s.equals("green")) {
			if(old.equals("blue"))
				return "yellow";
			else
				return "blue";
		} else if(s.equals("orange")) {
			if(old.equals("yellow"))
				return "red";
			else
				return "yellow";
		} else if(old.equals("blank")) {
			return s;
		}
		else if(s.equals(old)){
			return "blank";
		} else {
			return old;
		}
	}
	
	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}
	}

}
