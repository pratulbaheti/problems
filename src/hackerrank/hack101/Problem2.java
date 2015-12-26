package hackerrank.hack101;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/101hack32/challenges/tree-construction
 * @author pratu
 *
 */
public class Problem2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<Node> list = new ArrayList<Node>();
		for(int i=1;i<=n;i++) {
			list.add(new Node(i,in.nextInt()));
		}in.close();
		Collections.sort(list);
		ArrayList<Node> output = new ArrayList<Node>();
		for(Node l:list) {
			for(Node o:output) {
				if(o.val>0) {
					o.val--;
					l.val--;
					l.parent=o.pos;
					break;
				}
			}
			output.add(l);
		}
		Collections.sort(output, new Sort());
		for(Node l:output) {
			System.out.println(l.parent);
		}		
	}
	
}

class Node implements Comparable{
	int pos;
	int parent;
	int val;
	Node(int p,int v) {
		pos=p;
		val=v;
	}
	@Override
	public int compareTo(Object obj) {
		Node n = (Node)obj;
		if(this.val < n.val) return 1;
		if(this.val > n.val) return -1;
		return 0;
	}
	
	@Override
	public String toString() {
		return "Node [pos=" + pos + ", parent=" + parent + ", val=" + val + "]";
	}
}

class Sort implements Comparator<Node> {

	@Override
	public int compare(Node a, Node n) {
		if(a.pos > n.pos) return 1;
		if(a.pos < n.pos) return -1;
		return 0;
	}
	
}
