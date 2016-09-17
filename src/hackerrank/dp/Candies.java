package hackerrank.dp;
import java.util.Scanner;

public class Candies {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        int dp[] = new int[n];
        dp[0]=1;
        for(int i=0;i<n;i++) {
        	arr[i]=in.nextInt();
        }
        for(int i=1;i<n;i++) {
        	dp[i]=arr[i]>arr[i-1]?dp[i-1]+1:1;
        }
        for(int i=arr.length-2;i>=0;i--) {
        	if(arr[i]>arr[i+1] && dp[i]==dp[i+1])
        		dp[i]=dp[i+1]+1;
        }
        long sum=0l;
        for(int a:dp) {
        	sum+=a;
        }
        System.out.println(sum);
        in.close();
    }
}