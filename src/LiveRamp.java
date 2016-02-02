import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class LiveRamp {

	final static InputReader in = new InputReader(System.in);
	final static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		 int A[] = {2,8};
		 int X = 10;
		 int D = 3;
		 int x = new LiveRamp().solution(A,X,D);
		 System.out.println(x);
		out.close();
	}
	
	public int solution(int[] A, int X, int D) {
        Integer pos=0;//position
        TreeSet<Integer> leaves = new TreeSet<Integer>();
        leaves.add(pos);
        
        //BaseCase
        if(pos+D>X) {
        	return 0;
        }
        for(int timer=0;timer<A.length;timer++) {
        	Integer e = A[timer];
        	if(A[timer] > pos) {
        		leaves.add(e);
        	}
        	Integer nextJump = leaves.higher(pos);
        	if(null == nextJump) {
        		continue;
        	}
        	//int maxJump = pos+D;
        	while(null != nextJump && pos+D >= nextJump) {
        		pos=nextJump;
        		nextJump = leaves.higher(pos);
        	}
        	
        	if(pos+D>=X) {
        		return timer;
        	}
        }
        
        if(pos < 0) {
        	return -1;
        }
        
        return 0;
        
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
