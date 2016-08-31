package hackerrank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;


public class CodeSprint6_3 {

	final static InputReader in = new InputReader(System.in);
	final static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		int q = in.nextInt();
		for(int a=0;a<q;a++) {
			int n = in.nextInt();
			int arr[][] = new int[2*n][2*n];
			for(int i=0;i<2*n;i++) {
				for(int j=0;j<2*n;j++) {
					arr[i][j] = in.nextInt();
				}
			}
			System.out.println(output(arr, n));
		}
		out.close();
	}
	
	static int output(int arr[][], int k) {
		int sum=0;
		int n = arr.length-1;
		for(int i=0;i<k;i++) {
			for(int j=0;j<k;j++) {
				int max = Integer.MIN_VALUE;
				max = Integer.max(max, arr[i][j]);
				max = Integer.max(max, arr[i][n-j]);
				max = Integer.max(max, arr[n-i][j]);
				max = Integer.max(max, arr[n-i][n-j]);
				sum+=max;
			}
		}
		return sum;
	}
	
	static int match(char a, char b) {
		if(Character.toUpperCase(a) == b) {
			return 1;
		} else if ('a' <= a && a <= 'z') {
			return 0;
		} else 
			return -1;
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
