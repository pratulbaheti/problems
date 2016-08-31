package geeksforgeeks;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class MaximumSum {

	final static InputReader in = new InputReader(System.in);
	final static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		int arr[] = {8,3,1,2};
		int arrsum = prodSum(arr);
		int mysum = arraySum(arr);
		int max=0;
		for(int i=0;i<arr.length;i++) {
			max = arrsum > max ? arrsum : max;
			arrsum = arrsum + arr[i]*arr.length - mysum;
		}
		System.out.println(max);
		out.close();
	}
	
	static int arraySum(int arr[]) {
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
		}
		return sum;
	}
	static int prodSum(int arr[]) {
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			sum+=i*arr[i];
		}
		return sum;
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
