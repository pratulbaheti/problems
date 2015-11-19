/**
 * 
 */
package hackerrank;

import java.util.HashMap;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/morgan-stanley-2015/challenges/stock-values
 * @author pratul
 *
 */
public class Problem4 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String x,u;
		int testcase = in.nextInt();
		for(int loop=0;loop<testcase;loop++) {
			HashMap<Character, Integer> map = new HashMap<Character, Integer>(); 
			int i=0,d=0,r=0;
			int edit=0,temp=0,inop=0,delop=0;
			x=in.next();
			u=in.next();
			i=in.nextInt();
			d=in.nextInt();
			r=in.nextInt();
			
			for(char c : u.toCharArray()) {
				Integer val = map.get(c);
				if(val == null) {
					map.put(c, 1);
				} else {
					map.put(c,++val);
				}
			}
			
			for(char c : x.toCharArray()) {
				Integer val = map.get(c);
				if(val == null || val == 0) {
					++edit;
				} else {
					map.put(c,--val);
				}
			}
			
			temp = x.length() - u.length();
			if(temp < 0)
				delop=-temp;
			else {
				edit=edit-temp;
				inop=temp;
			}
			int min = Math.min(edit*i+edit*d+delop*d+inop*i, edit*r+delop*d+inop*i);
			System.out.println(min);
		}
	}
}