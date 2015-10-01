import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class ValidateTree {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int nNode = in.nextInt();
		int nEdge = in.nextInt();
		Node root = null;
		Node nodeArr[] = new Node[nNode+1];
		for(int i=1;i<=nNode;i++) {
			nodeArr[i] = new Node(i);
		}
		
		for(int i=1; i<=nEdge;i++) {
			int node1 = in.nextInt();
			int node2 = in.nextInt();
			nodeArr[node1].nbor.add(nodeArr[node2]);
			
			if(root == null) {
				root=nodeArr[node1];
//				root.visited = true;
			}
		}
//		boolean isTree = traverse(root);
/*		for(Node n:nodeArr) {
			if(n != null && n.visited == false) {
				System.out.println("NO");
				return ;
			}
		}
*/		
		
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		while(!stack.isEmpty()){
			Node temp = stack.pop();
			if(temp.visited == true) {
				System.out.println("NO");
				return ;
			}
			temp.visited=true;
			stack.addAll(temp.nbor);
		}
		System.out.println("YES");
/*		if(!isTree) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
		}*/
	}
	
	public static boolean traverse(Node root) {
		for(Node n : root.nbor) {
			if(n.visited == true) 
				return false;
			n.visited=true;
			traverse(n);
		}
		return true;
	}
}

class Node {
	int value;
	boolean visited;
	ArrayList<Node> nbor = new ArrayList<Node>();
	public Node(int i) {
		value=i;
	}
}