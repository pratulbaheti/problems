package fb_hackercup;

import java.util.Scanner;

public class PriceIsCorrect {
	
	static int[] bit = new int[100001];
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int test = in.nextInt();
		for(int t=0;t<test;t++) {
			int n = in.nextInt();
			int p = in.nextInt();
			arr = new int[n];
			for(int i=0;i<n;i++) {
				arr[i] = in.nextInt();
				update(i+1,arr[i]);
			}
			
			// Do binary search for x => read(x) - read(i) < p
			// Using this x, possible combinations will be x*(x+1)/2
			long count=0;
			
			for (int i = 1; i < n; i++) {
				
				int start=i,mid=0,end=bit.length-1;
				while(start <= end) {
					mid = start + (end - start)/2;
					int temp = read(mid) - read(i-1);
					if(temp == p)
						start = mid;
					else if(temp > p)
						end = mid-1;
					else
						start = mid+1;
				}
				
				int diff = start - i;
				count+=sumToN(diff);
			}
			System.out.println("Case #"+(t+1)+":"+count);
		}
		in.close();

	}
	
	public static long sumToN(int n) {
		double sum=n*(n+1);
		return (long)sum/2;
	}
	
	public static int read(int i) {
		if(i<=0) return 0;
		int resultSum = 0;
		while(i>0) {
			resultSum+=bit[i];
			i-=i&(-i);
		}
		return resultSum;
	}
	
	public static void update(int x,int val) {
		while(x<bit.length) {
			bit[x]+=val;
			x+=x&(-x);
		}
	}

}
