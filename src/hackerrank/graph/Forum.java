package hackerrank.graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

// https://www.hackerrank.com/challenges/even-tree/forum
public class Forum {

	final static InputReader in = new InputReader(System.in);
	final static PrintWriter out = new PrintWriter(System.out);
	static HashSet<Node> visited = new HashSet<Node>();
	static HashSet<Node> remove = new HashSet<Node>();
	static int ans;

	public static void main(String[] args) {
		int N = in.nextInt();
		int M = in.nextInt();
		Node graph[] = new Node[N+1];
		for(int n=1;n<=N;n++) {
			graph[n] = new Node(n);
		}
		for(int i=0;i<M;i++) {
			int a = in.nextInt(), b = in.nextInt();
			Node n1=graph[a],n2=graph[b];
			n1.add(n2);
			n2.add(n1);
		}
		dfs(graph[1]);
		System.out.println(ans);
		out.close();
	}
	
	static int dfs(Node root) {
		int count=1;
		visited.add(root);
		for(Node n:root.list) {
			if(visited.contains(n)) {
				continue;
			}
			int temp =dfs(n);
			if(temp%2==0){
				remove.add(n);
				ans++;
				temp=0;
			}
			count+=temp;
		}
		root.list.removeAll(remove);
		remove.clear();
		//visited.remove(root);
		return count;
	}
	
	static class Node{
		int data;
		HashSet<Node> list = new HashSet<Node>();
		int child;
		Node(int d){
			data=d;
		}
		public void add(Node n2) {
			list.add(n2);
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
