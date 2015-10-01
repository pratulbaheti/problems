package com.test;

/**
 * generating all binary numbers
 * @author pratul
 *
 */
public class Combinatorics {

	public static void main(String[] args) {
		for(int x=0;x<10;x++) {
			int index=0;
			for(int k=x;k>0;k>>=1) {
				if((k & 1) == 1) {
					System.out.println(""+index);
				}
				index++;
			}
		}
	}
}
