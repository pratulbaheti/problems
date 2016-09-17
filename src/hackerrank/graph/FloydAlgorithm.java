package hackerrank.graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

// https://www.hackerrank.com/challenges/floyd-city-of-blinding-lights
// Shortest Distance between two nodes
public class FloydAlgorithm {

	final static InputReader in = new InputReader(System.in);
	final static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		int n = in.nextInt();
		int m = in.nextInt();
		int arr[][] = new int[n+1][n+1];
		for(int i=1;i<arr[0].length;i++) {
			for(int j=1;j<arr[0].length;j++) {
				if(i != j) {
					arr[i][j]=Integer.MAX_VALUE;
				} else {
					arr[i][j]=0;
				}
			}
		}
		for(int i=0;i<m;i++) {
			int n1 = in.nextInt();
			int n2 = in.nextInt();
			int e = in.nextInt();
			arr[n1][n2] = e;
		}
		floydWarshall(arr);
		int q = in.nextInt();
		for(int i=0;i<q;i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			if(arr[a][b] == Integer.MAX_VALUE){
				System.out.println(-1);
				continue;
			}
			System.out.println(arr[a][b]);
		}
		out.close();
	}
	
	public static void floydWarshall(int arr[][]) {
		for(int k=1;k<arr[0].length;k++) {
			for(int i=1;i<arr[0].length;i++) {
				for(int j=1;j<arr[0].length;j++) {
					int temp_max = arr[i][k]+arr[k][j];
					if(temp_max < -1)
						temp_max = Integer.MAX_VALUE;
					arr[i][j] = Integer.min(arr[i][j], temp_max);
				}
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
