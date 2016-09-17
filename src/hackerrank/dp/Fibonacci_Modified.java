package hackerrank.dp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Fibonacci_Modified {

	final static InputReader in = new InputReader(System.in);
	final static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		BigInteger t1 = new BigInteger(Integer.toString(in.nextInt()));
		BigInteger t2 = new BigInteger(Integer.toString(in.nextInt()));
		BigInteger t3 = new BigInteger("0");
		int n = in.nextInt();
		for(int i=3;i<=n;i++) {
			t3 = t2.pow(2).add(t1);
			t1=t2;
			t2=t3;
		}
		System.out.println(t3.toString());
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
