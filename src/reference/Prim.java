package reference;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Prim {

	public static void main(String[] args) {
	   Scanner in = new Scanner(System.in);
	    long price = 0;
	    int t = in.nextInt();
	    int p = in.nextInt();
	    int n = in.nextInt();
	    int m = in.nextInt();

	    Vertex arr[] = new Vertex[n+1];
	    for(int i=0;i<m;i++) {
	        int a1 = in.nextInt();
	        int a2 = in.nextInt();
	        int a3 = in.nextInt();
	        Vertex v1 = arr[a1] != null ? arr[a1] : new Vertex(a1);
	        Vertex v2 = arr[a2] != null ? arr[a2] : new Vertex(a2);
	        Edge e1 = new Edge(a3,v2);
	        v1.nEdge.add(e1);
	        Edge e2 = new Edge(a3,v1);
	        v2.nEdge.add(e2);
	        arr[a1] = v1;
	        arr[a2] = v2;
	    }
	    
	    PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
	    pq.addAll(arr[1].nEdge);
	    arr[1].visited=true;
	    while(true) {
	    	if(pq.isEmpty()) 
	    		break;
	    	Edge shortE = pq.remove();
	    	if(shortE.nVertex.visited) 
	    		continue;
	    	shortE.nVertex.visited = true;
	    	pq.addAll(shortE.nVertex.nEdge);
	    	price+=shortE.weight*p;
	    }
	    System.out.println(price);
	}
}

class Vertex implements Comparable<Vertex>  {
	int id;
	int weight=Integer.MAX_VALUE;
	boolean visited=false;
	ArrayList<Edge> nEdge = new ArrayList<Edge>();
	Vertex(int id) {
		this.id=id;
	}
	@Override
	public int compareTo(Vertex v) {
		if(this.weight < v.weight)
			return -1;
		else if(this.weight > v.weight)
			return 1;
		else
			return 0;
	}
}

class Edge implements Comparable<Edge> {
	int weight=0;
	Vertex nVertex;
	Edge(int w, Vertex v) {
		weight =w;
		nVertex = v;
	}
	@Override
	public int compareTo(Edge e) {
		if(this.weight < e.weight)
			return -1;
		else if(this.weight > e.weight)
			return 1;
		else
			return 0;
	}
}