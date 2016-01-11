package codeforces;

import java.util.Scanner;

public class Problem338A {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int ans = (1<<m) - 1;
		int temp = 0;
		for(int i=1;i<=n;i++) {
			int val = in.nextInt();
			for (int j=0;j<val;j++) {
				int x = in.nextInt();
				temp |= 1 << (x - 1);
				if (temp == ans) {
					in.close();
					System.out.println("YES");
					return;
				}
			}
		}
		System.out.println("NO");
		in.close();
	}

}
