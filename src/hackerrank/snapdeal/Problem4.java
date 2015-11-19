package snapdeal;

import java.util.Scanner;

public class Problem4 {
	
	private static int ans = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long k1 = in.nextLong();
		long k2 = in.nextLong();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = in.nextInt();
		}
		
		for(int i=2;i<=arr.length;i++) {
			slidewindow(i,arr,k1,k2);
		}
		System.out.println(ans);
	}
	
	static long OrSum(int arr[]) {
		long orSum = 0;
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				orSum+= arr[i] | arr[j];
			}
		}
		return orSum;
	}
	
	static long XorSum(int arr[]) {
		long xorSum = 0;
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				xorSum+= arr[i] ^ arr[j];
			}
		}
		return xorSum;
	}
	
	static void slidewindow(int wind,int arr[],long k1,long k2) {
		for(int i=0;i<=arr.length-wind;i++) {
			int[] tempArr = newArr(wind,arr,i);
			long orSum = OrSum(tempArr);
			long xorSum = XorSum(tempArr);
			if(orSum > k1 && xorSum > k2)
				ans++;
		}
	}
	
	static int[] newArr(int wind,int arr[],int start) {
		int tempArr[] = new int[wind];
		int j=0;
		for(int i=start;start+wind-1 < arr.length && i<start+wind;i++) {
			tempArr[j]=arr[i];
			j++;
		}
		return tempArr;
	}
}