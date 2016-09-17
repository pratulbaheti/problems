package hackerrank.graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//https://www.hackerrank.com/challenges/primsmstsub
public class Prims_VeryBadImplementationDontUseThis {

	final static InputReader in = new InputReader(System.in);
	final static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		int n=in.nextInt();
		int m=in.nextInt();
		Node graph[] = new Node[n+1];
		for(int i=1;i<=n;i++) {
			graph[i]=new Node(i);
		}
		for(int i=0;i<m;i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			int w = in.nextInt();
			Node n1 = graph[x];
			Node n2 = graph[y];
			if(n1.neighbours.containsKey(y)) {
				Edge e = n1.neighbours.get(y);
				e.weight = w;
			} else {
				Edge e = new Edge(w, n1, n2);
				n1.neighbours.put(y, e);
				n2.neighbours.put(x, e);
			}
		}
		int s = in.nextInt();
		Node start = graph[s];
		long res = traverse(start, graph);
		System.out.println(res);
		out.close();
	}
	
	public static long traverse(Node curr, Node[] graph) {
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		curr.visited=true;
		long sum=0;
		for (Edge e : curr.neighbours.values()) {
				pq.add(e);
		}
		while (!pq.isEmpty()) {
			Edge m = pq.poll();
			if(m.visited) {
				continue;
			}
			m.visited=true;
			curr = m.getNeighbour(curr);
			if(curr.visited) {
				curr = m.getNeighbour(curr);
				if(curr.visited) continue;
			}
			sum+=m.weight;
			curr.visited=true;
			for (Edge e : curr.neighbours.values()) {
				if (!e.visited) {
					pq.add(e);
				}
			}
		}
		return sum;
	}
	
	static class Node{
		public int data;
		public HashMap<Integer, Edge> neighbours = new HashMap<Integer, Edge>();
		public boolean visited=false;
		Node(int data){
			this.data = data;
		}
	}
	
	static class Edge implements Comparable<Edge>{
		public int weight;
		boolean visited=false;
		public Node n1,n2;
		Edge(int w, Node n1, Node n2) {
			weight=w;
			this.n1=n1;
			this.n2=n2;
		}
		
		Node getNeighbour(Node n) {
			return n1==n?n2:n1;
		}
		@Override
		public int compareTo(Edge e) {
			return weight-e.weight;
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
