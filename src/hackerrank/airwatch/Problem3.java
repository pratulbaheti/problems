/**
 * 
 */
package hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/iit-bhu-copsopc-1-2015/challenges/siddhant-and-money
 * @author pratul
 *
 */
public class Problem3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int totnotes = in.nextInt();
		long k = in.nextLong();
		int[] arr = new int[totnotes+1];
		int ans=0;
		
		long total=0;
		int ptr=0;
		int temp=0;
		for(int i=0;i<totnotes;i++) {
			temp=in.nextInt();
			arr[i]=temp;
			total+=temp;
			if(total == k) {
				ans++;
				total-=arr[ptr];
				ptr++;
			} else if(temp == k) {
				ans++;
				ptr=i+1;
				total=0;
			} else if(total > k) {
				while(total > k) {
					total-=arr[ptr];
					ptr++;
				}
			}
			if(total<0)
				total=0;
		}
		System.out.println(ans);
	}
}
