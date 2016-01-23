package hackerrank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class HackJan_3 {

	final static InputReader in = new InputReader(System.in);
	final static PrintWriter out = new PrintWriter(System.out);
	static int[] arr;
	static int[] bit = new int[50000+1];
	static int p;
	public static void main(String[] args) {
		int test = in.nextInt();
		int verify = 0;
		for (int t = 0; t < test; t++) {
			int n = in.nextInt();
			p = in.nextInt();
			int k = Math.min(300,in.nextInt());
			arr = new int[n+1];
			
			for (int i = 1; i <= n; i++) {
				int val = in.nextInt();
				verify+=val;
				update(i, val);
			}
			System.out.println(verify);
			long max = 0;
			long sum = 0;
			for (int w = k; w <= n; w++) {
				for (int i = 1; i <= n - w + 1; i++) {
					sum = read(i + w - 1) - read(i - 1);
					max = Math.max(max, sum);
				}
			}
			bit = new int[50000+1];
			if(max%n == 0) {
				System.out.println(max/n + " " +  1);
			} else {
				System.out.println(max + " " + n);
			}
		}
		out.close();
	}
	
	public static int read(int i) {
		int resultSum = 0;
		while(i>0) {
			resultSum+=bit[i];
			resultSum%=p;
			i-=i&(-i);
		}
		return resultSum;
	}
	
	public static void update(int x,int val) {
		while(x<bit.length) {
			bit[x]=(bit[x] + val)%p;
			x+=x&(-x);
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
