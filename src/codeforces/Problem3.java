package codeforces;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Problem3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		Stack<String> stack = new Stack<String>();
		
		ArrayList<String> open = new ArrayList<String>();
		open.add("<");
		open.add("{");
		open.add("[");
		open.add("(");
		ArrayList<String> close = new ArrayList<String>();
		close.add(">");
		close.add("}");
		close.add("]");
		close.add(")");
		int counter = 0;
		
		if(close.contains("" + str.charAt(0))) {
			System.out.println("Impossible");
			return;
		}
		for(int i=0;i<str.length();i++) {
			String s = "" + str.charAt(i);
			if(close.contains(s) && !stack.isEmpty()) {
				String pop = stack.pop();
				if(match(pop,s)) {
					
				} else if(open.contains(pop)) {
					counter++;
				} else {
					System.out.println("Impossible");
					return;
				}
			} else if (open.contains(s)) {
				stack.push(s);
			} else {
				System.out.println("Impossible");
				return;
			}
		}
		System.out.println(counter);
	}
	
	static boolean match(String s1,String s2) {
		if(s1.equals("{") && s2.equals("}")) return true;
		if(s1.equals("[") && s2.equals("]")) return true;
		if(s1.equals("(") && s2.equals(")")) return true;
		if(s1.equals("<") && s2.equals(">")) return true;
		return false;
	}

}
