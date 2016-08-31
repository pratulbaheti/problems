package hack39_101;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class problem3 {

	final static InputReader in = new InputReader(System.in);
	final static PrintWriter out = new PrintWriter(System.out);
	static int xarr[];
	static int sarr[];
	
	public static void main(String[] args) {
		int n = in.nextInt();
		int q = in.nextInt();
		int arr[] = new int[n];
		xarr = new int[n];
		sarr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = in.nextInt();
		}
		proprocess(arr);
		System.out.println(g(arr,0,2));
		System.out.println(g(arr,0,1));
//		for(int i=0;i<q;i++) {
//			int x=in.nextInt();
//			int y=in.nextInt();
//			int k=in.nextInt();
//		}
		out.close();
	}
	static void proprocess(int arr[]) {
		xarr[0]=arr[0];
		for(int i=1;i<arr.length;i++)
			xarr[i]=xarr[i-1] ^ arr[i];
		sarr[0]=xarr[0];
		for(int i=1;i<xarr.length;i++)
			sarr[i]=sarr[i-1]+xarr[i];
	}
	
	static int g(int arr[], int x, int y) {
		int sum = (sarr[y]-sarr[x])*(y-x)*(y-x);
		if(sum%2==1)
			sum=sum/2+1;
		else
			sum/=2;
		return sum;
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
