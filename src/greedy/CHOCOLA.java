package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CHOCOLA {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int test = in.nextInt();
		for(int t=0;t<test;t++) {
			int x = in.nextInt();
			int y = in.nextInt();
			ArrayList<Integer> listc = new ArrayList<Integer>();
			ArrayList<Integer> listr = new ArrayList<Integer>();
			for(int i=0;i<x-1;i++) {
				listc.add(in.nextInt());
			}
			for(int j=0;j<y-1;j++) {
				listr.add(in.nextInt());
			}
			int ans=0;
//			if(y>x)
//				ans = moves(listc,listr);
//			else
//				ans = moves(listr,listc);
			
			int dp[][] = new int[listc.size()+1][listr.size()+1];
			dp[0][0] = 0;
			for(int i=1;i<x;i++) dp[i][0] = listc.get(i-1) + dp[i-1][0];
			for(int i=1;i<y;i++) dp[0][i] = listr.get(i-1) + dp[0][i-1];
			printarr(dp);
			System.out.println("---------------------------------------");
			for(int i=1;i<x;i++) {
				for(int j=1;j<y;j++) {
					int temp1 = dp[i-1][j] + listc.get(i-1)*(j+1);
					int temp2 = dp[i][j-1] + listr.get(j-1)*(i+1);
					dp[i][j] = temp1>temp2?temp2:temp1;
				}
				printarr(dp);
				System.out.println("---------------------------------------");
			}
			//System.out.println(ans);
		}
		in.close();

	}
	
	static void printarr(int [][] arr) {
		for(int i=0;i<arr.length;i++) {
			for (int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	static int moves(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		Collections.sort(list1);
		Collections.reverse(list1);
		Collections.sort(list2);
		Collections.reverse(list2);
		int a = 1, b = 1, sum = 0;
		int e1=0,e2=0; 
		while (!list1.isEmpty() || !list2.isEmpty()) {
			e1 = list1.size() > 0 ? list1.get(0) : 0;
			e2 = list2.size() > 0 ? list2.get(0) : 0;
			if (e1 >= e2) {
				a++;
				list1.remove(0);
				sum += e1 * b;
			} else {
				b++;
				list2.remove(0);
				sum += e2 * a;
			}
		}
		return sum;
	}

}
