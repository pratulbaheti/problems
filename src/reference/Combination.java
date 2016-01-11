package reference;

public class Combination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static int combination(int topNum, int bottomNum) {
		double incSum = 0;
		double decSum = 0;
		for (int i = 0; i < bottomNum; i++) {
			incSum += Math.log10(topNum - i);
			decSum += Math.log10(i + 1);
		}
		return (int) Math.exp(incSum-decSum);
	}

}
