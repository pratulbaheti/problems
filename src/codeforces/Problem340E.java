package codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Problem340E {

	final static InputReader in = new InputReader(System.in);
	final static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();
		int arr[] = new int[n+10];
		HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>> ();
		for(int i=1;i<=n;i++) {
			int x = arr[i-1] ^ in.nextInt();
			arr[i]=x;
			if(map.containsKey(x)) {
				map.get(x).add(i);
			} else {
				ArrayList<Integer> al = new ArrayList<Integer>();
				al.add(i);
				map.put(x,al);
			}
		}
		int count=0;
		for(int i=0;i<m;i++) {
			int l = in.nextInt();
			int r = in.nextInt();
			
			for(int j=l;j<=r;j++) {
				int q = arr[j-1];
				int xor = q^k;
				if(!map.containsKey(xor)) {
					continue;
				}
				ArrayList<Integer> al = map.get(xor);
				for(int a:al) {
					if(a >= l && a <= r && a >= j) {
						count++;
					}
					if(a > r) {
						break;
					}
				}
			}
			System.out.println(count);
			count=0;
		}
		
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
