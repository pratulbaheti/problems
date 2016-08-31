package hack39_101;
import java.io.*;
import java.util.*;

public class problem2 {

	final static InputReader in = new InputReader(System.in);
	final static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		int n = in.nextInt();
		int w = in.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++){
			arr[i]=in.nextInt();
		}
		int count=0;
		int curr=0-w;
		for(int i=0;i<n;i++){
			curr = rightMostSet1(arr, curr, w);
			if(curr==-1) {
				System.out.println(-1);
				break;
			}
			count++;
			if(curr+w>=arr.length) {
				System.out.println(count);
				break;
			}
		}
		
		out.close();
	}
	
	public static int rightMostSet1(int arr[], int s, int w) {
		w=s+2*w;
		if(w>=arr.length)
			w=arr.length-1;
		while(s<w && 0<w) {
			if(arr[w]==1)
				return w;
			w--;
		}
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
