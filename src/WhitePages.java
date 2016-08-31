import java.io.*;
import java.util.*;

public class WhitePages {

	public static void main(String args[]) throws Exception {
		List<Integer> list = new LinkedList<Integer>();
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			list.add(in.nextInt());
		}
		int arr[] = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i);
		}
		int[] ans = minJumps(arr);
		if(ans.length != 0 && arr[0]>arr.length) {
			System.out.println(0);
		} else if (ans.length == 0 || ans[ans.length-1] == 0) {
			System.out.println("failure");
		} else {
			String str="";
			for(int i=ans.length;i>0;) {
				str=ans[i-1]+", "+str;
				i=ans[i-1];
			}
			System.out.println(str+"out");
		}
		in.close();
	}

	static int[] minJumps(int arr[]) {
		int i, j, n = arr.length;
		int jumps[] = new int[n+1]; // jumps[n-1] will hold the result
		int list[] = new int[n];

		if (n == 0 || arr[0] == 0)
			return list;

		jumps[0] = 0;

		for (i = 1; i <= n; i++) {
			jumps[i] = Integer.MAX_VALUE;
			int temp = 0;
			for (j = 0; j < i; j++) {
				if (i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE) {
					if (jumps[i] > jumps[j] + 1) {
						jumps[i] = jumps[j] + 1;
						temp = j;
						// if(jumps[i] > jumps[i-1])
						list[i-1]=temp;
					}
				}
			}

		}
		return list;
	}
}