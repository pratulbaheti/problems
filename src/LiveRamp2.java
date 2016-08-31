import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class LiveRamp2 {

	final static InputReader in = new InputReader(System.in);
	final static PrintWriter out = new PrintWriter(System.out);
	
	static int dp[] ;
	
	public static void main(String[] args) {
		int arr[] = {8,7,6,3};
		 int x = 10;
		 int d = 3;
		 dp = new int[x];
		 int totalTime = solution(arr,x,d);
		 System.out.println(totalTime);
		out.close();
	}
	
	public static int solution(int arr[], int x, int d) {
		int curr = 0;
		//BaseCase
        if(curr+d>x) {
        	return 0;
        }
        
		for (int timer = 0; timer < arr.length; timer++) {
			int temp = arr[timer];
			if (temp <= curr)
				continue;
			
			if (dp[temp] == 0) {
				for (int i = temp; i >= temp - d && i>=0; i--) {
					if (dp[i] != 0) {
						dp[i] = temp;
						break;
					}
					dp[i] = temp;
				}
			} else {
				int val=dp[temp];
				for(int i=temp-d;i<=val-d-1;i++) {
					if (dp[i] != 0) {
//						dp[i] = temp;
						break;
					}
					dp[i] = temp;
				}
			}
			try {
			while(curr!=x && dp[curr] != 0 && dp[curr] != curr) {
					curr=dp[curr];
			}
			} catch(ArrayIndexOutOfBoundsException e) {
				System.out.println(curr);
			}
			
			if(curr+d>=x) {
	        	return timer;
	        }
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
