import java.util.*;

public class Ceaser {

	public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
		int n =in.nextInt();
		String s = in.next();
		int k= in.nextInt();
		
		for(int i=0;i<n;i++) {
			char c=s.charAt(i);
            int cint = c;
			cint=cint+k;
			if(cint > 65 && cint <= 65+26 || cint > 97 && cint <= 97+26) {
				System.out.print((char)cint);
			} else {
				System.out.print(c);
			}
		}
	}
}