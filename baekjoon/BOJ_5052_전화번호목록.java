import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_5052_��ȭ��ȣ��� {
	static class Trie {
		// ��Ʈ���
		private TrieNode rootNode;
		// ������
		Trie() {
			rootNode = new TrieNode();
		}
	}
	
	static class TrieNode {
		// �ڽ� ��� ��
		private Map<Character, TrieNode> childNodes = new HashMap<>();
		// ������ �������� ����
		private boolean isLast;
		
		// getter, setter
		Map<Character, TrieNode> getChildNodes() {
			return this.childNodes;
		}
		boolean getIsLast() {
			return this.isLast;
		}
		void setIsLast(boolean _isLast) {
			this.isLast = _isLast;
		}
	}
	
	static Trie trie;
	static int t, n;
	static String[] phoneBook;
	static String ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.parseInt(br.readLine());
		
		for(int testcase = 0; testcase < t; testcase++) {
			n = Integer.parseInt(br.readLine());
			ans = "YES";
			
			// Ʈ���� ����
			trie = new Trie();
			phoneBook = new String[n];
			
			for(int i = 0; i < n; i++) {
				phoneBook[i] = br.readLine().replaceAll(" ", "");
				insert(phoneBook[i]);
			}
			
			for(int i = 0; i < n; i++) {
				if(contains(phoneBook[i])) {
					ans = "NO";
					break;
				}
			}
			
			System.out.println(ans);
		}
		
	}
	
	// �ڽ� ��� �߰�
	public static void insert(String word) {
		TrieNode thisNode = trie.rootNode;
		
		for(int i = 0; i < word.length(); i++) {
			// ���� ��� ��������, ���ο� ��� ����
			// computeIfAbsent(key, mappingFunction) : �ش��ϴ� Ű ���� �������� ���� ������ �Ѱ��� ���ٽ��� ����Ѵ�.
			thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
		}
		
		thisNode.setIsLast(true);
	}
	
	// Ư�� �ܾ ����ִ��� Ȯ��
	public static boolean contains(String word) {
		TrieNode thisNode = trie.rootNode;
		
		for(int i = 0; i < word.length(); i++) {
			char character = word.charAt(i);
			TrieNode node = thisNode.getChildNodes().get(character);
			
			if(node == null) return false;
			
			thisNode = node;
		}
		
		if(thisNode.getChildNodes().size() == 0) {
			return false;
		} else {
			return true;
		}
	}
}
