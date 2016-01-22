package codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Educational6_b {

	final static InputReader in = new InputReader(System.in);
	final static PrintWriter out = new PrintWriter(System.out);
	static HashMap<String,Integer> map = new HashMap<String,Integer>();

	public static void main(String[] args) {
		initialize();
		int a = in.nextInt();
		int b = in.nextInt();
		int count=0;
		for(int i=a;i<=b;i++) {
			count+=data(""+i);
		}
		System.out.println(count);
		
		out.close();
	}

	static int data(String s) {
		int count =0;
		for(int i=0;i<s.length();i++) {
			count+=map.get(""+s.charAt(i));
		}
		return count;
	}
	
	static void initialize() {
		map.put("0", 6);
		map.put("1", 2);
		map.put("2", 5);
		map.put("3", 5);
		map.put("4", 4);
		map.put("5", 5);
		map.put("6", 6);
		map.put("7", 3);
		map.put("8", 7);
		map.put("9", 6);
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
