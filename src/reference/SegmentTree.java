package reference;

public class SegmentTree {

	static int data[] = {0,1,2,3,4,5,6,7,8,9};
	static int tree[];
	static int mintree[];
	static int lazy[];
	
	public static void main(String[] args) {
		int len = data.length;
		int height = (int)Math.ceil(Math.log(len)/Math.log(2));
		int size = 2 << (height+1);
		tree = new int[size];
		mintree = new int[size];
		lazy = new int[size];
		build(1, 0, data.length-1);
		int sum = minquery(1, 0, len-1, 0, 9);
		System.out.println(sum);
	}
	
	static void build(int node,int start, int end) {
		if(start > end) {
			return ;
		}
		if(start == end) {
			tree[node] = data[start];
			mintree[node] = data[start];
		} else {
			int mid = (start+end)/2;
			build(2*node, start, mid);
			build(2*node + 1, mid+1, end);
			tree[node] = tree[2*node] + tree[2*node +1];
			mintree[node] = Integer.min(mintree[2*node],mintree[2*node +1]);
		}
	}
	
	static void update(int node, int start, int end, int index, int val) {
		if(index < start || end < index)
			return ;
		if(start == end) {
			tree[node]+=val;
			mintree[node] = val;
			return;
		}
		int mid = (start + end)/2;
		if(index <= mid) {
			update(2*node, start, mid, index, val);
		} else {
			update(2*node+1, mid+1, end, index, val);
		}
		tree[node] = tree[2*node] + tree[2*node +1];
		mintree[node] = Integer.min(tree[2*node],tree[2*node +1]);
	}
	
	static int sumquery(int node, int start, int end, int l, int r) {
		if(r<start || end < l)
			return 0;
		if(l<=start && end<=r)
			return tree[node];
		int mid = (start + end)/2;
		int sum1 = sumquery(2*node,start,mid,l,r);
		int sum2 = sumquery(2*node+1,mid+1,end,l,r);
		return sum1+sum2;
	}
	
	static int minquery(int node, int start, int end, int l, int r) {
		if(r<start || end < l)
			return 0;
		if(l<=start && end<=r)
			return mintree[node];
		int mid = (start + end)/2;
		int min1 = minquery(2*node,start,mid,l,r);
		int min2 = minquery(2*node+1,mid,end,l,r);
		return Integer.min(min1, min2);
	}
	
	static void updateRange(int node, int start, int end, int index, int val) {
		
	}
	
	static int queryRange(int node, int start, int end, int l, int r) {
		
		return 0;
	}

}

