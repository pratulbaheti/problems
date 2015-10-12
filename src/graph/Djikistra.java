package graph;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Djikistra {

	public static void main(String[] args) {
  	   Scanner in = new Scanner(System.in);
  	   int t = in.nextInt();
  	   for(int i=0;i<t;i++) {
  	  	   PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
  	  	   HashMap<Integer,Vertex> map = new HashMap<Integer,Vertex>();
  	  	   int n = in.nextInt();
  	  	   int m = in.nextInt();
  	  	   for(int j=0;j<m;j++) {
  	  		   int a1 = in.nextInt();
  	  		   int a2 = in.nextInt();
  	  		   int a3 = in.nextInt();
  	  		   Vertex v1,v2;
  	  		   if(map.get(a1) != null) {
  	  			 v1 = map.get(a1);
  	  		   } else {
  	  			 v1 = new Vertex(a1);
  	    		 map.put(a1,v1);
  	  			 pq.add(v1);
  	  		   }
  	  		   if(map.get(a2) != null) {
  	  			 v2 = map.get(a2);
  	  		   } else {
  	  			v2 = new Vertex(a2);
  	    		map.put(a2,v2);
  	  			pq.add(v2);
  	  		   }
  	  		   Edge e1 = new Edge(a3,v2);
  	  		   v1.nEdge.add(e1);
  	  		   Edge e2 = new Edge(a3,v1);
  	  		   v2.nEdge.add(e2);
  		    }
  	  	   
  	  	   map.get(1).weight=0;
  	  	   while(true) {
  	  		 if(pq.isEmpty()) break;
  	  		 Vertex current = pq.remove();
  	  		 if(current.visited == true) continue;
  	  		 current.visited=true;
  	  		 for(Edge e : current.nEdge) {
  	  			 if(e.nVertex.weight > current.weight + e.weight && !e.nVertex.visited) {
  	  				e.nVertex.weight = current.weight + e.weight;
  	  			 }
  	  		 }
  	  		 if(pq.isEmpty()) break;
  	  		 Vertex temp = pq.remove();
  	  		 pq.add(temp);
  	  	   }
  	  	   System.out.println();
  		}
  	}
}