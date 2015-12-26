package codeforces;

import java.util.ArrayList;
import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(5);
		al.add(8);
		int s =7;
		int start=0;
		int end = al.size();
		int mid = 0;
		while(start != end) {
			mid = (start+end)/2;
			if(s<al.get(mid)) {
				end = mid-1;
			} else {
				start=mid+1;
			}
		}
		if(al.get(start+1) - s < al.get(start)-s)
			start=start+1;
		System.out.println(start);
	}

}
