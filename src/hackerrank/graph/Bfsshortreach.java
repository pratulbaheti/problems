package hackerrank.graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.hackerrank.com/challenges/bfsshortreach
public class Bfsshortreach {

	final static InputReader in = new InputReader(System.in);
	final static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		int query = in.nextInt();
		for(int q=0;q<query;q++) {
			int nodes = in.nextInt();
			Node[] graph = new Node[nodes+1];
			for(int i=1;i<=nodes;i++) {
				graph[i] = new Node(i);
			}
			int edges = in.nextInt();
			for(int i=1;i<=edges;i++) {
				Node n1 = graph[in.nextInt()];
				Node n2 = graph[in.nextInt()];
				n1.add(n2);
				n2.add(n1);
			}
			Node start=graph[in.nextInt()];
			traverse(graph,start);
			for(Node n:graph) {
				if(n!=null && n!= start)
					System.out.print(""+(n.hops>0?n.hops*6:-1) + " ");
			}
			System.out.println();
		}
		out.close();
	}
	
	public static void traverse(Node graph[], Node start) {
		Queue<Node> q = new LinkedList<Node>();
		start.visited=true;
		start.hops=0;
		q.add(start);
		int hop=1;
		while(!q.isEmpty()) {
			Node curr = q.poll();
			for(Node n:curr.neighbours) {
				if(!n.visited) {
					n.visited=true;
					n.hops=curr.hops+1;
					q.add(n);
				}
			}
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

class Node {
	public boolean visited=false;
	public LinkedList<Node> neighbours = new LinkedList<Node>();
	public int data;
	public int hops=-1;
	Node(int i){
		data=i;
	}
	public void add(Node n) {
		neighbours.add(n);
	}
}