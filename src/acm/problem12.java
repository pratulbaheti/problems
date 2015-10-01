package acm;
// max sub array
import java.util.Scanner;

class problem12 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		while(n != 0) {
			int arr[] = new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=in.nextInt();
			}
			int max = findAns(arr);
			System.out.println(max);
			n = in.nextInt();
		}
	}
	
	public static int findAns(int arr[]) {
		int temp[] = arr.clone();
		int max=arr[0];
		for(int i=1; i<arr.length;i++) {
			if(temp[i-1]+arr[i]>temp[i]) {
				temp[i]=temp[i-1]+arr[i];
				if(max < temp[i]) {
					max=temp[i];
				}
			}
		}
		return max;
	}
}
