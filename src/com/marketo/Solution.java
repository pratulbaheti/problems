package com.marketo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Solution {

	final static InputReader in = new InputReader(System.in);
	final static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = "Connections";
		
		//Question 1
		System.out.println(findMostFrequentChar(s));

		//Question 2		
/*		int a = in.nextInt();
		int b = in.nextInt();
		int n = reverse(a) + reverse(b);
		System.out.println(reverse(n));
*/	
	}
	
	// Query 4 for finding max salary in various dept
	// select dt.dept_name,max(et.salary) from department_table dt, employee_table et where dt.dept_id = et.dept_id group by et.dept_id,dt.dept_name;
	

	// Question 3
	class LinkedListNode {
		LinkedListNode next;
		int val;
	}
	static LinkedListNode removeElems(int value, LinkedListNode head) {
		 while(head != null && head.val == value) {
	            head = head.next;
	        }
	        if(head == null) {
	            return head;
	        }

	        LinkedListNode prev = head;
	        LinkedListNode curr = head;
	        
	        while(curr.next != null) {
	            if(curr.val == value) {
	                curr = curr.next;
	                prev.next = curr;
	            } else {
	                prev = curr;
	                curr = curr.next;
	            }
	        }
	        return head;
	        }
	
	
	static String findMostFrequentChar(String inputString) {
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        int max = 1;
        Character ans = inputString.charAt(0);
        for(int i=0;i<inputString.length();i++) {
            char c = inputString.charAt(i);
            if(map.containsKey(c)) {
                int freq = map.get(c);
                freq+=1;
                map.put(c,freq);
                if(max<freq) {
                    ans=c;
                    max=freq;
                }
            } else {
                map.put(c,1);
            }
        }
        return ""+ans;

    }
	
	static int reverse(int a) {
		int reverse = 0;
		while(a>0) {
			reverse=10*reverse + a%10;
			a=a/10;
		}
		return reverse;
    }
	
	

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}
	}

}
