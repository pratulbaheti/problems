package acm;
//Christmas day
import java.math.BigInteger;
import java.util.Scanner;

class problem5 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long input = in.nextLong();
		while(input != 0) {
			BigInteger bign = new BigInteger(Long.toString(input));
			BigInteger bign1 = bign.add(new BigInteger(String.valueOf("1")));
			BigInteger bign2 = bign.add(new BigInteger(String.valueOf("2")));
			BigInteger sum = bign.multiply(bign1).multiply(bign2).divide(new BigInteger(String.valueOf("6")));
			System.out.println(""+sum);
			input = in.nextLong();
		}
	}
}