package hackerrank.graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Kruskal {

	final static InputReader in = new InputReader(System.in);
	final static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		int n=in.nextInt();
		int m=in.nextInt();
		PriorityQueue<Edge> pq =  new PriorityQueue<Edge>();
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
			Edge e;
			if(n1.neighbours.containsKey(y)) {
				e = n1.neighbours.get(y);
				e.weight = w;
				pq.remove(e);
			} else {
				e = new Edge(w, n1, n2);
				n1.neighbours.put(y, e);
				n2.neighbours.put(x, e);
			}
			pq.add(e);
		}
		in.nextInt();
		int res = traverse(pq, graph);
		System.out.println(res);
		out.close();
	}
	
	public static int traverse(PriorityQueue<Edge> pq, Node[] graph) {
		HashSet<HashSet<Node>> set = new HashSet<HashSet<Node>>();
		int count=0;
		Edge e;
		Node n1,n2;
		HashSet<Node> s1,s2;
		while(!pq.isEmpty()) {
			e = pq.poll();
			n1 = e.n1;n2=e.n2;
			s1 = find(set, n1);
			s2 = find(set, n2);
			if(s1 == null) {
				s1 = new HashSet<Node>();
				s1.add(n1);
				set.add(s1);
			}
			if(s2 == null) {
				s2 = new HashSet<Node>();
				s2.add(n2);
				set.add(s2);
			}
			if(s1 == s2)
				continue;
			else {
				System.out.println(n1.data+"->"+n2.data+": "+e.weight);
				count+=e.weight;
				s1.addAll(s2);
				set.remove(s2);
				if(find(set, n1) != find(set, n2)){
					System.out.println("HELLO");
				}
			}
		}
		return count;
	}
	
	public static HashSet<Node> find(HashSet<HashSet<Node>> set, Node n) {
		for(HashSet<Node> hs: set){
			if(hs.contains(n))
				return hs;
		}
		return null;
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
		
		@Override
		public int compareTo(Edge e) {
			int compare = Integer.compare(weight, e.weight);
			if(compare == 0) {
				return Integer.compare(n1.data+n2.data, e.n1.data + e.n2.data);
			}
			return compare;
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
