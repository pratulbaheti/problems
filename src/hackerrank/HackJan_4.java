package hackerrank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class HackJan_4 {

	final static InputReader in = new InputReader(System.in);
	final static PrintWriter out = new PrintWriter(System.out);
	static int nexts[];
	static int nextb[];
	
	public static void main(String[] args) {
		int n = in.nextInt();
		int arr[] = new int[n+1];
		nexts = new int[n+1];
		nextb = new int[n+1];
		
		for(int i=1;i<=n;i++) {
			arr[i] = in.nextInt();
		}
		merge(arr,1,n);
		
		out.close();
	}
	
	static void merge(int arr[], int start, int end) {
		if(start <= end) {
			if(arr[start] > arr[end]) {
				nexts[start]=end;
			} else if(arr[start] < arr[end]) {
				nextb[start] = end;
			}
			return ;
		}
		
		int mid = (start+end)/2;
		merge(arr,start,mid);
		merge(arr,mid+1,end);
		
		for(int i=start;i<=end;i++) {
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
