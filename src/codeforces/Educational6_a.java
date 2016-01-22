package codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Educational6_a {

	final static InputReader in = new InputReader(System.in);
	final static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		int x1 = in.nextInt();
		int y1 = in.nextInt();
		int x2 = in.nextInt();
		int y2 = in.nextInt();
		
		int d1 = distance(x1,y1);
		int d2 = distance(x2,y2);
		
		if(d1 < d2) {
			x2 = Math.abs(x2-x1);
			y2 = Math.abs(y2-y1);
			
			if(x2 < y2) {
				System.out.println(y2);
			} else {
				System.out.println(x2);
			}
		} else {
			x1 = Math.abs(x1-x2);
			y1 = Math.abs(y1 - y2);
			
			if(x1<y1) {
				System.out.println(y1);
			} else {
				System.out.println(x1);
			}
			
		}
		out.close();
	}
	
	static int distance(int x,int y) {
		return x*x + y*y;
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
