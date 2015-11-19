/**
 * 
 */
package hackerrank;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.hackerrank.com/contests/morgan-stanley-2015/challenges/min-con-com
 * @author pratul
 *
 */
public class Problem5 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int nodes = in.nextInt();
		int query = in.nextInt();
		Node[] graph = new Node[nodes+1];
		for(int i=1;i<=nodes;i++) {
			int w = in.nextInt();
			graph[i]=new Node(i,w);
		}
		for(int i=1;i<=query;i++) {
			int n1 = in.nextInt();
			int n2 = in.nextInt();
			graph[n1].neb.add(graph[n2]);
			graph[n2].neb.add(graph[n1]);
			int min=Integer.MAX_VALUE;
			for(int loop=1;loop<=nodes;loop++) {
				int val = traverse(graph,loop);
				if(val == 0) continue;
				if(val<min)
					min=val;
			}
			System.out.println(min);
			for(int loop=1;loop<=nodes;loop++) {
				graph[loop].visited=false;
			}
		}
	}
	public static int traverse(Node[] graph, int start) {
		if(graph[start].visited)
			return 0;
		if(graph[start].neb.size() == 0)
			return graph[start].weight;
		graph[start].visited=true;
		int value=graph[start].weight;
		for(Node n : graph[start].neb) {
			value+= traverse(graph,n.id);
		}
		return value;
 	}
}

class Node {
	int id;
	int weight=0;
	boolean visited=false;
	ArrayList<Node> neb = new ArrayList<Node>();
	Node(int id,int w) {
		this.id=id;
		weight=w;
	}
}