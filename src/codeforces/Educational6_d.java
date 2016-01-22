package codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Educational6_d {

	final static InputReader in = new InputReader(System.in);
	final static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		int n = in.nextInt();
		int arr1[] = new int[n+1];
		int sum1=0;
		for(int i=1;i<=n;i++) {
			arr1[i] = in.nextInt();
			sum1+=arr1[i];
		}
		
		int n1 = in.nextInt();
		int sum2=0;
		int arr2[] = new int[n1+1];
		for(int i=1;i<=n;i++) {
			arr2[i] = in.nextInt();
			sum2+=arr2[i];
		}
		
		if(sum1 > sum2) {
			Arrays.sort(arr1);
			for(int i=0;i<arr1.length/2;i++) {
				int temp = arr1[0];
				arr1[i] = arr1[arr1.length-i-1];
				arr1[arr1.length-i-1] = temp;
			}
		} else if (sum1 == sum2) {
			System.out.println(0);
			System.out.println(0);
		} else {
			Arrays.sort(arr2);
			for(int i=0;i<arr2.length/2;i++) {
				int temp = arr2[0];
				arr2[i] = arr2[arr2.length-i-1];
				arr2[arr2.length-i-1] = temp;
			}
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
