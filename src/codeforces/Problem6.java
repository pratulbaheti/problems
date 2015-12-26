package codeforces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Problem6 {

	static int n;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		int s = in.nextInt();
		long arr[] = new long[n+1];
		Map<Long,ArrayList<Integer>> map = new HashMap<Long,ArrayList<Integer>>();
		PriorityQueue<Long> pq = new PriorityQueue<Long>();
		
		for(int i=1;i<=n;i++) {
			long l = in.nextLong();
			pq.add(l);
			arr[i] = l;
			if(map.containsKey(l)) {
				map.get(l).add(i);
			} else {
				ArrayList<Integer> al = new ArrayList<Integer>();
				al.add(i);
				map.put(l, al);
			}
		}
		in.close();
 		while(!pq.isEmpty()) {
			long l = pq.remove();
			int pos = closest(s,map.get(l));
			s = shortD(pos,map.get(l));
		}
		System.out.println(counter);
		for(String str:list) {
			System.out.println(str);
		}
	}
	static int counter = 0;
	
	static int shortD(int s,ArrayList<Integer> al) {
		int pos = s;
		int close = al.get(pos);
		if(n-al.get(al.size()-1) + s < Math.abs(s-close)) {
			close=n-al.get(al.size()-1) + s;
			counter+=close;
			print("-"+close);
			pos = al.size()-1;
			s=al.get(al.size()-1);
		} else if(close < s) {
			print("-"+(s-close));
			counter+=s-close;
			s=close;
		} else {
			print("+"+(close-s));
			counter+=close-s;
			s=close;
		}
		al.remove(pos);
		return s;
	}
	
	static int closest(int s,ArrayList<Integer> al) {
		int start=0;
		int end = al.size();
		int last = end-1;
		int mid = 0;
		int distance=0;
		while(start != end) {
			mid = (start+end)/2;
			if(s<al.get(mid)) {
				end = mid-1;
			} else {
				start=mid+1;
			}
		}
		distance = al.get(start)-s;
		if(al.get(start+1) - s < al.get(start)-s){
			distance=al.get(start+1) - s;
			start = start+1;
			print("+"+distance);
		} else {
			print("-"+distance);
		}
		int temp = n-al.get(last)+s;
		if(temp < distance) {
			distance=temp;
			start = al.get(last);
			print("-"+distance);
		}
		
		temp = n-s+al.get(0);
		if(temp < distance) {
			distance=temp;
			start=al.get(0);
			print("+"+distance);
		}
		return start;
	}
	static ArrayList<String> list = new ArrayList<String>();
	static void print(String s) {
		System.out.println(s);
//		list.add(s);
	}

}
