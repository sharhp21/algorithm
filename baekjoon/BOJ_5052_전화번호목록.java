import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_5052_전화번호목록 {
	static class Trie {
		// 루트노드
		private TrieNode rootNode;
		// 생성자
		Trie() {
			rootNode = new TrieNode();
		}
	}
	
	static class TrieNode {
		// 자식 노드 맵
		private Map<Character, TrieNode> childNodes = new HashMap<>();
		// 마지막 글자인지 여부
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
			
			// 트라이 생성
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
	
	// 자식 노드 추가
	public static void insert(String word) {
		TrieNode thisNode = trie.rootNode;
		
		for(int i = 0; i < word.length(); i++) {
			// 연결 노드 없을때만, 새로운 노드 생성
			// computeIfAbsent(key, mappingFunction) : 해당하는 키 값이 존재하지 않을 때에만 넘겨준 람다식을 사용한다.
			thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
		}
		
		thisNode.setIsLast(true);
	}
	
	// 특정 단어가 들어있는지 확인
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
