package codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Educational6_c {

	final static InputReader in = new InputReader(System.in);
	final static PrintWriter out = new PrintWriter(System.out);
	static HashMap<String,Integer> map = new HashMap<String,Integer>();

	public static void main(String[] args) {
		int n = in.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = in.nextInt();
		}
		
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		int win = 0;
		int count=0;
		LinkedList<String> list = new LinkedList<String>();
		
		win=1;
		for (int i = 0; i < n; i++) {
			int num = arr[i];
			if(map.containsKey(num)) {
				map.put(num, 2);
				list.add((i - win+2) + " " + (i+1));
				map.clear();
				count++;
				win=1;
			} else {
				map.put(num, 1);
				win++;
			}
			
/*			if (map.containsKey(num)) {
				map.put(num, 2);
				for (int j = i-win+1; j < i + 1; j++) {
					int shrink = arr[j];
					if (map.get(shrink) == 1) {
						win--;
					} else {
						list.add(j+1 + " " + (j + win));
						win = 1;
						map.clear();
						count++;
						break;
					}
				}
			} else {
				map.put(num, 1);
				win++;
			}
*/		}
		if(count==0) {
			System.out.println("-1");
		} else {
			System.out.println(count);
			for(String s:list) {
				System.out.println(s);
			}
		}
		
		out.close();
	}

	static int data(String s) {
		int count =0;
		for(int i=0;i<s.length();i++) {
			count+=map.get(""+s.charAt(i));
		}
		return count;
	}
	
	static void initialize() {
		map.put("0", 6);
		map.put("1", 2);
		map.put("2", 5);
		map.put("3", 5);
		map.put("4", 4);
		map.put("5", 5);
		map.put("6", 6);
		map.put("7", 3);
		map.put("8", 7);
		map.put("9", 6);
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
