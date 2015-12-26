package codeforces;

import java.util.Scanner;

public class Problem2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n+1];
		for(int i=1;i<=n;i++) {
			int j = in.nextInt();
			arr[j] = i;
		}
		long sum = 0;
		int last = arr[1];
		for(int i=2;i<=n;i++) {
			int no = arr[i];
			sum+= Math.abs(no - last);
			last = no;
		}
		System.out.println(sum);
		in.close();
	}

}
