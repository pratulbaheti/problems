package codeforces;

import java.util.Scanner;

public class Problem22 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		String xstr[] = input.split(" ");
		int x = Integer.parseInt(xstr[0]);
		String freq = xstr[2];
		if(freq.equals("week")) {
			if(x == 5 || x == 6) {
				System.out.println("53");
			} else {
				System.out.println("52");				
			}
		} else {
			if(x == 31) {
				System.out.println("7");
			} else if (x== 30) {
				System.out.println("11");				
			} else if(x <30) {
				System.out.println("12");
			}
		}
		
	}

}
