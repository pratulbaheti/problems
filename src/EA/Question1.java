package EA;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Question1 {

	final static InputReader in = new InputReader(System.in);
	final static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		System.out.println(solution("a\n b\n  c.jpeg\n  d.jpeg"));
		out.close();
	}
	
	static String lines[];
	static int counter=-1;
	static long answer = 0L;
	public static int solution(String s) {
		lines = s.split("\n");
		System.out.println(1+recursion(0,0));
		return 0;
	}
	static long ans = 0L;
	public static long recursion(int parentSp,long parentL) {
		counter++;
		if(counter==lines.length) {
			return ans;
		} else if(counter>=lines.length) {
			return ans;
		}
		
		boolean isImg = isImg(lines[counter]);
		int mySpace = spaces(lines[counter]);
			if (isImg) {
				if(parentSp == mySpace) {
					ans = (ans + parentSp + parentL + lines[counter].length()) % 1000000007;
					recursion(parentSp, parentL);
				} else {
					ans = (ans + parentSp + parentL + lines[counter].length()) % 1000000007;
					recursion(mySpace, parentL + lines[counter].length());
				}
			} else {
				if(parentSp == mySpace) {
					recursion(parentSp, parentL);
				} else 
					recursion(mySpace, parentL + lines[counter].length());
			}
		return ans;
	}
	
	public static int spaces(String line) {
		int depth=0;
		for(char c:line.toCharArray()) {
			if(c == ' '){
				depth++;
			} else {
				break;
			}
		}
		return depth;
	}
	public static boolean isImg(String ext) {
		int pos = ext.lastIndexOf(".");
		ext = ext.substring(pos+1);
		if(ext.equals("jpeg") || ext.equals("gif") || ext.equals("png")) {
			return true;
		}
		return false;
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
