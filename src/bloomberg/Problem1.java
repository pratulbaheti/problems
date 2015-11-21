package bloomberg;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem1 {

	public static void main(String[] args) {
		Map<Integer,String> map = new HashMap<Integer,String>();
		intialize(map);
		Scanner in = new Scanner(System.in);
		int val = 26*26*26; //in.nextInt();
		double powD = Math.log(26*26*26+1)/Math.log(26);
		int pow = (int)powD;
		
		StringBuffer ans= new StringBuffer();
		while(val > 0) {
			int rem =val%26; 
	       ans.append(map.get(rem)); 
	       val=val/26;
		}
		System.out.println(ans);
		
	}
	
	public static void intialize(Map<Integer,String> map) {
		map.put(1,"A");
		map.put(2,"B");
		map.put(3,"C");
		map.put(4,"D");
		map.put(5,"E");
		map.put(6,"F");
		map.put(7,"G");
		map.put(8,"H");
		map.put(9,"I");
		map.put(10,"J");
		map.put(11,"K");
		map.put(12,"L");
		map.put(13,"M");
		map.put(14,"N");
		map.put(15,"O");
		map.put(16,"P");
		map.put(17,"Q");
		map.put(18,"R");
		map.put(19,"S");
		map.put(20,"T");
		map.put(21,"U");
		map.put(22,"V");
		map.put(23,"W");
		map.put(24,"X");
		map.put(25,"Y");
		map.put(0,"Z");
	}

}
