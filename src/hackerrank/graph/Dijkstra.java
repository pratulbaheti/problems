package hackerrank.graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Dijkstra {

	final static InputReader in = new InputReader(System.in);
	final static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		int test = in.nextInt();
		for(int t=0;t<test;t++) {
			int nodes = in.nextInt();
			Node[] graph = new Node[nodes+1];
			PriorityQueue<Node> q = new PriorityQueue<Node>();
			setup(nodes, graph,q);
			Node start = graph[in.nextInt()];
			traverse(start, graph,q);
			for(Node n:graph) {
				if(n!=null && n!=start)
					System.out.print(""+(n.distance>0 && n.distance!=Integer.MAX_VALUE?n.distance:-1)+" ");
			}
			System.out.println();
		}
		out.close();
	}
	
	private static void traverse(Node start, Node[] graph, PriorityQueue<Node> q) {
		start.distance=0;
		q.add(start);
		while(!q.isEmpty()) {
			Node curr = q.remove();
			if(curr.visited) continue;
			curr.visited=true;
			Node n1;
			for(int k:curr.neighbours.keySet()) {
				n1 = graph[k];
				if(n1.data==1) 
					n1=n1;
				if(n1.visited) continue;
				if(n1.distance > curr.distance+curr.neighbours.get(k))
					n1.distance=curr.distance+curr.neighbours.get(k);
				q.add(q.remove());
			}
			if(!q.isEmpty())
				q.add(q.poll());
		}
	}

	private static void setup(int nodes, Node[] graph, PriorityQueue<Node> q) {
		for(int n=1;n<=nodes;n++) {
			graph[n]=new Node(n);
			q.add(graph[n]);
		}
		int edges = in.nextInt();
		Node n1,n2;
		for(int e=0;e<edges;e++) {
			int a=in.nextInt(), b=in.nextInt();
			n1=graph[a];
			n2=graph[b];
			int weight = in.nextInt();
			if(n1.neighbours.containsKey(b)) {
				int maxWeight = n1.neighbours.get(b);
				n1.neighbours.put(b, Integer.min(weight, maxWeight));
				n2.neighbours.put(a, Integer.min(weight, maxWeight));
			} else {
				n1.neighbours.put(b, weight);
				n2.neighbours.put(a, weight);
			}
		}
	}

	static class Node implements Comparable<Node>{
		public boolean visited=false;
		public HashMap<Integer, Integer> neighbours = new HashMap<Integer, Integer>();
		public int distance=Integer.MAX_VALUE;
		int data;
		Node(int n){data=n;}
		Node(Node n) {
			data=n.data;
			visited=n.visited;
			neighbours=n.neighbours;
			distance=n.distance;
		}
		@Override
		public int compareTo(Node n1) {
			return Integer.compare(this.distance,n1.distance);
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