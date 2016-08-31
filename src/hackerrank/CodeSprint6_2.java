package hackerrank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * https://www.hackerrank.com/contests/world-codesprint-6/challenges/abbr/submissions/code/6799149
 * @author pratu
 *
 */
public class CodeSprint6_2 {

	final static InputReader in = new InputReader(System.in);
	final static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		int q = in.nextInt();
		for(int x=0;x<q;x++) {
			String astr = in.next();
			String bstr = in.next();
			char[] a = astr.toCharArray();
			char[] b = bstr.toCharArray();
			int arr[][] = new int[b.length+1][a.length+1];
			arr[0][0] = 0;
			for(int i=0;i<a.length;i++) {
				arr[0][i+1] = Character.isUpperCase(a[i]) ? arr[0][i]+1 : arr[0][i]+0;
			}
			for(int i=0;i<b.length;i++) {
				arr[i+1][0] = i+1;
			}
			for(int i=0;i<b.length;i++) {
				for(int j=0;j<a.length;j++) {
					if(b[i] == Character.toUpperCase(a[j])) {
						arr[i+1][j+1] = arr[i][j];
					} else if(Character.isLowerCase(a[j])) {
						int up = arr[i][j+1]+1;
						int left = arr[i+1][j];
						arr[i+1][j+1] = Integer.max(up, left);
					} else {
						int up = arr[i][j+1]+1;
						int left = arr[i+1][j]+1;
						arr[i+1][j+1] = Integer.max(up, left);
					}
				}
			}
			
			for(int i=0;i<=b.length;i++) {
				for(int j=0;j<=a.length;j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
			boolean flag = false;
			for(int i=a.length;i>0;i--) {
				if(arr[b.length][i] == 0) {
					System.out.println("YES");
					flag=true;
					break;
				} else if(Character.isUpperCase(a[i-1])) {
					System.out.println("NO");
					flag=true;
					break;
				}
			}
			if(!flag)
				System.out.println("NO");
		}
		out.close();
	}
	
	static int match(char a, char b) {
		if(Character.toUpperCase(a) == b) {
			return 1;
		} else if ('a' <= a && a <= 'z') {
			return 0;
		} else 
			return -1;
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
