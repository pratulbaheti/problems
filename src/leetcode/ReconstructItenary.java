package leetcode;

import java.util.*;

public class ReconstructItenary {
	
	public static void main(String args[]) {
		
//		String[][] tickets = {{"JFK", "MUC"},{"MUC", "LHR"}, {"LHR", "SFO"}, {"SFO", "SJC"}};
//		String[][] tickets = {{"JFK","ATL"},{"ATL","JFK"},{"JFK","SFO"},{"SFO","ATL"},{"ATL","SFO"}};
		
		String[][] tickets = {{"CBR","JFK"},{"TIA","EZE"},{"AUA","TIA"},{"JFK","EZE"},{"BNE","CBR"},{"JFK","CBR"},{"CBR","AUA"},{"EZE","HBA"},{"AXA","ANU"},{"BNE","EZE"},{"AXA","EZE"},{"AUA","ADL"},{"OOL","JFK"},{"BNE","AXA"},{"OOL","EZE"},{"EZE","ADL"},{"TIA","BNE"},{"EZE","TIA"},{"JFK","AUA"},{"AUA","EZE"},{"ANU","ADL"},{"TIA","BNE"},{"EZE","OOL"},{"ANU","BNE"},{"EZE","ANU"},{"ANU","AUA"},{"BNE","ANU"},{"CNS","JFK"},{"TIA","ADL"},{"ADL","AXA"},{"JFK","OOL"},{"AUA","ADL"},{"ADL","TIA"},{"ADL","ANU"},{"ADL","JFK"},{"BNE","EZE"},{"ANU","BNE"},{"JFK","BNE"},{"EZE","AUA"},{"EZE","AXA"},{"AUA","TIA"},{"ADL","CNS"},{"AXA","AUA"}};
		String sb = new String();
		System.out.print("JFK");
		findItinerary(tickets);
		for(;!list.isEmpty();) {
			System.out.print("-->"+list.pop());
		}
	}
	
	static HashMap<String,PriorityQueue<String>> map = new HashMap<String,PriorityQueue<String>>();
	static HashMap<String,LinkedList<String>> storage = new HashMap<String,LinkedList<String>>();
	static Stack<String> list = new Stack<String>();
	static int size =1;
	static int total = 0;
	
	public static List<String> findItinerary(String[][] tickets) {
		for (String[] s : tickets) {
			if (map.containsKey(s[0])) {
				map.get(s[0]).add(s[1]);
			} else {
				PriorityQueue<String> pq = new PriorityQueue<String>();
				pq.add(s[1]);
				map.put(s[0], pq);
			}
		}
		total=tickets.length;
		recursion("JFK");
		return list;
	}
    
    public static boolean recursion(String s) {
    	
    	if(map.get(s).isEmpty() && storage.containsKey(s)) {
    		map.get(s).addAll(storage.get(s));
    		storage.remove(s);
    	}
    	if(s.equals("EZE") && map.get(s).peek().equals("HBA")) {
    		System.out.println("debug");
    	}
		if(size == total) {
			list.push(map.get(s).peek());
			return true;
		}
		PriorityQueue<String> pq = map.get(s);
		while(!pq.isEmpty()) {
    		String to = pq.remove();
			if(map.containsKey(to)) {
    			++size;
    			boolean value = recursion(to);
    			if(value) {
    				list.push(to);
    				return true;
    			} else {
    				pq.add(to);
    				--size;
    			}
    		} else {
    			if(storage.containsKey(s)) {
    				storage.get(s).add(to);
    			} else {
    				LinkedList<String> dummy = new LinkedList<String>();
    				dummy.add(to);
    				storage.put(s, dummy);
    			}
    			//return false;
    		}
    	}
    	return false;
    }
}