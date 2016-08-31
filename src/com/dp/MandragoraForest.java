package com.dp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class MandragoraForest {

	final static InputReader in = new InputReader(System.in);
	final static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) { 
		int query = in.nextInt();
		for(int q=0;q<query;q++) {
			int n = in.nextInt();
			int arr[] = new int[n];
			int parr[] = new int[n];
			int sarr[] = new int[n];
			parr[0] = 0;
			sarr[0] = 2;
			long max = Long.MIN_VALUE; 
			long temp = 0;
			for(int i=0;i<n;i++) {
				arr[i] = in.nextInt();
			}
			Arrays.sort(arr);
			long aux[] = sumarray(arr);
			for(int i=0;i<n;i++) {
				temp = (i+1) * aux[i];
				max = Long.max(temp, max);
			}
			System.out.println(max);
		}
		out.close();
	}
	
	static long[] sumarray(int arr[]) {
		long aux[] = new long[arr.length];
		aux[arr.length-1] = arr[arr.length-1];
		for(int i=arr.length-2;i>=0;i--) {
			aux[i] = aux[i+1] + arr[i];
		}
		return aux;
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
