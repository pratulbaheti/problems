package hack39_101;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class problem1 {

	final static InputReader in = new InputReader(System.in);
	final static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		int n = in.nextInt();
		HashMap<Integer,Integer>  map = new HashMap<Integer, Integer>();
		int maxCount = Integer.MIN_VALUE;
		int temp=0;
		int count=0;
		for(int i=0;i<n;i++) {
			temp = in.nextInt();
			if(map.containsKey(temp)) {
				count = map.get(temp);
				map.put(temp, ++count);
				maxCount = Integer.max(count, maxCount);
			} else {
				map.put(temp, 1);
				maxCount = Integer.max(1, maxCount);
			}
		}
		System.out.println(n - maxCount);	
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
