package palindrome;

import java.util.Scanner;

public class AnagramIsPalindrome {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.next();
		char charArr[] = str.toCharArray();
		int arr[] = new int[127];
		for(char c : charArr) {
			arr[c]+=1;
		}
		
	}

}
