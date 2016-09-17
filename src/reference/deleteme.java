package reference;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class deleteme {

	final static InputReader in = new InputReader(System.in);
	final static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		PriorityQueue<ABC> pq = new PriorityQueue<ABC>();
		ABC arr[] = new ABC[1001];
		for(int i=0;i<=1000;i++){
			arr[i]=new ABC(i);
			pq.add(arr[i]);
		}
		arr[0].data=-1;
		arr[1000].data=49;
		System.out.println(pq.peek().data);
		out.close();
	}
	
	static class ABC implements Comparable<ABC>{
		public int data=Integer.MAX_VALUE;
		ABC(int a) { data=a;}
		@Override
		public int compareTo(ABC a){
			return Integer.compare(data, a.data);
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
