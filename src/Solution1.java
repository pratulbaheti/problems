import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

class Node {
	public int value;
	public Node(int value) {
		this.value=value;
	}
}

class NodeList extends ArrayList<Node> {
	
	@Override
	public boolean add(Node e) {
		super.add(e);
		int i=0;
		for(i=this.size()-1;i>0;i--) {
			if(this.get(i-1).value > this.get(i).value) {
				swap(this.get(i), this.get(i-1));
			} else {
				break;
			}
		}
		return true;
	}
	
	public void swap(Node n1,Node n2) {
		int temp = n1.value;
		n1.value = n2.value;
		n2.value = temp;
	}
}

public class Solution1 {

	final static InputReader in = new InputReader(System.in);
	final static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		Integer arr[] = {1,2,3,5,7,1,2,9,0};
		NodeList list = new NodeList();
		for(int i=0;i < arr.length;i++) {
			list.add(new Node(arr[i]));
		}
		for(int i=0;i < arr.length;i++) {
			System.out.println(list.get(i).value);
		}
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
