package hackerrank.hack101;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * https://www.hackerrank.com/contests/101hack32/challenges/straight-flush
 * @author pratu
 *
 */
public class Problem1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> rank = new ArrayList<Integer>();
		Set<Character> suit = new HashSet<Character>();
		boolean flag = false;
		for(int i=1;i<=5;i++) {
			String s = in.next();
			char val = s.charAt(0);
			int cardVal = 0;
			switch(val) {
			case 'T' : cardVal = 10;break;
			case 'J' : cardVal = 11;break;
			case 'Q' : cardVal = 12;break;
			case 'K' : cardVal = 13;break;
			case 'A' : cardVal = 14;flag=true;break;
			default  : cardVal = Integer.parseInt(""+val);
			}
			rank.add(cardVal);
			suit.add(s.charAt(1));
		}
		boolean isFlush = checkFlush(rank);
		if(flag && !isFlush) {
			int posOfA = rank.indexOf(14);
			rank.remove(posOfA);
			rank.add(1);
			isFlush = checkFlush(rank);
		}
		if(suit.size() == 1 && isFlush)
			System.out.println("YES");
		else
			System.out.println("NO");
		in.close();
	}
	
	public static boolean checkFlush(ArrayList<Integer> cards) {
		Collections.sort(cards);
		for(int i=1;i<5;i++) {
			int diff = cards.get(i)-cards.get(i-1);
			if(diff != 1)
				return false;
		}
		return true;
	}

}
