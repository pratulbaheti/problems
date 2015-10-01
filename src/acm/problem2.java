package acm;

import java.util.*;
/**
 * polling
 * @author pratul
 *
 */
class problem2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Map<String,Integer> counter = new HashMap<String,Integer>();
		int noOfTc = in.nextInt();
		String voterName = new String();
		int temp=0;
		int max = 1;
		for(int i=0; i<noOfTc;i++) {
			voterName = in.next();
			if(counter.containsKey(voterName)){
				temp = counter.get(voterName)+1;
				counter.put(voterName, temp);
			} else {
				counter.put(voterName, 1);
			}
			if(max < temp) 
				max=temp;
		}
		TreeSet<String> output = new TreeSet<String>();
		for(String s : counter.keySet()) {
			if(max == counter.get(s)) {
				output.add(s);
			}
		}
		for(String s : output)
			System.out.println(s);
	}
}