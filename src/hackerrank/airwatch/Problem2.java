package hackerrank;

import java.util.Scanner;
/**
 * https://www.hackerrank.com/contests/iit-bhu-copsopc-1-2015/challenges/yash-bets-chandu
 * @author pratul
 *
 */
public class Problem2 {

	public static void main(String[] args) {
		long limit[] = new long[11];
		limit[0]=9;
		for(int i=1;i<=10;i++) {
			limit[i]=(long) (9*Math.pow(10, i))*(i+1);
		}
		Scanner in = new Scanner(System.in);
		int loop = in.nextInt();
		long arr[] = new long[loop];
		for(int i=0;i<loop;i++) {
			arr[i]=in.nextLong();
		}
		for(long pos:arr) {
			long temppos=pos;
			if(pos < 10) {
				System.out.println(pos);
				continue;
			}
			for(int i=1;i<=limit.length;i++) {
				if(temppos>limit[i-1]) {
					temppos-=limit[i-1];
				} else {
					long rem = temppos/i;
					long pnumber = (long) Math.pow(10, i-1)+rem;
					long mod = temppos % i;
					if(mod != 0) {
						String s = Long.toString(pnumber);
						char c = s.charAt((int)mod-1);
						System.out.println(c);
						break;
					} else {
						String s = Long.toString(pnumber-1);
						char c = s.charAt(i-1);
						System.out.println(c);
						break;
					}
				}
			}
		}
	}
}