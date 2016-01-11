package fb_hackercup;

import java.util.Scanner;

public class PriceIsCorrect {
	
	static int[] bit = new int[100000];
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
				update(i,arr[i]);
			}
			
			// Do binary search for x => read(x) - read(i) < p
			// Using this x, possible combinations will be x*(x+1)/2
			for(int i=0;i<n;i++) {
				int first  = 0;
			    int last   = n;
			    int middle = (first + last)/2;
			 
			    while( first <= last )
			    {
			      if ( < x )
			        first = middle + 1;    
			      else if ( array[middle] == x ) 
			      {
			        System.out.println(x + " found at location " + (middle + 1) + ".");
			        break;
			      }
			      else
			         last = middle - 1;
			 
			      middle = (first + last)/2;
			   }
			}
		}
		in.close();

	}
	
	public static int read(int i) {
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
