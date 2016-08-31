package com.dp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class CandiesHacker {

	final static InputReader in = new InputReader(System.in);
	final static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		int n = in.nextInt();
		Stack<Integer> stack = new Stack<Integer>();
		int count=0;
		for(int i=1;i<=n;i++) {
			int num = in.nextInt();
			int peek = stack.isEmpty() ? Integer.MIN_VALUE: stack.peek();
			
			if(num < peek) {
				stack.push(num);
			} else if (num == peek) {
				
			} else if(num > peek) {
				for(int j=1;!stack.isEmpty();j++) {
					stack.pop();
					count+=j;
				}
			}
		}
		System.out.println(count);
		out.close();
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
