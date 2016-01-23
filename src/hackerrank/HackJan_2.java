package hackerrank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class HackJan_2 {

	final static InputReader in = new InputReader(System.in);
	final static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		int n = in.nextInt();
		Node graph[] = new Node[n+1];
		for(int i=1;i<=n;i++) {
			graph[i] = new Node(i,in.nextInt());
		}
		int parent=0;
		for(int i=2;i<=n;i++) {
			parent = in.nextInt();
			graph[i].parent = graph[parent];
			graph[parent].child.add(graph[i]);
		}
		dfs(graph[1]);
		System.out.println(max);
		out.close();
	}
	
	static int max=0;
	static int dfs(Node n) {
		
		if(n.child.isEmpty()) {
			max = Math.max(max, n.color);
			return n.color;
		}
		
		for(Node c:n.child) {
			n.total = Math.max(n.total,n.color + dfs(c));
		}
		max = Math.max(max, n.total);
		if(n.color == 0) return 0;
		return n.total;
		
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

class Node {
	int val;
	int color;
	Node parent;
	ArrayList<Node> child = new ArrayList<Node>();
	int total;
	
	Node(int v,int c) {
		val=v;
		color=c;
	}
}
