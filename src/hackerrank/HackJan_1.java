package hackerrank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class HackJan_1 {

	final static InputReader in = new InputReader(System.in);
	final static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		int n = in.nextInt();
		int arr[] = new int[n+1];
		int dp[] = new int[n+1];
		
		arr[0] = in.nextInt();
		dp[0] = arr[0];
		int current=0;
		long max=dp[0];
		for(int i=1;i<n;i++) {
			current=in.nextInt();
			arr[i] = current;
			if(current != 0) {
				int sum = dp[i-1] + current;
				if(sum > arr[i]) 
					dp[i] = sum;
				else
					dp[i]=arr[i];
			}
			max = Math.max(dp[i], max);
		}
		if(max == Integer.MIN_VALUE) {
			System.out.println(0);
		} else 
			System.out.println(max);
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
