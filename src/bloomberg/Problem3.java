package bloomberg;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Problem3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int f = in.nextInt();
		int e = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();
		
		int arr[][] = new int[e][2];
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		HashSet<Integer> set = new HashSet<Integer>();
		
		HashSet<Integer> visited = new HashSet<Integer>();

		ArrayList<Integer> temp = new ArrayList<Integer>();

		for(int i=0;i<e;i++) {
			int jump = in.nextInt();
			int base = in.nextInt();
			for(int j=base;j<=f;j=j+jump) {
				temp.add(j);
			}
			list.add(temp);
			if(temp.contains(b)) 
				set.addAll(temp);
			temp.clear();
		}
		
		while(true) {
		}
		 
	}
}