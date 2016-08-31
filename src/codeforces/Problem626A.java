package codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Problem626A {

	final static InputReader in = new InputReader(System.in);
	final static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		int n = in.nextInt();
		String[] arr = new String[n];
		String str = in.next();
		for(int i=0;i<n;i++) {
			arr[i] = ""+str.charAt(i);
		}
		int counter=0;
		
		for(int i=0;i<n;i++) {
			int xsum=0,ysum=0;
			for(int j=i;j<n;j++) {
				switch(arr[j]) {
				case "U": ++ysum;break;
				case "D": --ysum;break;
				case "L": --xsum;break;
				case "R": ++xsum;break;
				default:  break;
				}
				if(xsum ==0 && ysum==0) {
					counter+=1;
				}
			}
		}
		System.out.println(counter);
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
