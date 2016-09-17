package hackerrank.dp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * https://www.hackerrank.com/challenges/maxsubarray
 * @author pratu
 *
 */
public class Maxsubarray {

	final static InputReader in = new InputReader(System.in);
	final static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		int query = in.nextInt();
		for(int q=0;q<query;q++) {
			int num=in.nextInt();
			int arr[] = new int[num];
			int dp[] = new int[num];
			int dp2[] = new int[num];
			arr[0]=in.nextInt();
			dp[0] = arr[0];
			dp2[0] = arr[0];
			int max=dp[0];
			for(int n=1;n<num;n++) {
				arr[n]=in.nextInt();
				dp[n]=max(dp[n-1]+arr[n],arr[n]);
				max=max(max,dp[n]);
				dp2[n]=max(max(dp2[n-1]+arr[n],arr[n]),dp2[n-1]);
			}
			System.out.println(max+" "+dp2[dp2.length-1]);
		}
		out.close();
	}
	
	static int max(int a,int b) {
		return Integer.max(a, b);
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