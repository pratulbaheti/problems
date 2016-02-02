package hackerrank.airwatch;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Solution1 {

	final static InputReader in = new InputReader(System.in);
	final static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i=0;i<t;i++) {
			int n = in.nextInt();
			int arr[] = new int[n];
			for(int j=0;j<n;j++) {
				arr[j] = in.nextInt();
			}
			String result = isValidBst(arr);
			System.out.println(result);
		}
		in.close();
	}
	
	static String isValidBst(int arr[]) {
        Stack<Integer> s = new Stack<Integer>();
        int top = Integer.MIN_VALUE;
 
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < top) {
                return "NO";
            }
            while (!s.empty() && s.peek() < arr[i]) {
                top = s.peek();
                s.pop();
            }
            s.push(arr[i]);
        }
        return "YES";
    }
	
	static String[] Braces(String[] values) {
        String result[] = new String[values.length];
        for(int i=0;i<values.length;i++) {
            result[i]=isValid(values[i]);
        }
        return result;
    }

    static String isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        HashMap<Character,Character> map = new HashMap<Character,Character>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        
        HashSet<Character> validInputChecker = new HashSet<Character>();
        validInputChecker.add('(');
        validInputChecker.add(')');
        validInputChecker.add('{');
        validInputChecker.add('}');
        validInputChecker.add('[');
        validInputChecker.add(']');
        
        for(int i=0;i<s.length();i++) {
            char nextBracket = s.charAt(i);
            if(!map.containsKey(nextBracket) && !map.values().contains(nextBracket)) {
            	continue;
            }
            if(map.containsKey(nextBracket)) {
                stack.push(nextBracket);
            } else {
                if(!stack.isEmpty() && map.get(stack.peek()) == nextBracket) {
                    stack.pop();
                } else {
                    return "NO";
                }
            }
        }
        if(stack.isEmpty()) {
            return "YES";
        }
        return "NO";
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
