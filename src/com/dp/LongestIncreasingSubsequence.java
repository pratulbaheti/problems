package com.dp;

/**
 * 
 * Longest Increasing Subsequence
 *
 */
public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int arr[] = {4,6,1,3,8,4,6};
		int len[] = new int[arr.length];
		int seq[] = new int[arr.length];
		
		initializer(len,1);
		initializer(seq,-1);
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<i;j++) {
				if(arr[j]<arr[i] && len[j]+1 > len[i]) {
					len[i]=len[j]+1;
					seq[i]=j;
				}
			}
		}
		
		printLIS(arr,len,seq);
	}
	
	public static void println(String str) {
		System.out.println(str);
	}
	public static void printLIS(int arr[],int len[],int seq[]) {
		
	}
	public static void initializer(int arr[],int val) {
		for(int i=0;i<arr.length;i++) {
			arr[i]=val;
		}
	}
}
