/**
 * 
 */
package geeksforgeeks;

import java.util.ArrayList;

/**
 * @author pratul
 *http://geeksquiz.com/greedy-algorithm-to-find-minimum-number-of-coins/
 */
public class NumberOfCoins {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(1);arr.add(2);arr.add(5);arr.add(10);arr.add(20);arr.add(50);arr.add(100);arr.add(500);
		int val = 70;
		ArrayList<Integer> ans = new ArrayList<Integer>();
		while(val != 0) {
			int temp = binarySearch(val, arr);
			val-=temp;
			ans.add(temp);
		}
		System.out.println(ans.toString());
	}
	
	static int binarySearch(int val, ArrayList<Integer> arr) {
		int start=0,mid=0,end=arr.size()-1;
		while(start <= end) {
			mid = start + (end - start)/2;
			int temp = arr.get(mid);
			if(temp == val)
				return val;
			else if(temp > val)
				end = mid-1;
			else
				start = mid+1;
		}
		if(start-1 > 0 && arr.get(start) > val) 
			return arr.get(start-1);
		return arr.get(start);
	}

}
