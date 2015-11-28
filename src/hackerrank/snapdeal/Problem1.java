package hackerrank.snapdeal;

import java.util.Scanner;

public class Problem1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int Q = in.nextInt();
		int arr[] = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = in.nextInt();
		}
		for(int j=0;j<Q;j++) {
			int X = in.nextInt();
			//find pos of x in array
			X = binarySearch(arr,X);
			int K = in.nextInt();
			int type = in.nextInt();

			switch(type) {
				case 0: {
					if(X+K > N)
						System.out.println(-1);
					else
						System.out.println(arr[X+K]);
					break;
				}
				case 1: {
					if(X -K+1 < 0)
						System.out.println(-1);
					else
						System.out.println(arr[X-K+1]);
				}
			}
		}
	}
	
	static int binarySearch(int arr[],int X) {
		int start = 0;
		int end = arr.length-1;
		int curr = (start+end)/2;
		while(true) {
			if(X == arr[curr])
				return arr[curr];
			if(X < arr[curr]) {
				end = curr;
				curr = (start+end)/2;
			} else {
				start = curr;
				curr = (start+end)/2;
			}
			if(start >= end || end - start == 1)
				return start;
		}
	}
}