package hackerrank;

import java.util.Scanner;
/**
 * https://www.hackerrank.com/contests/iit-bhu-copsopc-1-2015/challenges
 * Find next binary number
 * @author pratul
 *
 */
public class Problem0 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int loop = in.nextInt();
        long total = 0;
        for(int i=0;i<loop;i++) {
            total+= in.nextInt();
        }
        if((total & -total) == total) {
        } else {
            long n=total;
            n=n|n>>1;
            n=n|n>>2;
            n=n|n>>4;
            n=n|n>>8;
            n=n|n>>16;
            n=n|n>>32;
            n=n|n>>64;
            total=n+1;
        }
        System.out.println(total);
    }
}