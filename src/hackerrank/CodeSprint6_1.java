package hackerrank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class CodeSprint6_1 {

	final static InputReader in = new InputReader(System.in);
	final static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		int[] arr1 = new int[5];
		int[] arr2 = new int[5];
		for(int i=0;i<5;i++)
			arr1[i]=in.nextInt();
		for(int i=0;i<5;i++)
			arr2[i]=in.nextInt();
		int sum=0;
		for(int i=0;i<5;i++) {
			int diff = diff(arr1[i], arr2[i]);
			sum+=diff;
		}
		System.out.println(sum);
	}
	
	public static int diff(int a, int b) {
		int x = a-b;
		if(x<0) 
			x+=10;
		int y =b-a;
		if(y<0)
			y+=10;
		return Integer.min(x, y);
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
