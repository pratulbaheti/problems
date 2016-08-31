package com.dp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class CoinChangingProblem {

	final static InputReader in = new InputReader(System.in);
	final static PrintWriter out = new PrintWriter(System.out);

	static int table[];
	public static void main(String[] args) {
		int n = 4;
		int m = 3;
		int S[] = {1,2,3,4};
		table = new int[n+1];
		table[0]=1;
		for(int i=0;i<m;i++) {
			int Si = S[i];
			for(int j=Si;j<=n;j++) {
				table[j] = table[j] + table[j-S[i]];
			}
		}
		System.out.println(table[n]);
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
