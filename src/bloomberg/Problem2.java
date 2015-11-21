package bloomberg;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2 {
	
	static int dp[][];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int r = in.nextInt();
		int c = in.nextInt();
		Node arr[][] = new Node[r+1][c+1];
		dp = new int[r+1][c+1];
		for(int[] a : dp) {
			Arrays.fill(a, -1);
		}

		for(int i=0;i<=r;i++) {
			for(int j=0;j<=c;j++) {
				arr[i][j] = new Node(i,j);
			}
		}
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				Edge e = new Edge(in.nextInt());
				e.next=arr[i][j+1];
				arr[i][j].he=e;
			}
			for(int j=0;j<=c;j++) {
				Edge e = new Edge(in.nextInt());
				e.next=arr[i+1][j];
				arr[i][j].ve=e;
			}
		}
		for(int j=0;j<c;j++) {
			Edge e = new Edge(in.nextInt());
			e.next=arr[r][j+1];
			arr[r][j].he=e;
		}
		
		int ans = recursion(arr,r,c);
		System.out.println(ans);
	}
	
	static int recursion(Node arr[][],int r,int c) {
		if(dp[r][c] != -1) {
			return dp[r][c];
		}
		int above=0;
		if(r != 0)
			above = arr[r-1][c].ve.val + recursion(arr,r-1,c);
		
		int left=0;
		if(c != 0)
			left = arr[r][c-1].he.val + recursion(arr,r,c-1);
		
		int val = max(above,left);
		dp[r][c] = val;
		return val;
	}
	
	static int max(int a, int b) {
		return a >= b ? a : b;
	}
}

class Node {
	int x;
	int y;
	Edge he;
	Edge ve;
	int total;
	Node(int i,int j) {
		x=i;
		y=j;
	}
}

class Edge {
	int val;
	Node next;
	Edge(int value) {
		val = value;
	}
}