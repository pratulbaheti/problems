package geeksforgeeks;

import java.util.Scanner;

/**
 * http://www.geeksforgeeks.org/find-all-possible-trees-with-given-inorder-traversal/
 * @author pratul
 *
 */
public class NoOfTress {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = in.nextInt();
		}
		for(int i=0;i<n;i++) {
			
		}
		in.close();
	}
	
	public static void constructTree() {
		 
	}

	public static void preorder() {
		
	}
}

class Node {
	int data;
	Node left;
	Node right;
	Node(int d) {
		data=d;
	}
}