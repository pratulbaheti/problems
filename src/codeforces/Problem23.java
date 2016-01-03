package codeforces;

import java.util.Scanner;

public class Problem23 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int h = in.nextInt();
		int w = in.nextInt();
		boolean arr[][] = new boolean[h+1][w+1];
		String strarr[] = new String[h+1];
		for(int i=1;i<=h;i++) {
			String s = in.next();
			strarr[i] = s;
			for(int j=1;j<=w;j++) {
				if(s.charAt(j-1) == '#')
					arr[i][j] = false;
				else
					arr[i][j] = true;
			}
		}
		
		int q = in.nextInt();
		for(int t=0;t<q;t++) {
			int r1 = in.nextInt();
			int c1 = in.nextInt();
			int r2 = in.nextInt();
			int c2 = in.nextInt();
			boolean box[][] = new boolean[r2-r1+1][c2-c1+1];
			long counter =0 ;
			for(int i=r1;i<=r2;i++) {
				String temp = strarr[i].substring(c1-1, c2);
				String temparr[] = temp.split("#");
				for(String s:temparr) {
					counter+= s.length()==0?0:s.length()-1;
				}
			}
			int token = 0;
			for(int j=c1;j<=c2;j++) {
				for(int i=r1;i<=r2;i++) {
					if(arr[i][j] == false) {
						counter+=token==0?0:token-1;
						token=0;
					} else {
						token++;
					}
				}
				counter+=token==0?0:token-1;
				token=0;
			}
			System.out.println(counter);
		}
	}
}
