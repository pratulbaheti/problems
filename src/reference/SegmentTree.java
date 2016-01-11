package reference;

public class SegmentTree {

	static int segarr[];
	static int data[] = {2,3,4,0,1,2,3,4,5,6}; //,5,1,6,22,4
	
	public static void main(String[] args) {
		int sizeOfSegmentTree = (int) Math.pow(2, Math.ceil(Math.log10(data.length) / Math.log10(2)));
		segarr = new int[2*sizeOfSegmentTree-1];
		build(0,0,data.length-1);
		for(int i=0;i<segarr.length;i++) System.out.print(segarr[i]+", ");
	}
	
	static void build(int node,int start, int end) {
		if(start == end) {
			segarr[node] = data[start];
		} else {
			int mid = (start+end)/2;
			build(2*node+1,start,mid);
			build(2*node+2,mid+1,end);
			segarr[node] = segarr[2*node+1] + segarr[2*node + 2];
		}
	}

}

