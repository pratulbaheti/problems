package bloomberg;

import java.util.Scanner;

public class Problem3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int f = in.nextInt();
		int e = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();
		
		int liftarr[][] = new int[e][2];
		floor arr[] = new floor[e];

		for(int i=0;i<e;i++) {
			arr[i].end=in.nextInt();
			arr[i].start=in.nextInt();
		}
		int start = a;
		while(true) {
			start = contains(liftarr,start,b);
			if(start == -1) {
				System.out.println(0);
				return ;
			}
			if(start >= b) {
				System.out.println(1);
				return;
			}
		}
	}
	
	public static int contains(int liftarr[][],int a,int b) {
		for(int i=0;i<liftarr.length;i++) {
			if(a >= liftarr[i][1] && a < liftarr[i][0])
				return liftarr[i][0];
		}
		return -1;
	}

}

class floor {
	int start;
	int end;
	floor(int a, int b) {
		start =a;
		end=b;
	}
	boolean contains(int val) {
		if(val >= start && val < end) {
			return true;
		} else 
			return false;
	}
}
