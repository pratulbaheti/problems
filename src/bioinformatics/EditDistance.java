package bioinformatics;

public class EditDistance {

	public static void main(String[] args) {
		String str1 = "aattcg";
		String str2 = "acatcg";
		
		int a[][] = new int[str1.length()+1][str2.length()+1];
		
		for(int i=0;i<=str1.length();i++) {
			a[i][0] = i;
		}
		for(int j=0;j<=str1.length();j++) {
			a[0][j] = j;
		}

		for(int i=1;i<=str2.length();i++) {
			for(int j=1;j<=str1.length();j++) {
				if(str1.charAt(j-1) == str2.charAt(i-1))
					a[i][j]=a[i-1][j-1];
				else 
					a[i][j]=min(a[i-1][j]+1,a[i][j-1]+1,a[i-1][j-1]+1);
			}
		}
		
		for(int i=0;i<=str1.length();i++) {
			for(int j=0;j<=str2.length();j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
		
		int i=str2.length();
		int j=str1.length();
		for(int x=str1.length()+str2.length();i!=0 && j!=0;x--) {
			System.out.print(a[i][j]+"->");
			int min=min(a[i-1][j-1],a[i][j-1],a[i-1][j]);
			if(min==a[i-1][j-1]) {
				i=i-1;
				j=j-1;
			} else if (min == a[i][j-1]) {
				j=j-1;
			} else {
				i=i-1;
			}
		}
		
	}
	
	public static int min(int a, int b, int c) {
		if(a<=b && a<=c) return a;
		if(b<=c && b<=a) return b;
		if(c<=a && c<=b) return c;
		return 0;
	}

}
