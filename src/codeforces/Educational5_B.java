package codeforces;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Educational5_B {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int arr[] = new int[n+1];
		for(int i=1;i<=n;i++) {
			arr[i]=Integer.MAX_VALUE;
		}
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("a", "b");
		int min = 0;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				min = in.nextInt();
				if(min < arr[i]) {
					arr[i] = min;
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=1;i<=n;i++) {
			max = Math.max(max, arr[i]);
		}
		System.out.println(max);
	}
	

}
