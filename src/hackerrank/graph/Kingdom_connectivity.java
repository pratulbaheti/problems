package hackerrank.graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;

// https://www.hackerrank.com/challenges/kingdom-connectivity
public class Kingdom_connectivity {

	final static InputReader in = new InputReader(System.in);
	final static PrintWriter out = new PrintWriter(System.out);
	final static int MOD = 1000000000;

	public static void main(String[] args) {
		int n = in.nextInt();
		int m = in.nextInt();
		Node graph[] = new Node[n+1];
		for(int i=1;i<=n;i++) {
			graph[i] = new Node(i);
		}
		for(int i=1;i<=m;i++) {
			int x = in.nextInt();
			Node xnode = graph[x];
			int y = in.nextInt();
			Node ynode = graph[y];
			Edge e = new Edge(xnode);
			ynode.neighbours.add(e);
		}
		LinkedHashSet<Integer> path = new LinkedHashSet<Integer>();
		long l = dfs(graph[n], path, graph[1]);
		System.out.println(l%MOD);
		out.close();
	}
	
	static long dfs(Node root, LinkedHashSet<Integer> path, Node dest) {
		long count=root.count;
		Node nb;
		path.add(root.data);
		for(Edge e:root.neighbours) {
			nb = e.neighbour;
			if(path.contains(nb.data)) {
				path(path);
				System.out.println("INFINITE PATHS");
				System.exit(0);
			}
			if(nb == dest) {
				count=(count+1)%MOD;
			}
			if(nb.count != 0) {
				count = (count+nb.count)%MOD;
				continue;
			}
			long temp = dfs(nb,path,dest);
			nb.count =(nb.count+ temp)%MOD;
			path.remove(nb.data);
			count=(count + nb.count)%MOD;
		}
		return count%MOD;
	}
	
	static void path(Set<Integer> set) {
		for(int i:set) {
			System.out.print(i+"-->");
		}
		System.out.println();
	}
	
	
	static class Node{
		public int data;
		public long count;
		public LinkedList<Edge> neighbours = new LinkedList<Edge>();
		Node(int data){
			this.data = data;
		}
	}
	
	static class Edge{
		public int weight;
		public Node neighbour;
		Edge(Node n1) {
			neighbour=n1;
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
