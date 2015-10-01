package com.dp;

import java.util.Scanner;

public class Tree {
	
	public Node root = new Node();

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Tree bst = new Tree();
		int value=0;
		Scanner in = new Scanner(System.in);
		bst.println("Insert root node");
		value = in.nextInt();
		Node newNode = new Node(value);
		bst.root = newNode;
		
		while(true) {
			System.out.println("Insert value");
			value = in.nextInt();
			if(value == -1)
				break;
			newNode = new Node(value);
			bst.insertNode(bst.root,newNode);
		}
		System.out.println("Type 1.Inorder \t 2.Preorder \t 3.Postorder");
		int printOrder = in.nextInt();
		switch(printOrder) {
		case 1: bst.printInOrder(bst.root);break;
		case 2: bst.printPreOrder(bst.root);break;
		case 3: bst.printPostOrder(bst.root);break;
		}
	}
	
	public void insertNode(Node parent,Node newNode) {
		if(newNode.val <= parent.val)
			if(parent.left == null)
				parent.left = newNode;
			else
				insertNode(parent.left,newNode);
		else
			if(parent.right == null)
				parent.right = newNode;
			else
				insertNode(parent.right,newNode);
	}
	
	public void printInOrder(Node root) {
		if(root == null)
			return;
		printInOrder(root.left);
		println(""+root.val);
		printInOrder(root.right);
	}
	public void printPreOrder(Node root) {
		if(root == null)
			return;
		println(""+root.val);
		printPreOrder(root.left);
		printPreOrder(root.right);
	}
	public void printPostOrder(Node root) {
		if(root == null)
			return;
		printPostOrder(root.left);
		printPostOrder(root.right);
		println(""+root.val);
	}
	public void println(String str) {
		System.out.println(str);
	}
}

class Node {
	Node left;
	Node right;
	int val;
	Node() {
		
	}
	Node(int val) {
		this.val=val;
	}
}