package zapos;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class NumberOfPalindrome {

	final static InputReader in = new InputReader(System.in);
	final static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		String s = "aabbaa";
		int ans = palindrome(s);
		System.out.println(ans);
		for(String a:set) {
			System.out.println(a);
		}
		out.close();
	}
	
	static HashSet<String> set = new HashSet<String>();
	static int palindrome(String str) {
		char[] arr = str.toCharArray();
		int length = arr.length-1;

		// Test for Odd length
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<=arr.length/2;j++) {
				if(i-j >= 0 && i+j <= length) {
					if(arr[i-j] == arr[i+j]) {
						set.add(str.substring(i-j, i+j+1));
					} else {
						break;
					}
				}
			}
		}
		
		// Test for even length
		for(int i=1;i<arr.length;i++) {
			for(int j=1;j<=arr.length/2;j++) {
				if(i-j >= 0 && i+j-1 <= length) {
					if(arr[i-j] == arr[i+j-1]) {
						set.add(str.substring(i-j, i+j));
					} else {
						break;
					}
				}
			}
		}
		
		return set.size();
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
