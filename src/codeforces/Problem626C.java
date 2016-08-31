package codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Problem626C {

	final static InputReader in = new InputReader(System.in);
	final static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		int n = in.nextInt();
		int m = in.nextInt();
		HashSet<Integer> set = new HashSet<Integer>();
		
		int j=0;
		int max=Integer.MIN_VALUE;
		
		for(int i=1;i<=n+m;i++) {
			j++;
			if(i<=n) {
				if(!set.contains(2*j)){
					set.add(2*j);
					if(2*j > max) {
						max = 2*j;
					}
				}
				
				else{
					set.add(2*(j+1));
					if(2*(j+1) > max) {
						max = 2*(j+1);
					}
					j++;
				}
			}
			
			if(i<=m) {
				set.add(3*i);
				if(3*i > max) {
					max = 3*i;
				}
			}
		}
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
