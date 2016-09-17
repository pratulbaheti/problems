package hackerrank.dp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class array_splitting {

	final static InputReader in = new InputReader(System.in);
	final static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		int query = in.nextInt();
		for(int q=0;q<query;q++) {
			int n= in.nextInt();
			long dp[] = new long[n+1];
			dp[0] = 0;
			for(int i=1;i<=n;i++) {
				dp[i]=dp[i-1]+in.nextInt();
			}
			long val = biggerHalf(1,dp.length-1,dp);
			System.out.println(val);
		}
		out.close();
	}
	
	static int biggerHalf(int start, int end, long arr[]) {
		if(start>=end) return 0;
		long half = arr[end]+arr[start-1];
		half = half%2 == 0 ? half/2 : -1;
		if(half<0) return 0;
		int pos = binarySearch(start, end, half, arr);
		if(pos < 0)
			return 0;
		if(end-pos > pos-start+1)
			return 1 + biggerHalf(pos+1, end, arr);
		else
			return 1 + biggerHalf(start, pos, arr);
	}
	
	static int binarySearch(int start, int end, long key, long arr[]) {
		int mid = (start+end)/2;
		if(start >= end) {
			return arr[start] == key ? start : -1;
		}
		if(arr[mid] >= key) {
			return binarySearch(start, mid, key, arr);
		} else if(arr[mid] < key) {
			return binarySearch(mid+1, end, key, arr);
		}
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