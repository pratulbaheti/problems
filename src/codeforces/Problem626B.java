package codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Problem626B {

	final static InputReader in = new InputReader(System.in);
	final static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		int n = in.nextInt();
		String str = in.next();
		char[] arr = str.toCharArray();
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		map.put('R', 0);
		map.put('B', 0);
		map.put('G', 0);

		int temp=0;
		for(int i=0;i<n;i++) {
			temp = map.get(arr[i]);
			map.put(arr[i],temp+1);
		}
		int r = map.get('R');
		int b = map.get('B');
		int g = map.get('G');
		
		if(r>0 && b>0 && g>0) {
			System.out.println("RBG");
		} else if(r==0 && b==0 && g>0){
			System.out.println("G");
		} else if(r>0 && b==0 && g==0){
			System.out.println("R");
		} else if(r==0 && b>0 && g==0){
			System.out.println("B");
		} else if(r%2==0 && b==0 && g>0){
			System.out.println("G");
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
