package reference;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class TrieMain {

	final static InputReader in = new InputReader(System.in);
	final static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("abc");
		trie.insert("abd");
		trie.insert("ca");
		trie.print();
		trie.delete("abd");
		trie.print();
		trie.insert("abd");
		trie.delete("abd");
		trie.delete("abc");
		trie.print();
		out.close();
	}

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}
	}

}

class TrieNode {
	HashMap<Character, TrieNode> map = new HashMap<Character, TrieNode>();
	boolean eos=false;
	char data;
	TrieNode(char data) {
		this.data = data;
		eos=false;
	}
}

class Trie {
	private TrieNode root = new TrieNode('*');
	
	public void insert(String str) {
		this.insert(root, str, 0);
	}
	
	private void insert(TrieNode t, String str, int pos) {
		if(str.length() == pos) {
			t.eos = true;
			return ;
		}
		char curr = str.charAt(pos);
		if(t.map.containsKey(curr)) {
			insert(t.map.get(curr), str, pos+1);
		} else {
			t.map.put(curr, new TrieNode(curr));
			insert(t.map.get(curr), str, pos+1);
		}
	}
	
	public boolean search(String str) {
		return this.search(root,  str, 0);
	}
	
	private boolean search(TrieNode t, String str, int pos) {
		if(str.length() == pos) {
			return true;
		}
		char curr = t.map.get(str.charAt(pos)).data;
		if(t.map.containsKey(curr))
			return search(t.map.get(curr), str, pos+1);
		else 
			return false;
	}
	
	public void delete(String str) {
		delete(root, str, 0);
	}
	
	private void delete(TrieNode t, String str, int pos) {
		if(str.length() == pos) {
			if(!t.map.isEmpty())
				t.eos=false;
			return;
		}
		char curr = str.charAt(pos);
		if(t.map.containsKey(curr)) {
			delete(t.map.get(curr), str, pos+1);
			if(t.map.get(curr).map.isEmpty())
				t.map.remove(curr);
		}
	}
	
	public void print() {
		print(root,"");
	}
	private void print(TrieNode t,String str) {
		System.out.println(str+t.data+(t.eos?"($)":""));
		for(TrieNode tn:t.map.values()) {
			print(tn,str+".");
		}
	}
}