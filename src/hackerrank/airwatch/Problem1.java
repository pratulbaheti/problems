package hackerrank.airwatch;

import java.util.Scanner;
/**
 * https://www.hackerrank.com/contests/iit-bhu-copsopc-1-2015/challenges/yash-loves-justice
 * @author pratul
 *
 */
public class Problem1 {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        boolean isvalid = valid(x,a,y,b);
        if(isvalid) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
    
    public static boolean valid(int x,int a,int y,int b) {
    	if(x==0 || y==0) {
    		return false;
    	}
        if(x*a==y*b) {
            return true;
        }
        if(x*a<y*b && valid(x,a,y-1,b)) {
        	return true;
        } else if(x*a>y*b && valid(x-1,a,y,b)) {
        	return true;
        }
        return false;
    }
}