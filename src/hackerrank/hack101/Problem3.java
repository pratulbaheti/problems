package hackerrank.hack101;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/101hack32/challenges/sorting-under-square-distance
 * @author pratu
 *
 */
public class Problem3 {

	public static void main(String[] args) {
		int counter = 0;
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long a[] = new long[n];
		for(int i=0;i<n;i++) {
			a[i] = in.nextLong();
		}
		//bubble sort
/*		for(int i =0;i<n;i++) {
			for(int j=1;j<n-i;j++) {
				if(a[j-1] > a[j]) {
					long temp = a[j];
					a[j] = a[j-1];
					a[j-1] = temp;
					counter++;
				}
			}
		}
*/
		// Merge sort
		
		System.out.println(counter);
		in.close();
	}
}
