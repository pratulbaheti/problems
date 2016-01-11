package fb_hackercup;

import java.util.HashMap;
import java.util.Scanner;

public class Boomerrang_Constellations {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i=0;i<t;i++) {
			int n = in.nextInt();
			int stars[][] = new int[n][2];
			for(int j=0;j<n;j++) {
				stars[j][0] = in.nextInt();
				stars[j][1] = in.nextInt();
			}
			int sky[][] = new int[n][n];
			for(int a=0;a<n;a++) {
				for(int b=0;b<n;b++) {
					sky[a][b] = distance(stars[a],stars[b]);
				}
			}
			long count = 0;
			for(int j=0;j<sky.length;j++) {
				HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
				for(int k=0;k<sky[j].length;k++) {
					if(sky[j][k] == 0) continue;
					int freq =0;
					if(map.containsKey(sky[j][k])) {
						freq = map.get(sky[j][k])+1;
						map.put(sky[j][k], freq);
					} else {
						map.put(sky[j][k], 1);
					}
				}
				for(int top:map.keySet()) {
					count+=combination(map.get(top),2);
				}
			}
			System.out.println("Case #"+(i+1)+":"+count);
		}
		in.close();
	}
	
	static int distance(int[] posa,int[] posb) {
		int x = posa[0] - posb[0];
		int y = posa[1] - posb[1];
		int distance = x*x + y*y;
		return distance;
	}
	
	static long combination(int topNum, int bottomNum) {
		long ans = 1;
		for (int i = 0; i < bottomNum; i++) {
			ans *= (topNum - i);
			ans /= (i+1);
		}
		return ans;
	}

}
