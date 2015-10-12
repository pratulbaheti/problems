package bioinformatics;

public class ScoringMatrix {

	public static void main(String[] args) {
		String str1 = "aattcg";
		String str2 = "acatcg";
		int a[][] = new int[str1.length()+1][str2.length()+1];
		
		for(int i=0;i<=str2.length();i++) {
			a[i][0] = -1*i;
		}
		for(int j=0;j<=str1.length();j++) {
			a[0][j] = -1*j;
		}
	
		for(int i=1;i <= str2.length();i++) {
			for(int j=1;j<=str1.length();j++) {
				if(str1.charAt(j-1) == str2.charAt(i-1))
					a[i][j]=max(a[i-1][j]-1,a[i][j-1]-1,a[i-1][j-1]+1);
				else 
					a[i][j]=max(a[i-1][j]-1,a[i][j-1]-1,a[i-1][j-1]-1);
			}
		}

		for(int i=0;i<=str2.length();i++) {
			for(int j=0;j<=str1.length();j++) {
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	public static int max(int a, int b, int c) {
		if(a>=b && a>=c) return a;
		if(b>=c && b>=a) return b;
		if(c>=a && c>=b) return c;
		return 0;
	}

}
