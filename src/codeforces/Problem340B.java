package codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Problem340B {

	final static InputReader in = new InputReader(System.in);
	final static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		int n=in.nextInt();
		int count=0;
		int ans=1;
		boolean flag=false;
		int total =0;
		
		for(int i=0;i<n;i++) {
			int x = in.nextInt();
			total+=x;
			if(x==1 && !flag) {
				flag = true;
			}
			if(flag && x==0) {
				count++;
			}
			if(flag && x==1) {
				ans*=(count+1);
				count=0;
			}
		}
		if(total ==0) {
			System.out.println(0);
			return ;
		}
		System.out.println(ans);
		out.close();
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
