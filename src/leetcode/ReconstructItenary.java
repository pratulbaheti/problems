package leetcode;

import java.util.*;

public class ReconstructItenary {
	
	public static void main(String args[]) {
		
//		String[][] tickets = {{"JFK", "MUC"},{"MUC", "LHR"}, {"LHR", "SFO"}, {"SFO", "SJC"}};
		String[][] tickets = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
		String sb = new String();
		for(String s: findItinerary(tickets)) {
			sb=s+"-->"+sb;
		}
		System.out.println(sb);
	}
	
	static HashMap<String,TreeSet<String>> map = new HashMap<String,TreeSet<String>>();
	static List<String> list = new LinkedList<String>();
//	static LinkedHashMap<String,LinkedHashSet<String>> iter = new LinkedHashMap<String,LinkedHashSet<String>>();
	static int size =1;
	static int total = 0;
	
	public static List<String> findItinerary(String[][] tickets) {
		for (String[] s : tickets) {
			if (map.containsKey(s[0])) {
				map.get(s[0]).add(s[1]);
			} else {
				TreeSet<String> set = new TreeSet<String>();
				set.add(s[1]);
				map.put(s[0], set);
			}
		}
		total=tickets.length;
		recursion("JFK");
		return list;
	}
    
    public static boolean recursion(String s) {
    	
		if(size == total) {
			list.add(s);
			return true;
		}
    	for(final Iterator<String> iterator = map.get(s).iterator(); iterator.hasNext();) {
    		String to = iterator.next().toString();
			if(map.containsKey(to)) {
				iterator.remove();
    			++size;
    			boolean value = recursion(to);
    			if(value) {
    				list.add(s);
    			} else {
    				map.get(s).add(to);
    				--size;
    			}
    		} else {
    			return false;
    		}
    	}
    	return true;
    }
}