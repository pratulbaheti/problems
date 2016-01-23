package reference;

public class BinaryIndexedTree {
	
	static int[] bit;
	static int[] arr;
	public static void main(String[] args) {
		arr = new int[]{10,1,3,2,3,4,5,6,7,8,9};
		bit = new int[50000+1];
		
		totalInversion();
	}
	
	static int max() {
		//Max of arr[]
		return 10;
	}
	
	static int totalInversion() {
		int totalInversion = 0;
		for(int i=0;i<arr.length;i++) {
			totalInversion+=i-read(arr[i]);
			update(arr[i],1);
		}
		System.out.println(totalInversion);
		return 0;
	}
	
	public static int read(int i) {
		int resultSum = 0;
		while(i>0) {
			resultSum+=bit[i];
			i-=i&(-i);
		}
		return resultSum;
	}
	
	public static void update(int x,int val) {
		while(x<bit.length) {
			bit[x]+=val;
			x+=x&(-x);
		}
	}

	static void print() {
		for(int i=1;i<bit.length;i++) {
			System.out.print(bit[i]+",");
		}
		System.out.println();
		for(int i=1;i<bit.length;i++) {
//			System.out.print(read(i)+",");
		}
	}
}
